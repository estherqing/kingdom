package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.ExActivityNoticeEntity;

import java.util.List;

/**
 * @author zhongjiajun
 * @date 2019/12/5 14:07
 * @describe 活动卡片通知信息
 */
public interface IExActivityNoticeDao {
    /**
     * 新增活动卡片
     *
     * @param entity 活动卡片
     * @return
     */
    int insert(ExActivityNoticeEntity entity);

    /**
     * 删除活动卡片信息
     *
     * @param activityId 活动卡片id
     * @return
     */
    int deleteByActivityId(String activityId);

    /**
     * 查询活动卡片信息详情
     *
     * @param activityId 活动卡片id
     * @return
     */
    List<ExActivityNoticeEntity> selectByActivityId(String activityId);
}
