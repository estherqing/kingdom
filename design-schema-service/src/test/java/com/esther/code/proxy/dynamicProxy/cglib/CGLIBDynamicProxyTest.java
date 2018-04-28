package com.esther.code.proxy.dynamicProxy.cglib;

import com.esther.code.service.proxy.dynamicProxy.cglib.CGLIBDynamicProxy;
import com.esther.code.service.proxy.dynamicProxy.cglib.Hello;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author esther
 * 2018-04-25 16:24
 * $DESCRIPTION}
 */

public class CGLIBDynamicProxyTest {
    public static void main(String[] args) {
        CGLIBDynamicProxy proxy=new CGLIBDynamicProxy();
        Hello hello=(Hello)proxy.getProxy(Hello.class);
        hello.sayHello("esther");
        System.out.println("我们得到的bean是：" + hello.getClass());
        System.out.println("实际调用者的父类：" + hello.getClass().getSuperclass());

        try {
            Class<?> c = Class.forName("com.esther.code.service.proxy.dynamicProxy.cglib.Hello$$EnhancerByCGLIB$$ae8cd9e3");
            Class<?> beanc = Class.forName("com.esther.code.service.proxy.dynamicProxy.cglib.Hello");

            Method[] beanc_method = beanc.getMethods();
            int i = 1;
            System.out.println("原始的bean的方法总共" + beanc_method.length + "个");
            for (Method method : beanc_method) {
                System.out.println("原始的bean方法" + i++ + method.getName());
            }
            i = 1;
            Method[] methods = c.getMethods();
            System.out.println("我们得到的bean的方法总共" + methods.length + "个");
            for (Method method : methods) {
                System.out.println("我们得到的bean的方法" + i++ + method.getName());
            }
            System.out.println("原始的bean的父类：" + beanc.getSuperclass());
            System.out.println("我们得到的bean的父类：" + c.getSuperclass());

            Field[] bean_fields = beanc.getDeclaredFields();
            i = 1;
            for (Field field : bean_fields) {
                System.out.println("原始bean的属性 " + i++ + field);
            }

            Field[] fields = c.getDeclaredFields();
            i = 1;
            for (Field field : fields) {
                System.out.println("我们得到的bean的属性 " + i++ + field);
            }

            Class proxyGenerator = Class.forName("sun.misc.ProxyGenerator");
            Method[] methods2 = proxyGenerator.getMethods();
            for (Method method : methods2) {
                System.out.println(method);
                byte[] TempProxySuper = (byte[]) method.invoke(proxyGenerator, "TempProxySuper", new Class[]{c.getSuperclass()});
                byte[] TempProxy = (byte[]) method.invoke(proxyGenerator, "TempProxy", new Class[]{c});
                byte[] TempBean = (byte[]) method.invoke(proxyGenerator, "TempBean", new Class[]{beanc});
                createClassFile("TempProxy", TempProxy);
                createClassFile("TempProxySuper", TempProxySuper);
                createClassFile("TempBean", TempBean);
                break;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 生成class文件
     * @param fileName
     * @param classFile
     */
    public static void createClassFile(String fileName,byte[] classFile) {
        try {
            File file = new File( fileName+".class");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(classFile);
            fos.flush();
            fos.close();
            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
