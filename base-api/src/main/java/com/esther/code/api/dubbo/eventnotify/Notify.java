package com.esther.code.api.dubbo.eventnotify;

import com.esther.code.model.User;

/**
 * @author esther
 * 2018-05-30 14:46
 * $DESCRIPTION}
 */

public interface Notify {
    public void onreturn(User msg, Integer id);
    public void onthrow(Throwable ex, Integer id);
}
