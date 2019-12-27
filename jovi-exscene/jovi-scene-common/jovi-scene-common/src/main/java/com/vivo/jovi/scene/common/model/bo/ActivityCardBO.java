package com.vivo.jovi.scene.common.model.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhongjiajun
 * @date 2019/12/4 17:37
 * @describe 活动卡片
 */
@Data
public class ActivityCardBO {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 活动卡片名称
     */
    private String name;
    /**
     * 弹窗文案
     */
    private String popup;
    /**
     * 活动Icon
     */
    private String icon;
    /**
     * 活动banner
     */
    private String banner;
    /**
     * 卡片位置
     */
    private Integer cardPosition;
    /**
     * 是否跳转
     */
    private Integer jumpType;
    /**
     * 跳转地址
     */
    private String jumpUrl;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 卡片触发开始时间
     */
    private Date triggerStartTime;
    /**
     * 卡片触发结束时间
     */
    private Date triggerEndTime;
    /**
     * 消失规则
     */
    private Integer disapperType;
    /**
     * 通知标题
     */
    private String noticeTitle;
    /**
     * 通知内容
     */
    private String noticeContent;
    /**
     * 通知触发方式
     */
    private Integer noticeType;
    /**
     * 通知触发开始时间
     */
    private Date noticeStartTime;
    /**
     * 通知触发结束时间
     */
    private Date noticeEndTime;
    /**
     * 翻译语言类型
     */
    private String[] translateLanguage;
    /**
     * 保存类型
     */
    private Integer saveAction;
}
