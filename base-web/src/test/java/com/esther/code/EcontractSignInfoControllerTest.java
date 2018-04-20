package com.esther.code;

import com.esther.code.base.AbstractControllerTest;
import org.junit.Test;

/**
 * @author esther
 * 2017-11-22 11:44
 * $DESCRIPTION}
 */

public class EcontractSignInfoControllerTest extends AbstractControllerTest {
    private String getLoanInfoList="http://localhost:8080/signInfo/list";

    @Test
    public void getSignInfoList() throws Exception {
       /* HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(getLoanInfoList);
        System.out.println("request=" + getLoanInfoList);
        post.addHeader("Cookie", "JSESSIONID=" + loginResult.getToken());
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("orgId", "1"));
        params.add(new BasicNameValuePair("customerName", "杭州子烨"));
        params.add(new BasicNameValuePair("bankId", "1"));
        params.add(new BasicNameValuePair("busNo", "111"));
        params.add(new BasicNameValuePair("startTime","2017-08-30"));
        params.add(new BasicNameValuePair("endTime","2017-09-31"));

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

        System.out.println("body=" + body);*/
    }

}
