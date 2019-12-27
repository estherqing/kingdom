package com.vivo.jovi.scene.common.activity.action;

/**
 * @author Tian Guangxin
 * @date 2018/11/21
 * @since 1.0
 */
public abstract class AbstractAction implements Action {

    @Override
    public String getType() {
        return ActionTypeRepository.getType(getClass());
    }


}
