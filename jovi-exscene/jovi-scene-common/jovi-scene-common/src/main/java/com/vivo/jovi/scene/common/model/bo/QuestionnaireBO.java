package com.vivo.jovi.scene.common.model.bo;

/**
 * @Classname QuestionnaireBO
 * @Description TODO
 * @Date 2019-05-05 16:25
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionnaireBO extends QuestionBO{

    private Long id;

    private String questionnaireId;

    private String questionId;

    private String startTime;

    private String endTime;

    private Integer isReward;

    private String icon;

    private String title;

    private String description;

    private String cueWord;

    private String reason;

    private Integer status;

    /**审核状态 1通过 2驳回 **/
    private Integer approvalStatus;

    /**审核类型  **/
    private Integer auditType;

    /**草稿按钮的位置 0非最后页面的草稿按钮位置 1最后页面的草稿按钮位置**/
    private int draftButtonPosition;

    /** 0 保存草稿 1调研问卷的最后提交 2问卷的修改**/
    private Integer operationType;

    private String imeis;

    private Integer sex;

    private String personalQuestionIds;

    private String mainBodyQuestionIds;

    private String age;

    private String profession;

    private String model;

    /**
     * 录入的语言
     */
    private String language;

    /**
     * 是否是定时任务
     */
    private boolean isTask;

    private Integer start;

    private Integer end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getQuestionnaireId() {
        return questionnaireId;
    }

    @Override
    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Override
    public String getQuestionId() {
        return questionId;
    }

    @Override
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCueWord() {
        return cueWord;
    }

    public void setCueWord(String cueWord) {
        this.cueWord = cueWord;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getImeis() {
        return imeis;
    }

    public void setImeis(String imeis) {
        this.imeis = imeis;
    }

    public String getPersonalQuestionIds() {
        return personalQuestionIds;
    }

    public void setPersonalQuestionIds(String personalQuestionIds) {
        this.personalQuestionIds = personalQuestionIds;
    }

    public String getMainBodyQuestionIds() {
        return mainBodyQuestionIds;
    }

    public void setMainBodyQuestionIds(String mainBodyQuestionIds) {
        this.mainBodyQuestionIds = mainBodyQuestionIds;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDraftButtonPosition() {
        return draftButtonPosition;
    }

    public void setDraftButtonPosition(int draftButtonPosition) {
        this.draftButtonPosition = draftButtonPosition;
    }

    public boolean isTask() {
        return isTask;
    }

    public void setTask(boolean task) {
        isTask = task;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
