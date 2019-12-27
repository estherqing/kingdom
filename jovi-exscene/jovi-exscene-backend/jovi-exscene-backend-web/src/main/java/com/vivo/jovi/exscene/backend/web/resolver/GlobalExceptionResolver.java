package com.vivo.jovi.exscene.backend.web.resolver;

import com.vivo.jovi.scene.common.CommonVOCode;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;

/**
 * @author Tian Guangxin
 * @date 2018/03/15
 * @since 1.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    private ObjectMapper objectMapper	= new ObjectMapper();

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 返回一个空的ModelAndVie表示异常已经在本Resolver中处理，返回null表示在本resolver中没有处理异常，交给异常处理链中的下一个处理
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LinkedHashMap<String, Object> model = new LinkedHashMap<String, Object>();

        if (ex instanceof MissingServletRequestParameterException) {
            LOGGER.warn("客户端参数错误",ex);
            model.put("code", CommonVOCode.BAD_PARAMS);
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            LOGGER.warn("客户端参数错误",ex);
            model.put("code", CommonVOCode.BAD_PARAMS);
        } else if (ex instanceof IllegalArgumentException) {
            LOGGER.warn("客户端参数错误",ex);
            model.put("code", CommonVOCode.BAD_PARAMS);
        } else if (StringUtils.equals(ex.getClass().getName(), "org.apache.catalina.connector.ClientAbortException")) {
            // 客户端关闭了IO导致的异常无需输出日志，也无需再输出内容
            return new ModelAndView();
        } else {
            LOGGER.error("服务器未处理异常", ex);
            model.put("code", CommonVOCode.SERVER_ERROR);
            model.put("msg",ex.getMessage());
        }
        try {
            response.getWriter().write(objectMapper.writeValueAsString(model));
        } catch (Exception e) {

        }
        return new ModelAndView();
    }
}
