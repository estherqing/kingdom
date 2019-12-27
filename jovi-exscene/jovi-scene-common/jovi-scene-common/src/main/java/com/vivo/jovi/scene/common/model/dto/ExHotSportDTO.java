package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: 热门赛事请求参数
 * @author: Lu Guodong
 * @CreateDate: 2019-07-22
 */
public class ExHotSportDTO {
    private String country;

    private String order;

    private String field;

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

    @Override
    public String toString() {
        return "ExHotSportDTO{" +
                "country='" + country + '\'' +
                ", order='" + order + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
