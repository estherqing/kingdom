package com.vivo.jovi.scene.common.support;


import org.springframework.beans.BeanUtils;

/**
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public abstract class AbstractConfigurable<C> implements Configurable<C> {

    private Class<C> configClass;

    protected AbstractConfigurable(Class<C> configClass){
        this.configClass = configClass;
    }

    @Override
    public Class<C> getConfigClass() {
        return configClass;
    }

    @Override
    public C newConfig(String json) {
        return BeanUtils.instantiateClass(this.configClass);
    }


}
