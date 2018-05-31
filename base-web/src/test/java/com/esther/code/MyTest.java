package com.esther.code;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.esther.code.api.IDemoService;
import com.esther.code.api.IDictService;
import com.esther.code.api.IUserService;
import com.esther.code.model.Dict;
import com.esther.code.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author esther
 * 2018-05-28 15:13
 * $DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MyTest {

    @Autowired
    private IDemoService demoService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDictService dictService;


    @Test
    public void testDemo() {
        String hello = demoService.sayHello("world"); // call remote method
        System.out.println(hello); // get result
    }

    @Test
    // 回声测试
    public void testHS() {
     /*   回声测试用于检测服务是否可用，回声测试按照正常请求流程执行，能够测试整个调用是否通畅，可用于监控。
        所有服务自动实现 EchoService 接口，只需将任意服务引用强制转型为 EchoService，即可使用。*/

        // 回声测试
        EchoService echoService = (EchoService) demoService; // 强制转型为EchoService
        // 回声测试可用性
        String status = echoService.$echo("OK").toString();
        assert (status.equals("OK"));
    }

    @Test
    public void testRpcContext() {
        RpcContext.getContext().setAttachment("index", "1"); // 隐式传参，后面的远程调用都会隐式将这些参数发送到服务器端，类似cookie，用于框架集成，不建议常规业务使用
        demoService.rpcContext();
        // 本端是否为消费端，这里会返回true
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
// 获取最后一次调用的提供方IP地址
        String serverIP = RpcContext.getContext().getRemoteHost();
// 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] isConsumerSide=" + isConsumerSide + ",serverIp=" + serverIP + ",application=" + application);

// 注意：每发起RPC调用，上下文状态会变化
        userService.selectByPrimaryKey(1);
        isConsumerSide = RpcContext.getContext().isConsumerSide();
        System.out.println("isConsumerSide=" + isConsumerSide);
    }

    @Test
    public void testNIO() throws Exception {
       /* User user = userService.selectByPrimaryKey(1);
        Dict dict = dictService.selectByPrimaryKey(1);
        System.out.println(user);
        System.out.println(dict);*/

        // 此调用会立即返回null
        userService.selectByPrimaryKey(1);
// 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        Future<User> future = RpcContext.getContext().getFuture();

// 此调用会立即返回null
        dictService.selectByPrimaryKey(1);
// 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        Future<Dict> dictFuture = RpcContext.getContext().getFuture();

// 此时findFoo和findBar的请求同时在执行，客户端不需要启动多线程来支持并行，而是借助NIO的非阻塞完成

// 如果foo已返回，直接拿到返回值，否则线程wait住，等待foo返回后，线程会被notify唤醒
        User userV = future.get();
// 同理等待bar返回
        Dict dictV = dictFuture.get();

// 如果foo需要5秒返回，bar需要6秒返回，实际只需等6秒，即可获取到foo和bar，进行接下来的处理。
        System.out.println(userV);
        System.out.println(dictV);

        //获取线程数
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        int totalThread = threadGroup.activeCount();
        System.out.println(totalThread);
    }

}
