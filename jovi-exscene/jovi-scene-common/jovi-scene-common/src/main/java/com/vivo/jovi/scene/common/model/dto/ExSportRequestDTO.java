package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: 获取普通赛事请求参数
 * @author: Lu Guodong
 * @CreateDate: 2019-07-20
 */
public class ExSportRequestDTO {
    private Long leagueId;

    private String countryCode;

    private String leagueName;

    private String fetchType;

    private Integer pageSize;

    private Integer pageNum;

    private String order;

    private String field;

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

    public String getFetchType() {
        return fetchType;
    }

    public void setFetchType(String fetchType) {
        this.fetchType = fetchType;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "ExSportRequestDTO{" +
                "leagueId=" + leagueId +
                ", countryCode='" + countryCode + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", fetchType='" + fetchType + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", order='" + order + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
