package com.vivo.jovi.exscene.api.service;

import com.vivo.jovi.scene.common.model.ExsceneActivityCardBizQueryParam;

import java.util.Map;

/**
 * @Description 活动卡片管理
 * @auther zhongjiajun
 * @create 2019-12-07 16:32
 */
public interface IActivityCardService {
    /**
     * 客户端主动轮询获取最新调研卡片
     *
     * @param exsceneBizQueryParam
     * @return
     */
    Map<String, Object> getActivityCardList(ExsceneActivityCardBizQueryParam exsceneBizQueryParam);
}
