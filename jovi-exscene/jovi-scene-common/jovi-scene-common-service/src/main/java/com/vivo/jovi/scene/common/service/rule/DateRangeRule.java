package com.vivo.jovi.scene.common.service.rule;

import com.vivo.jovi.scene.common.activity.rule.AbstractRule;
import com.vivo.jovi.scene.common.model.SceneRequest;
import com.vivo.jovi.scene.common.model.SceneResponse;

import java.sql.Timestamp;

/**
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public class DateRangeRule extends AbstractRule {
    private Integer state;
    private Integer order;
    private Integer attenuationDuration;
    private Timestamp startTime;
    private Timestamp endTime;


    /*static {
        RuleTypeRepository.register(DateRangeRule.class,"DateRangeRule");
    }*/

    @Override
    protected boolean doPredicate(SceneRequest request, SceneResponse response) {
        if(state==9){
            return true;
        }
        return false;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getAttenuationDuration() {
        return attenuationDuration;
    }

    public void setAttenuationDuration(Integer attenuationDuration) {
        this.attenuationDuration = attenuationDuration;
    }
}
