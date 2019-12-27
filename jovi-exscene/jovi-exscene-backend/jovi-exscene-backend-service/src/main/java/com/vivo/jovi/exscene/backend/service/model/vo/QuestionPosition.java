package com.vivo.jovi.exscene.backend.service.model.vo;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname QuestionPosition
 * @Description TODO
 * @Date 2019-07-11 17:52
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionPosition {

    private HashMap<String, List<QuestionVO>> personalInformationQuestionsMap;

    private HashMap<String, List<QuestionVO>> mainBodyQuestionsMap;

    public HashMap<String, List<QuestionVO>> getPersonalInformationQuestionsMap() {
        return personalInformationQuestionsMap;
    }

    public void setPersonalInformationQuestionsMap(HashMap<String, List<QuestionVO>> personalInformationQuestionsMap) {
        this.personalInformationQuestionsMap = personalInformationQuestionsMap;
    }

    public HashMap<String, List<QuestionVO>> getMainBodyQuestionsMap() {
        return mainBodyQuestionsMap;
    }

    public void setMainBodyQuestionsMap(HashMap<String, List<QuestionVO>> mainBodyQuestionsMap) {
        this.mainBodyQuestionsMap = mainBodyQuestionsMap;
    }
}
