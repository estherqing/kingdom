package com.vivo.jovi.scene.common.activity.rule;

import com.vivo.jovi.scene.common.model.SceneRequest;
import com.vivo.jovi.scene.common.model.SceneResponse;

import java.util.Map;

/**
 * @author Tian Guangxin
 * @date 2018/11/13
 * @since 1.0
 */
public interface Rule {

    boolean predicate(SceneRequest request, SceneResponse response);

    Rule and(Rule other);

    Rule or(Rule other);

    Rule negate();

    String getType();

    String getAttribute(String name);

    Map<String,String> getAttributeMap();

}
