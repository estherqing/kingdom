package com.vivo.jovi.exscene.api.web.controller;

import com.vivo.jovi.exscene.api.service.IQuestionnaireService;
import com.vivo.jovi.exscene.api.service.model.form.LuckDrawForm;
import com.vivo.jovi.exscene.api.service.model.form.QuestionnaireForm;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireDetailVO;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.model.ExsceneBizQueryParam;
import com.vivo.jovi.scene.common.util.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname QuestionnaireController
 * @Description 调研卡片
 * @Date 2019-05-15 14:48
 * @Version 1.0
 * @Author Lu Guodong
 */
@Controller
@RequestMapping("exscene")
public class QuestionnaireController extends BaseController{

    @Autowired
    private IQuestionnaireService questionnaireService;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireController.class);

    @RequestMapping("answer")
    @ResponseBody
    public CommonVO answer(@RequestBody QuestionnaireForm questionnaireForm){
        LOGGER.info("answer begin with param={}", JsonUtils.TO_JSON(questionnaireForm));
        if (StringUtils.isBlank(questionnaireForm.getQuestionnaireId()) || StringUtils.isBlank(questionnaireForm.getUserId())
                || StringUtils.isBlank(questionnaireForm.getModel())
                || StringUtils.isBlank(questionnaireForm.getAndroidVersion()) || StringUtils.isBlank(questionnaireForm.getLanguage())
                || questionnaireForm.getSex() == null || questionnaireForm.getAge() == null){
            return CommonVO.badParams("param error");
        }

        return questionnaireService.answer(questionnaireForm);
    }

    @RequestMapping("luckDraw")
    @ResponseBody
    public CommonVO luckDraw(@RequestBody LuckDrawForm luckDrawForm){
        LOGGER.info("luckDraw begin with param={}", JsonUtils.TO_JSON(luckDrawForm));
        if (StringUtils.isBlank(luckDrawForm.getQuestionnaireId()) || StringUtils.isBlank(luckDrawForm.getUserId())
                || StringUtils.isBlank(luckDrawForm.getName()) || StringUtils.isBlank(luckDrawForm.getPhoneNum())
                || StringUtils.isBlank(luckDrawForm.getEmail())){
            return CommonVO.badParams("param error");
        }
        return questionnaireService.luckDraw(luckDrawForm);
    }

    @RequestMapping("query")
    @ResponseBody
    public CommonVO query(@RequestBody ExsceneBizQueryParam exsceneBizQueryParam){
        LOGGER.info("queryQuestionnaire begin with param={}", JsonUtils.TO_JSON(exsceneBizQueryParam));
        try{
            Map<String, List<QuestionnaireVO>> exsceneBizMap = new HashMap<>(1);
            List<QuestionnaireVO> questionnaires = questionnaireService.getQuestionnaireList(exsceneBizQueryParam);
            if(CollectionUtils.isNotEmpty(questionnaires)){
                exsceneBizMap.put("questionnaires",questionnaires);
            }
            if(MapUtils.isEmpty(exsceneBizMap)){
                return CommonVO.error(CommonVOCode.NO_DATA, null);
            } else {
                LOGGER.info("queryQuestionnaire success with param={}, result={}", JsonUtils.TO_JSON(exsceneBizQueryParam), JsonUtils.TO_JSON(exsceneBizMap));
                return CommonVO.success(exsceneBizMap);
            }

        }catch (Exception e){
            LOGGER.error("SERVICE_ERROR:", e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR,e.getMessage()+":"+getTraceSource(e));
        }
    }

    @RequestMapping("getQuestionnaireDetail")
    @ResponseBody
    public CommonVO getQuestionnaireDetail(String userId, String model, String androidVersion, String language, String questionnaireId){
        LOGGER.info("getQuestionnaireDetail beigin with userId={}, model={}, androidVersion={}, language={} and questionnaireId={}", userId, model, androidVersion, language, questionnaireId);
        if(questionnaireId == null || language == null){
            return CommonVO.badParams("getQuestionnaireDetail with questionnaire or language being null");
        }
        try{
            QuestionnaireDetailVO questionnaireDetailVO = questionnaireService.getQuestionDetail(questionnaireId, language);
            if(questionnaireDetailVO != null){
                LOGGER.info("getQuestionnaireDetail success withlanguage={} and questionnaireId={}, result={}", language, questionnaireId, JsonUtils.TO_JSON(questionnaireDetailVO));
                return CommonVO.success(questionnaireDetailVO);
            }
            return CommonVO.badParams("getQuestionnaireDetail with bad params language and questionnaireId");
        } catch(Exception e){
            LOGGER.error("getQuestionnaireDetail error, questionnaireId={} language={}", questionnaireId, language);
            return CommonVO.error("getQuestionnaireDetail Error");
        }
    }
}