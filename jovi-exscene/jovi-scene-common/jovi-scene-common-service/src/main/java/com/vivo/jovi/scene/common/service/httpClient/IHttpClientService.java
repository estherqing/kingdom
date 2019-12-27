package com.vivo.jovi.scene.common.service.httpClient;

import java.io.IOException;
import java.util.Map;

public interface IHttpClientService {

    /**
     * 执行GET请求
     */
    String doGet(String url);

    /**
     * 带有参数的GET请求
     */
    String doGet(String url, Map<String, String> params);

    /**
     * 执行POST请求
     */
    String doPost(String url, Map<String, String> params);


    /**
     * 执行POST请求
     */
    String doPost(String url) throws IOException;

    /**
     * 提交json数据
     */
    String doPostData(String url, String json);

    /**
     * 通过gzip的方式进行提交
     */
    String postWithGzip(String url, byte[] gzipData);

    /**
     * 通过application/json的方式提交
     */
    String doPostJson(String url, String json);

    /**
     * 通过application/json的方式提交
     * @param url
     * @param json
     * @param headerMap
     * @return
     */
    String doPostJson(String url, String json, Map<String, String> headerMap);

    /**
     * 执行POST请求
     */
    String doPost(String url, Map<String, String> params, Map<String, String> headerMap);

}
