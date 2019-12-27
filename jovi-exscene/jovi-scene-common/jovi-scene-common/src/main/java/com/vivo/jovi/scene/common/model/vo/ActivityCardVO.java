package com.vivo.jovi.scene.common.model.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 活动卡片信息
 * @auther zhongjiajun
 * @create 2019-12-06 15:42
 */
@Data
@Builder
public class ActivityCardVO implements Serializable {
    /**
     * 活动卡片Id
     */
    private Long id;
    /**
     * 活动卡片名称
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 操作员
     */
    private String operator;
}
