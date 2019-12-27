package com.vivo.jovi.scene.common.activity.rule;

import com.vivo.jovi.scene.common.support.Configurable;

/**
 * 构造Rule的工厂类
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public interface RuleFactory<C> extends Configurable<C> {

    /**
     * 获取支持构造的rule类全限定名
     * @return
     */
    String getSupportedType();

    Rule apply(C config);

}
