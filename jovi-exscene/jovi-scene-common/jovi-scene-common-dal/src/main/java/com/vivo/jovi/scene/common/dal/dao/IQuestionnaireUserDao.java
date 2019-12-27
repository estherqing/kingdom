package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.QuestionnaireUserEntity;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IQuestionnaireUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionnaireUserEntity record);

    int insertSelective(QuestionnaireUserEntity record);

    QuestionnaireUserEntity selectByPrimaryKey(Long id);

    QuestionnaireUserEntity selectByQuestionnaireIdAndUserId(@Param("questionnaireId") String questionnaireId, @Param("userId") String userId);

    int updateByPrimaryKeySelective(QuestionnaireUserEntity record);

    int updateByPrimaryKey(QuestionnaireUserEntity record);

    List<QuestionnaireUserEntity> selectByQuestionnaireId(String questionnaireId);

    List<QuestionnaireUserEntity> statisticalAnswer(@Param("questionnaireId") String questionnaireId, @Param("questionId") String questionId,
                                                    @Param("sex") Integer sex, @Param("age") String age,
                                                    @Param("profession") String profession, @Param("model") String model);

    long count(String questionnaireId);

    List<String> selectUserIdsByQuestionnaireId(String questionnaireId);

    String selectCueWord(@Param("code") Integer code, @Param("language") String language);

    List<QuestionnaireUserEntity> selectDetailByQuestionnaireId(QuestionnaireBO questionnaireBO);
}