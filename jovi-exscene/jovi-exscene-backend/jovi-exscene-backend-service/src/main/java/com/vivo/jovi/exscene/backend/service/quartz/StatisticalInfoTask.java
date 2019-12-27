package com.vivo.jovi.exscene.backend.service.quartz;

import com.google.common.collect.Lists;
import com.vivo.jovi.exscene.backend.service.IQuestionService;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.scene.common.constant.LanguageEnum;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireDao;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireDescDao;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireDescEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.vo.questionnaire.QuestionInfoVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhan
 * @description 定时刷新问卷统计信息缓存
 * @date 2019-08-06 9:07
 */
@Component
public class StatisticalInfoTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticalInfoTask.class);

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IQuestionnaireDescDao questionnaireDescDao;

//    @Scheduled(cron = "0 */15 * * * ?")
    public void doStatisticalInfo() {
        List<QuestionInfoVO> questionInfoVOS = new ArrayList<>();
        try {
            List<QuestionnaireEntity> questionnaireEntityList = questionnaireDao.getAll();
            List<QuestionnaireVO> questionnaireVOList = Lists.newArrayList();
            buildQuestionVOList(questionnaireVOList, questionnaireEntityList);
            if (CollectionUtils.isEmpty(questionnaireVOList)) {
                return;
            }
            for (QuestionnaireVO questionnaireVO : questionnaireVOList) {
                QuestionnaireBO questionnaireBO = new QuestionnaireBO();
                questionnaireBO.setQuestionnaireId(questionnaireVO.getQuestionnaireId());
                questionnaireBO.setLanguage(questionnaireVO.getLanguage());
                questionnaireBO.setStatus(questionnaireVO.getStatus());
                questionnaireBO.setTask(true);
                if (validQuestionnaireStatus(questionnaireBO)) {
                    questionService.getQuestionInfo(questionnaireBO);
                }
            }
        }catch (Exception e) {
            LOGGER.error("doStatisticalInfo error! e {}", e);
        }
    }

    private void buildQuestionVOList(List<QuestionnaireVO> questionnaireVOList, List<QuestionnaireEntity> questionnaireEntityList) {
        QuestionnaireDescEntity questionnaireDescDTO = new QuestionnaireDescEntity();
        for (QuestionnaireEntity questionnaireEntity : questionnaireEntityList) {
            questionnaireDescDTO.setQuestionnaireId(questionnaireEntity.getQuestionnaireId());
            questionnaireDescDTO.setLanguage(LanguageEnum.CHINESE.getValue());
            QuestionnaireDescEntity questionnaireDescEntity = questionnaireDescDao.selectBySelective(questionnaireDescDTO);
            if (questionnaireDescEntity == null) {
                questionnaireDescDTO.setLanguage(LanguageEnum.ENGLISH.getValue());
                questionnaireDescEntity = questionnaireDescDao.selectBySelective(questionnaireDescDTO);
            }
            if (questionnaireDescEntity == null) {
                continue;
            }
            QuestionnaireVO questionnaireVO = new QuestionnaireVO();
            BeanUtils.copyProperties(questionnaireEntity, questionnaireVO);
            questionnaireVO.setLanguage(questionnaireDescEntity.getLanguage());
            questionnaireVO.setStatus(questionnaireEntity.getStatus());

            questionnaireVOList.add(questionnaireVO);
        }
    }

    /**
     * 判断问卷的状态是否是 已上线，已下线，已禁用 状态
     */
    private boolean validQuestionnaireStatus(QuestionnaireBO questionnaireBO) {
        boolean flag = QuestionnaireStatusEnum.ONLINE.getStatus() == questionnaireBO.getStatus() || QuestionnaireStatusEnum.DISABLED.getStatus() == questionnaireBO.getStatus()
                || QuestionnaireStatusEnum.OFFLINE.getStatus() == questionnaireBO.getStatus();
        return flag;
    }
}
