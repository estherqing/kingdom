package com.vivo.jovi.exscene.api.service.recognition;

import java.util.Map;

/**
 * @author Tian Guangxin
 * @date 2018/11/19
 * @since 1.0
 */
public interface Predicate {

    boolean apply(Map<String,String> attribute);
}
