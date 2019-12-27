package com.vivo.jovi.exscene.backend.service.impl;

import com.google.common.collect.Lists;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IExSportsService;
import com.vivo.jovi.exscene.backend.service.model.vo.ExSportVO;
import com.vivo.jovi.exscene.backend.service.model.vo.ExSportsOperateRecordVO;
import com.vivo.jovi.scene.common.dal.dao.IExSportDao;
import com.vivo.jovi.scene.common.dal.entity.SportOperateRecordEntity;
import com.vivo.jovi.scene.common.exception.ExSportRequestException;
import com.vivo.jovi.scene.common.model.dto.*;
import com.vivo.jovi.scene.common.service.httpClient.IHttpClientService;
import com.vivo.jovi.scene.common.util.DateUtil;
import com.vivo.jovi.scene.common.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: ExSportsService
 * @author: Lu Guodong
 * @CreateDate: 2019-07-20
 */
@Service
public class ExSportsService implements IExSportsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExSportsService.class);

    private static final String EX_SPORT_URL = VivoConfigManager.getString("ex.sport.url", "https://in-assistant-sports.vivoglobal.com");

    @Autowired
    private IHttpClientService httpClientService;

    @Autowired
    private IExSportDao exSportDao;

    @Override
    public List<ExSportVO> getHotSportList(ExSportDTO exSportDTO) {
        String response = null;
        ExHotSportResponseDTO exSportResponseDTO;
        ExHotSportRequestDTO exHotSportRequestDTO = new ExHotSportRequestDTO();
        exHotSportRequestDTO.setCountryCode(exSportDao.getAbbrByCountry(exSportDTO.getCountry()));
        exHotSportRequestDTO.setField(exSportDTO.getField());
        exHotSportRequestDTO.setOrder(exSportDTO.getOrder());
        exHotSportRequestDTO.setFetchType(exSportDao.getTranslationBySport(exSportDTO.getFetchType()));
        exHotSportRequestDTO.setLeagueName(exSportDTO.getLeagueName());
        try {
            response = httpClientService.doPostJson(EX_SPORT_URL + "/getHotLeagues", JsonUtils.TO_JSON(exHotSportRequestDTO));
            exSportResponseDTO = JsonUtils.TO_OBJ(response, ExHotSportResponseDTO.class);
            if (exSportResponseDTO.getRetcode() == 0) {
                LOGGER.info("getHotSportList success with response={} and country={}", response, exSportDTO.getCountry());
            } else {
                LOGGER.error("getHotSportList failed with  response={} and country={}", response, exSportDTO.getCountry());
                throw new ExSportRequestException("getHotSportList failed with getting wrong response code");
            }
        } catch (Exception e) {
            LOGGER.error("getHotSportList fail with response={} and country={}, {}=", response, exSportDTO.getCountry(), e);
            throw new ExSportRequestException("getHotSportList fail with request error");
        }
        return addToHotList(exSportResponseDTO);
    }

    @Override
    public boolean validParams(ExSportDTO exSportDTO) {
        final String defaultCountry = "印度";
        if (StringUtils.isBlank(exSportDTO.getCountry())) {
            exSportDTO.setCountry(defaultCountry);
        }
        if (StringUtils.isBlank(exSportDTO.getField())) {
            exSportDTO.setField("id");
        }
        if (StringUtils.isBlank(exSportDTO.getOrder())) {
            exSportDTO.setOrder("desc");
        }
        String country = exSportDTO.getCountry();
        return isValidCountry(country);
    }

    @Override
    public ExSportResponseDTO getGeneralSportList(String country, String leagueName, String fetchType, Integer pageSize, Integer pageNum, String order, String field) {
        String response = null;
        ExSportResponseDTO exSportResponseDTO;
        ExSportRequestDTO exSportRequestDTO = new ExSportRequestDTO();
        exSportRequestDTO.setCountryCode(exSportDao.getAbbrByCountry(country));
        if (leagueName == null) {
            exSportRequestDTO.setLeagueName("");
        }
        exSportRequestDTO.setLeagueName(leagueName);
        if (fetchType == null) {
            exSportRequestDTO.setFetchType("");
        }
        exSportRequestDTO.setFetchType(exSportDao.getTranslationBySport(fetchType));
        exSportRequestDTO.setPageSize(pageSize);
        exSportRequestDTO.setPageNum(pageNum - 1);
        exSportRequestDTO.setOrder(order);
        exSportRequestDTO.setField(field);
        try {
            response = httpClientService.doPostJson(EX_SPORT_URL + "/getGeneralLeagues", JsonUtils.TO_JSON(exSportRequestDTO));
            exSportResponseDTO = JsonUtils.TO_OBJ(response, ExSportResponseDTO.class);
            if (exSportResponseDTO.getRetcode() == 0) {
                LOGGER.info("getGeneralSportList success with response={} and request={}", response, exSportRequestDTO.toString());
            } else {
                LOGGER.error("getGeneralSportList failed with response={} and request={}", response, exSportRequestDTO.toString());
                throw new ExSportRequestException("getGeneralSportList failed with getting wrong response code");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("getGeneralSportList failed with response={} and request={}", response, exSportRequestDTO.toString());
            throw new ExSportRequestException("getHotSportList fail with request error");
        }
        return exSportResponseDTO;
    }

    @Override
    public void setHotSport(String country, String leagueName, Integer status, Long leagueId) {
        String response = null;
        SetHotSportResponseDTO setHotSportResponseDTO;
        SetHotSportResquestDTO setHotSportResquestDTO = new SetHotSportResquestDTO();
        setHotSportResquestDTO.setCountryCode(exSportDao.getAbbrByCountry(country));
        setHotSportResquestDTO.setLeagueName(leagueName);
        setHotSportResquestDTO.setStatus(status);
        setHotSportResquestDTO.setLeagueId(leagueId);
        try {
            response = httpClientService.doPostJson(EX_SPORT_URL + "/setLeagueHotStatus", JsonUtils.TO_JSON(setHotSportResquestDTO));
            setHotSportResponseDTO = JsonUtils.TO_OBJ(response, SetHotSportResponseDTO.class);
            if (setHotSportResponseDTO.getRetcode() == 0) {
                LOGGER.info("setHotSport success with response={}", response);
            } else {
                LOGGER.error("setHotSport failed with response={}", response);
                throw new ExSportRequestException("setHotSport failed with getting wrong response code");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("setHotSport failed with response={}", response);
            throw new ExSportRequestException("setHotSport fail with request error");
        }
    }

    /**
     * 验证国家是否有效
     *
     * @param country
     * @return
     */
    @Override
    public boolean isValidCountry(String country) {
        int countryNum = exSportDao.countCountryNum(country);
        if (countryNum != 1) {
            return false;
        }
        return true;
    }

    @Override
    public List<ExSportVO> addToList(ExSportResponseDTO exSportResponseDTO) {
        List<ExSportVO> exSportVOList = new ArrayList<>();
        ExSportReturnDTO exSportReturnDTO = exSportResponseDTO.getData();
        List<ExSportReturnContentDTO> contentList = exSportReturnDTO.getContent();
        if (contentList == null) {
            return null;
        }
        for (ExSportReturnContentDTO contentDTO : contentList) {
            ExSportVO exSportVO = new ExSportVO();
            exSportVO.setLeagueId(contentDTO.getId());
            exSportVO.setLeagueName(contentDTO.getLeagueName());
            exSportVO.setFetchType(contentDTO.getFetchType());
            exSportVOList.add(exSportVO);
            exSportVO = null;
        }
        return exSportVOList;
    }

    @Override
    public List<ExSportVO> addToHotList(ExHotSportResponseDTO exSportResponseDTO) {
        List<ExSportVO> exSportVOList = new ArrayList<>();
        List<ExHotSportContentDTO> contentList = exSportResponseDTO.getData();
        if (contentList == null) {
            return null;
        }
        for (ExHotSportContentDTO contentDTO : contentList) {
            ExSportVO exSportVO = new ExSportVO();
            exSportVO.setLeagueId(contentDTO.getLeagueId());
            exSportVO.setLeagueName(contentDTO.getLeagueName());
            exSportVO.setFetchType(contentDTO.getFetchType());
            exSportVOList.add(exSportVO);
            exSportVO = null;
        }
        return exSportVOList;
    }

    @Override
    public void addOperateRecord(ExSportDTO exSportDTO, SSOUser ssoUser) {
        String operationalDesc = "取消热门";
        if (exSportDTO.getStatus() == 1) {
            operationalDesc = "设为热门";
        }
        SportOperateRecordEntity sportOperateRecordEntity = new SportOperateRecordEntity();
        sportOperateRecordEntity.setLeagueId(exSportDTO.getLeagueId());
        sportOperateRecordEntity.setLeagueName(exSportDTO.getLeagueName());
        sportOperateRecordEntity.setCountry(exSportDTO.getCountry());
        sportOperateRecordEntity.setOperator(ssoUser == null ? "" : ssoUser.getUserName());
        sportOperateRecordEntity.setOperationalDesc(operationalDesc);
        exSportDao.insertSelective(sportOperateRecordEntity);

    }

    @Override
    public List<ExSportsOperateRecordVO> getOperateRecord(Long leagueId, String leagueName, String country, Pageable pageable) {
        Integer limit = pageable.getPageSize();
        Integer offSet = pageable.getOffset();
        List<SportOperateRecordEntity> sportOperateRecordEntityList = exSportDao.getOperateRecord(leagueId, leagueName, country, limit, offSet);
        List<ExSportsOperateRecordVO> exSportsOperateRecordVOList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(sportOperateRecordEntityList)) {
            for (SportOperateRecordEntity sportOperateRecordEntity : sportOperateRecordEntityList) {
                ExSportsOperateRecordVO exSportsOperateRecordVO = new ExSportsOperateRecordVO();
                exSportsOperateRecordVO.setOperatingTime(DateUtil.format(sportOperateRecordEntity.getOperatingTime(), DateUtil.DEF_TIME_FORMAT));
                exSportsOperateRecordVO.setOperationalDesc(sportOperateRecordEntity.getOperationalDesc());
                exSportsOperateRecordVO.setOperator(sportOperateRecordEntity.getOperator());
                exSportsOperateRecordVOList.add(exSportsOperateRecordVO);
            }
        }
        return exSportsOperateRecordVOList;
    }

    private String refFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String refFormatNowDate = simpleDateFormat.format(nowTime);
        return refFormatNowDate;
    }
}
