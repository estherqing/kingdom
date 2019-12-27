package com.vivo.jovi.scene.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David
 * @version 3.0
 * @describe 日志计时器
 * @date 2019-05-07
 */

public class TimeLogger {

    private static Logger logger = LoggerFactory.getLogger(TimeLogger.class);
    private static ThreadLocal<Long> startTimeStamp = new ThreadLocal<>();
    private static ThreadLocal<Long> lastTimeStamp = new ThreadLocal<>();
    private static ThreadLocal<String> name = new ThreadLocal<>();

    /**
     * 开始计时
     * @param reqName 请求名称
     */
    public static void start(String reqName){
        try {
            name.set(reqName);
            startTimeStamp.set(System.currentTimeMillis());
            lastTimeStamp.set(System.currentTimeMillis());
            logger.info("Thread_{},{} timer starts at {}", Thread.currentThread().getId(),name.get(),startTimeStamp.get());
        }catch (Exception e){
            logger.error("timer error",e);
        }
    }

    /**
     * 记时并输出日志：自上次计时到当前的时间
     * @param content 日志内容
     */
    public static void mark(String content){
        try {
            if(lastTimeStamp.get()!=null) {
                Long timeElapse = System.currentTimeMillis() - lastTimeStamp.get();
                logger.info("Thread_{},{},{} time elapse {}ms", Thread.currentThread().getId(), name.get(), content, timeElapse);
                lastTimeStamp.set(System.currentTimeMillis());
            }
        }catch (Exception e){
            logger.error("timer error",e);
        }
    }

    /**
     * 记时并输出日志：自开始计时到当前的时间
     * @param content 日志内容
     */
    public static void markStart(String content){
        try {
            if(startTimeStamp.get()!=null) {
                Long timeElapse = System.currentTimeMillis() - startTimeStamp.get();
                logger.info("Thread_{},{},{} time elapse since start {}ms", Thread.currentThread().getId(), name.get(), content, timeElapse);
            }
        }catch (Exception e){
            logger.error("timer error",e);
        }
    }

}
