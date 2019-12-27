package com.vivo.jovi.scene.common.dal.entity;

/**
 * @description: t_country_abbr对应实体类
 * @author: Lu Guodong
 * @CreateDate: 2019-07-22
 */
public class CountryAndAbbrEntity {

    private Integer id;

    /**
     * 国家(中文)
     */
    private String country;

    /**
     * 国际域名缩写
     */
    private String abbreviation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
