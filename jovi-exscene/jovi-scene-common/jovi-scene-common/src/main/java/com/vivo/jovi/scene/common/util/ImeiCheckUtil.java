package com.vivo.jovi.scene.common.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImeiCheckUtil {
    /**
     * 验证imei合法性,
     * 校验了15位格式的合法性
     * 14位校验是否存在非数字字母
     * 其他长度直接被认为非法
     *
     * @param imei
     * @return
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ImeiCheckUtil.class);
    public static Boolean isLegalImei(String imei) {
        try {
            if (StringUtils.isBlank(imei)) {
                LOGGER.error("ImeiCheckUtil with imei being null");
            }
            if ("012345678987654".equals(imei.toLowerCase()) || "123456789012345".equals(imei.toLowerCase()) || "865407010000009".equals(imei.toLowerCase())) {
                LOGGER.error("ImeiCheckUtil with invalid imei");
            }
            char[] imeiChar = imei.toCharArray();
            if (imeiChar.length == 15) {
                int resultInt = 0;
                for (int i = 0; i < 14; i++) {
                    int a = Integer.parseInt(String.valueOf(imeiChar[i]));
                    i++;
                    final int temp = Integer.parseInt(String.valueOf(imeiChar[i])) * 2;
                    final int b = temp < 10 ? temp : temp - 9;
                    resultInt += a + b;
                }
                resultInt %= 10;
                resultInt = resultInt == 0 ? 0 : 10 - resultInt;
                int check = Integer.parseInt(String.valueOf(imeiChar[14]));
                return resultInt == check;
            } else if (imeiChar.length == 14) {// 电信手机没有校验位无法校验
                return imei.matches("^[0-9a-fA-F]{14}$");
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ImeiCheckUtil.isLegalImei("869238031190594"));
    }
}
