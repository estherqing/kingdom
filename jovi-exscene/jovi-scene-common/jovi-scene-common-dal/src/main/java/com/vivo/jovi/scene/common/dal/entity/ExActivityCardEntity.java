package com.vivo.jovi.scene.common.dal.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhongjiajun
 * @date 2019/12/4 15:28
 * @describe 活动卡片对象
 */
@Data
public class ExActivityCardEntity {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 活动卡片名称
     */
    private String activityId;
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
    private String iconUrl;
    /**
     * 活动banner
     */
    private String bannerUrl;
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
    private String noticeStartTime;
    /**
     * 通知触发结束时间
     */
    private String noticeEndTime;
    /**
     * 翻译语言类型
     */
    private String translateLanguage;
    /**
     * 下架原因
     */
    private String pulloffReason;
    /**
     * 禁用原因
     */
    private String disableReason;
    /**
     * 测试审核id
     */
    private String approvalTestUserId;
    /**
     * 测试审核姓名
     */
    private String approvalTestUserName;
    /**
     * 测试审核不通过原因
     */
    private String approvalTestReason;
    /**
     * 测试审批结果
     */
    private Integer approvalTestStatus;
    /**
     * 审核运营id
     */
    private String approvalOperationUserId;
    /**
     * 审核运营姓名
     */
    private String approvalOperationUserName;
    /**
     * 运营审核不通过原因
     */
    private String approvalOperationReason;
    /**
     * 运营审核结果
     */
    private Integer approvalOperationStatus;
    /**
     * 翻译文件名
     */
    private String translateFileName;
    /**
     * 翻译文件url
     */
    private String translateFileUrl;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建者账户
     */
    private String createUserId;
    /**
     * 创建者名字
     */
    private String createUserName;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者账户
     */
    private String modifyUserId;
    /**
     * 修改者名字
     */
    private String modifyUserName;
    /**
     * 最近更新的时间
     */
    private Date modifyTime;

}
