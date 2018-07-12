package com.esther.code.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author esther
 * 2018-07-11 15:33
 * $DESCRIPTION}
 */

public class Test {
    public static void main(String[] args) {
        Map map = new HashMap();
        Map<String, String> ms = new HashMap<>();
        ms.put("name","jack");
        System.out.println(map.getClass() + ", " + ms.getClass());
    }
}
