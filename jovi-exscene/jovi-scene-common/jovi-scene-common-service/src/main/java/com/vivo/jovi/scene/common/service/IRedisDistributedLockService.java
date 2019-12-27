package com.vivo.jovi.scene.common.service;

/**
 * @author huhan
 * @description 使用redis实现的简单分布式锁
 * @date 2019-08-06 17:24
 */
public interface IRedisDistributedLockService {

    /**
     * 加锁
     * PS：访问资源时注意控制时间，防止锁过期，其他客户端获取到锁后，并发访问资源
     *
     * @param uniqueLockKey
     *            每种资源的锁都需要有一个唯一标识key
     * @param uniqueClientFlag
     *            每个加锁的客户端都需要有一个唯一标识flag
     * @param expiredTime
     *            每个锁都需要有一个自动过期时间以保证活性（单位：毫秒）
     * @return
     */
    boolean tryLock(String uniqueLockKey, Object uniqueClientFlag, long expiredTime);

    /**
     * 解锁
     *
     * @param uniqueLockKey
     *            参考lock方法
     * @param uniqueClientFlag
     *            参考lock方法
     */
    void unlock(String uniqueLockKey, Object uniqueClientFlag);
}
