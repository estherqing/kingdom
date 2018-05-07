package com.esther.code.schema.service.impl;

import com.esther.code.annotation.MyCacheable;
import com.esther.code.schema.api.IEhcacheService;
import com.esther.code.schema.api.IUserService;
import com.esther.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // 使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    // 每次都会执行方法，并将结果存入指定的缓存中
    @CachePut(value = "HelloWorldCache", key = "#key")
    @Override
    public String refreshData(String key) {
        System.out.println("模拟从数据库中加载数据");
        return key + "::" + String.valueOf(Math.round(Math.random() * 1000000));
    }

    // ------------------------------------------------------------------------

    /**
     * 没有定义key的话，使用xml文件中配置的CacheKeyGenerator
     * <p>
     * unless过滤方法返回值。unless为false时，缓存起来。当方法返回空值时，就不会被缓存起来。
     * condition：对传入的参数进行筛选. 触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL。
     * expire：过期时间，单位为秒。
     * beforeInvocation: 是否在方法执行前就清空，缺省为 false，缺省情况下，如果方法执行抛出异常，则不会清空缓存；如果指定为 true，则在方法还没有执行的时候就清空缓存，
     *
     * @param userId
     * @return
     */
    @Override
    @Cacheable(value = "userService", condition = "#userId<=2", unless = "#result==null")
    public User findUserById(Integer userId) {
        System.out.println("模拟从数据库中查询数据");
        return userService.selectByPrimaryKey(userId);
    }

    /**
     * condition：对传入的参数进行筛选. 触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL。
     * expire：过期时间，单位为秒。
     *
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
    //@CacheEvict(value = "userService", allEntries = true)
    @Caching(evict = {@CacheEvict(value = {"UserCache", "user", "userService", "HelloWorldCache"}, allEntries = true)})
    public void removeAllUser() {
        System.out.println("Cache delete all");
    }

    /**
     * 多个缓存组合的@Caching
     *
     * @param param
     * @return
     */
    @Override
    @Caching(evict = @CacheEvict(value = "UserCache", allEntries = true), cacheable = {@Cacheable("HelloWorldCache")})
    public String testCaching(String param) {
        System.out.println("UserCache delete all");
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

    /**
     * 自定义缓存MyCacheable
     *
     * @param userId
     * @return
     */
    @Override
    @MyCacheable
    public User get(Integer userId) {
        return userService.selectByPrimaryKey(userId);
    }

    @Override
    @Cacheable(value = "user", unless = "#result==null")
    public User testSecondCache(Integer userId) {
        System.out.println("模拟从数据库中查询数据");
        return userService.selectByPrimaryKey(userId);
    }

    @Override
    @Cacheable(value = "userService")
    public List<User> getUserList() {
        System.out.println("模拟从数据库中查询数据");
        return userService.selectByExample(null);
    }
}
