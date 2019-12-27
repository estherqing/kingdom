package com.vivo.jovi.exscene.api.service.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description 活动卡片对象客户端
 * @auther zhongjiajun
 * @create 2019-12-07 16:33
 */
@Data
public class ActivityCardVO {
    private String activityId;
    private Integer status;
    private List<ActivityNameVo> activityTranslation;
    private Long startTime;
    private Long endTime;
    private String bannerUrl;
    private String iconUrl;
    private Integer cardPosition;
    private Integer jumpType;
    private String jumpUrl;
    private Integer weight;
    private Integer disapperType;
    private Long publishTime;
    private Integer noticeType;
    private List<ActivityCardNoticeVO> notice;
    private Long noticeStartTime;
    private Long noticeEndtime;
}
