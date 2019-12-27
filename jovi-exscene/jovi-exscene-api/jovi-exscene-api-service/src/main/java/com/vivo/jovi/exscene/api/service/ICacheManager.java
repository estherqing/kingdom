package com.vivo.jovi.exscene.api.service;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-20
 */
public interface ICacheManager {

    /**
     * 实现调研卡片实际发布量统计
     * @param bizId 调研卡片的id
     */
    void addQNRPublishQuantity(String bizId);

    /**
     * 获取调研卡片的已发布量
     * @param bizId
     * @return
     */
    Integer getQNRPublishQuatity(String bizId);
}
