package com.esther.code.common.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class TimeInterceptor implements HandlerInterceptor {
	private final Logger log = LoggerFactory.getLogger(TimeInterceptor.class);
	private int openingTime;// openingTime 属性指定上班时间
	private int closingTime;// closingTime属性指定下班时间
	private String outsideOfficeHoursPage;// outsideOfficeHoursPage属性指定错误提示页面的URL

	// 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("==============执行顺序: 1、" + this.getClass().getName() + " preHandle================");
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);// 获取当前时间 
		if (openingTime <= hour && hour <= closingTime) {// 判断当前是否处于工作时间段内
			System.out.println("当前处于工作时间段内");
			return true;
		}
		System.out.println("当前不处于工作时间段内");
		response.sendRedirect(outsideOfficeHoursPage);// 返回提示页面
		return false;
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

	}

	public int getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}

	public int getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}

	public String getOutsideOfficeHoursPage() {
		return outsideOfficeHoursPage;
	}

	public void setOutsideOfficeHoursPage(String outsideOfficeHoursPage) {
		this.outsideOfficeHoursPage = outsideOfficeHoursPage;
	}

}
