package com.esther.code.annotation;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.*;

/**
 * @author esther
 * 2018-04-23 18:38
 * $DESCRIPTION}
 */
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target({ElementType.METHOD,ElementType.TYPE})//目标是方法
@Documented//文档生成时，该注解将被包含在javadoc中，可去掉
@Cacheable(value = "UserCache")
public @interface MyCacheable {
}
