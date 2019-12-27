package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.QuestionnaireDescEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IQuestionnaireDescDao {
    int deleteByPrimaryKey(Integer id);

    int deleteByQuestionnaireId(String questionnaireId);

    int insert(QuestionnaireDescEntity record);

    int insertSelective(QuestionnaireDescEntity record);

    QuestionnaireDescEntity selectByPrimaryKey(long id);

    int updateByPrimaryKeySelective(QuestionnaireDescEntity record);

    int updateByPrimaryKeyWithBLOBs(QuestionnaireDescEntity record);

    int updateByPrimaryKey(QuestionnaireDescEntity record);

    List<QuestionnaireDescEntity> selectByQuestionnaireId(@Param("questionnaireId") String questionnaireId, @Param("languageList") List<String> languageList);

    QuestionnaireDescEntity selectByIdAndLanguage(@Param("questionnaireId") String questionnaireId, @Param("language") String language, @Param("translateLanguage") String translateLanguage);

    QuestionnaireDescEntity selectQNRDescByIdAndLanguage(@Param("questionnaireId") String questionnaireId, @Param("language") String language);

    QuestionnaireDescEntity selectBySelective(QuestionnaireDescEntity questionnaireDescEntity);

    String selectLanguageBySelective(String questionnaireId);
}