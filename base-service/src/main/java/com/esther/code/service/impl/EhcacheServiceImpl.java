package com.esther.code.service.impl;

import com.esther.code.api.IEhcacheService;
import com.esther.code.api.IUserService;
import com.esther.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author esther
 * 2018-04-23 10:59
 * ehcache与spring注解实现
 */
@Service("ehcacheService")
public class EhcacheServiceImpl implements IEhcacheService {

    @Autowired
    private IUserService userService;

    // value的值和ehcache.xml中的配置保持一致
    @Cacheable(value = "HelloWorldCache", key = "#param")
    @Override
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

    @Cacheable(value = "HelloWorldCache", key = "#key")
    @Override
    public String getDataFromDB(String key) {
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random() * 1000000));
    }

    @CacheEvict(value = "HelloWorldCache", key = "#key")
    @Override
    public void removeDataAtDB(String key) {
        System.out.println("从数据库中删除数据");
    }

    @CachePut(value = "HelloWorldCache", key = "#key")
    @Override
    public String refreshData(String key) {
        System.out.println("模拟从数据库中加载数据");
        return key;
        //  return key + "::" + String.valueOf(Math.round(Math.random()*1000000));
    }

    // ------------------------------------------------------------------------

    /**
     * unless过滤方法返回值。当方法返回空值时，就不会被缓存起来
     * condition：对传入的参数进行筛选. 触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL。
     * expire：过期时间，单位为秒。
     * @param userId
     * @return
     */
    @Override
    @Cacheable(value = "UserCache", key = "'user:' + #userId", condition = "#userId<=2", unless = "#result==null")
    public User findUserById(Integer userId) {
        System.out.println("模拟从数据库中查询数据");


        System.out.println("UserCache:" + userId);
        return userService.selectByPrimaryKey(userId);
    }

    /**
     * condition：对传入的参数进行筛选. 触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL。
     * expire：过期时间，单位为秒。
     * @param userId
     * @return
     */
    @Override
    @Cacheable(value = "UserCache", condition = "#userId<=2")
    public boolean isReserved(Integer userId) {
        System.out.println("UserCache:" + userId);
        return false;
    }

    //清除掉UserCache中某个指定key的缓存
    @Override
    @CacheEvict(value = "UserCache", key = "'user:' + #userId")
    public void removeUser(Integer userId) {
        System.out.println("UserCache remove:" + userId);
    }

    //清除掉UserCache中全部的缓存
    @Override
    @CacheEvict(value = "UserCache", allEntries = true)
    public void removeAllUser() {
        System.out.println("UserCache delete all");
    }
}
