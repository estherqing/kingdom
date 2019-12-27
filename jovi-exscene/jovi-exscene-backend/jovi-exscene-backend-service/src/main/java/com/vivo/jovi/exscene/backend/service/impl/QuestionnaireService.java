package com.vivo.jovi.exscene.backend.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireService;
import com.vivo.jovi.exscene.backend.service.model.PublishStrategyDetail;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionPosition;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionVO;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireDetailVO;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.constant.*;
import com.vivo.jovi.scene.common.dal.dao.*;
import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireDescEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.model.RoleSystemResult;
import com.vivo.jovi.scene.common.model.bo.QuestionBO;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.model.dto.QuestionDTO;
import com.vivo.jovi.scene.common.model.dto.QuestionnaireDTO;
import com.vivo.jovi.scene.common.service.httpClient.impl.HttpClientService;
import com.vivo.jovi.scene.common.util.JsonUtils;
import com.vivo.jovi.scene.common.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Classname QuestionnaireService
 * @Description TODO
 * @Date 2019-05-06 15:04
 * @Created by Administrator
 * @Version 1.0
 */
@Service
public class QuestionnaireService implements IQuestionnaireService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireService.class);

    private static final String QUESTIONNAIREABBREVIATION = "qnr_";

    private static final String QUESTIONABBREVIATION = "qu_";


    protected static final String ROLE_SYSTEM_URL = VivoConfigManager.getString("ROLE_SYSTEM_URL", "http://privilege-api.vivo.xyz/roleuser/");

    protected static final String ROLE_OPERATE_NAME = "exscene_operate";

    protected static final String ROLE_TEST_NAME = "exscene_test";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private IQuestionDao questionDao;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IQuestionnaireDescDao questionnaireDescDao;

    @Autowired
    private IPublishService publishService;

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private IExPublishDao exPublishDao;


    @Override
    public CommonVO saveQuestion(QuestionBO questionBO, SSOUser ssoUser) {
        QuestionEntity questionEntity = new QuestionEntity();
        BeanUtils.copyProperties(questionBO, questionEntity);
        if (StringUtils.isBlank(questionBO.getQuestionId())) {
            questionDao.insertSelective(questionEntity);
            questionEntity.setQuestionId(QUESTIONABBREVIATION + questionEntity.getId());
            questionDao.updateByPrimaryKey(questionEntity);
        } else {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestionId(questionBO.getQuestionId());
            questionEntity = questionDao.selectBySelective(questionDTO);
            if (questionEntity == null) {
                return CommonVO.error("该调查问卷问题记录不存在");
            }
            QuestionnaireBO questionnaireBO = new QuestionnaireBO();
            BeanUtils.copyProperties(questionBO, questionnaireBO);
            QuestionnaireEntity questionnaireEntity = isExistQuestionnaire(questionnaireBO);
            if (questionnaireEntity != null && !isAllowModify(questionnaireEntity)) {
                return CommonVO.error("该调查问卷问题在新建、草稿以及翻译待导出的状态下，才可以进行修改");
            }
            BeanUtils.copyProperties(questionBO, questionEntity);
            questionDao.updateBySelective(questionEntity);
        }
        return CommonVO.success(questionEntity.getQuestionId());
    }


    /**
     * 保存或更新调查问卷信息
     *
     * @param questionnaireBO
     * @param ssoUser
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonVO saveQuestionnaire(QuestionnaireBO questionnaireBO, SSOUser ssoUser) throws ParseException {
        QuestionnaireDescEntity questionnaireDescEntity = new QuestionnaireDescEntity();
        //最后一个页面的草稿按钮
        if (questionnaireBO.getDraftButtonPosition() == 1) {
            CommonVO checkRsult = checkLanguageOption(questionnaireBO);
            if (!checkRsult.getCode().equals(CommonVO.success().getCode())) {
                return checkRsult;
            }
            setLanguage(questionnaireDescEntity, null, questionnaireBO);
            questionnaireBO.setLanguage(questionnaireDescEntity.getLanguage());
        }
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        BeanUtils.copyProperties(questionnaireBO, questionnaireEntity);
        if (StringUtil.isNotBlank((questionnaireBO.getPersonalQuestionIds())) && StringUtil.isNotBlank((questionnaireBO.getMainBodyQuestionIds()))) {
            questionnaireEntity.setQuestionIdList(questionnaireBO.getPersonalQuestionIds()+","+questionnaireBO.getMainBodyQuestionIds());
        }else if (StringUtil.isBlank((questionnaireBO.getPersonalQuestionIds()))){
            questionnaireEntity.setQuestionIdList(questionnaireBO.getMainBodyQuestionIds());
        }else if (StringUtil.isBlank((questionnaireBO.getMainBodyQuestionIds()))){
            questionnaireEntity.setQuestionIdList(questionnaireBO.getPersonalQuestionIds());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (questionnaireBO.getOperationType() == 0) {
            questionnaireEntity.setStatus(QuestionnaireStatusEnum.DRAFT.getStatus());
        } else if (questionnaireBO.getOperationType() == 1) {
            questionnaireEntity.setStatus(QuestionnaireStatusEnum.TEXT_TO_BE_EXPORTED.getStatus());
        }
        //新建问卷时候是沒有问卷id的
        if (StringUtil.isBlank(questionnaireBO.getQuestionnaireId())) {
            Date startDateTime = questionnaireBO.getStartTime() == null ? null : simpleDateFormat.parse(questionnaireBO.getStartTime());
            Date endDateTime = questionnaireBO.getEndTime() == null ? null : simpleDateFormat.parse(questionnaireBO.getEndTime());
            CommonVO commonVO = paramVerification(questionnaireBO, startDateTime, endDateTime);
            if (!commonVO.getCode().equals(CommonVO.success().getCode())) {
                return commonVO;
            }
            String questionnaireId = this.getQuestionnaireId();
            questionnaireEntity.setQuestionnaireId(questionnaireId);
            questionnaireEntity.setStartTime(startDateTime);
            questionnaireEntity.setEndTime(endDateTime);
            questionnaireEntity.setVersionCode(1);

            if (StringUtil.isBlank(questionnaireEntity.getIcon())) {
                questionnaireEntity.setCreateUserId(ssoUser == null ? " " : ssoUser.getUserId());
                questionnaireEntity.setCreateUserName(ssoUser == null ? " " : ssoUser.getUserName());
                questionnaireEntity.setModifyUserName(ssoUser == null ? " " : ssoUser.getUserName());
                questionnaireEntity.setModifyUserId(ssoUser == null ? " " : ssoUser.getUserId());
                questionnaireEntity.setIcon(VivoConfigManager.get("icon.url"));
            }
            questionnaireDao.insertSelective(questionnaireEntity);
            updateQuestionLanguage(questionnaireEntity, questionnaireBO);
            BeanUtils.copyProperties(questionnaireBO, questionnaireDescEntity);
            questionnaireDescEntity.setQuestionnaireId(questionnaireEntity.getQuestionnaireId());
            questionnaireDescDao.insertSelective(questionnaireDescEntity);
        } else {
            questionnaireEntity.setStartTime(questionnaireBO.getStartTime() == null ? null : simpleDateFormat.parse(questionnaireBO.getStartTime()));
            questionnaireEntity.setEndTime(questionnaireBO.getEndTime() == null ? null : simpleDateFormat.parse(questionnaireBO.getEndTime()));
            QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
            questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
            QuestionnaireEntity questionnaireBean = questionnaireDao.getQuestionnaire(questionnaireDTO);
            //只有当前问卷是草稿的状态，才需要修改提交后改状态
            if (questionnaireBean.getStatus() != QuestionnaireStatusEnum.DRAFT.getStatus()) {
                questionnaireEntity.setStatus(null);
            }
            questionnaireEntity.setModifyUserId(ssoUser == null ? " " : ssoUser.getUserId());
            questionnaireEntity.setModifyUserName(ssoUser == null ? " " : ssoUser.getUserName());
            questionnaireDao.updateByPrimaryKeySelective(questionnaireEntity);
            QuestionnaireEntity questionnaire = questionnaireDao.selectByQuestionnaireId(questionnaireEntity.getQuestionnaireId());
            updateQuestionLanguage(questionnaire, questionnaireBO);
            BeanUtils.copyProperties(questionnaireBO, questionnaireDescEntity);
            questionnaireDescDao.updateByPrimaryKeySelective(questionnaireDescEntity);
        }
        return CommonVO.success("操作成功");
    }

    private void updateQuestionLanguage(QuestionnaireEntity questionnaireEntity, QuestionnaireBO questionnaireBO) {
        String questionIdList = questionnaireEntity.getQuestionIdList();
        if (StringUtil.isNotBlank(questionIdList)) {
            List<String> list = Arrays.asList(questionIdList.split(","));
            for (String questionId : list) {
                QuestionEntity questionEntity = new QuestionEntity();
                questionEntity.setQuestionId(questionId);
                questionEntity.setQuestionnaireId(questionnaireEntity.getQuestionnaireId());
                setLanguage(null, questionEntity, questionnaireBO);
                questionDao.updateBySelective(questionEntity);
            }
        }
    }

    private CommonVO checkLanguageOption(QuestionnaireBO questionnaireBO) {
        if (LanguageEnum.HINDI.getValue().equals(questionnaireBO.getTranslateLanguage()) || (questionnaireBO.getTranslateLanguage().indexOf(LanguageEnum.ENGLISH.getValue()) != -1
                && questionnaireBO.getTranslateLanguage().indexOf(LanguageEnum.HINDI.getValue()) != -1)) {
            return CommonVO.success();
        }
        return CommonVO.badParams("只能单独选中印地语或同时勾选英语和印地语");
    }

    private void setLanguage(QuestionnaireDescEntity questionnaireDescEntity, QuestionEntity questionEntity, QuestionnaireBO questionnaireBO) {
        if (StringUtil.isBlank(questionnaireBO.getTranslateLanguage())) {
            return;
        }
        if (questionnaireBO.getTranslateLanguage().indexOf(LanguageEnum.ENGLISH.getValue()) != -1) {
            if (questionEntity != null) {
                questionEntity.setLanguage(LanguageEnum.CHINESE.getValue());
            }
            if (questionnaireDescEntity != null) {
                questionnaireDescEntity.setLanguage(LanguageEnum.CHINESE.getValue());
            }
        } else {
            if (questionEntity != null) {
                questionEntity.setLanguage(LanguageEnum.ENGLISH.getValue());
            }
            if (questionnaireDescEntity != null) {
                questionnaireDescEntity.setLanguage(LanguageEnum.ENGLISH.getValue());
            }
        }
        return;
    }

    private CommonVO paramVerification(QuestionnaireBO questionnaireBO, Date startDateTime, Date endDateTime) {
        //非问卷创建最后一页，不需校验
        if (questionnaireBO.getDraftButtonPosition() != 1) {
            return CommonVO.success();
        }
        if (StringUtils.isBlank(questionnaireBO.getPersonalQuestionIds()) && StringUtils.isBlank(questionnaireBO.getMainBodyQuestionIds())) {
            return CommonVO.error("个人信息问题和问卷问题至少设置一个");
        }
        if (StringUtils.isBlank(questionnaireBO.getTitle())) {
            return CommonVO.error("title不能为空");
        }
        if (StringUtils.isBlank(questionnaireBO.getStartTime())) {
            return CommonVO.error("开始时间不能为空");
        }
        if (StringUtils.isBlank(questionnaireBO.getEndTime())) {
            return CommonVO.error("结束时间不能为空");
        }
        if (StringUtils.isBlank(questionnaireBO.getTranslateLanguage())) {
            return CommonVO.error("语言类型不能为空");
        }
        if (questionnaireBO.getTranslateLanguage().indexOf(LanguageEnum.CHINESE.getValue()) == -1 &&
                questionnaireBO.getTranslateLanguage().indexOf(LanguageEnum.ENGLISH.getValue()) == -1 &&
                questionnaireBO.getTranslateLanguage().indexOf(LanguageEnum.HINDI.getValue()) == -1) {
            return CommonVO.error("语言类型值有误");
        }
        if (questionnaireBO.getIsReward() == null) {
            return CommonVO.error("是否有抽奖不能为空");
        }
        if (StringUtils.isBlank(questionnaireBO.getCueWord())) {
            return CommonVO.error("提示语不能为空");
        }
        if (!startDateTime.before(endDateTime)) {
            return CommonVO.error("结束时间必须大于开始时间");
        }
        if (!new Date().before(startDateTime)) {
            return CommonVO.error("开始时间必须大于当前时间");
        }
        return CommonVO.success();
    }

    @Override
    public List<QuestionnaireVO> getQuestionnaireList(QuestionnaireDTO questionnaireDTO, Pageable pageable) {
        questionnaireDTO.setOffset(pageable.getOffset());
        questionnaireDTO.setLimit(pageable.getPageSize());
        List<QuestionnaireEntity> questionnaireEntityList = questionnaireDao.getQuestionnaireList(questionnaireDTO);
        List<QuestionnaireVO> questionnaireVOList = Lists.newArrayList();
        QuestionnaireDescEntity questionnaireDescDTO = new QuestionnaireDescEntity();
        for (QuestionnaireEntity questionnaireEntity : questionnaireEntityList) {
            questionnaireDescDTO.setQuestionnaireId(questionnaireEntity.getQuestionnaireId());
            questionnaireDescDTO.setTitle(questionnaireDTO.getTitle());
            if (questionnaireEntity.getStatus() != QuestionnaireStatusEnum.DRAFT.getStatus()) {
                questionnaireDescDTO.setLanguage(LanguageEnum.CHINESE.getValue());
            }
            QuestionnaireDescEntity questionnaireDescEntity = questionnaireDescDao.selectBySelective(questionnaireDescDTO);
            if (questionnaireDescEntity == null) {
                questionnaireDescDTO.setLanguage(LanguageEnum.ENGLISH.getValue());
                questionnaireDescEntity = questionnaireDescDao.selectBySelective(questionnaireDescDTO);
            }
            if (questionnaireDescEntity == null) {
                continue;
            }
            questionnaireEntity.setTitle(questionnaireDescEntity.getTitle());
            QuestionnaireVO questionnaireVO = new QuestionnaireVO();
            BeanUtils.copyProperties(questionnaireEntity, questionnaireVO);
            questionnaireVO.setCreateTime(questionnaireEntity.getCreateTime() == null ? null : SIMPLE_DATE_FORMAT.format(questionnaireEntity.getCreateTime()));
            questionnaireVO.setLanguage(questionnaireDescEntity.getLanguage());
            setTime(questionnaireEntity, null, questionnaireVO);
            questionnaireVOList.add(questionnaireVO);
        }
        return questionnaireVOList;
    }

    @Override
    public Integer countQuestionnaire(QuestionnaireDTO questionnaireDTO) {
        return questionnaireDao.selectCountByCondition(questionnaireDTO);
    }

    @Override
    public QuestionnaireDetailVO getQuestionnaireDetail(QuestionnaireDTO questionnaireDTO) {
        QuestionnaireDetailVO questionnaireDetailVO = new QuestionnaireDetailVO();
        QuestionnaireEntity questionnaireEntity = questionnaireDao.getQuestionnaire(questionnaireDTO);
        if (questionnaireEntity == null) {
            return null;
        }
        List<String> languageList = null;
        //非草稿状态下才需要根据语言类型查询,草稿数据可能还没设置翻译语言
        if (questionnaireEntity.getStatus() != QuestionnaireStatusEnum.DRAFT.getStatus()) {
            languageList = Arrays.asList(questionnaireDTO.getLanguage());
        }
        BeanUtils.copyProperties(questionnaireEntity, questionnaireDetailVO);

        List<QuestionnaireDescEntity> questionnaireDescEntityList = questionnaireDescDao.selectByQuestionnaireId(questionnaireEntity.getQuestionnaireId(), languageList);
        if (!CollectionUtils.isEmpty(questionnaireDescEntityList)) {
            questionnaireDetailVO.setTitle(questionnaireDescEntityList.get(0).getTitle());
            questionnaireDetailVO.setCueWord(questionnaireDescEntityList.get(0).getCueWord());
            questionnaireDetailVO.setDescription(questionnaireDescEntityList.get(0).getDescription());
            String language = questionnaireDescDao.selectLanguageBySelective(questionnaireDTO.getQuestionnaireId());
            if (StringUtil.isNotBlank(language)) {
                List<HashMap<String, String>> languageVOList = Lists.newArrayList();
                for (String string : Arrays.asList(language.split(","))) {
                    HashMap<String, String> languageHashMap = Maps.newHashMap();
                    languageHashMap.put("key", LanguageEnum.getEnum(string).getValue());
                    languageHashMap.put("value", LanguageEnum.getEnum(string).getDesc());
                    languageVOList.add(languageHashMap);
                }
                questionnaireDetailVO.setLanguageList(languageVOList);
                questionnaireDetailVO.setTranslateLanguage(questionnaireDescEntityList.get(0).getTranslateLanguage());
            }
        }
        setTime(questionnaireEntity, questionnaireDetailVO, null);
        List<QuestionVO> personalInformationQuestionList = Lists.newArrayList();
        List<QuestionVO> mainBodyQuestionList = Lists.newArrayList();
        List<QuestionEntity> questionEntityList = questionDao.selectByQuestionIdList(Arrays.asList(questionnaireEntity.getQuestionIdList().split(",")), null);
        List<String> personalQuestionIdList = Lists.newArrayList();
        List<String> mainBodyQuestionIdList = Lists.newArrayList();
        for (QuestionEntity questionEntity : questionEntityList) {
            //个人信息问题
            if (questionEntity.getPosition() == 0) {
                personalQuestionIdList.add(questionEntity.getQuestionId());
            } else {
                mainBodyQuestionIdList.add(questionEntity.getQuestionId());
            }
            if (questionnaireEntity.getStatus() == QuestionnaireStatusEnum.DRAFT.getStatus() || questionEntity.getLanguage().equals(questionnaireDTO.getLanguage())) {
                QuestionVO questionVO = new QuestionVO();
                BeanUtils.copyProperties(questionEntity, questionVO);
                if (questionEntity.getPosition() == 0) {
                    personalInformationQuestionList.add(questionVO);
                } else {
                    mainBodyQuestionList.add(questionVO);
                }
            }
        }
        questionnaireDetailVO.setPersonalQuestionIdList(personalQuestionIdList);
        questionnaireDetailVO.setMainBodyQuestionIdList(mainBodyQuestionIdList);
        QuestionPosition questionPosition = new QuestionPosition();
        assembleResult(questionnaireDetailVO, questionPosition, mainBodyQuestionList, personalInformationQuestionList);
        return questionnaireDetailVO;
    }

    public void assembleResult(QuestionnaireDetailVO questionnaireDetailVO, QuestionPosition questionPosition, List<QuestionVO> mainBodyQuestionList, List<QuestionVO> personalInformationQuestionList) {
        HashMap<String, List<QuestionVO>> personalInformationQuestionsMap = Maps.newHashMap();
        personalInformationQuestionsMap.put("personalQuestion", personalInformationQuestionList);
        questionPosition.setPersonalInformationQuestionsMap(personalInformationQuestionsMap);
        HashMap<String, List<QuestionVO>> mainInformationQuestionsMap = Maps.newHashMap();
        mainInformationQuestionsMap.put("mainBodyQuestion", mainBodyQuestionList);
        questionPosition.setMainBodyQuestionsMap(mainInformationQuestionsMap);
        HashMap<String, Object> questionnaireInfoMap = Maps.newHashMap();
        questionnaireInfoMap.put("personalInformationQuestionsMap", personalInformationQuestionsMap);
        questionnaireInfoMap.put("mainBodyQuestionsMap", mainInformationQuestionsMap);
        questionnaireDetailVO.setQuestionnaireInfoMap(questionnaireInfoMap);
    }

    private void setTime(QuestionnaireEntity questionnaireEntity, QuestionnaireDetailVO questionnaireDetailVO, QuestionnaireVO questionnaireVO) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (questionnaireEntity.getStartTime() != null) {
            if (questionnaireVO != null) {
                questionnaireVO.setStartTime(simpleDateFormat.format(questionnaireEntity.getStartTime()));
            }
            if (questionnaireDetailVO != null) {
                questionnaireDetailVO.setStartTime(simpleDateFormat.format(questionnaireEntity.getStartTime()));
            }
        }
        if (questionnaireEntity.getEndTime() != null) {
            if (questionnaireVO != null) {
                questionnaireVO.setEndTime(simpleDateFormat.format(questionnaireEntity.getEndTime()));
            }
            if (questionnaireDetailVO != null) {
                questionnaireDetailVO.setEndTime(simpleDateFormat.format(questionnaireEntity.getEndTime()));
            }
        }
    }

    @Override
    public QuestionnaireEntity getQuestionnaireEntity(QuestionnaireDTO questionnaireDTO) {
        QuestionnaireEntity questionnaireEntity = questionnaireDao.getQuestionnaire(questionnaireDTO);
        return questionnaireEntity;
    }

    @Override
    public CommonVO judgeOperationType(QuestionnaireBO questionnaireBO) throws RuntimeException {
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
        QuestionnaireEntity questionnaireEntity = questionnaireDao.getQuestionnaire(questionnaireDTO);
        QuestionnaireOperationTypeEnum questionnaireOperationTypeEnum;
        //审核不通过时候需要 传入auditAfterstatus 用于区分已上线卡片禁用审核不通过还是已下线卡片禁用审核不通过
        if (questionnaireBO.getApprovalStatus().equals(AuditStatus.NOT_PASS_AUDIT_STATUS) && questionnaireBO.getAuditType().intValue() != 6) {
            questionnaireOperationTypeEnum = QuestionnaireOperationTypeEnum.codeOf(questionnaireEntity.getStatus(), questionnaireBO.getAuditType(), questionnaireBO.getApprovalStatus(), questionnaireEntity.getPreApprovalStatus());
        } else {
            questionnaireOperationTypeEnum = QuestionnaireOperationTypeEnum.codeOf(questionnaireEntity.getStatus(), questionnaireBO.getAuditType(), questionnaireBO.getApprovalStatus());
        }
        if (questionnaireOperationTypeEnum == null) {
            return CommonVO.badParams("审核类型参数和当前卡片状态不对应");
        }
        if (StringUtils.isBlank(questionnaireBO.getReason())) {
            if (questionnaireOperationTypeEnum == QuestionnaireOperationTypeEnum.OFFLINE_AUDIT_FAILED || questionnaireOperationTypeEnum == QuestionnaireOperationTypeEnum.OFFLINE_DISABLE_AUDIT_FAILED
                    || questionnaireOperationTypeEnum == QuestionnaireOperationTypeEnum.ON_LINE_DISABLE_AUDIT_FAILED || questionnaireOperationTypeEnum == QuestionnaireOperationTypeEnum.ONLINE_AUDIT_FAILED) {
                return CommonVO.error("reason must not be null");
            }
        }
        return CommonVO.success(questionnaireOperationTypeEnum);
    }

    @Override
    public CommonVO checkAuditAuthority(SSOUser user, QuestionnaireBO questionnaireBO, QuestionnaireEntity questionnaireEntity) {
        CommonVO commonVO = judgeOperationType(questionnaireBO);
        if (commonVO.getCode() != CommonVOCode.SUCCESS) {
            return commonVO;
        }
        String response = httpClientService.doGet(ROLE_SYSTEM_URL + user.getUserId());
        List<RoleSystemResult> roleSystemResults = JsonUtils.TO_ARRAY(response, RoleSystemResult.class);
        Boolean isHavePermission = false;
        String reAuditMsg = null;
        try {
            for (RoleSystemResult rs : roleSystemResults) {
                if (!ROLE_OPERATE_NAME.equals(rs.getName()) && !ROLE_TEST_NAME.equals(rs.getName())) {
                    continue;
                }
                QuestionnaireEntity questionnaireBean = new QuestionnaireEntity();
                questionnaireBean.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
                //测试审核
                if (ROLE_TEST_NAME.equals(rs.getName())) {
                    if (questionnaireEntity.getApprovalTestStatus() != AuditStatus.DEFAULT_STATUS.intValue()) {
                        reAuditMsg = "测试已审核，不能重复审核！";
                        continue;
                    }
                    isHavePermission = true;
                    questionnaireBean.setApprovalTestStatus(questionnaireBO.getApprovalStatus());
                    questionnaireBean.setApprovalTestUserName(user.getUserName());
                    questionnaireBean.setApprovalTestUserId(user.getUserId());
                    questionnaireBean.setApprovalTestReason(questionnaireBO.getReason());
                }
                //运营审核
                if (ROLE_OPERATE_NAME.equals(rs.getName())) {
                    if (questionnaireEntity.getApprovalOperationStatus() != AuditStatus.DEFAULT_STATUS.intValue()) {
                        reAuditMsg = "运营已审核，不能重复审核！";
                        continue;
                    }
                    isHavePermission = true;
                    questionnaireBean.setApprovalOperationStatus(questionnaireBO.getApprovalStatus());
                    questionnaireBean.setApprovalOperationReason(questionnaireBO.getReason());
                    questionnaireBean.setApprovalOperationUserId(user.getUserId());
                    questionnaireBean.setApprovalOperationUserName(user.getUserName());
                }
                questionnaireDao.updateByPrimaryKeySelective(questionnaireBean);
                reAuditMsg = null;
                break;
            }
            if (StringUtils.isNotBlank(reAuditMsg)) {
                return CommonVO.error(reAuditMsg);
            }
            if (!isHavePermission) {
                return CommonVO.error("无权限进行审核");
            }
            QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
            questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
            questionnaireEntity = questionnaireDao.getQuestionnaire(questionnaireDTO);
            QuestionnaireOperationTypeEnum questionnaireOperationTypeEnum = (QuestionnaireOperationTypeEnum) commonVO.getData();
            if (questionnaireEntity.getApprovalTestStatus() == 1 && questionnaireEntity.getApprovalOperationStatus() == 1) {
                questionnaireEntity.setPreApprovalStatus(questionnaireEntity.getStatus());
                questionnaireEntity.setStatus(questionnaireOperationTypeEnum.getAuditAfterstatus());
                questionnaireDao.updateByPrimaryKeySelective(questionnaireEntity);

            }
            if (questionnaireEntity.getApprovalTestStatus() == 2) {
                questionnaireEntity.setStatus(questionnaireOperationTypeEnum.getAuditAfterstatus());
                questionnaireEntity.setRejectReason(questionnaireBO.getReason());
                questionnaireEntity.setApprovalTestReason(questionnaireBO.getReason());
            }
            if (questionnaireEntity.getApprovalOperationStatus() == 2) {
                questionnaireEntity.setStatus(questionnaireOperationTypeEnum.getAuditAfterstatus());
                questionnaireEntity.setRejectReason(questionnaireBO.getReason());
                questionnaireEntity.setApprovalOperationReason(questionnaireBO.getReason());
            }
            questionnaireDao.updateByPrimaryKeySelective(questionnaireEntity);
            return CommonVO.success("操作成功");
        } catch (Exception e) {
            LOGGER.error("{}", e);
            return CommonVO.error("操作失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonVO questionnaireAuditing(QuestionnaireDTO questionnaireDTO, SSOUser ssoUser) throws Exception {
        List<QuestionnaireDescEntity> questionnaireDescEntityList = questionnaireDescDao.selectByQuestionnaireId(questionnaireDTO.getQuestionnaireId(), Arrays.asList(LanguageEnum.CHINESE.getValue()));
        if (CollectionUtils.isEmpty(questionnaireDescEntityList)) {
            questionnaireDescEntityList = questionnaireDescDao.selectByQuestionnaireId(questionnaireDTO.getQuestionnaireId(), Arrays.asList(LanguageEnum.ENGLISH.getValue()));
            if (CollectionUtils.isEmpty(questionnaireDescEntityList)) {
                return CommonVO.error("该调查问卷描述无记录");
            }
        }
        QuestionnaireEntity questionnaireEntity = questionnaireDao.getQuestionnaire(questionnaireDTO);
        if (questionnaireEntity.getApprovalTestStatus() != 1 || questionnaireEntity.getApprovalOperationStatus() != 1) {
            return CommonVO.success("操作成功");
        }
        //已上线状态下 需要插入t_publish_strategy表
        ExPublishEntity exPublishEntity = new ExPublishEntity();
        exPublishEntity.setBizId(String.valueOf(questionnaireEntity.getQuestionnaireId()));
        if (questionnaireEntity.getStatus() == QuestionnaireStatusEnum.ONLINE.getStatus()) {
            exPublishEntity.setBizName(questionnaireDescEntityList.get(0).getTitle());
            exPublishEntity.setBizEndTime(questionnaireEntity.getEndTime());
            exPublishEntity.setBizStatus(QuestionnaireStatusEnum.ONLINE.getStatus());
            exPublishEntity.setModifyUserName(ssoUser.getUserName());
            exPublishEntity.setIsReward(questionnaireEntity.getIsReward());
            PublishStrategyDetail publishDetail = publishService.getPublishDetail(null, exPublishEntity.getBizId());
            if (publishDetail == null) {
                publishService.insertSelective(exPublishEntity);
                Long id = exPublishEntity.getId();
                String strategyId = "strategy_" + id;
                publishService.updateStrategy(id, strategyId);
            } else {
                exPublishEntity.setId(publishDetail.getId());
                publishService.updateSelective(exPublishEntity);
            }
        }
        if (questionnaireEntity.getStatus() == QuestionnaireStatusEnum.OFFLINE.getStatus() || questionnaireEntity.getStatus() == QuestionnaireStatusEnum.DISABLED.getStatus()) {
            exPublishEntity.setBizStatus(questionnaireEntity.getStatus());
            exPublishEntity.setIsReward(questionnaireEntity.getIsReward());
            exPublishEntity.setStatus(PublishStatus.PUBLISH_PAUSE.getCode());
            exPublishEntity.setModifyUserName(ssoUser.getUserName());
            publishService.updateSelective(exPublishEntity);
        }
        exPublishDao.updateBizStatus(questionnaireEntity.getQuestionnaireId(), questionnaireEntity.getModifyUserName(), questionnaireEntity.getStatus());
        return CommonVO.success("操作成功");
    }

    @Override
    public CommonVO stateJudgement(QuestionnaireBO questionnaireBO, QuestionnaireEntity questionnaireEntity) {
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
        QuestionnaireEntity questionnaireDetail = questionnaireDao.getQuestionnaire(questionnaireDTO);
        if (questionnaireEntity.getStatus() == QuestionnaireStatusEnum.ONLINE_AUDIT.getStatus()) {
            if (questionnaireDetail.getStatus() != QuestionnaireStatusEnum.TRANSLATION_TO_BE_IMPORTED.getStatus() && questionnaireDetail.getStatus() != QuestionnaireStatusEnum.BACK.getStatus()) {
                return CommonVO.error("当前卡片不处于待上线/驳回状态，无法申请上线");
            }
        } else if (questionnaireEntity.getStatus() == QuestionnaireStatusEnum.OFFLINE_AUDIT.getStatus()) {
            if (questionnaireDetail.getStatus() != QuestionnaireStatusEnum.ONLINE.getStatus()) {
                return CommonVO.error("只有已上线卡片才能申请下线");
            }
            questionnaireEntity.setPulloffReason(questionnaireBO.getReason());
        } else if (questionnaireEntity.getStatus() == QuestionnaireStatusEnum.DISABLEAUDIT.getStatus()) {
            if (questionnaireDetail.getStatus() != QuestionnaireStatusEnum.ONLINE.getStatus() && questionnaireDetail.getStatus() != QuestionnaireStatusEnum.OFFLINE.getStatus()) {
                return CommonVO.error("已上线或已下线状态卡片才能申请禁用");
            }
            questionnaireEntity.setDisableReason(questionnaireBO.getReason());
        } else {
            return CommonVO.error("当前卡片状态不支持发起申请");
        }
        return CommonVO.success("操作成功");
    }

    @Override
    public int updateCardsBySelective(QuestionnaireEntity questionnaireEntity) {
        return questionnaireDao.updateByPrimaryKeySelective(questionnaireEntity);
    }

    private QuestionnaireEntity isExistQuestionnaire(QuestionnaireBO questionnaireBO) {
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
        QuestionnaireEntity questionnaireEntity = questionnaireDao.getQuestionnaire(questionnaireDTO);
        return questionnaireEntity;
    }

    private Boolean isAllowModify(QuestionnaireEntity questionnaireEntity) {
        if (questionnaireEntity.getStatus() != QuestionnaireStatusEnum.DRAFT.getStatus() && questionnaireEntity.getStatus() != QuestionnaireStatusEnum.TEXT_TO_BE_EXPORTED.getStatus()
                && questionnaireEntity.getStatus() != QuestionnaireStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus()) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteQuestionnaire(String questionnaireId, Integer status) {
        int count = questionnaireDao.deleteByQuestionnaireId(questionnaireId, status);
        count += questionDao.deleteByQuestionnaireId(questionnaireId);
        count += questionnaireDescDao.deleteByQuestionnaireId(questionnaireId);
        return count;
    }


    @Override
    public int deleteQuestion(List<String> questionIdList, String questionnaireId) {
        return questionDao.deleteByQuestionId(questionIdList, questionnaireId);
    }

    @Override
    public String getQuestionnaireId() {
        String jdbcUrl = VivoConfigManager.get("mysql.jdbcurl");
        String tableSchema = jdbcUrl.substring(jdbcUrl.lastIndexOf("/") + 1, jdbcUrl.indexOf("?"));
        return QUESTIONNAIREABBREVIATION + questionnaireDao.getId(tableSchema);
    }

}
