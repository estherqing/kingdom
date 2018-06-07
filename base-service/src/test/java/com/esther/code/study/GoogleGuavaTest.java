package com.esther.code.study;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * @author esther
 * 2018-06-06 15:58
 * $DESCRIPTION}
 */

public class GoogleGuavaTest {
    // 连接器
    private static final Joiner joiner = Joiner.on(",").useForNull("rose");  //.skipNulls(
    // 分割器
    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    private static final CharMatcher charMatcherDigit = CharMatcher.DIGIT;
    private static final CharMatcher charMatcherAny = CharMatcher.ANY;


    public static void main(String[] args) {
        String str = joiner.join(Lists.newArrayList("a", null, "b", ""));
        System.out.println(str);
        for (String tmp : splitter.split("a, ,b,null,,")) {
            System.out.println(tmp);
        }

        // 只保留匹配的字符
        System.out.println(charMatcherDigit.retainFrom("asdfg4657~-"));
        // 移除匹配的字符
        System.out.println(charMatcherDigit.removeFrom("yes,i love you!666"));
        System.out.println(charMatcherAny.replaceFrom("hello world", "*"));
    }
}
