package com.esther.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author esther
 * 2018-04-19 9:21
 * $DESCRIPTION}
 */

public class UserControllerTest {
    private String get="http://localhost:8086/kingdom/flow/submit2next";

    @Test
    public void getSignInfoList() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(get);
        System.out.println("request=" + get);
        //post.addHeader("Cookie", "JSESSIONID=" + loginResult.getToken());
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("boId", "1"));
        params.add(new BasicNameValuePair("nextNodeUserId", "2"));
        params.add(new BasicNameValuePair("nextNodeUserName", "rose"));
        HttpEntity entity = new UrlEncodedFormEntity(params, Charset.defaultCharset());
        post.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(post);
        HttpEntity respEntity = httpResponse.getEntity();
        int code = httpResponse.getStatusLine().getStatusCode();
        if (code == 302) {
            String redirect = httpResponse.getHeaders("Location")[0].getValue();
            HttpGet get1 = new HttpGet(redirect);
            httpResponse = httpClient.execute(get1);
            respEntity = httpResponse.getEntity();
        }
        String body = EntityUtils.toString(respEntity);
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("body=" + body);
    }
}
