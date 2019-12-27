package com.vivo.jovi.scene.common.activity.action;

import com.vivo.jovi.scene.common.support.Configurable;

/**
 * 构造Action的工厂类
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public interface ActionFactory<C> extends Configurable<C> {

    /**
     * 获取
     * @return
     */
    String getSupportedType();
    
    Action apply(C config); 
    
}
