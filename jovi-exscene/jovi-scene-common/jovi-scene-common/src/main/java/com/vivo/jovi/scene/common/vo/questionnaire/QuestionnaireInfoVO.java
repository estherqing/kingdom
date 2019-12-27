package com.vivo.jovi.scene.common.vo.questionnaire;

import java.util.List;
import java.util.Set;

/**
 * @author huhan
 * @description
 * @date 2019-05-16 11:14
 */
public class QuestionnaireInfoVO {

    private String questionnaireId;

    private String title;

    private long actualRelease = 0;

    private long answerCount = 0;

    private Set<Integer> sex;

    private List<String> age;

    private Set<String> profession;

    private Set<String> model;

    /**
     * 用户数量
     */
    private Long totalUserNum;

    /**
     * 是否有奖，0：没有，1：有
     */
    private Integer isReward;

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

    public long getActualRelease() {
        return actualRelease;
    }

    public void setActualRelease(long actualRelease) {
        this.actualRelease = actualRelease;
    }

    public long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(long answerCount) {
        this.answerCount = answerCount;
    }

    public Set<Integer> getSex() {
        return sex;
    }

    public void setSex(Set<Integer> sex) {
        this.sex = sex;
    }

    public List<String> getAge() {
        return age;
    }

    public void setAge(List<String> age) {
        this.age = age;
    }

    public Set<String> getProfession() {
        return profession;
    }

    public void setProfession(Set<String> profession) {
        this.profession = profession;
    }

    public Set<String> getModel() {
        return model;
    }

    public void setModel(Set<String> model) {
        this.model = model;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public Long getTotalUserNum() {
        return totalUserNum;
    }

    public void setTotalUserNum(Long totalUserNum) {
        this.totalUserNum = totalUserNum;
    }
}
