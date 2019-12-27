package com.vivo.jovi.exscene.api.web.controller;

import com.vivo.jovi.exscene.api.service.IActivityCardService;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.model.ExsceneActivityCardBizQueryParam;
import com.vivo.jovi.scene.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description 活动卡片对客户端接口
 * @auther zhongjiajun
 * @create 2019-12-07 17:49
 */
@Controller
@RequestMapping("exscene/activity/card")
@Slf4j
public class ActivityCardController extends BaseController {
    @Autowired
    private IActivityCardService activityCardService;

    @RequestMapping("query")
    @ResponseBody
    public CommonVO query(@RequestBody ExsceneActivityCardBizQueryParam exsceneBizQueryParam) {
        log.info("queryActivityCard begin with param={}", JsonUtils.TO_JSON(exsceneBizQueryParam));
        try {
            Map<String, Object> exsceneBizMap = activityCardService.getActivityCardList(exsceneBizQueryParam);
            if (MapUtils.isEmpty(exsceneBizMap)) {
                return CommonVO.error(CommonVOCode.NO_DATA, null);
            } else {
                log.info("queryActivityCard success with  result={}", JsonUtils.TO_JSON(exsceneBizMap));
                return CommonVO.success(exsceneBizMap);
            }
        } catch (Exception e) {
            log.error("SERVICE_ERROR:", e);
            return CommonVO.error(CommonVOCode.SERVER_ERROR, e.getMessage() + ":" + getTraceSource(e));
        }
    }
}
