package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: ExSetHotSportDTO
 * @author: Lu Guodong
 * @CreateDate: 2019-08-08
 */
public class ExSetHotSportDTO {
    private Long leagueId;

    private String country;

    private String leagueName;

    /**
     * 设置为热门赛事：1；取消热门赛事设置：0
     */
    private Integer status;

    @Override
    public String toString() {
        return "ExSetHotSportDTO{" +
                "leagueId=" + leagueId +
                ", country='" + country + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
