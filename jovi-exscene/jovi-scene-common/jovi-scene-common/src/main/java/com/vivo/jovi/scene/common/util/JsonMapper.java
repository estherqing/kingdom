package com.vivo.jovi.scene.common.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class JsonMapper {

	private static final ObjectMapper jsonMapper;

	static {
		jsonMapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		jsonMapper.setDateFormat(df);
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static String bean2Json(Object value){
		try {
			return jsonMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String bean2Json(Object value,Class<?> clazz){
		try {
			return jsonMapper.writerFor(clazz).writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T json2Bean(String json,Class<T> clazz){
		try {
			return jsonMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T json2Bean(String json,Class<T> parametrized,Class<?>... parameterClasses){
		try {
			JavaType javaType = jsonMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
			return jsonMapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T json2Bean(String json, TypeReference<T> typeReference){
		try {
			return jsonMapper.readValue(json, typeReference);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> List<T> json2List(String json,Class<T> clazz){
		try {
			JavaType javaType = jsonMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
			return jsonMapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

