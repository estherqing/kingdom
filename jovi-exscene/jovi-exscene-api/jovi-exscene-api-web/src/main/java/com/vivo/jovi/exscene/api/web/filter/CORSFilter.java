package com.vivo.jovi.exscene.api.web.filter;

import com.vivo.internet.vivocfg.client.VivoConfigManager;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 跨域请求过滤器
 * @author: Lu Guodong
 * @CreateDate: 2019-05-28
 */
public class CORSFilter implements Filter {

    private String JSONPPrefix = VivoConfigManager.getString("JSONP.prefix","ai-h5-pre");
    private String[] WHITE_LIST = {JSONPPrefix + ".vivo.com.cn", "vivo.com.cn"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String origin = request.getHeader("Origin");
        boolean valid = false;
        if(StringUtils.isNotEmpty(origin)){
            for(String domain : WHITE_LIST){
                if(origin.contains(domain)){
                    valid = true;
                    break;
                }
            }
            if(valid){
                response.setHeader("Access-Control-Allow-Origin", origin);
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
                response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
