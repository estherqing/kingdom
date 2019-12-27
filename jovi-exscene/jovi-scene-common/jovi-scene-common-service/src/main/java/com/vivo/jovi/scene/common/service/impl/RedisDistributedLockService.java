package com.vivo.jovi.scene.common.service.impl;

import com.vivo.framework.redis.cluster.JedisClusterTemplate;
import com.vivo.jovi.scene.common.service.IRedisDistributedLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * @author huhan
 * @description
 * @date 2019-08-06 17:26
 */
public class RedisDistributedLockService implements IRedisDistributedLockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisDistributedLockService.class);

    @Autowired
    private JedisClusterTemplate jedisClusterTemplate;

    /**
     * redis请求成功返回值
     */
    private static final String SUCCESS = "OK";

    @Override
    public boolean tryLock(String uniqueLockKey, Object uniqueClientFlag, long expiredTime) {
        boolean lockResult = false;
        String result = jedisClusterTemplate.set(uniqueLockKey, uniqueClientFlag.toString(), "NX", "PX", expiredTime);
        LOGGER.debug("result:{}", result);
        if (SUCCESS.equals(result)) {
            lockResult = true;
        }
        return lockResult;
    }

    /**
     * 解锁
     *
     * @param uniqueLockKey    参考lock方法
     * @param uniqueClientFlag
     */
    @Override
    public void unlock(String uniqueLockKey, Object uniqueClientFlag) {
        String luaScript = "if redis.call(\"get\", KEYS[1]) == ARGV[1] then return redis.call(\"del\", KEYS[1]) else return 0 end";
        Object unlockResult = jedisClusterTemplate.eval(luaScript, Collections.singletonList(uniqueLockKey),
                Collections.singletonList(uniqueClientFlag.toString()));
        LOGGER.debug("unlockResult:{}", unlockResult);
    }
}
