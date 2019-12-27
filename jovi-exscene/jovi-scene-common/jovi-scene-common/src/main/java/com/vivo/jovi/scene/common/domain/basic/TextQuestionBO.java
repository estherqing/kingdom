package com.vivo.jovi.scene.common.domain.basic;

import java.util.Date;

/**
 * @author huhan
 * @description
 * @date 2019-05-20 10:09
 */
public class TextQuestionBO {

    /**
     * 机型
     */
    private String model = "";
    /**
     * 安卓版本
     */
    private String androidVersion = "";
    /**
     * 回答时间
     */
    private Date answerTime = null;
    /**
     * 回答内容
     */
    private String answer = "";

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
