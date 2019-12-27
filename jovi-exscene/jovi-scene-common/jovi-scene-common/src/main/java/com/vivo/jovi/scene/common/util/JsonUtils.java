package com.vivo.jovi.scene.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    private static final SerializerFeature[] features = { SerializerFeature.SortField,
            SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty,
            // SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect,
            SerializerFeature.WriteDateUseDateFormat };

    private static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();

    public static String TO_JSON(Object data) {
        return JSON.toJSONString(data, features);
    }

    /*
    *  使用Jackson库转换对象成json字符串
    * */
    public static String TO_JSON2(Object data) {
        try {
            return JACKSON_MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T TO_OBJ(String source, Class<T> clazz) {
        return JSON.parseObject(source, clazz);
    }

    public static <T> T TO_OBJ(Object source, Class<T> clazz) {
        return TO_OBJ(JSON.toJSONString(source), clazz);
    }

    public static <T> T parse2Generic(String source) {
        return JSON.parseObject(source, new TypeReference<T>() {
        });
    }
    

    public static <T> List<T> TO_ARRAY(String source, Class<T> clazz) {
        return JSONArray.parseArray(source, clazz);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parse2Map(String source) {
        Map<String, Object> map = null;
        try {
            map = (Map<String, Object>) TO_OBJ(source, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> parse2Map(InputStream is) {
        Map<String, Object> map = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while (StringUtil.isNotBlank(line = br.readLine())) {
                sb.append(line);
            }
            map = parse2Map(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
