package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.PublishGrayImeiEntity;
import org.apache.ibatis.annotations.Param;

public interface IPublishGrayImeiDao {

    int insert(PublishGrayImeiEntity entity);

    PublishGrayImeiEntity getPublishGrayImei(@Param("strategyId") String strategyId, @Param("imei") String imei);
}
