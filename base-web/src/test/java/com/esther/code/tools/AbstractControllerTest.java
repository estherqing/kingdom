package com.esther.code.tools;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class AbstractControllerTest {

    private static String phone = "13300000000";
    private static String password = "13300000001";

    //spring security的URL定死了为：login
    final static String URL = "http://localhost:8080/login";
    //spring security的URL定死了为：logout
    final static String LOGOUT_URL = "http://localhost:8080/logout";

    protected static LoginResult loginResult = new LoginResult();

    @BeforeClass
    public static void setUp() throws Exception {
      /*  HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(URL);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("userName", phone));
        params.add(new BasicNameValuePair("password", password));
        HttpEntity entity = new UrlEncodedFormEntity(params, Charset.defaultCharset());

        LogManager.getRootLogger().setLevel(Level.ALL);
        post.setEntity(entity);

        // 发送请求
        HttpResponse httpResponse = httpClient.execute(post);
        HttpEntity respEntity = httpResponse.getEntity();
        int code = httpResponse.getStatusLine().getStatusCode();
        String cookie = httpResponse.getHeaders("Set-Cookie")[0].getElements()[0].getValue();
        loginResult.setCode(code);
        loginResult.setToken(cookie);
        //String cookies = httpResponse.getHeaders("Cookie")[0].getValue();
        if (code == 302) {
            String redirect = httpResponse.getHeaders("Location")[0].getValue();
            HttpGet get = new HttpGet(redirect);
            httpResponse = httpClient.execute(get);
            respEntity = httpResponse.getEntity();
        }

        String body = EntityUtils.toString(respEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        //loginResult = objectMapper.readValue(body,LoginResult.class);
        //System.out.println("body="+body);
        //String body = mapper.readValue(respEntity.getContent(),String.class);
        System.out.println("body=" + body);*/
        //System.out.println("cookies="+cookies);
        //HttpResponseProxy{HTTP/1.1 302 Found [Server: Apache-Coyote/1.1, Cache-Control: no-cache, no-store, max-age=0, must-revalidate, Pragma: no-cache, Expires: 0, X-XSS-Protection: 1; mode=block, X-Frame-Options: DENY, X-Content-Type-Options: nosniff, Set-Cookie: JSESSIONID=71A72AF00EC83B32634762A8C9C8D254; Path=/ppcp/; HttpOnly, Location: http://121.40.193.167:8180/ppcp/index.do, Content-Length: 0, Date: Sat, 29 Aug 2015 10:39:43 GMT] [Content-Length: 0,Chunked: false]}
    }

    @AfterClass
    public static void tearDown() {

    }
}
