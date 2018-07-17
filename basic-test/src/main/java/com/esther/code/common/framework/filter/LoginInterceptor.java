package com.esther.code.common.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
	private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			// RequestUtil.saveRequest();
		}
		log.info("==============执行顺序: 1、LoginInterceptor preHandle================");
//		String requestUri = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String url = requestUri.substring(contextPath.length());
//
//		log.info("requestUri:" + requestUri);
//		log.info("contextPath:" + contextPath);
//		log.info("url:" + url);

		response.getWriter().append(this.getClass().getName()).append(": preHandle");
		
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式

		String username = (String) request.getParameter("username");
		String name = new String(username.getBytes("iso-8859-1"), "utf-8");
		if (username == null || name == null) {
			log.info("LoginInterceptor：跳转到login页面！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		response.getWriter().append(this.getClass().getName()).append(": postHandle");
		log.info("==============执行顺序: 2、LoginInterceptor postHandle================");
		if (modelAndView != null) { // 加入当前时间
			modelAndView.addObject("var", "测试postHandle");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		response.getWriter().append(this.getClass().getName()).append(": afterCompletion");
		log.info("==============执行顺序: 3、LoginInterceptor afterCompletion================");
	}
}
