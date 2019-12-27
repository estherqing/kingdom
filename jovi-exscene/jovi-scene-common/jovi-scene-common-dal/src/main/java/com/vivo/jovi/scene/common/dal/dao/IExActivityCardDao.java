package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhongjiajun
 * @date 2019/12/4 16:54
 * @describe 活动卡片管理
 */
public interface IExActivityCardDao {
    /**
     * 新增活动卡片
     *
     * @param entity 活动卡片
     * @return
     */
    int insertSelective(ExActivityCardEntity entity);

    /**
     * 更新活动卡片信息
     *
     * @param entity 活动卡片
     * @return
     */
    int updateSelectiveByPrimaryKey(ExActivityCardEntity entity);

    /**
     * 删除活动卡片信息
     *
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 查询活动卡片详情信息
     *
     * @param id 主键
     * @return
     */
    ExActivityCardEntity selectByPrimaryKey(Long id);

    /**
     * 查询活动卡片详情信息
     *
     * @param activityId 活动卡片id
     * @return
     */
    ExActivityCardEntity selectByActivityId(String activityId);

    /**
     * 查询活动卡片记录数
     *
     * @param queryparam 查询条件
     * @return
     */
    Integer count(ExActivityCardEntity queryparam);

    /**
     * 分页查询活动卡片信息
     *
     * @param entity     状态选择
     * @param orderField 排序规则
     * @param offset     分页起始位置
     * @param limit      每页记录数
     * @return
     */
    List<ExActivityCardEntity> selectPage(@Param("entity") ExActivityCardEntity entity, @Param("orderField") String orderField, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
