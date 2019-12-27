package com.vivo.jovi.exscene.api.service.model.vo;

import com.vivo.jovi.scene.common.dal.entity.QuestionnaireDescEntity;

import java.util.Date;
import java.util.List;

/**
 *@description: 传给客户端的调研卡片
 *@author: Lu Guodong
 *@CreateDate: 2019-05-17
 */
public class QuestionnaireVO {
    private String questionnaireId;

    /** 用于判定调研卡片状态，1：新增或者修改，2：删除*/
    private Integer op;

    private Date startTime;

    private Date endTime;

    private String icon;

    /**H5界面的url地址*/
    private String h5Url;

    private List<QuestionnaireDescEntity> questionnaireDesc;

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<QuestionnaireDescEntity> getQuestionnaireDesc() {
        return questionnaireDesc;
    }

    public void setQuestionnaireDesc(List<QuestionnaireDescEntity> questionnaireDescList) {
        this.questionnaireDesc = questionnaireDescList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public Integer getOp() {
        return op;
    }
}
