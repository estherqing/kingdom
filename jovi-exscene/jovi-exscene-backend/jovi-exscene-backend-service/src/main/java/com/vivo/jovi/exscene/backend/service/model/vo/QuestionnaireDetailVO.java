package com.vivo.jovi.exscene.backend.service.model.vo;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname QuestionnaireDetailVO
 * @Description TODO
 * @Date 2019-05-09 16:15
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionnaireDetailVO {

    private Integer id;

    private Integer status;

    private List<String> personalQuestionIdList;

    private List<String> mainBodyQuestionIdList;

    private String startTime;

    private String endTime;

    private String icon;

    private Integer isReward;

    private String questionnaireId;

    private String title;

    private String cueWord;

    private String description;

    private String pulloffReason;

    private String disableReason;

    private String rejectReason;

    private String approvalTestUserName;

    private String approvalTestReason;

    private Integer approvalTestStatus;

    private String approvalOperationUserName;

    private String approvalOperationReason;

    private Integer approvalOperationStatus;

    private String translateLanguage;

    private List<HashMap<String, String>> languageList;

    private HashMap<String, Object> questionnaireInfoMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCueWord() {
        return cueWord;
    }

    public void setCueWord(String cueWord) {
        this.cueWord = cueWord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPulloffReason() {
        return pulloffReason;
    }

    public void setPulloffReason(String pulloffReason) {
        this.pulloffReason = pulloffReason;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getApprovalTestUserName() {
        return approvalTestUserName;
    }

    public void setApprovalTestUserName(String approvalTestUserName) {
        this.approvalTestUserName = approvalTestUserName;
    }

    public String getApprovalTestReason() {
        return approvalTestReason;
    }

    public void setApprovalTestReason(String approvalTestReason) {
        this.approvalTestReason = approvalTestReason;
    }

    public Integer getApprovalTestStatus() {
        return approvalTestStatus;
    }

    public void setApprovalTestStatus(Integer approvalTestStatus) {
        this.approvalTestStatus = approvalTestStatus;
    }

    public String getApprovalOperationUserName() {
        return approvalOperationUserName;
    }

    public void setApprovalOperationUserName(String approvalOperationUserName) {
        this.approvalOperationUserName = approvalOperationUserName;
    }

    public String getApprovalOperationReason() {
        return approvalOperationReason;
    }

    public void setApprovalOperationReason(String approvalOperationReason) {
        this.approvalOperationReason = approvalOperationReason;
    }

    public Integer getApprovalOperationStatus() {
        return approvalOperationStatus;
    }

    public void setApprovalOperationStatus(Integer approvalOperationStatus) {
        this.approvalOperationStatus = approvalOperationStatus;
    }

    public String getTranslateLanguage() {
        return translateLanguage;
    }

    public void setTranslateLanguage(String translateLanguage) {
        this.translateLanguage = translateLanguage;
    }

    public List<String> getPersonalQuestionIdList() {
        return personalQuestionIdList;
    }

    public void setPersonalQuestionIdList(List<String> personalQuestionIdList) {
        this.personalQuestionIdList = personalQuestionIdList;
    }

    public List<String> getMainBodyQuestionIdList() {
        return mainBodyQuestionIdList;
    }

    public void setMainBodyQuestionIdList(List<String> mainBodyQuestionIdList) {
        this.mainBodyQuestionIdList = mainBodyQuestionIdList;
    }

    public HashMap<String, Object> getQuestionnaireInfoMap() {
        return questionnaireInfoMap;
    }

    public void setQuestionnaireInfoMap(HashMap<String, Object> questionnaireInfoMap) {
        this.questionnaireInfoMap = questionnaireInfoMap;
    }

    public List<HashMap<String, String>> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<HashMap<String, String>> languageList) {
        this.languageList = languageList;
    }
}
