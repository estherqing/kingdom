package com.esther.code.util;

/**
 * Created by gaowenlin on 2015/11/28.
 */
public class CodeTransUtils {

    /**
     * 获取贷款期限
     *
     * @param loanTermKey
     * @return
     */
    public static Integer getLoanTerm(Integer loanTermKey) throws IllegalArgumentException {
        Integer loanTermValue = null;
        switch (loanTermKey) {
            case 1:
                loanTermValue = 12;
                break;
            case 2:
                loanTermValue = 18;
                break;
            case 3:
                loanTermValue = 24;
                break;
            case 4:
                loanTermValue = 36;
                break;
            case 5:
                loanTermValue = 48;
                break;
            default:
                throw new IllegalArgumentException("贷款期限选择异常");
        }
        return loanTermValue;
    }
}
