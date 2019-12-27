package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: 外销赛事请求参数
 * @author: Lu Guodong
 * @CreateDate: 2019-07-19
 */
public class ExSportDTO {
    private Long leagueId;

    private String country;

    private String order;

    private String field;

    private String leagueName;

    private String fetchType;

    /**
     * 分页页数
     */
    private Integer page;

    /**
     * 设置为热门赛事：1；取消热门赛事设置：0
     */
    private Integer status;

    /**分页size*/
    private Integer pageSize;

    private Integer offset;

    private Integer limit;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "ExSportDTO{" +
                "leagueId=" + leagueId +
                ", country='" + country + '\'' +
                ", order='" + order + '\'' +
                ", field='" + field + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", fetchType='" + fetchType + '\'' +
                ", page=" + page +
                ", status=" + status +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
