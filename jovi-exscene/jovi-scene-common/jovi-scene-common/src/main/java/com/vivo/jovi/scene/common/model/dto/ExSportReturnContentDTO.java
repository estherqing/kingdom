package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: ExSportReturnContentDTO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-23
 */
public class ExSportReturnContentDTO {
    private Long id;

    private Long thirdPartId;

    private String leagueName;

    private String leagueLogo;

    private String fetchType;

    private String urlLeagueId;

    private Integer activated;

    public Long getThirdPartId() {
        return thirdPartId;
    }

    public void setThirdPartId(Long thirdPartId) {
        this.thirdPartId = thirdPartId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueLogo() {
        return leagueLogo;
    }

    public void setLeagueLogo(String leagueLogo) {
        this.leagueLogo = leagueLogo;
    }

    public String getFetchType() {
        return fetchType;
    }

    public void setFetchType(String fetchType) {
        this.fetchType = fetchType;
    }

    public String getUrlLeagueId() {
        return urlLeagueId;
    }

    public void setUrlLeagueId(String urlLeagueId) {
        this.urlLeagueId = urlLeagueId;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExSportReturnContentDTO{" +
                "id=" + id +
                ", thirdPartId=" + thirdPartId +
                ", leagueName='" + leagueName + '\'' +
                ", leagueLogo='" + leagueLogo + '\'' +
                ", fetchType='" + fetchType + '\'' +
                ", urlLeagueId='" + urlLeagueId + '\'' +
                ", activated=" + activated +
                '}';
    }
}
