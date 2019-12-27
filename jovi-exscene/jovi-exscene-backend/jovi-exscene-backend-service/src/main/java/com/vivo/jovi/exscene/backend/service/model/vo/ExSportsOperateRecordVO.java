package com.vivo.jovi.exscene.backend.service.model.vo;

/**
 * @Classname ExSportsOperateRecordVO
 * @Description TODO
 * @Date 2019-08-14 15:03
 * @Created by Administrator
 * @Version 1.0
 */
public class ExSportsOperateRecordVO {

    private String operator;

    private String operatingTime;

    private String operationalDesc;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getOperationalDesc() {
        return operationalDesc;
    }

    public void setOperationalDesc(String operationalDesc) {
        this.operationalDesc = operationalDesc;
    }
}
