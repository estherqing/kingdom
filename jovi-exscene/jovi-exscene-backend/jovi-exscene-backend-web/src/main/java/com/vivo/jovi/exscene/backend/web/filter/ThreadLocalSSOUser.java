package com.vivo.jovi.exscene.backend.web.filter;

import com.vivo.internet.privilege.client.SSOUser;

/**
 * @author: xuxitao
 * @create: 2018/11/03
 * @description: 使用ThreadLocal保存用户登录信息
 **/
public class ThreadLocalSSOUser {
    private static ThreadLocal<SSOUser> threadLocal = new ThreadLocal<SSOUser>();

    public static void setSSOuser(SSOUser ssouser) {
        threadLocal.set(ssouser);
    }

    public static SSOUser getSSOuser() {
        return threadLocal.get();
    }
}
