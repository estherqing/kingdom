package com.vivo.jovi.scene.common.dal.entity;

import lombok.Data;

/**
 * @author zhongjiajun
 * @date 2019/12/5 11:40
 * @describe 活动通知消息
 */
@Data
public class ExActivityNoticeEntity {
    private Long id;
    /**
     * 活动卡片Id
     */
    private String activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 弹窗文案
     */
    private String popup;
    /**
     * 语言
     */
    private String language;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
}
