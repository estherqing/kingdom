package com.vivo.jovi.scene.common.service.impl;

import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.internet.vivocfg.client.internals.util.MD5Utils;
import com.vivo.jovi.scene.common.exception.InvokePushException;
import com.vivo.jovi.scene.common.model.PushRequestDTO;
import com.vivo.jovi.scene.common.model.PushResponseDTO;
import com.vivo.jovi.scene.common.service.ICommonMonitorService;
import com.vivo.jovi.scene.common.service.IPushService;
import com.vivo.jovi.scene.common.service.httpClient.IHttpClientService;
import com.vivo.jovi.scene.common.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 推送
 * @Author Hu Han
 * @Date 2019-03-02 11:15
 */
@Service
public class PushService implements IPushService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PushService.class);

    /**
     * push host
     */
    private static final String PUSH_HOST = VivoConfigManager.get("push.host", "http://121.43.164.239:3502");

    /**
     * push app key
     */
    private static final String PUSH_APP_KEY = VivoConfigManager.get("push.app.key", "9144b32b127b47ebb13703d3cd0f7cdf");

    /**
     * push app secret
     */
    private static final String PUSH_APP_SECRET = VivoConfigManager.get("push.app.secret", "00b7e630-c123-49ab-945b-0fc7f35cb815");

    /**
     * 是否启用 push
     */
    private static final boolean IS_ENABLE_PUSH = VivoConfigManager.getBoolean("is.enable.push", true);

    /**
     * 推送消息体的最大长度，超过这个长度消息将会push失败
     */
    private static final int PUSH_CUSTOM_MESSAGE_MAX_LENGTH = 1024 * 4;

    @Autowired
    private ICommonMonitorService monitorService;

    @Autowired
    private IHttpClientService httpClientService;

    @Override
    public<T> void batchPush(String imeis, T pushObj) {
        String[] imeiArray = imeis.split(";");
        String pushMsg = assemblePushMsg(pushObj);
        for (String imei : imeiArray) {
            List<String> backList = Arrays.asList(VivoConfigManager.getString("preview.black.list").split(","));
            if (backList.contains(imei)) {
                continue;
            }
            push(imei, pushMsg);
        }
    }

    /**
     * 组装PUSH数据
     */
    private<T> String assemblePushMsg(T pushCardsList) {
        Map<String, Object> data = new HashMap<>(0);
        data.put("code", 0);
        data.put("msg", "");
        data.put("data", pushCardsList);
        return JsonUtils.TO_JSON2(data);
    }

    @Override
    public void push(String imei, String pushMsg) {

        if (imei == null){
            //如果imei为null 直接返回
            return;
        }

        if (StringUtils.length(pushMsg) > PUSH_CUSTOM_MESSAGE_MAX_LENGTH) {
            LOGGER.error("Push message is too large,  imei=" + imei + " and pushMsg=" + pushMsg);
            return;
        }

        if (monitorService.monitorImeiPush(imei)) {
            //如果监控发现异常 直接返回
            return;
        }

        if (!IS_ENABLE_PUSH) {
            //如果没有配置 直接返回
            LOGGER.info("not enable push.");
            return;
        }

        Long timestamp = System.currentTimeMillis();
        PushRequestDTO pushPublishReqDTO = new PushRequestDTO();
        pushPublishReqDTO.setAppKey(PUSH_APP_KEY);
        pushPublishReqDTO.setCustomMessage(pushMsg);
        pushPublishReqDTO.setTimeToLive(1L);
        pushPublishReqDTO.setTargetUsers(imei);
        pushPublishReqDTO.setIsEncrypt(1L);
        pushPublishReqDTO.setTimestamp(timestamp);
        pushPublishReqDTO.setUserType(5);
        pushPublishReqDTO.setSign(MD5Utils.getMD5Str(PUSH_APP_KEY + PUSH_APP_SECRET + timestamp));
        LOGGER.info("push给手机的内容为：pushPublishReqDTO={}",JsonUtils.TO_JSON(pushPublishReqDTO));
        String response = httpClientService.doPostJson(PUSH_HOST + "/message/publishToUser", JsonUtils.TO_JSON(pushPublishReqDTO));
        if (StringUtils.isBlank(response)) {
            LOGGER.error("push return error ：pushPublishReqDTO={}",JsonUtils.TO_JSON(pushPublishReqDTO));
            throw new InvokePushException("get empty response when invoke push");
        }
        PushResponseDTO pushPublishResDTO = JsonUtils.TO_OBJ(response, PushResponseDTO.class);
        if (pushPublishResDTO.getCode() != 0) {
            throw new InvokePushException("Push imei=" + imei + " and pushMsg=" + pushMsg + ",get error code when invoke push , code is " + pushPublishResDTO.getCode() +
                    " and msg is " + pushPublishResDTO.getMsg() + " and data is " + pushPublishResDTO.getData());
        } else {
            LOGGER.info("Push imei=" + imei + " and pushMsg=" + pushMsg + " is success! and data is "+pushPublishResDTO.getData());
        }
    }
}
