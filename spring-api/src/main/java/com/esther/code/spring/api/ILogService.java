package com.esther.code.spring.api;

import com.esther.code.spring.model.Log;

/**
 * @author esther
 * 2018-06-20 14:52
 * $DESCRIPTION}
 */

public interface ILogService {
    void save(Log log);

    Log getById(Integer id);

    String sayHello(String name);

    // 测试内部调用
    String parent(String name);

    String child(String name);
}
