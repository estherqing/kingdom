package com.esther.code.common.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L; 
	
	 private final Logger log = LoggerFactory.getLogger(AllInterceptor.class);  
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;  
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");  
        httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");  
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");  
        
        System.out.println(request.getCharacterEncoding());
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式
        
        log.info("==============filter==============");
        chain.doFilter(request, httpResponse);

	}

}
