package com.esther.code.common.framework.filter;



import com.esther.code.common.framework.context.UserContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录状态校验过滤器
 *
 * Created by Wudy on 2016/6/22.
 */
public class UserLoginValidateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 此处只拦截jsp  action在LoginInteceptor中拦截
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        UserContext.setHttpSession(request.getSession());

        if(isNeedLogin(request)){

            if(null == UserContext.getSysUser()){
                response.sendRedirect(request.getContextPath()+"/login.html");
                return;
            }

        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private boolean isNeedLogin(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        return !requestURI.contains("login.html");
                //&& !requestURI.contains("index.jsp");
    }
}
