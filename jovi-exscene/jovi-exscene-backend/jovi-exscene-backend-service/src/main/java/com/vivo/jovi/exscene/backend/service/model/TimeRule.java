package com.vivo.jovi.exscene.backend.service.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: ssdp-intellig-scene
 * @description:
 * @author: xuxitao
 * @create: 2018-11-22 21:12
 **/
public class TimeRule {
    private Integer type;
    private String holiday;
    private String startTime;
    private String endTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean verify(boolean nextFlag){

        if(nextFlag){
            if(type == null || StringUtils.isBlank(startTime) || StringUtils.isBlank(endTime)){
                return true;
            }
        }
        try {
            if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime) &&
                    DateUtils.parseDate(startTime,"yyyy-MM-dd HH:mm:ss").getTime() >=
                    DateUtils.parseDate(endTime,"yyyy-MM-dd HH:mm:ss").getTime()){
                return true;
            }
        } catch (ParseException e) {
            throw new RuntimeException("活动开始时间和结束时间参数有问题",e);
        }
        return false;
    }

    @Override
    public String toString() {

        return "{" +
                "\"type\":" + type +
                ", \"holiday\":\"" + holiday + "\"" +
                ", \"startTime\":" + string2Date(startTime).getTime() +
                ", \"endTime\":" + string2Date(endTime).getTime() +
                '}';
    }

    private Date string2Date(String s){
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date  = fmt.parse(s);
        } catch (ParseException e) {
            date = new Date();
        }
        return date;
    }
}
