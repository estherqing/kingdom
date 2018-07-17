package com.esther.code.modules.service;


import com.esther.code.modules.entity.User;
import com.esther.code.modules.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esther
 * 2018-03-30 15:20
 * $DESCRIPTION}
 */
@Service
public class UserService {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /**
     * 预期效果：
     * 1.child回滚
     * 2.parent插入成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void parent() throws Exception {
        try {
//            必须要获取当前AopProxy，然后通过AOP、代理来调用child方法。否则是当前对象执行child方法，则其上的注解不起作用
//            <!-- 启用CGliB(code generation library), expose-proxy="true"暴露AOP到ThreadLocal，默认为false -->
//	          <aop:aspectj-autoproxyexpose-proxy="true" />
            ((UserService) AopContext.currentProxy()).child();
            // child();
        } catch (Exception e) {
            logger.error("父类捕获了子类的异常。。。");
        }
        System.out.println(this);
        System.out.println("是否是代理调用，AopUtils.isAopProxy(baseServiceb) : " + AopUtils.isAopProxy(this));
        System.out
                .println("是否是cglib类代理调用，AopUtils.isCglibProxy(baseServiceb) : " + AopUtils.isCglibProxy(this));
        System.out.println("是否是jdk动态接口代理调用，AopUtils.isJdkDynamicProxy(baseServiceb) : "
                + AopUtils.isJdkDynamicProxy(this));

        User user = new User("jack parent", "123456", "jack parent", "America", "male", 20);
        userMapper.insert(user);
        int e = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child() {
        User user = new User("jack child", "123456", "jack child", "America", "male", 20);
        userMapper.insert(user);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User getTwo(Integer id){
        User user=userMapper.selectByPrimaryKey(id);
        return userMapper.selectByPrimaryKey(id);
    }
}
