package com.vivo.jovi.exscene.api.service.model.vo;

import lombok.Data;

/**
 * @Description 活动卡片名称
 * @auther zhongjiajun
 * @create 2019-12-10 15:05
 */
@Data
public class ActivityNameVo {
    /**
     * 语言
     */
    private String language;
    /**
     * 活动卡片名称
     */
    private String activityName;
    /**
     * 弹窗文案
     */
    private String popup;
}
