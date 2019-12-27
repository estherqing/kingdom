package com.vivo.jovi.exscene.backend.service.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: ssdp-intellig-scene
 * @description:
 * @author: xuxitao
 * @create: 2018-11-22 21:41
 **/
public class Noti {
    private String title;
    private String content;
    private Integer endTime;
    private Integer startType;
    private Integer endType;
    private Boolean timeSwitch;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getStartType() {
        return startType;
    }

    public void setStartType(Integer startType) {
        this.startType = startType;
    }

    public Integer getEndType() {
        return endType;
    }

    public void setEndType(Integer endType) {
        this.endType = endType;
    }

    public Boolean getTimeSwitch() {
        return timeSwitch;
    }

    public void setTimeSwitch(Boolean timeSwitch) {
        this.timeSwitch = timeSwitch;
    }

    public boolean verify(boolean nextFlag){

        if(nextFlag){
            if(StringUtils.isBlank(title) || StringUtils.isBlank(content) || startType == null ||
                    endType == null || endTime == null || timeSwitch == null){
                return true;
            }
        }

        if(title != null && title.length() > 50){
            return true;
        }

        if(content != null && content.length() > 250){
            return true;
        }

        if(endTime != null && endTime != 0 && (endTime < 1 || endTime > 10080)){
            return true;
        }

        return false;
    }
}
