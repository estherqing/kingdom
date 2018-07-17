package com.esther.code.modules.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author esther
 * 2018-04-10 20:52
 * $DESCRIPTION}
 */

public class RedisCacheTransfer {
    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
