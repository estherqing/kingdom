package com.esther.code.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.esther.code.api.IDemoService;
import com.esther.code.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("demoService")
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private IUserService userService;

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }

    @Override
    public void rpcContext() {
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");

        // 获取客户端隐式传入的参数，用于框架集成，不建议常规业务使用
        String index = RpcContext.getContext().getAttachment("index");
        System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] isProviderSide=" + isProviderSide + ",clientIp=" + clientIP + ",application=" + application+",隐式参数index="+index);

        // 注意：每发起RPC调用，上下文状态会变化
        userService.selectByPrimaryKey(1);
        //  此时本端变成消费端，这里会返回false
        isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("调用userService之后，isProviderSide=" + isProviderSide);
    }
}