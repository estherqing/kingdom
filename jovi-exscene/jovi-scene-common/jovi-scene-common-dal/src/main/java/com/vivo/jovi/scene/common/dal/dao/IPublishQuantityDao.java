package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.PublishQuantityEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPublishQuantityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PublishQuantityEntity record);

    int insertSelective(PublishQuantityEntity record);

    PublishQuantityEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PublishQuantityEntity record);

    int updateByPrimaryKey(PublishQuantityEntity record);

    PublishQuantityEntity getBiz(@Param("bizId")String bizId, @Param("version")Integer version);


    List<PublishQuantityEntity> findAll();

    void batchUpdate(List<PublishQuantityEntity> updatedQuantity);

    /**
     * 批量插入
     * @param quantities 发布量列表
     */
    void batchInsert(List<PublishQuantityEntity> quantities);
}