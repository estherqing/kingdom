package com.esther.code.model;

/**
 * @author esther
 * 2018-04-27 18:02
 * $DESCRIPTION}
 */

public class SubmitParam {
    private User user;
    private boolean isOk;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }
}
