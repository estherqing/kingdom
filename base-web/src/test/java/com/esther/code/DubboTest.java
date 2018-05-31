package com.esther.code;

import com.alibaba.dubbo.rpc.RpcException;
import com.esther.code.api.IUserService;
import com.esther.code.api.dubbo.cache.CacheService;
import com.esther.code.api.dubbo.callback.CallbackListener;
import com.esther.code.api.dubbo.callback.CallbackService;
import com.esther.code.api.dubbo.eventnotify.Notify;
import com.esther.code.api.dubbo.merger.MergeService;
import com.esther.code.api.dubbo.validation.ValidationParameter;
import com.esther.code.api.dubbo.validation.ValidationService;
import com.esther.code.dubbo.eventnotify.NotifyImpl;
import com.esther.code.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author esther
 * 2018-05-29 15:42
 * $DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class DubboTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private MergeService mergeService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private CallbackService callbackService;

    @Autowired
    private NotifyImpl notify;

    @Test
    public void testCache() throws Exception {
        // 测试缓存生效，多次调用返回同样的结果。(服务器端自增长返回值)
        String fix = null;

        for (int i = 0; i < 5; i++) {

            String result = cacheService.findCache("0");
            if (fix == null || fix.equals(result)) {
                System.out.println("i=" + i + " OK: " + result);
            } else {
                System.err.println("i=" + i + " ERROR: " + result);
            }

            fix = result;
            Thread.sleep(500);
        }

        // LRU的缺省cache.size为1000，执行1001次，应有溢出
        for (int n = 0; n < 1001; n++) {
            String pre = null;
            for (int i = 0; i < 10; i++) {
                String result = cacheService.findCache(String.valueOf(n));
                if (pre != null && !pre.equals(result)) {
                    System.err.println("n=" + n + " ERROR: " + result);
                }
                pre = result;
            }
        }

        // 测试LRU有移除最开始的一个缓存项
        String result = cacheService.findCache("0");
        if (fix != null && !fix.equals(result)) {
            System.out.println("OK: " + result);
        } else {
            System.err.println("ERROR:" + result);
        }
    }

    @Test
    public void testMerge() {
        List<String> result = mergeService.mergeResult();
        System.out.println(result);
    }

    @Test
    public void testValidation() {
        // Save OK
        ValidationParameter parameter = new ValidationParameter();
        parameter.setName("liangfei");
        parameter.setEmail("liangfei@liang.fei");
        parameter.setAge(50);
        parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000));
        parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000));
        validationService.save(parameter);
        System.out.println("Validation Save OK");

        // Save Error
        try {
            parameter = new ValidationParameter();
            validationService.save(parameter);
            System.err.println("Validation Save ERROR");
        } catch (RpcException e) {// 抛出的是RpcException
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause();// 里面嵌了一个ConstraintViolationException
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();// 可以拿到一个验证错误详细信息的集合
            System.out.println(violations);
        }

        // Delete OK
        validationService.delete(2, "abc");
        System.out.println("Validation Delete OK");

        // Delete Error
        try {
            validationService.delete(0, "abc");
            System.err.println("Validation Delete ERROR");
        } catch (RpcException e) {
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause();
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
            System.out.println(violations);
        }

        // Update OK
        parameter = new ValidationParameter();
        parameter.setName("jack");
        parameter.setAge(20);
        validationService.update(parameter);
        System.out.println("Validation Update OK");
    }

    @Test
    public void testCallback() {
        callbackService.addListener("foo.bar", new CallbackListener() {
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
    }

    @Test
    public void testEventNotify() throws Exception {
        Integer requestId = 1;
        User ret = userService.selectByPrimaryKey(requestId);
        Assert.assertEquals(null, ret);
//for Test：只是用来说明callback正常被调用，业务具体实现自行决定.
        for (int i = 0; i < 10; i++) {
            if (!notify.ret.containsKey(requestId)) {
                Thread.sleep(200);
            } else {
                break;
            }
        }
        Assert.assertEquals(requestId, notify.ret.get(requestId).getId());
    }

}
