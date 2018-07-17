package com.esther.code.common.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StopWatchHandlerInterceptor implements HandlerInterceptor {
	private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("StopWatch-StartTime");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 1、" + this.getClass().getName() + " preHandle================");
		long startTime = System.currentTimeMillis();// 开始时间
		startTimeThreadLocal.set(startTime);// 线程绑定变量（该数据只有当前请求的线程可见）
		return true;// 继续流程
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 2、" + this.getClass().getName() + " postHandle================");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 3、" + this.getClass().getName() + " afterCompletion================");
		long endTime = System.currentTimeMillis();// 结束时间
		long startTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long consumeTime = endTime - startTime;// 3、消耗的时间
		if (consumeTime > 500) {// 此处认为处理时间超过500毫秒的请求为慢请求
			// TODO 记录到日志文件
			System.out.println(String.format("%s consumes %d mills", request.getRequestURI(), consumeTime));
		} else {
			System.out.println(request.getRequestURI() + " is fast.");
		}
	}

}
