package com.esther.code.common.framework.context;


import com.esther.code.common.framework.vo.UserVo;

import javax.servlet.http.HttpSession;


public class UserContext {
	private static ThreadLocal<HttpSession> localHttpSession = new ThreadLocal<HttpSession>();

	/**
	 * 登陆用户Session key
	 */
	public static final String LOCAL_USER_KEY = "LOCAL_USER_KEY";
	
	public static HttpSession getHttpSession() {
		return localHttpSession.get();
	}

	public static void setHttpSession(HttpSession httpSession) {
		localHttpSession.set(httpSession);
	}
	/**
	 * 设置登陆用户对象到Session中
	 * @param user
	 */
	public static void setSysUser(UserVo user){
		HttpSession session = getHttpSession();
		if(session != null){
			session.setAttribute(LOCAL_USER_KEY, user);
		}
	}
	/**
	 * 获取会话中的用户
	 * @return
	 */
	/*public static UserVo getSysUser(Integer userId){
		UserVo user = userMapper.get(userId);
		if(null != user){
			return user;
		}
		return null;
	}*/
	public static UserVo getSysUser(){
		HttpSession session = getHttpSession();
		if(session != null){
			return (UserVo) session.getAttribute(LOCAL_USER_KEY);
		}
		return null;
	}
	/**
	 * 获取用户id
	 * @return
	 */
	public static int getUserId(){
		UserVo user = getSysUser();
		if(user == null){
			return 0;
		}
		return user.getId();
	}

	/**
	 * 设置用户失效
	 */
	public static void invalidate(){
		HttpSession session = getHttpSession();
		if(session != null){
			session.invalidate();
		}
	}
}
