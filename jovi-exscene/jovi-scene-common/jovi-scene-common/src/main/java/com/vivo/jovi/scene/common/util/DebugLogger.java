package com.vivo.jovi.scene.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David
 * @version 3.0
 * @describe 日志计时器
 * @date 2019-05-07
 */

public class DebugLogger {

    private static Logger logger = LoggerFactory.getLogger(DebugLogger.class);
    private static ThreadLocal<List<String>> logText = new ThreadLocal<>();
    private static ThreadLocal<Boolean> debugActivated = new ThreadLocal<>();

    public static void activate(){
        try {
            debugActivated.set(true);
        }catch (Exception e){
            logger.error("日志错误"+e.getMessage(),e);
        }
    }


    public static void deactivate() {
        try {
            debugActivated.set(false);
        }catch (Exception e){
            logger.error("日志错误"+e.getMessage(),e);
        }
    }

    /**
     * 开始计时
     * @param text 日志内容
     */
    public static void add(String text){
        try {
            if(debugActivated.get()) {
                List<String> textlist = logText.get();
                if (textlist == null) {
                    textlist = new ArrayList<>();
                }
                textlist.add(text);
                logText.set(textlist);
            }
        }catch (Exception e){
            logger.error("日志错误"+e.getMessage(),e);
        }
    }

    /**
     * 开始计时
     */
    public static List<String> get(){
        try {
            if(debugActivated.get()) {
                return logText.get();
            }
        }catch (Exception e){
            logger.info("日志错误"+e.getMessage(),e);
        }
        return null;
    }

}
