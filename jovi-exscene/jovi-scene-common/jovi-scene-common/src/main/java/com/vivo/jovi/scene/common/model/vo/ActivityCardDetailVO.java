package com.vivo.jovi.scene.common.model.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 活动卡片详细信息
 * @auther zhongjiajun
 * @create 2019-12-06 15:49
 */
@Data
@Builder
public class ActivityCardDetailVO implements Serializable {
    /**
     * 活动卡片Id
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
     * 活动icon
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
     * 跳转类型
     */
    private Integer jumpType;
    /**
     * 跳转链接
     */
    private String jumpUrl;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 卡片触发开始时间
     */
    private String triggerStartTime;
    /**
     * 卡片触发结束时间
     */
    private String triggerEndTime;
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
    private String noticeStartTime;
    /**
     * 通知触发结束时间
     */
    private String noticeEndTime;
    /**
     * 翻译语言类型
     */
    private String[] translateLanguage;
    /**
     * 下架原因
     */
    private String offShelfReason;
    /**
     * 禁用原因
     */
    private String forbidReason;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 运营审核结果
     */
    private Integer approvalOperationStatus;
    /**
     * 运营驳回原因
     */
    private String approvalOperationReason;
    /**
     * 运营人员姓名
     */
    private String approvalOperationUserName;
    /**
     * 测试审核结果
     */
    private Integer approvalTestStatus;
    /**
     * 测试驳回原因
     */
    private String approvalTestReason;
    /**
     * 测试姓名
     */
    private String approvalTestUserName;
}
