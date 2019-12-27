package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: 设置或者取消热门赛事请求参数
 * @author: Lu Guodong
 * @CreateDate: 2019-07-22
 */
public class SetHotSportResquestDTO {
    private String countryCode;

    private String leagueName;

    private Integer status;

    private Long leagueId;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "SetHotSportResquestDTO{" +
                "countryCode='" + countryCode + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", status=" + status +
                ", leagueId=" + leagueId +
                '}';
    }
}
