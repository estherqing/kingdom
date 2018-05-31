package com.esther.code.dubbo.eventnotify;

import com.esther.code.api.dubbo.eventnotify.Notify;
import com.esther.code.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author esther
 * 2018-05-30 15:04
 * $DESCRIPTION}
 */

public class NotifyImpl implements Notify {

    public  Map<Integer, User> ret = new HashMap<Integer, User>();
    public  Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();

    @Override
    public void onreturn(User msg, Integer id) {
        System.out.println("onreturn:" + msg);
        ret.put(id, msg);
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }

    public Map<Integer, User> getRet() {
        return ret;
    }

    public void setRet(Map<Integer, User> ret) {
        this.ret = ret;
    }

    public Map<Integer, Throwable> getErrors() {
        return errors;
    }

    public void setErrors(Map<Integer, Throwable> errors) {
        this.errors = errors;
    }
}
