package com.esther.code.java.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author esther
 * 2018-07-19 20:48
 * 常量池溢出
 */
public class ConstantOutOfMemory {
    public static void main(String[] args) throws Exception {

        try {
            List<String> strings = new ArrayList<String>();
            int i = 0;
            while (true) {
                strings.add(String.valueOf(i++).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
