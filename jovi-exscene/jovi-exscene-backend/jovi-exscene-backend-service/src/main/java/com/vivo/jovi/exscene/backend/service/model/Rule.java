package com.vivo.jovi.exscene.backend.service.model;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @program: ssdp-intellig-scene
 * @description:
 * @author: xuxitao
 * @create: 2018-11-20 22:28
 **/
public class Rule {
    private Integer order;
    private Integer attenuationDuration;
    private TimeRule timeRule;
    private Integer state;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public TimeRule getTimeRule() {
        return timeRule;
    }

    public void setTimeRule(TimeRule timeRule) {
        this.timeRule = timeRule;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAttenuationDuration() {
        return attenuationDuration;
    }

    public void setAttenuationDuration(Integer attenuationDuration) {
        this.attenuationDuration = attenuationDuration;
    }

    public boolean verify(boolean nextFlag){

        if(nextFlag){
            //第一步先做非空check
            if(attenuationDuration == null || order == null ||
                    timeRule == null || state == null ){
                return true;
            }
        }

        //初始权值只能输入[0,50]之间的数字
        if(order!=null && (order < 0 || order > 50)){
            return true;
        }

        if(order!=null && !NumberUtils.isDigits(String.valueOf(order))) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "\"order\":" + order +
                ", \"attenuationDuration\":" + attenuationDuration +
                ", \"state\":" + state +
                ", \"timeRule\":" + timeRule.toString() +
                '}';
    }
}
