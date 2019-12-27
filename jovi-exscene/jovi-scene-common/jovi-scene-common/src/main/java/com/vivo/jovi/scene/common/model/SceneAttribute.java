package com.vivo.jovi.scene.common.model;

/**
 * @author Tian Guangxin
 * @date 2018/11/13
 * @since 1.0
 */
public class SceneAttribute {
    private long activityId;
    private Integer versionCode;

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }
}
