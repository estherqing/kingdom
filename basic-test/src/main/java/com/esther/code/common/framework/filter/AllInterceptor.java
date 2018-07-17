package com.esther.code.common.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllInterceptor implements HandlerInterceptor {
	 private final Logger log = LoggerFactory.getLogger(AllInterceptor.class);  
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if ("GET".equalsIgnoreCase(request.getMethod())) {  
            //RequestUtil.saveRequest();  
        }  
        log.info("==============执行顺序: 1、AllInterceptor preHandle================"); 
//        String requestUri = request.getRequestURI();  
//        String contextPath = request.getContextPath();  
//        String url = requestUri.substring(contextPath.length());  
//        
//        log.info("requestUri:"+requestUri);    
//        log.info("contextPath:"+contextPath);    
//        log.info("url:"+url); 
        
		response.getWriter().append(this.getClass().getName()).append(": preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		response.getWriter().append(this.getClass().getName()).append(": postHandle");
		log.info("==============执行顺序: 2、AllInterceptor postHandle================");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		response.getWriter().append(this.getClass().getName()).append(": afterCompletion");
		 log.info("==============执行顺序: 3、AllInterceptor afterCompletion================");   
	}

}
