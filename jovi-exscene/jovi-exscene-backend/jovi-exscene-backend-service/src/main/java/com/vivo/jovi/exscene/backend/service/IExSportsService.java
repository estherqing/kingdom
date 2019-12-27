package com.vivo.jovi.exscene.backend.service;

import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.model.vo.ExSportVO;
import com.vivo.jovi.exscene.backend.service.model.vo.ExSportsOperateRecordVO;
import com.vivo.jovi.scene.common.model.dto.ExHotSportResponseDTO;
import com.vivo.jovi.scene.common.model.dto.ExSportDTO;
import com.vivo.jovi.scene.common.model.dto.ExSportResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @description: 外销赛事运营方法实现接口
 * @author: Lu Guodong
 * @CreateDate: 2019-07-20
 */
public interface IExSportsService {

    /**
     * 获取热门赛事列表
     * @param exSportDTO
     * @return
     */
    List<ExSportVO> getHotSportList(ExSportDTO exSportDTO);

    /**
     * 校验并初始化客户端请求参数
     * @param exSportDTO
     * @return
     */
    boolean validParams(ExSportDTO exSportDTO);

    /**
     * 获取非热门赛事列表
     * @param country
     * @param leagueName
     * @param fetchType
     * @param pageSize
     * @param pageNum
     * @param order
     * @param field
     * @return
     */
    ExSportResponseDTO getGeneralSportList(String country, String leagueName, String fetchType, Integer pageSize, Integer pageNum, String order, String field);

    /**
     * 判断是否是南亚七国之一
     * @param country
     * @return
     */
    boolean isValidCountry(String country);

    /**
     * 设置/取消热门赛事
     * @param country
     * @param leagueName
     * @param status
     * @param leagueId
     */
    void setHotSport(String country, String leagueName, Integer status, Long leagueId);

    /**
     * 获取最终的非热门赛事列表
     * @param exSportResponseDTO
     * @return
     */
    List<ExSportVO> addToList(ExSportResponseDTO exSportResponseDTO);

    /**
     * 获取最终的热门赛事列表
     * @param exSportResponseDTO
     * @return
     */
    List<ExSportVO> addToHotList(ExHotSportResponseDTO exSportResponseDTO);

    /**
     * 添加操作历史
     * @param exSportDTO
     * @param ssoUser
     */
    void addOperateRecord(ExSportDTO exSportDTO, SSOUser ssoUser);

    /**
     * 获取赛事的相应操作历史
     * @param leagueId
     * @param leagueName
     * @param country
     * @param pageable
     * @return
     */
    List<ExSportsOperateRecordVO> getOperateRecord(Long leagueId, String leagueName, String country, Pageable pageable);
}
