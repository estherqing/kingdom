package com.vivo.jovi.scene.common.util;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-22
 */
public class BackgroundUtil {



    public static long getBackgroundIdLong(String id){
        return Long.valueOf(id.substring(3));
    }

    public static long getRandomTime(Long period) {
        return (long)(Math.random() * period);
    }

    public static void main(String[] args){
        System.out.print(getRandomTime(12L));

    }
}
