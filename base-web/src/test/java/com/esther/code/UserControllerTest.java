package com.esther.code;

import org.junit.Test;

/**
 * @author esther
 * 2018-04-19 9:21
 * $DESCRIPTION}
 */

public class UserControllerTest {
    private String get="http://localhost:8080/user/get";

    @Test
    public void getSignInfoList() throws Exception {
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpPost post = new HttpPost(get);
//        System.out.println("request=" + get);
//        //post.addHeader("Cookie", "JSESSIONID=" + loginResult.getToken());
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("id", "1"));
//
//        HttpEntity entity = new UrlEncodedFormEntity(params, Charset.defaultCharset());
//        post.setEntity(entity);
//        HttpResponse httpResponse = httpClient.execute(post);
//        HttpEntity respEntity = httpResponse.getEntity();
//        int code = httpResponse.getStatusLine().getStatusCode();
//        if (code == 302) {
//            String redirect = httpResponse.getHeaders("Location")[0].getValue();
//            HttpGet get1 = new HttpGet(redirect);
//            httpResponse = httpClient.execute(get1);
//            respEntity = httpResponse.getEntity();
//        }
//        String body = EntityUtils.toString(respEntity);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        System.out.println("body=" + body);
    }
}
