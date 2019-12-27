package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @description: t_exscene_sport_operate_record对应实体类
 * @author: Lu Guodong
 * @CreateDate: 2019-08-08
 */
public class SportOperateRecordEntity {
    private Long id;
    private Long leagueId;
    private String leagueName;
    private String country;
    private String operationalDesc;
    private Date operatingTime;
    private String operator;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOperationalDesc() {
        return operationalDesc;
    }

    public void setOperationalDesc(String operationalDesc) {
        this.operationalDesc = operationalDesc;
    }

    public Date getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(Date operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SportOperateRecordEntity{" +
                "id=" + id +
                ", leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", country='" + country + '\'' +
                ", operationalDesc='" + operationalDesc + '\'' +
                ", operatingTime=" + operatingTime +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
