package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.AnswerEntity;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAnswerDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnswerEntity record);

    int insertSelective(AnswerEntity record);

    AnswerEntity selectByPrimaryKey(Long id);

    List<AnswerEntity> selectByQuestionnaireId(@Param("questionnaireId") String questionnaireId, @Param("languageList") List<Integer> languageList);

    List<AnswerEntity> selectByQuestionnaireIdAndQuestionId(@Param("questionnaireId") String questionnaireId, @Param("questionId") String questionId);

    int updateByPrimaryKeySelective(AnswerEntity record);

    int updateByPrimaryKeyWithBLOBs(AnswerEntity record);

    int updateByPrimaryKey(AnswerEntity record);

    Integer findNumByQuestionId(@Param("questionnaireId") String questionnaireId, @Param("questionId") String questionId);

    List<AnswerEntity> selectAnswerAndUserInfo(QuestionnaireBO questionnaireBO);
}