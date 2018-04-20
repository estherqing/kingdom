package com.esther.code.util;

/**
 * Created by hank on 17-6-8.
 */
public class ByteUtils {
    /**
     * @param strs 字符串数组
     * @return 返回byte数组
     */
    public static byte[] arrStrToByte(String[] strs) {
        byte[] b = new byte[strs.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Byte.parseByte(strs[i]);
        }
        return b;
    }
}
