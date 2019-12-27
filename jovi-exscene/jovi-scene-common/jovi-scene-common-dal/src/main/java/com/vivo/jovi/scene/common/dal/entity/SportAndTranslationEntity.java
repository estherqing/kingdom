package com.vivo.jovi.scene.common.dal.entity;

/**
 * @description: t_sport_translation对应实体类
 * @author: Lu Guodong
 * @CreateDate: 2019-07-22
 */
public class SportAndTranslationEntity {
    private Integer id;

    /**
     * 运动类型(中文)
     */
    private String sportName;

    /**
     * 运动对应的英文翻译
     */
    private String sportTranslation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportTranslation() {
        return sportTranslation;
    }

    public void setSportTranslation(String sportTranslation) {
        this.sportTranslation = sportTranslation;
    }
}
