package com.vivo.jovi.exscene.backend.service;

import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.dal.entity.QuestionEntity;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.vo.questionnaire.QuestionInfoVO;

import java.util.List;

public interface IQuestionnaireUserService {
    /**
     * 获取用户答题信息
     */
    CommonVO getStatisticalInfo(QuestionnaireBO questionnaireBO);

    /**
     * 统计用户回答的答案
     */
    List<QuestionInfoVO> statisticalAnswer(QuestionnaireBO questionnaireBO, QuestionEntity questionEntity, boolean isTask,
                                                        List<QuestionInfoVO> questionInfoVOS);
}
