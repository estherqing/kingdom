package com.vivo.jovi.exscene.backend.service.model.vo;

/**
 * @description: ExSportVO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-20
 */
public class ExSportVO {
    /**
     * 赛事id
     */
    private Long leagueId;
    /**
     * 赛事名称
     */
    private String leagueName;
    /**
     * 赛事类型，现有板球、足球和篮球三种
     */
    private String fetchType;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getFetchType() {
        return fetchType;
    }

    public void setFetchType(String fetchType) {
        this.fetchType = fetchType;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "ExSportVO{" +
                "leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", fetchType='" + fetchType + '\'' +
                '}';
    }
}
