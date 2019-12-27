package com.vivo.jovi.scene.common.activity.action;

import com.vivo.jovi.scene.common.activity.Activity;
import com.vivo.jovi.scene.common.model.SceneRequest;
import com.vivo.jovi.scene.common.model.SceneResponse;

/**
 * @author Tian Guangxin
 * @date 2018/11/13
 * @since 1.0
 */
public interface Action {

    String getType();

    void doAction(SceneRequest request, SceneResponse response, Activity activity);


}
