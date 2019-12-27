package com.vivo.jovi.exscene.backend.web.filter;

import com.vivo.internet.privilege.client.SSOUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lijun
 * @date 2018/11/16
 * @describe 获取OA_SESSION中的账户信息
 */
public class SSOUserFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        Object oaUser = session.getAttribute("OA_SESSION");
        ThreadLocalSSOUser.setSSOuser((SSOUser) oaUser);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
