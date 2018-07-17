package com.esther.code.modules.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
/**
 * 实现EnvironmentAware接口获取环境相关信息
 * @author esther
 *
 */ 
public class TestController implements EnvironmentAware {
	Logger logger=LoggerFactory.getLogger(TestController.class);
	
	@SuppressWarnings("unused")
	private Environment enviroment = null;

	@Override
	public void setEnvironment(Environment environment) {
		this.enviroment = environment;
	}
 
	@RequestMapping("/testinfo")
	public String test() {
		logger.info("test test");
		return "test";
	}
}
