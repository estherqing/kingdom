package com.esther.code.base;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author esther
 * 2018-07-17 18:55
 * $DESCRIPTION}
 */

public class MapTest {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap();
        ConcurrentHashMap cmap = new ConcurrentHashMap();
        System.out.println(Integer.parseInt("0001111", 2) & 15);
        System.out.println(Integer.parseInt("0011111", 2) & 15);
        System.out.println(Integer.parseInt("0111111", 2) & 15);
        System.out.println(Integer.parseInt("1111111", 2) & 15);
    }
}
