package com.esther.code.schema.api;

import com.esther.code.model.User;

import java.util.List;

/**
 * @author esther
 * 2018-04-23 10:58
 * $DESCRIPTION}
 */

public interface IEhcacheService {

    // 测试失效情况，有效期为5秒
    public String getTimestamp(String param);

    public String getDataFromDB(String key);

    public void removeDataAtDB(String key);

    public String refreshData(String key);


    public User findUserById(Integer userId);

    public boolean isReserved(Integer userId);

    public void removeUser(Integer userId);

    public void removeAllUser();

    // @Caching注解实现
    public String testCaching(String param);

    // 自定义注解实现
    User get(Integer userId);

    // 测试二级缓存，一级为ehcache，二级为redis
    User testSecondCache(Integer userId);

    List<User> getUserList();
}
