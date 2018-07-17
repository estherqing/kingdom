package com.esther.code.modules.test;


import com.esther.code.common.utils.HttpClientUtil;

/**
 * 字典测试
 */
public class DictTest {
    public static void main(String[] args) {
       // testAllDictList();
        testDictListByDictType();
    }

    @SuppressWarnings("unused")
    private static void testAllDictList() {
        String url = "http://localhost:8080/springTest/dict/list/all";       
        HttpClientUtil.sendPost(url, "");
    }
    
    private static void testDictListByDictType() {
        String url = "http://localhost:8080/springTest/dict/list/some?dictType=1";
        HttpClientUtil.sendHttpsGet(url);
    }
}
