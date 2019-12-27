package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.QuestionEntity;
import com.vivo.jovi.scene.common.model.dto.QuestionDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IQuestionDao {
    int deleteByPrimaryKey(Integer id);

    int deleteByQuestionnaireId(String questionnaireId);

    int deleteByQuestionId(@Param("questionIdList") List<String> questionIdList, @Param("questionnaireId") String questionnaireId);

    int insert(QuestionEntity record);

    int insertSelective(QuestionEntity record);

    QuestionEntity selectByPrimaryKey(long id);

    QuestionEntity selectBySelective(QuestionDTO questionDTO);

    int updateBySelective(QuestionEntity record);

    int updateByPrimaryKeyWithBLOBs(QuestionEntity record);

    int updateByPrimaryKey(QuestionEntity record);

    List<QuestionEntity> selectByQuestionnaireId(@Param("questionnaireId") String questionnaireId, @Param("List") List<String> languages);

    List<QuestionEntity> selectByIdAndLanguage(@Param("questionnaireId") String questionnaireId, @Param("language") String cn);

    List<QuestionEntity> selectByQuestionDetail(@Param("questionnaireId") String questionnaireId, @Param("language") String language);

    List<QuestionEntity> selectByQuestionIdList(@Param("questionIdList") List<String> questionIdList, @Param("language") String cn);

    QuestionEntity selectQuestionByIdAndLanguage(@Param("questionId") String questionId, @Param("language") String language);

    List<QuestionEntity> selectByQuestionnaireIdAndQuestionId(QuestionEntity record);
}