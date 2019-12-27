package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.console.data.domain.SimplePage;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.service.impl.ExSportsService;
import com.vivo.jovi.exscene.backend.service.model.vo.ExSportVO;
import com.vivo.jovi.exscene.backend.service.model.vo.ExSportsOperateRecordVO;
import com.vivo.jovi.exscene.backend.web.filter.ThreadLocalSSOUser;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.model.dto.ExSportDTO;
import com.vivo.jovi.scene.common.model.dto.ExSportResponseDTO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 外销赛事运营
 * @author: Lu Guodong
 * @CreateDate: 2019-07-19
 */
@Controller
@RequestMapping("exscene/sports")
public class ExSportsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExSportsService.class);

    private static final String OERATING_COUNTRIES = VivoConfigManager.getString("operating.countries", "印度");

    @Autowired
    private ExSportsService exSportsService;

    @Autowired
    private IPublishService publishService;

    @RequestMapping("/operate")
    public String publishHome() {
        return "scene/sports/index";
    }

    /**
     * 获取当前运营的国家
     * @return
     */
    @RequestMapping("getOperatingCountries")
    @ResponseBody
    public CommonVO getOperatingCountries(){
        return CommonVO.success(Arrays.asList(OERATING_COUNTRIES));
    }


    /**
     * 获取热门赛事列表
     * @param exSportDTO
     * @return
     */
    @RequestMapping("getHotSportList")
    @ResponseBody
    public CommonVO getHotSportList(@RequestBody ExSportDTO exSportDTO){
        Boolean isValid = exSportsService.validParams(exSportDTO);
        if (!isValid) {
            return CommonVO.badParams("getHotSportList error with invalid country");
        }

        List<ExSportVO> exSportsVOList;
        try {
            exSportsVOList = exSportsService.getHotSportList(exSportDTO);
            if (exSportsVOList == null){
                return null;
            }
        } catch (Exception e){
            LOGGER.error("getHotSportList fail with ExSportDTO={} because of {}", exSportDTO, e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, "getHotSportList fail with serverError");
        }
        return CommonVO.success(exSportsVOList);
    }

    /**
     * 获取非热门赛事列表
     * @param exSportDTO
     * @return
     */
    @RequestMapping("getGeneralSportList")
    @ResponseBody
    public CommonVO getGeneralSportList(@RequestBody ExSportDTO exSportDTO){
        Boolean isValid = exSportsService.validParams(exSportDTO);
        if (!isValid) {
            return CommonVO.badParams("getGeneralSportList error with invalid country");
        }
        if ( null == exSportDTO.getPage()) {
            exSportDTO.setPage(1);
        }
        if (null == exSportDTO.getPageSize()) {
            exSportDTO.setPageSize(20);
        }
        List<ExSportVO> exSportsVOList;
        ExSportResponseDTO exSportResponseDTO;
        try {
            exSportResponseDTO = exSportsService.getGeneralSportList(exSportDTO.getCountry(), exSportDTO.getLeagueName(), exSportDTO.getFetchType(),
                    exSportDTO.getPageSize(), exSportDTO.getPage(), exSportDTO.getOrder(), exSportDTO.getField());
            exSportsVOList = exSportsService.addToList(exSportResponseDTO);
            if (exSportsVOList == null) {
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("getGeneralSportList fail with ExSportDTO={} because of {}", exSportDTO, e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, "getGeneralSportList fail with serverError");
        }
        Pageable pageable = new PageRequest(exSportDTO.getPage() - 1, exSportDTO.getPageSize(), null);
        Integer count = exSportResponseDTO.getData().getTotalRows();
        SimplePage<ExSportVO> simplePage = new SimplePage<>(exSportsVOList, pageable, count);
        return CommonVO.success(simplePage);
    }

    /**
     * 设为/取消热门赛事
     * @param exSportDTO
     * @return
     */
    @RequestMapping("setHotSport")
    @ResponseBody
    public CommonVO setHotSport(@RequestBody ExSportDTO exSportDTO) {
        Integer status = exSportDTO.getStatus();
        if (exSportDTO.getStatus() != 0 && exSportDTO.getStatus() != 1) {
            return CommonVO.badParams(status, "setHotSport error with invalid status not 1 or 0");
        }
        if (StringUtils.isBlank(exSportDTO.getCountry()) || !exSportsService.isValidCountry(exSportDTO.getCountry())) {
            return CommonVO.badParams("setHotSport error with invalid country");
        }
        if (StringUtils.isBlank(exSportDTO.getLeagueName()) || exSportDTO.getLeagueId() == null) {
            return CommonVO.badParams("setHotSport error with invalid leagueName or leagueId");
        }
        try {
            exSportsService.setHotSport(exSportDTO.getCountry(), exSportDTO.getLeagueName(), exSportDTO.getStatus(), exSportDTO.getLeagueId());
            SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
            exSportsService.addOperateRecord(exSportDTO, ssoUser);
        } catch (Exception e) {
            LOGGER.error("setHotSport fail with ExSportDTO={} because of {}", exSportDTO, e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, "setHotSport fail with serverError");
        }
        return CommonVO.success();
    }

    /**
     * 获取赛事的操作记录
     * @param exSportDTO
     * @return
     */
    @RequestMapping("getOperateRecord")
    @ResponseBody
    public CommonVO getOperateRecord(@RequestBody ExSportDTO exSportDTO) {
        if (exSportDTO.getLeagueId() == null || StringUtils.isBlank(exSportDTO.getLeagueName()) || StringUtils.isBlank(exSportDTO.getCountry())) {
            return CommonVO.error(CommonVOCode.BAD_PARAMS, "getOperateRecord fail with leagueId or leagueName or country being null");
        }
        if ( null == exSportDTO.getPage()) {
            exSportDTO.setPage(1);
        }
        if (null == exSportDTO.getPageSize()) {
            exSportDTO.setPageSize(20);
        }
        Pageable pageable = new PageRequest(exSportDTO.getPage() - 1, exSportDTO.getPageSize(), null);
        List<ExSportsOperateRecordVO> exSportsOperateRecordVOList;
        try {
            exSportsOperateRecordVOList = exSportsService.getOperateRecord(exSportDTO.getLeagueId(), exSportDTO.getLeagueName(), exSportDTO.getCountry(), pageable);
        } catch (Exception e) {
            LOGGER.error("getOperateRecord fail with error", e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, "getOperateRecord fail with serverError");
        }
       /* if (CollectionUtils.isEmpty(exSportsOperateRecordVOList)) {
            return CommonVO.success(exSportsOperateRecordVOList);
        }*/
        SimplePage<ExSportsOperateRecordVO> simplePage = new SimplePage<>(exSportsOperateRecordVOList, pageable, exSportsOperateRecordVOList.size());
        return CommonVO.success(simplePage);
    }
}
