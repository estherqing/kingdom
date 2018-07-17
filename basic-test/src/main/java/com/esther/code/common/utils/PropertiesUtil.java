package com.esther.code.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description 用来获取properties文件中的配置
 * @author wudy
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer {
	private static Map<String, String> propertiesMap = new HashMap<String, String>();

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			propertiesMap.put(keyStr, props.getProperty(keyStr));
		}
	}

	public static String getProperty(String key) {
		return propertiesMap.get(key);
	}
}
