package com.vivo.jovi.scene.common.activity.rule;

import com.vivo.jovi.scene.common.support.AbstractConfigurable;

/**
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public abstract class AbstractRuleFactory<C> extends AbstractConfigurable<C> implements RuleFactory<C> {


    protected AbstractRuleFactory(Class<C> configClass) {
        super(configClass);
    }


}
