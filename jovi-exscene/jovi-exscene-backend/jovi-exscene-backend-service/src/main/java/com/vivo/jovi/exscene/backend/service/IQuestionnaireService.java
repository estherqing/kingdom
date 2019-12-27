package com.vivo.jovi.exscene.backend.service;

import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireDetailVO;
import com.vivo.jovi.exscene.backend.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.model.bo.QuestionBO;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.model.dto.QuestionnaireDTO;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface IQuestionnaireService {

    CommonVO saveQuestion(QuestionBO questionBO, SSOUser ssoUser);

    CommonVO saveQuestionnaire(QuestionnaireBO questionnaireBO, SSOUser ssoUser) throws ParseException;

    List<QuestionnaireVO> getQuestionnaireList(QuestionnaireDTO questionnaireDTO, Pageable pageable);

    Integer countQuestionnaire(QuestionnaireDTO questionnaireDTO);

    QuestionnaireDetailVO getQuestionnaireDetail(QuestionnaireDTO questionnaireDTO);

    QuestionnaireEntity getQuestionnaireEntity(QuestionnaireDTO questionnaireDTO);

    CommonVO checkAuditAuthority(SSOUser ssoUser, QuestionnaireBO questionnaireBO, QuestionnaireEntity questionnaireEntity);

    CommonVO judgeOperationType(QuestionnaireBO questionnaireBO) throws RuntimeException;

    CommonVO questionnaireAuditing(QuestionnaireDTO questionnaireDTO, SSOUser ssoUser) throws Exception;

    CommonVO stateJudgement(QuestionnaireBO questionnaireBO, QuestionnaireEntity questionnaireEntity);

    int updateCardsBySelective(QuestionnaireEntity questionnaireEntity);

    int deleteQuestionnaire(String questionnaireId, Integer status);

    int deleteQuestion(List<String> questionIdList, String questionnaireId);

    String getQuestionnaireId();

    }
