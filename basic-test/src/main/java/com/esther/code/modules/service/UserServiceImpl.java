package com.esther.code.modules.service;


import com.esther.code.modules.entity.User;
import com.esther.code.modules.mapper.UserMapper;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esther
 * 2018-04-02 15:57
 * $DESCRIPTION}
 */
@Service("userServiceA")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService2 userServiceB;

    /*
    * 注意：在上面的实例中，我没有把insertB()方法放在类UserServiceImpl，而是放在UserServiceImpl2中，
    * 这是因为spring通过扫描所有含有注解的@Trasational的方法，使用aop形成事务增强advise。
    * 但是加入增强时是通过代理对象调用方法的形式加入的，如果将insertB()方法放在insert()方法直接调用时，
    * 在调用insertB()方法的时候是通过当前对象来调用insertB()方法的，而不是通过代理来调用的insertB()方法，
    * 这个时候insertB()方法上加的事务注解就失效了不起作用。在Spring事务传播行为在内部方法不起作用讲到。
    * */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Override
    public int insert(User user) {
        userMapper.insert(user);
        System.out.println(userServiceB);

        System.out.println("是否是代理调用，AopUtils.isAopProxy(baseServiceb) : " + AopUtils.isAopProxy(userServiceB));
        System.out
                .println("是否是cglib类代理调用，AopUtils.isCglibProxy(baseServiceb) : " + AopUtils.isCglibProxy(userServiceB));
        System.out.println("是否是jdk动态接口代理调用，AopUtils.isJdkDynamicProxy(baseServiceb) : "
                + AopUtils.isJdkDynamicProxy(userServiceB));

        user.setUserName(user.getUserName() + "2");
        userServiceB.insertB(user);
        int i = 1 / 0;
        return 1;
    }
}
