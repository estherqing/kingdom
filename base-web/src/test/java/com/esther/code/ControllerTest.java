package com.esther.code;

import com.esther.code.util.HttpClientUtil;

/**
 * @author esther
 * 2018-04-19 11:26
 * $DESCRIPTION}
 */

public class ControllerTest {
    public static void main(String[] args) {
        testAllDictList();
    }
    private static void testAllDictList() {
        String url = "http://localhost:8086/kingdom/user/get?id=1";
         HttpClientUtil.sendPost(url, "");
    }
}
