package com.esther.code.spring.service.impl;

import com.esther.code.spring.api.ILogService;
import com.esther.code.spring.dao.LogMapper;
import com.esther.code.spring.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * 2018-06-20 14:52
 * $DESCRIPTION}
 */
@Component("logService")
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public Log getById(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
