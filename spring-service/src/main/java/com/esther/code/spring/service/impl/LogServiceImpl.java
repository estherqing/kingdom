package com.esther.code.spring.service.impl;

import com.esther.code.spring.api.ILogService;
import com.esther.code.spring.dao.LogMapper;
import com.esther.code.spring.model.Log;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esther
 * 2018-06-20 14:52
 * $DESCRIPTION}
 */
@Component("logService")
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogMapper logMapper;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void save(Log log){
        logMapper.insertSelective(log);
       // throw new Exception();
    }

    @Override
    public Log getById(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    /**
     * 问题：目标对象内部的自我调用无法实施切面中的增强
     * 解决：expose-proxy="true"
     *
     * @param name
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public String parent(String name) {
//        child(name+"000");
//            必须要获取当前AopProxy，然后通过AOP、代理来调用child方法。否则是当前对象执行child方法，则其上的注解不起作用
//            <!-- 启用CGliB(code generation library), expose-proxy="true"暴露AOP到ThreadLocal，默认为false -->
//	          <aop:aspectj-autoproxy expose-proxy="true" />
        ((ILogService) (AopContext.currentProxy())).child("name");
        return "parent: " + name;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public String child(String name) {
        return "child: " + name;
    }
}
