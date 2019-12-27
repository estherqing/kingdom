package com.vivo.jovi.scene.common.support;

/**
 * 可配置的对象抽象接口
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public interface Configurable<C> {

    /**
     * 获取配置的class对象
     * @return
     */
    Class<C> getConfigClass();

    /**
     * 实例化一个配置对象
     * @return
     */
    C newConfig(String json);
}
