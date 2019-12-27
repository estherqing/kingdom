package com.vivo.jovi.scene.common.service.httpClient.impl;

import com.vivo.jovi.scene.common.exception.HttpClientException;
import com.vivo.jovi.scene.common.model.HttpResult;
import com.vivo.jovi.scene.common.service.httpClient.IHttpClientService;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
@Service
public class HttpClientService implements IHttpClientService {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientService.class);

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;

    @Override
    public String doGet(String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(this.requestConfig);
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toString(response.getEntity(), "UTF-8");
                } else {
                    throw new HttpClientException("do get error, url is " + url + " and status code is " + response.getStatusLine().getStatusCode());
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            throw new HttpClientException("do get error, url is " + url, e);
        }
    }

    @Override
    public String doGet(String url, Map<String, String> params) {

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            for (String key : params.keySet()) {
                uriBuilder.addParameter(key, params.get(key));
            }
            return this.doGet(uriBuilder.build().toString());
        } catch (Exception e) {
            throw new HttpClientException("do get error. url is " + url + " and params is " + params, e);
        }
    }

    @Override
    public String doPost(String url, Map<String, String> params) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(this.requestConfig);
            if (params != null) {
                List<NameValuePair> parameters = new ArrayList<>();
                for (String key : params.keySet()) {
                    parameters.add(new BasicNameValuePair(key, params.get(key)));
                }
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
                httpPost.setEntity(formEntity);
                httpPost.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
            }

            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toString(response.getEntity(), "UTF-8");
                } else {
                    throw new HttpClientException("do post error,url is " + url + " ,params is" + params + " and statusCode is" +
                            response.getStatusLine().getStatusCode());
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            throw new HttpClientException("do post error,url is " + url + " and params is " + params, e);
        }
    }

    @Override
    public String doPost(String url) throws IOException {
        return this.doPost(url, null);
    }

    @Override
    public String doPostData(String url, String data) {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (data != null) {
                StringEntity stringEntity = new StringEntity(data, "UTF-8");
                httpPost.setEntity(stringEntity);
            }
            return this.doPost(httpPost);
        } catch (Exception e) {
            throw new HttpClientException("do post data error,url is" + url + " and data is" + data, e);
        }
    }

    @Override
    public String postWithGzip(String url, byte[] gzipData) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Encoding", "gzip");
            httpPost.setEntity(new ByteArrayEntity(gzipData));
            return this.doPost(httpPost);
        } catch (Exception e) {
            throw new HttpClientException("do post with gzip error,url is" + url, e);
        }
    }


    private String doPost(HttpPost httpPost) throws IOException {
        httpPost.setConfig(this.requestConfig);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = this.httpClient.execute(httpPost);
            HttpResult httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
            if (httpResult.getStatusCode() != 200) {
                throw new HttpClientException("do post error , status code is :" + httpResult.getStatusCode());
            } else {
                return httpResult.getResponse();
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public String doPostJson(String url, String json) {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (json != null) {
                StringEntity stringEntity = new StringEntity(json, "UTF-8");
                httpPost.setEntity(stringEntity);
            }

            httpPost.setConfig(this.requestConfig);
            httpPost.setHeader(new BasicHeader("Content-Type", "application/json"));
            CloseableHttpResponse response = null;
            try {
                // 执行请求
                response = this.httpClient.execute(httpPost);
                HttpResult httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                        EntityUtils.toString(response.getEntity(), "UTF-8"));
                if (httpResult.getStatusCode() != 200) {
                    throw new HttpClientException("do post json error , status code is :" + httpResult.getStatusCode());
                } else {
                    return httpResult.getResponse();
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            throw new HttpClientException("do post json error , url is " + url + " and json is " + json, e);
        }

    }

    @Override
    public String doPostJson(String url, String json ,Map<String,String> headerMap) {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (json != null) {
                StringEntity stringEntity = new StringEntity(json, "UTF-8");
                httpPost.setEntity(stringEntity);
            }

            httpPost.setConfig(this.requestConfig);
            for(String key:headerMap.keySet()){
                httpPost.setHeader(new BasicHeader(key, headerMap.get(key)));
            }
            CloseableHttpResponse response = null;
            try {
                // 执行请求
                response = this.httpClient.execute(httpPost);
                HttpResult httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                        EntityUtils.toString(response.getEntity(), "UTF-8"));
                if (httpResult.getStatusCode() != 200) {
                    throw new HttpClientException("do post json error , status code is :" + httpResult.getStatusCode());
                } else {
                    return httpResult.getResponse();
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            throw new HttpClientException("do post json error , url is " + url + " and json is " + json, e);
        }

    }

    @Override
    public String doPost(String url, Map<String, String> params, Map<String,String> headerMap) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(this.requestConfig);
            if (params != null) {
                List<NameValuePair> parameters = new ArrayList<>();
                for (String key : params.keySet()) {
                    parameters.add(new BasicNameValuePair(key, params.get(key)));
                }
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
                httpPost.setEntity(formEntity);
            }
            for(String key:headerMap.keySet()){
                httpPost.setHeader(new BasicHeader(key, headerMap.get(key)));
            }

            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toString(response.getEntity(), "UTF-8");
                } else {
                    throw new HttpClientException("do post error,url is " + url + " ,params is" + params + " and statusCode is" +
                            response.getStatusLine().getStatusCode());
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            throw new HttpClientException("do post error,url is " + url + " and params is " + params, e);
        }
    }
}
