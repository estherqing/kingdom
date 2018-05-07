package com.esther.code.proxy.staticProxy;

import com.esther.code.proxy.ProxyType;
import com.esther.code.schema.api.proxy.IHello;
import com.esther.code.schema.service.proxy.Hello;
import com.esther.code.schema.service.proxy.staticProxy.StaticProxy;

/**
 * @author esther
 * 2018-04-25 16:25
 * 从静态代理中可以看出：
1.接口：代理类需要实现一个接口，这个接口和委托类的接口是一样的，这样proxy才能和委托类行为表现一致
2. 方法（Method）:由于接口限制，proxy类中也要有interface中的各个方法，这就造成了代码重复
 */

public class StaticProxyTest {
    public static void main(String[] args) {
        IHello iHello=new Hello();
        StaticProxy proxy=new StaticProxy(iHello);
        proxy.sayHello("esther");
        ProxyType.getProxyType(iHello);
    }
}
