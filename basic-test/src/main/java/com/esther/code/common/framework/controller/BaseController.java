package com.esther.code.common.framework.controller;


import com.esther.code.common.framework.mapper.JsonMapper;
import com.esther.code.common.utils.DateUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;

public abstract class BaseController {

	/**
	 * ��־����
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, JsonMapper.toJsonString(object), "application/json");
	}

	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String����ת���������д��ݽ�����String����HTML���룬��ֹXSS����
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date ����ת��
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
		});
	}

	protected boolean checkLogin(Integer userId) {
		if(null == userId){
			return false;
		}
		//UserVo loginUser = UserContext.getSysUser();
		//if(null != loginUser && loginUser.getId() == userId){
		//	return true;
		//}
		return false;
	}
	
}

