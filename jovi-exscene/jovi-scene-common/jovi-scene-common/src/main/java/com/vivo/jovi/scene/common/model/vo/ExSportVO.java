package com.vivo.jovi.scene.common.model.vo;

/**
 * @description: ExSportVO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-22
 */
public class ExSportVO {
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

    @Override
    public String toString() {
        return "ExSportsVO{" +
                "leagueName='" + leagueName + '\'' +
                ", fetchType='" + fetchType + '\'' +
                '}';
    }
}
