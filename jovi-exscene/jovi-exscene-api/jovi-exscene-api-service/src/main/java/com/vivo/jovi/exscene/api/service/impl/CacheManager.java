package com.vivo.jovi.exscene.api.service.impl;

import com.vivo.framework.redis.cluster.JedisClusterTemplate;
import com.vivo.jovi.exscene.api.service.ICacheManager;
import com.vivo.jovi.scene.common.util.CacheUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author David
 * @version 3.0
 * @date 2019-02-20
 */
@Service
public class CacheManager implements ICacheManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(CacheManager.class);

    @Autowired
    private JedisClusterTemplate jedisClusterTemplate;

    @Override
    public void addQNRPublishQuantity(String bizId) {
        String key = CacheUtil.getQNRPublishQuantityKey(bizId);
        jedisClusterTemplate.incr(key);
    }

    @Override
    public Integer getQNRPublishQuatity(String bizId) {
        String key = CacheUtil.getQNRPublishQuantityKey(bizId);
        String publishQuantity = jedisClusterTemplate.get(key);
        if(StringUtils.isBlank(publishQuantity)){
            return 0;
        }
        return Integer.valueOf(publishQuantity);
    }
}
