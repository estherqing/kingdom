package com.vivo.jovi.scene.common.model.dto;

import java.util.Date;

/**
 * @description: ExHotSportContentDTO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-24
 */
public class ExHotSportContentDTO {
    private Long id;

    private Long LeagueId;

    private String leagueName;

    private String countryCode;

    private String fetchType;

    private Date createTime;

    private Date updateTime;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFetchType() {
        return fetchType;
    }

    public void setFetchType(String fetchType) {
        this.fetchType = fetchType;
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

    public Long getLeagueId() {
        return LeagueId;
    }

    public void setLeagueId(Long leagueId) {
        LeagueId = leagueId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExHotSportContentDTO{" +
                "id=" + id +
                ", LeagueId=" + LeagueId +
                ", leagueName='" + leagueName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", fetchType='" + fetchType + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
