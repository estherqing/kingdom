package com.esther.code.api;

import com.esther.code.model.User;

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
}
