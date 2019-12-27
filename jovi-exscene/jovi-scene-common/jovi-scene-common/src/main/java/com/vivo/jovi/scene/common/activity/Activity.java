package com.vivo.jovi.scene.common.activity;

import com.vivo.jovi.scene.common.activity.action.Action;
import com.vivo.jovi.scene.common.activity.rule.Rule;
import com.vivo.jovi.scene.common.model.SceneRequest;
import com.vivo.jovi.scene.common.model.SceneResponse;

/**
 * @author Tian Guangxin
 * @date 2018/11/13
 * @since 1.0
 */
public class Activity {
    private Long activityId;

    private Integer versionCode;

    private Integer activityType;

    private Integer randomTime;

    private Rule rule;

    private Action action;

    public Activity() {
    }

    public Activity(Rule rule, Action action, Long activityId,
                    Integer versionCode,Integer activityType,Integer randomTime){
        if(rule == null || action == null){
            throw new IllegalArgumentException("Rule或者Action不能为null");
        }
        this.rule = rule;
        this.action = action;
        this.activityId = activityId;
        this.versionCode = versionCode;
        this.activityType = activityType;
        this.randomTime = randomTime;
    }

    public void handleActivity(SceneRequest request, SceneResponse response){
        if(rule!=null && rule.predicate(request,response)){
            action.doAction(request,response,this);
        }
    }

    public Rule getRule(){
        return rule;
    }

    public Action getAction(){
        return action;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getRandomTime() {
        return randomTime;
    }

    public void setRandomTime(Integer randomTime) {
        this.randomTime = randomTime;
    }
}
