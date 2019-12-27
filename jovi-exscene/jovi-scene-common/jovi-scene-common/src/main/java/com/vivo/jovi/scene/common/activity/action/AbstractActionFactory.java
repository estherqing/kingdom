package com.vivo.jovi.scene.common.activity.action;

import com.vivo.jovi.scene.common.support.AbstractConfigurable;

/**
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public abstract class AbstractActionFactory<C> extends AbstractConfigurable<C> implements ActionFactory<C> {

    protected AbstractActionFactory(Class<C> configClass) {
        super(configClass);
    }


}
