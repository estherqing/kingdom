package com.vivo.jovi.scene.common.vo.questionnaire;

/**
 * @author huhan
 * @description
 * @date 2019-05-16 11:26
 */
public class AnswerVO {

    /**
     * 答案选项
     */
    private String answer;

    /**
     * 答案占比
     */
    private Integer percentage;

    /**
     * 答题人数
     */
    private Integer numbers;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}
