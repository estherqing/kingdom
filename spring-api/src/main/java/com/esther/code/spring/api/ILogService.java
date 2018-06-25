package com.esther.code.spring.api;

import com.esther.code.spring.model.Log;

/**
 * @author esther
 * 2018-06-20 14:52
 * $DESCRIPTION}
 */

public interface ILogService {
    Log getById(Integer id);
    String sayHello(String name);
}
