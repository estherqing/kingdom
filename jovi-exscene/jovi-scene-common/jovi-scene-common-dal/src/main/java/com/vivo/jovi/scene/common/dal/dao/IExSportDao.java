package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.SportOperateRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IExSportDao {

    /**
     * 判断前端传递的国家码是否有效
     * @param country
     * @return
     */
    int countCountryNum(String country);

    /**
     * 通过国际域名缩写获取中文国家名称
     * @param country
     * @return
     */
    String getAbbrByCountry(String country);

    /**
     * 通过中文国家名称获取国际域名缩写
     * @param abbreviation
     * @return
     */
    String getCountryByAbbr(String abbreviation);

    /**
     * 根据前端传递的中文获取英语名称
     * @param translation
     * @return
     */
    String getSportByTranslation(String translation);

    /**
     * 将从外销赛事获取的运动类型转化为中文
     * @param sportName
     * @return
     */
    String getTranslationBySport(String sportName);

    /**
     * 添加操作记录
     * @param sportOperateRecordEntity
     */
    void insertSelective(SportOperateRecordEntity sportOperateRecordEntity);

    /**
     * 获取操作历史记录
     *
     * @param leagueId
     * @param leagueName
     * @param country
     * @param limit
     * @param offSet
     * @return
     */
    List<SportOperateRecordEntity> getOperateRecord(@Param("leagueId") Long leagueId, @Param("leagueName") String leagueName,
                                                    @Param("country") String country, @Param("limit") Integer limit, @Param("offSet") Integer offSet);
}
