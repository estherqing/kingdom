package com.vivo.jovi.exscene.backend.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vivo.console.data.domain.SimplePage;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireService;
import com.vivo.jovi.exscene.backend.service.IUploadFileService;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireDetailVO;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.exscene.backend.web.filter.ThreadLocalSSOUser;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.constant.LanguageEnum;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.model.bo.QuestionBO;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.model.dto.QuestionnaireDTO;
import com.vivo.jovi.scene.common.util.FileUtil;
import com.vivo.jovi.scene.common.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Classname QuestionnaireController
 * @Description 调研卡片
 * @Date 2019-05-05 16:11
 * @Created by Administrator
 * @Version 1.0
 */
@Controller
@RequestMapping("/exscene/questionnaire/")
public class QuestionnaireController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireController.class);

    @Autowired
    private IQuestionnaireService questionnaireService;

    @Autowired
    private IUploadFileService uploadFileService;

    @RequestMapping("index")
    public String cardsHome() {
        return "scene/cards/index";
    }

    @RequestMapping("audit")
    public String auditHome() {
        return "scene/cardsAudit/index";
    }


    public String paramVerification(QuestionBO questionBO) {
        String message = null;
        if (StringUtils.isBlank(questionBO.getContent())) {
            message = "问题内容必填";
        }
        if (null == questionBO.getType()) {
            message = "问题类型必填";
        }
        if (null == questionBO.getLanguage()) {
            message = "语言必填";
        }
        if (null == questionBO.getIsRequired()) {
            message = "是否为必填选项必填";
        }
        if (null == questionBO.getAnswer()) {
            message = "问题标准答案必填";
        }
        if (null == questionBO.getPosition()) {
            message = "问题出现的位置必填";
        }
        return message;
    }

    @RequestMapping(value = "saveQuestion", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO saveQuestion(@RequestBody QuestionBO questionBO) {
        String message = paramVerification(questionBO);
        if (StringUtils.isNotBlank(message)) {
            return CommonVO.error(message);
        }
        try {
            SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
            CommonVO commonVO = questionnaireService.saveQuestion(questionBO, ssoUser);
            return commonVO;
        } catch (Exception e) {
            LOGGER.error("saveQuestion()发生异常 {}", e);
            return CommonVO.error("操作发生异常");
        }
    }

    @RequestMapping(value = "saveQuestionnaire", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO saveQuestionnaire(@RequestBody QuestionnaireBO questionnaireBO) {
        if (questionnaireBO.getOperationType() == null) {
            return CommonVO.error("operationType不能为空");
        }
        try {
            SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
            CommonVO commonVO = questionnaireService.saveQuestionnaire(questionnaireBO, ssoUser);
            return commonVO;
        } catch (Exception e) {
            LOGGER.error("saveQuestionnaire()发生异常 {}", e);
            return CommonVO.error("操作发生异常");
        }
    }

    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public CommonVO getQuestionnaireList(QuestionnaireDTO questionnaireDTO) {
        if (null == questionnaireDTO.getPage()) {
            questionnaireDTO.setPage(1);
        }
        if (StringUtils.isBlank(questionnaireDTO.getOrder())) {
            questionnaireDTO.setOrder("desc");
        }
        if (null == questionnaireDTO.getSize()) {
            questionnaireDTO.setSize(20);
        }
        Pageable pageable = new PageRequest(questionnaireDTO.getPage() - 1, questionnaireDTO.getSize(), null);
        List<QuestionnaireVO> questionnaireVOList = questionnaireService.getQuestionnaireList(questionnaireDTO, pageable);
        Integer count = questionnaireService.countQuestionnaire(questionnaireDTO);
        SimplePage<QuestionnaireVO> simplePage = new SimplePage<>(questionnaireVOList, pageable, count);
        return CommonVO.success(simplePage);
    }

    @RequestMapping(value = "getStatus", method = RequestMethod.GET)
    @ResponseBody
    public CommonVO getStatus() {
        List<Map<String, String>> enumList = Lists.newArrayList();
        for (QuestionnaireStatusEnum questionnaireStatusEnum : QuestionnaireStatusEnum.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("propertyValue", questionnaireStatusEnum.getStatus() + "");
            map.put("propertyDesc", questionnaireStatusEnum.getDesc());
            enumList.add(map);
        }
        return CommonVO.success(enumList);
    }

    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @ResponseBody
    public CommonVO getQuestionnaireDetail(QuestionnaireDTO questionnaireDTO) {
        if (StringUtil.isBlank(questionnaireDTO.getQuestionnaireId())) {
            return CommonVO.badParams("questionnaireId must not be null");
        }
        if (StringUtil.isBlank(questionnaireDTO.getLanguage())) {
            questionnaireDTO.setLanguage(LanguageEnum.CHINESE.getValue());
        }
        try {
            QuestionnaireDetailVO questionnaireDetailVO = questionnaireService.getQuestionnaireDetail(questionnaireDTO);
            if (questionnaireDetailVO == null) {
                return CommonVO.error("该调查问卷记录不存在");
            }
            return CommonVO.success(questionnaireDetailVO);
        } catch (Exception e) {
            LOGGER.error("getQuestionnaireDetail error, {}, questionnaireDTO={}", e, questionnaireDTO.toString());
            return CommonVO.error("获取调查问卷详情时发生异常");
        }
    }

    @RequestMapping(value = "auditList", method = RequestMethod.GET)
    @ResponseBody
    public CommonVO getQuestionnaireAuditList(QuestionnaireDTO questionnaireDTO) {
        questionnaireDTO.setStatusList(Arrays.asList(QuestionnaireStatusEnum.ONLINE_AUDIT.getStatus(),
                QuestionnaireStatusEnum.OFFLINE_AUDIT.getStatus(), QuestionnaireStatusEnum.DISABLEAUDIT.getStatus()));
        return getQuestionnaireList(questionnaireDTO);
    }

    @RequestMapping(value = "onlineApply", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO onlineApply(@RequestBody QuestionnaireBO questionnaireBO) {
        questionnaireBO.setAuditType(QuestionnaireStatusEnum.ONLINE_AUDIT.getStatus());
        return judgeOperationType(questionnaireBO);
    }

    @RequestMapping(value = "offlineApply", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO offlineApply(@RequestBody QuestionnaireBO questionnaireBO) {
        questionnaireBO.setAuditType(QuestionnaireStatusEnum.OFFLINE_AUDIT.getStatus());
        return judgeOperationType(questionnaireBO);
    }

    @RequestMapping(value = "disableApply", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO disableApply(@RequestBody QuestionnaireBO questionnaireBO) {
        questionnaireBO.setAuditType(QuestionnaireStatusEnum.DISABLEAUDIT.getStatus());
        return judgeOperationType(questionnaireBO);
    }

    public CommonVO judgeOperationType(QuestionnaireBO questionnaireBO) {
        if (StringUtils.isBlank(questionnaireBO.getQuestionnaireId())) {
            return CommonVO.badParams("questionnaireId must not be null");
        }
        try {
            QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
            questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
            QuestionnaireEntity questionnaireEntity = questionnaireService.getQuestionnaireEntity(questionnaireDTO);
            Integer status = questionnaireEntity.getStatus();
            if (questionnaireEntity == null) {
                return CommonVO.error(CommonVOCode.NO_DATA, "该调查问卷记录不存在");
            }
            SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
            BeanUtils.copyProperties(questionnaireBO, questionnaireEntity);
            questionnaireEntity.setModifyUserName(ssoUser.getUserName());
            questionnaireEntity.setPreApprovalStatus(status);
            questionnaireEntity.setStatus(questionnaireBO.getAuditType());
            /**
             * 清除之前的审核进度状态数据 避免错误显示
             */
            questionnaireEntity.setApprovalTestStatus(0);
            questionnaireEntity.setApprovalTestReason("");
            questionnaireEntity.setApprovalTestUserName("");
            questionnaireEntity.setApprovalOperationStatus(0);
            questionnaireEntity.setApprovalOperationUserName("");
            questionnaireEntity.setApprovalOperationReason("");
            CommonVO commonVO = questionnaireService.stateJudgement(questionnaireBO, questionnaireEntity);
            if (!commonVO.getCode().equals(CommonVO.success().getCode())) {
                return commonVO;
            }
            int count = questionnaireService.updateCardsBySelective(questionnaireEntity);
            if (count > 0) {
                return CommonVO.success("操作成功");
            }
            return CommonVO.error(CommonVOCode.OPERATION_FAILURE, "更新失败");
        } catch (Exception e) {
            LOGGER.error("judgeOperationType error, questionnaireBO:{}", questionnaireBO.toString(), e);
            return CommonVO.error("judgeOperationType Failed");
        }
    }

    @RequestMapping("auditing")
    @ResponseBody
    public CommonVO questionnaireAuditing(@RequestBody QuestionnaireBO questionnaireBO) {
        if (null == questionnaireBO.getApprovalStatus()) {
            return CommonVO.badParams("approvalStatus must not be null");
        }
        if (null == questionnaireBO.getQuestionnaireId()) {
            return CommonVO.badParams("questionnaireId must not be null");
        }
        if (null == questionnaireBO.getAuditType()) {
            return CommonVO.badParams("auditType must not be null");
        }
        if (questionnaireBO.getApprovalStatus() == 2 && StringUtils.isBlank(questionnaireBO.getReason())) {
            return CommonVO.badParams("审核没通过时,驳回理由reason必填");
        }
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        questionnaireDTO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
        QuestionnaireEntity questionnaireEntity = questionnaireService.getQuestionnaireEntity(questionnaireDTO);
        if (questionnaireEntity == null) {
            return CommonVO.error(CommonVOCode.NO_DATA, "调查问卷不存在");
        }
        try {
            SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
            CommonVO commonVO = questionnaireService.checkAuditAuthority(ssoUser, questionnaireBO, questionnaireEntity);
            if (commonVO.getCode() != CommonVOCode.SUCCESS) {
                return commonVO;
            }
            return questionnaireService.questionnaireAuditing(questionnaireDTO, ssoUser);
        } catch (Exception e) {
            LOGGER.error("questionnaireAuditing error, questionnaireBO:{}", questionnaireBO.toString(), e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping("uploadIcon")
    @ResponseBody
    public CommonVO uploadQuestionnaireIcon(@RequestParam(value = "questionnaireId", required = false) String questionnaireId,
                                            @RequestParam(value = "iconFile") MultipartFile iconFile) throws IOException {

        if (iconFile == null || iconFile.isEmpty()) {
            LOGGER.error("Questionnaire：{} 上传的Icon异常。", questionnaireId);
            return CommonVO.badParams("上传的Icon异常");
        }

        String docSuffix = iconFile.getOriginalFilename().substring(iconFile.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg".equals(docSuffix) && !"png".equals(docSuffix) && !"jpeg".equals(docSuffix)) {
            LOGGER.error("Questionnaire：{} 上传的Icon不是jpg/png/jpeg。", questionnaireId);
            return CommonVO.badParams("上传的Icon不是jpg/png/jpeg");
        }
        if (!FileUtil.checkFileSize(iconFile.getSize(), 50, "K")) {
            LOGGER.error("Questionnaire：{} 上传的Icon过大", questionnaireId);
            return CommonVO.badParams("上传的Icon过大");
        }
        BufferedImage bufferedImage = ImageIO.read(iconFile.getInputStream()); // 通过MultipartFile得到InputStream，从而得到BufferedImage
        if (bufferedImage == null) {
            // 证明上传的文件不是图片，获取图片流失败，不进行下面的操作
            return CommonVO.badParams("上传的不是图片！");
        }
        Integer width = bufferedImage.getWidth();
        Integer height = bufferedImage.getHeight();
        if (!width.equals(height)) { // 策划要求图片宽高相等
            return CommonVO.badParams("图片宽高需保持一致！");
        }

        String iconUrl = uploadFileService.uploadFile(UUID.randomUUID().toString() +
                        iconFile.getOriginalFilename().substring(iconFile.getOriginalFilename().lastIndexOf("."))
                , iconFile.getInputStream(), docSuffix);
        HashMap<String, String> result = Maps.newHashMap();
        result.put("iconUrl", iconUrl);
        return CommonVO.success(result);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO deleteQuestionnaireInfo(@RequestBody JSONObject jsonObject) {
        if (jsonObject == null) {
            return CommonVO.error("传递的参数不能为空");
        }
        Integer operationType = jsonObject.getInteger("operationType");
        if (operationType == null) {
            return CommonVO.error("operationType不能为空");
        }
        String questionnaireId = (String) jsonObject.get("questionnaireId");
        int count;
        try {
            //0删除问题 1删除问卷&问题&问卷描述
            if (operationType == 0) {
                String questionId = jsonObject.getJSONArray("questionId").toString();
                List<String> questionnaireIdList = getJsonToList(questionId);
                if (CollectionUtils.isEmpty(questionnaireIdList)) {
                    return CommonVO.error("questionId不能为空");
                }
                count = questionnaireService.deleteQuestion(questionnaireIdList, questionnaireId);
            } else {
                if (StringUtil.isBlank(questionnaireId)) {
                    return CommonVO.error("questionnaireId不能为空");
                }
                count = questionnaireService.deleteQuestionnaire(questionnaireId, QuestionnaireStatusEnum.DRAFT.getStatus());
            }
            if (count > 0) {
                return CommonVO.success("操作成功");
            }
            return CommonVO.error("操作失败");
        } catch (Exception e) {
            LOGGER.error("deleteQuestionnaireInfo error, questionnaireId:{}", questionnaireId, e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, e.getMessage());
        }
    }


    /**
     * 功能描述：把JSON数据转换成较为复杂的List<Map<String, Object>>
     * @param jsonData JSON数据
     * @return List<String, Object>
     */
    public static List<String> getJsonToList(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<String>>() {
        });
    }
}
