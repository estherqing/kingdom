package com.vivo.jovi.exscene.api.service.impl;

import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.api.common.constant.BizOp;
import com.vivo.jovi.exscene.api.service.ICacheManager;
import com.vivo.jovi.exscene.api.service.ILocalCacheManager;
import com.vivo.jovi.exscene.api.service.IQuestionnaireService;
import com.vivo.jovi.exscene.api.service.model.form.LuckDrawForm;
import com.vivo.jovi.exscene.api.service.model.form.Question;
import com.vivo.jovi.exscene.api.service.model.form.QuestionnaireForm;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionVO;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireDescVO;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireDetailVO;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.constant.PublishStatus;
import com.vivo.jovi.scene.common.constant.PublishType;
import com.vivo.jovi.scene.common.constant.QuestionTypeEnum;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.dal.dao.*;
import com.vivo.jovi.scene.common.dal.entity.*;
import com.vivo.jovi.scene.common.model.ExsceneBizQueryParam;
import com.vivo.jovi.scene.common.model.dto.QuestionnaireDTO;
import com.vivo.jovi.scene.common.util.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnaireService implements IQuestionnaireService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireService.class);

    @Autowired
    private IQuestionnaireUserDao questionnaireUserDao;

    @Autowired
    private IAnswerDao answerDao;

    @Autowired
    private IQuestionnaireDescDao questionnaireDescDao;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private ICacheManager cacheManager;

    @Autowired
    private ILocalCacheManager localCacheManager;

    @Autowired
    private IQuestionDao questionDao;

    @Autowired
    private IAnswerCountDao answerCountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonVO answer(QuestionnaireForm questionnaireForm) {
        QuestionnaireUserEntity questionnaireUserEntity = localCacheManager.selectByQuestionnaireIdAndUserId(questionnaireForm.getQuestionnaireId(), questionnaireForm.getUserId());
        if(questionnaireUserEntity == null){
            questionnaireUserEntity = questionnaireUserDao.selectByQuestionnaireIdAndUserId(questionnaireForm.getQuestionnaireId(), questionnaireForm.getUserId());
        }
        if (questionnaireUserEntity == null){
            questionnaireUserEntity = new QuestionnaireUserEntity();
            questionnaireUserEntity.setQuestionnaireId(questionnaireForm.getQuestionnaireId());
            questionnaireUserEntity.setModel(questionnaireForm.getModel());
            questionnaireUserEntity.setAndroidVersion(questionnaireForm.getAndroidVersion());
            questionnaireUserEntity.setAnswerTime(new Date());
            questionnaireUserEntity.setSex(questionnaireForm.getSex());
            questionnaireUserEntity.setAge(questionnaireForm.getAge());
            questionnaireUserEntity.setProfession(questionnaireForm.getProfession());
            questionnaireUserEntity.setUserId(questionnaireForm.getUserId());

            int row = questionnaireUserDao.insertSelective(questionnaireUserEntity);
            if (row <= 0){
                LOGGER.error("新增用户信息失败，questionnaireUserEntity:{}", questionnaireUserEntity);
                return CommonVO.error(CommonVOCode.OPERATION_FAILURE, "提交答案失败");
            }

            List<Question> questionList = questionnaireForm.getQuestion();
            for (Question question: questionList){
                AnswerEntity answerEntity = new AnswerEntity();
                answerEntity.setQuestionnaireId(questionnaireForm.getQuestionnaireId());
                answerEntity.setQuestionId(question.getQuestionId());
                answerEntity.setType(question.getType());
                answerEntity.setLanguage(questionnaireForm.getLanguage());
                answerEntity.setAnswer(question.getAnswer());
                answerEntity.setUserId(questionnaireForm.getUserId());

                row = answerDao.insertSelective(answerEntity);
                if (row <= 0){
                    LOGGER.error("新增用户答案失败，answerEntity:{}", answerEntity);
                    String msg = questionnaireUserDao.selectCueWord(CommonVOCode.QUESTION_SUBMIT_FAILURE, questionnaireForm.getLanguage());
                    return CommonVO.error(CommonVOCode.QUESTION_SUBMIT_FAILURE, msg);
                }

                // 保存用户答案计数记录
                saveAnswerCount(questionnaireForm, question);
            }
            LOGGER.info("saveQuestionnaire success with param={}", JsonUtils.TO_JSON(questionnaireForm));
            return CommonVO.success();
        } else {
            String msg = questionnaireUserDao.selectCueWord(CommonVOCode.QUESTION_USED_ANSWER, questionnaireForm.getLanguage());
            return CommonVO.error(CommonVOCode.QUESTION_USED_ANSWER, msg);
        }
    }

    /**
     * 保存答案计数信息
     */
    private void saveAnswerCount(QuestionnaireForm questionnaireForm, Question question) {
        try {
            //文本题
            if (QuestionTypeEnum.TEXT.getCode() == question.getType()) {
                return;
            }
            // 保存答案的位置
            Map<String, Integer> answerIndexMap = new HashMap<>();
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setQuestionnaireId(questionnaireForm.getQuestionnaireId());
            questionEntity.setQuestionId(question.getQuestionId());
            List<QuestionEntity> questionEntities = questionDao.selectByQuestionnaireIdAndQuestionId(questionEntity);
            for (QuestionEntity entity : questionEntities) {
                String[] answers = entity.getAnswer().split("\\|");
                for (int i = 0; i < answers.length; i++) {
                    answerIndexMap.put(answers[i], i);
                }
            }
            //单选
            if (QuestionTypeEnum.RADIO.getCode() == question.getType()) {
                answerCount(questionnaireForm, question, question.getAnswer(), answerIndexMap);
            }
            //多选
            if (QuestionTypeEnum.MULTIPLE.getCode() == question.getType()) {
                String[] answers = question.getAnswer().split("\\|");
                for (String answer : answers) {
                    answerCount(questionnaireForm, question, answer, answerIndexMap);
                }
            }
        } catch (Exception e) {
            LOGGER.error("save_answer_count_error, e {}", e);
        }
    }

    private void answerCount(QuestionnaireForm questionnaireForm, Question question, String answer, Map<String, Integer> answerIndexMap) {
        Integer answerIndex = answerIndexMap.get(answer);
        AnswerCountEntity answerCountEntity = new AnswerCountEntity();
        answerCountEntity.setQuestionnaireId(questionnaireForm.getQuestionnaireId());
        answerCountEntity.setQuestionId(question.getQuestionId());
        answerCountEntity.setQuestionPosition(answerIndex);
        answerCountEntity.setSex(questionnaireForm.getSex());
        answerCountEntity.setAge(questionnaireForm.getAge());
        answerCountEntity.setModel(questionnaireForm.getModel());
        List<AnswerCountEntity> selective = answerCountDao.getSelective(answerCountEntity);
        if (CollectionUtils.isEmpty(selective)) {
            // 新增一条答案计数
            answerCountEntity.setAnswerCount(1);
            answerCountDao.insertSelective(answerCountEntity);
        } else {
            // 已经存在，答案人数+1
            AnswerCountEntity answerCount = selective.get(0);
            answerCount.setAnswerCount(answerCount.getAnswerCount() + 1);
            answerCountDao.updateByPrimaryKeySelective(answerCount);
        }
    }

    @Override
    public CommonVO luckDraw(LuckDrawForm luckDrawForm) {
        QuestionnaireUserEntity questionnaireUserEntity = localCacheManager.selectByQuestionnaireIdAndUserId(luckDrawForm.getQuestionnaireId(), luckDrawForm.getUserId());
        if(questionnaireUserEntity == null){
            questionnaireUserEntity = questionnaireUserDao.selectByQuestionnaireIdAndUserId(luckDrawForm.getQuestionnaireId(), luckDrawForm.getUserId());
        }
        if (questionnaireUserEntity != null){
            questionnaireUserEntity.setName(luckDrawForm.getName());
            questionnaireUserEntity.setPhoneNum(luckDrawForm.getPhoneNum());
            questionnaireUserEntity.setEmail(luckDrawForm.getEmail());

            int row = questionnaireUserDao.updateByPrimaryKeySelective(questionnaireUserEntity);
            if (row <= 0){
                LOGGER.error("修改用户信息失败，questionnaireUserEntity:{}", questionnaireUserEntity);
                String msg = questionnaireUserDao.selectCueWord(CommonVOCode.LUCKDRAW_SUBMIT_FAILURE, luckDrawForm.getLanguage());
                return CommonVO.error(CommonVOCode.LUCKDRAW_SUBMIT_FAILURE, msg);
            }
            LOGGER.info("luckDraw success with param={}", JsonUtils.TO_JSON(luckDrawForm));
            return CommonVO.success();
        } else {
            String msg = questionnaireUserDao.selectCueWord(CommonVOCode.QUESTION_NOT_ANSWER, luckDrawForm.getLanguage());
            return CommonVO.error(CommonVOCode.QUESTION_NOT_ANSWER, msg);
        }
    }

    /**
     * 客户端主动轮询时，获取最新审核通过的调研卡片
     * @param exsceneBizQueryParam
     * @return
     */
    @Override
    public synchronized List<QuestionnaireVO> getQuestionnaireList(ExsceneBizQueryParam exsceneBizQueryParam) {

        final String H5URL = VivoConfigManager.getString("h5.url","https://ai-h5-pre.vivo.com.cn/diaoyan/index.html");
        final String questionnaireKey = "questionnaires";
        //获取最新修改的策略
        ExPublishEntity latestStrategy = localCacheManager.getLatestStrategy();
        List<QuestionnaireVO> questionnaireVOList = new ArrayList<>(1);
        QuestionnaireVO questionnaireVO = new QuestionnaireVO();
        if(latestStrategy == null){
            LOGGER.error("GetQuestionnaireList in query with lastStrategy being null");
            return null;
        }
        Map<String, List<QuestionnaireDTO>> questionnaireMap = exsceneBizQueryParam.getBizMap();
        if (questionnaireMap != null && !questionnaireMap.isEmpty()) {
            String questionnaireIdOfClient = questionnaireMap.get(questionnaireKey).get(0).getQuestionnaireId();
            if (questionnaireIdOfClient.equals(latestStrategy.getBizId())) {
                LOGGER.info("The questionnaire in client is the latest");
                return null;
            }
        }
        Integer actualRelease = cacheManager.getQNRPublishQuatity(latestStrategy.getBizId());
        if(latestStrategy.getExpectedRelease() != -1 && actualRelease > latestStrategy.getExpectedRelease()){
            LOGGER.error("ActualRelease has been higher than expectedRelease");
            return null;
        }
        if(bizWillPublish(latestStrategy)){
            if(reachValidVersion(exsceneBizQueryParam.getAppVersion(), latestStrategy.getIntelligSceneEdition())){
                if (Objects.equals(PublishType.ALL_PUBLISH.getCode(), latestStrategy.getType())) {
                    questionnaireVO = getQuestionnaire(latestStrategy.getBizId(), exsceneBizQueryParam.getLanguage());
                } else if (Objects.equals(PublishType.GREY_PUBLISH.getCode(), latestStrategy.getType())) {
                    //有效灰度用户
                    if(inGrey(exsceneBizQueryParam.getRole(), latestStrategy)){
                        questionnaireVO = getQuestionnaire(latestStrategy.getBizId(), exsceneBizQueryParam.getLanguage());
                    }
                }
                if(StringUtils.isNotBlank(questionnaireVO.getQuestionnaireId())){
                    questionnaireVO.setOp(BizOp.MODIFY);
                    addPublishQuantity(latestStrategy);
                }
            }
        } else if(bizWillDeleteInClient(exsceneBizQueryParam.getRole(), latestStrategy)){
            //业务被禁用,返回时op=2
            questionnaireVO = getQuestionnaire(latestStrategy.getBizId(), exsceneBizQueryParam.getLanguage());
            questionnaireVO.setOp(BizOp.DELETE);
        }
        if(StringUtils.isNotBlank(questionnaireVO.getQuestionnaireId())){
            questionnaireVO.setH5Url(H5URL);
            questionnaireVOList.add(questionnaireVO);
        }
        return questionnaireVOList;
    }

    private void addPublishQuantity(final ExPublishEntity latestStrategy) {
        cacheManager.addQNRPublishQuantity(latestStrategy.getBizId());
    }

    @Override
    public QuestionnaireDetailVO getQuestionDetail(String questionnaireId, String language) {
        QuestionnaireEntity questionnaireEntity = localCacheManager.selectByQuestionnaireId(questionnaireId);
        QuestionnaireDescEntity questionnaireDescEntity = localCacheManager.selectByIdAndLanguage(questionnaireId, language);
        if(questionnaireEntity == null || questionnaireDescEntity == null){
            questionnaireEntity = questionnaireDao.selectByQuestionnaireId(questionnaireId);
            questionnaireDescEntity = questionnaireDescDao.selectByIdAndLanguage(questionnaireId, language, null);
        }
        QuestionnaireDescVO questionnaireDescVO = new QuestionnaireDescVO();
        if(questionnaireDescEntity == null){
            LOGGER.error("GetQuestionDetail in getQuestionnaireDetail error with questionnaireId {} and language {}", questionnaireId, language);
            return null;
        }
        BeanUtils.copyProperties(questionnaireDescEntity, questionnaireDescVO);
        String questionIds = questionnaireEntity.getQuestionIdList();
        List<String> questionIdList = Arrays.asList(questionIds.split(","));
        List<QuestionVO> questionVOList = new ArrayList<>();
        QuestionVO questionVO = null;
        for(String questionId : questionIdList){
            QuestionEntity questionEntity = localCacheManager.selectQuestionByIdAndLanguage(questionId, language);
            if(questionEntity == null){
                questionEntity = questionDao.selectQuestionByIdAndLanguage(questionId, language);
            }
            if(questionEntity != null){
                questionEntity.setQuestionId(questionId);
                questionVO = new QuestionVO();
                BeanUtils.copyProperties(questionEntity, questionVO);
                questionVOList.add(questionVO);
            }
        }
        QuestionnaireDetailVO questionnaireDetailVO = new QuestionnaireDetailVO();
        questionnaireDetailVO.setQuestionnaireId(questionnaireId);
        questionnaireDetailVO.setIsReward(questionnaireEntity.getIsReward());
        questionnaireDetailVO.setQuestionnaireDesc(questionnaireDescVO);
        questionnaireDetailVO.setQuestionList(questionVOList);
        questionnaireDescVO = null;
        return questionnaireDetailVO;
    }

    /**
     * 判断发布策略是否为全量或者灰度，同时业务为上架状态
     * @param publish
     * @return
     */
    private boolean bizWillPublish(ExPublishEntity publish){
        return (Objects.equals(publish.getStatus(), PublishStatus.PUBLISH_GRAY_LEVEL.getCode())
                    || Objects.equals(publish.getStatus(),PublishStatus.PUBLISH_FULL.getCode()))
                    && (publish.getBizStatus().equals(QuestionnaireStatusEnum.ONLINE.getStatus()));
    }

    /**
     * 当发布策略失效或者卡片状态为禁用的时候，客户端相应的调研卡片会被删除
     * 失效时，判断两种情况：
     * 1.如果roleGrey为空，认为是全量发布；
     * 2.如果roleGrey不为空，确认是否包含role值；
     * @param publish
     * @return
     */
    private boolean bizWillDeleteInClient(String role, ExPublishEntity publish){
        return ((Objects.equals(publish.getStatus(), PublishStatus.PUBLISH_FAILURE.getCode()) &&
                (inGrey(role, publish) || StringUtils.isEmpty(publish.getRoleGrey())))
                || (publish.getBizStatus().equals(QuestionnaireStatusEnum.DISABLED.getStatus())));
    }

    /**
     * 判断客户端的版本号与调研卡片要求的版本号是否一致
     * @param appVersion
     * @param intelligSceneEdition
     * @return
     */
    private boolean reachValidVersion(Integer appVersion, String intelligSceneEdition) {
        if(appVersion==null || intelligSceneEdition==null){
            LOGGER.error("ReachMinVersion with empty version {},{}",appVersion,intelligSceneEdition);
            return false;
        }
        try{
            String[] clientVersionArray = intelligSceneEdition.split(",");
            return Arrays.asList(clientVersionArray).contains(appVersion.toString());
        }catch (Exception e){
            LOGGER.error("ReachMinVersion with error {},{}",appVersion,intelligSceneEdition,e);
            return false;
        }
    }

    /**
     * 获取传给客户端的调研卡片
     * @param questionnaireId
     * @param language
     * @return
     */
    private QuestionnaireVO getQuestionnaire(String questionnaireId, String language){

        List<String> languageList =  getLanguageList(language);
        List<QuestionnaireDescEntity> questionnaireDescList = new ArrayList<>(3);
        QuestionnaireVO questionnaireVO = new QuestionnaireVO();

        for(int i = 0, len = languageList.size(); i < len; i++){
            QuestionnaireDescEntity questionnaireDesc = getQNRDescByIdAndLNG(questionnaireId, languageList.get(i));
            if(questionnaireDesc != null){
                questionnaireDescList.add(questionnaireDesc);
            }
        }

        if(CollectionUtils.isEmpty(questionnaireDescList)){
            LOGGER.error("getQuestionnaire2Client error with questionnaireId {} and language {}",questionnaireId, language);
        } else {
            QuestionnaireEntity questionnaireEntity = questionnaireDao.selectByQuestionnaireId(questionnaireId);
            questionnaireVO.setQuestionnaireId(questionnaireId);
            questionnaireVO.setStartTime(questionnaireEntity.getStartTime());
            questionnaireVO.setEndTime(questionnaireEntity.getEndTime());
            questionnaireVO.setIcon(questionnaireEntity.getIcon());
            questionnaireVO.setQuestionnaireDesc(questionnaireDescList);
        }

        return questionnaireVO;
    }

    /**
     * 通过id和language获取调研卡片
     * @param questionnaireId
     * @param language
     * @return
     */
    private QuestionnaireDescEntity getQNRDescByIdAndLNG(String questionnaireId, String language){
        return questionnaireDescDao.selectQNRDescByIdAndLanguage(questionnaireId, language);
    }

    /**
     * 获取所有要翻译的语言
     * @param language
     * @return
     */
    private List getLanguageList(String language){
        List<String> languageList = new ArrayList<>(3);
        final String allLanguage = "all";
        final String India = "hi_IN";
        final String English = "en_US";
        final String Chinese = "zh_CN";
        if(language.startsWith(allLanguage)){
            languageList.add(Chinese);
            languageList.add(English);
            languageList.add(India);
        }else if(language.startsWith(India)){
            languageList.add(India);
        } else if(language.startsWith(English)){
            languageList.add(English);
        } else if(language.startsWith(Chinese)){
            languageList.add(Chinese);
        }
        return languageList;
    }

    /**
     * 判断role是否存在于灰度策略中
     * @param role
     * @param latestStrategy
     * @return
     */
    private boolean inGrey(String role, ExPublishEntity latestStrategy){
        String roleString = latestStrategy.getRoleGrey();
        String[] roleArray = null;
        if(StringUtils.isNotBlank(roleString)){
            roleArray = roleString.split(",");
            return Arrays.asList(roleArray).contains(role);
        }else{
            return false;
        }
    }

}
