package com.esther.code.api.schema.service.proxy.dynamicProxy.cglib;

/**
 * @author esther
 * 2017-12-19 14:45
 * $DESCRIPTION}
 */

public class PerformanceMonitor {
    //①通过一个ThreadLocal保存调用线程相关的性能监视信息
    private static ThreadLocal<MethodPerformance> performanceRecord =
            new ThreadLocal<MethodPerformance>();

    //②启动对某一目标方法的性能监视
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }
    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();

        //③打印出方法性能监视的结果信息。
        mp.printPerformance();
    }

   static class MethodPerformance {
        private long begin;
        private long end;
        private String serviceMethod;
        public MethodPerformance(String serviceMethod){
            this.serviceMethod = serviceMethod;

            //①记录目标类方法开始执行点的系统时间
            this.begin = System.currentTimeMillis();

        }
        public void printPerformance(){

            //②获取目标类方法执行完成后的系统时间，并进而计算出目标类方法执行时间
            end = System.currentTimeMillis();
            long elapse = end - begin;

            //③报告目标类方法的执行时间
            System.out.println(serviceMethod+"花费"+elapse+"毫秒。");
        }
    }

}