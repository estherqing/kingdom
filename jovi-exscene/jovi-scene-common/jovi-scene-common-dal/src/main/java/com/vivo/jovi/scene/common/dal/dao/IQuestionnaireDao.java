package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.model.dto.QuestionnaireDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IQuestionnaireDao {
    int getId(String tableSchema);

    int deleteByPrimaryKey(Integer id);

    int deleteByQuestionnaireId(@Param("questionnaireId") String questionnaireId, @Param("status") Integer status);

    int insert(QuestionnaireEntity record);

    int insertSelective(QuestionnaireEntity record);

    QuestionnaireEntity selectByPrimaryKey(Integer id);

    List<QuestionnaireEntity> getQuestionnaireList(QuestionnaireDTO questionnaireDTO);

    QuestionnaireEntity getQuestionnaire(QuestionnaireDTO questionnaireDTO);

    Integer selectCountByCondition(QuestionnaireDTO researchCardsQTO);

    int updateByPrimaryKeySelective(QuestionnaireEntity record);

    int updateByPrimaryKey(QuestionnaireEntity record);

    QuestionnaireEntity selectByQuestionnaireId(String questionnaireId);

    List<QuestionnaireEntity> getAll();

    Integer selectIsReward(String questionnaireId);
}