package com.esther.code;


import com.esther.code.util.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author esther
 * 2018-04-19 11:26
 * $DESCRIPTION}
 */

public class ControllerTest {
    public static void main(String[] args) throws Exception {
//        testGetUser();
//        testFlow();
        pressTest();
    }

    private static void testFlow() throws Exception {
        String url = "http://localhost:8086/kingdom/flow/submit2next";
        Map<String, String> params = new HashMap<>();
        params.put("boId", "1");
        params.put("nextNodeUserId", "2");
        params.put("nextNodeUserName", "rose");
        HttpClientUtil.sendPost(url, params);
    }

    private static void testGetUser() throws Exception {
        String url = "http://localhost:8086/kingdom/user/get";
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        HttpClientUtil.sendPost(url, params);
    }

    public static void pressTest() throws Exception {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        long startStamp = System.currentTimeMillis();
        AtomicInteger index = new AtomicInteger(0);
        for (int i = 0; i < 1; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    int uuid = (int) (Math.random() * 100);
                    String url = "http://localhost:8080/jovi-exscene-api-web/exscene/activity/card/query";
                    Map<String, String> params = new HashMap<>();
                    params.put("lastQueryTime", "");
                    params.put("appVersion", "3710");
                    params.put("language", "all");
                    params.put("model", "vivo1851");
                    params.put("pd", "PD1730DF_EX");
                    params.put("role", "0");
                    params.put("sysVersion", "PD1730DF_EX_A_6.10.3");
                    params.put("userId", "0B50D9E52910B98555565317D0A17AE54AB501502ACC6B2FDA9C843020396F451578385454545");
                    try {
                        HttpClientUtil.sendPost(url, params);
                    } catch (Exception e) {
                    }
                    index.incrementAndGet();
                }
            });
        }
        while (index.get() < 1) {
            Thread.currentThread();
            Thread.sleep(100);
        }
        System.out.println(System.currentTimeMillis() - startStamp);
        System.out.println("end.......");

    }


}
