package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: 获取热门赛事请求参数
 * @author: Lu Guodong
 * @CreateDate: 2019-07-24
 */
public class ExHotSportRequestDTO {
    private String leagueName;

    private String fetchType;

    private String countryCode;

    private String order;

    private String field;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    @Override
    public String toString() {
        return "ExHotSportRequestDTO{" +
                "leagueName='" + leagueName + '\'' +
                ", fetchType='" + fetchType + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", order='" + order + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
