package com.esther.code.service.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author esther
 * 2018-04-25 16:24
 * Cglib的原理是对指定的目标类动态生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类和final方法进行代理。
 *
 * 拦截器：实现MethodInterceptor接口的类，在intercept方法中实现对代理目标类的方法拦截。
 * 但同时Cglib为简化和提高性能提供了一些专门的回调类型如FixedValue（可以在实现的方法loadObject中指定返回固定值，而不调用目标类函数）、
 * NoOp（把对回调方法的调用直接委派到这个方法的父类，即不进行拦截）
 */

public class CGLIBDynamicProxy implements MethodInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Enhancer enhancer = new Enhancer();

    //　要注意的是，target类是作为产生的代理的父类传进来的。不同于JDK的动态代理，它不能在创建代理时传target对象，target对象必须被CGLIB包来创建。
    public Object getProxy(Class targetClass) {
        enhancer.setSuperclass(targetClass); //① 设置需要创建子类的类
        // 设置单一回调对象，在回调中拦截对目标方法的调用
        enhancer.setCallback(this);
        return enhancer.create(); //②通过字节码技术动态创建子类实例

    }

    //③拦截父类所有方法的调用

    /**
     *  * 回调方法:在代理实例上拦截并处理目标方法的调用，返回结果
     *
     * @param obj 代理类
     * @param method 被代理的方法
     * @param args 该方法的参数数组
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());//③-1
        // 调用目标方法，用methodProxy,
        // 而不是原始的method，以提高性能
        Object result = proxy.invokeSuper(obj, args); //③-2  使用Cglib代理调用
        PerformanceMonitor.end();//③-1通过代理类调用父类中的方法
        return result;
    }
}
