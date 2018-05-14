package com.esther.code;

import com.esther.code.util.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author esther
 * 2018-04-19 11:26
 * $DESCRIPTION}
 */

public class ControllerTest {
    public static void main(String[] args) throws Exception {
        testAllDictList();
    }

    private static void testAllDictList() throws Exception{
        String url = "http://localhost:8086/kingdom/flow/submit2next";//"http://localhost:8086/kingdom/user/get?id=1";
       Map<String,String> params =new HashMap<>();
       params.put("boId","1");
       params.put("nextNodeUserId","2");
       params.put("nextNodeUserName","rose");
        HttpClientUtil.sendPost(url, params);
    }


}
