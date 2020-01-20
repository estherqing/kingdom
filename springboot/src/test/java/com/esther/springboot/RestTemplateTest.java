package com.esther.springboot;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class RestTemplateTest {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RestTemplate httpClientTemplate;

    @Test
    public void test() throws Exception {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(500);
        long startStamp = System.currentTimeMillis();
        AtomicInteger index = new AtomicInteger(0);
        for (int i = 0; i < 100000; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {

//                      String url = "http://localhost:8080/jovi-exscene-api-web/exscene/activity/card/query";
                    String url = "http://10.101.38.78:8080/exscene/activity/card/query";
                    String str = "{\n" +
                            "    \"lastQueryTime\": \"\",\n" +
                            "    \"appVersion\": \"3710\",\n" +
                            "    \"language\": \"all\",\n" +
                            "    \"model\": \"vivo1851\",\n" +
                            "    \"pd\": \"PD1730DF_EX\",\n" +
                            "    \"role\": \"0\",\n" +
                            "    \"sysVersion\": \"PD1730DF_EX_A_6.10.3\",\n" +
                            "    \"userId\": \"0B50D9E52910B98555565317D0A17AE54AB501502ACC6B2FDA9C843020396F451578385454545\"\n" +
                            "}";
                   /* HttpHeaders headers = new HttpHeaders();

                    headers.setContentType(MediaType.APPLICATION_JSON);

                    headers.set(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());

                    HttpEntity<String> requestEntity = new HttpEntity<>(str, headers);*/

                    ResponseEntity<CommonVO> responseEntity = restTemplate.postForEntity(url, str, CommonVO.class);

                    // System.out.println("-----------------------------------");
                    // System.out.println(responseEntity.getBody().getData());
                    index.incrementAndGet();
                }
            });
        }
        while (index.get() < 99999) {
            Thread.currentThread();
            Thread.sleep(100);
        }
        System.out.println(System.currentTimeMillis() - startStamp);
        System.out.println("end.......");
    }


    @Test
    public void test2() throws Exception {
        System.out.println("开始测试------------");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(500);
        long startStamp = System.currentTimeMillis();
        AtomicInteger index = new AtomicInteger(0);
        for (int i = 0; i < 100000; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {

                      String url = "http://localhost:8080/jovi-exscene-api-web/exscene/activity/card/query";
                   // String url = "http://10.101.38.78:8080/exscene/activity/card/query";
                    String str = "{\n" +
                            "    \"lastQueryTime\": \"\",\n" +
                            "    \"appVersion\": \"3710\",\n" +
                            "    \"language\": \"all\",\n" +
                            "    \"model\": \"vivo1851\",\n" +
                            "    \"pd\": \"PD1730DF_EX\",\n" +
                            "    \"role\": \"0\",\n" +
                            "    \"sysVersion\": \"PD1730DF_EX_A_6.10.3\",\n" +
                            "    \"userId\": \"0B50D9E52910B98555565317D0A17AE54AB501502ACC6B2FDA9C843020396F451578385454545\"\n" +
                            "}";
                    ExsceneActivityCardBizQueryParam param = JSONObject.parseObject(str, ExsceneActivityCardBizQueryParam.class);
                    ResponseEntity<CommonVO> responseEntity = httpClientTemplate.postForEntity(url, param, CommonVO.class);

                    // System.out.println("-----------------------------------");
                    System.out.println("index:" + index.get());
                    index.incrementAndGet();
                }
            });
        }
        while (index.get() < 99999) {
            Thread.currentThread();
            Thread.sleep(100);
        }
        System.out.println(System.currentTimeMillis() - startStamp);
        System.out.println("end.......");
    }


    @Test
    public void testHello() {
        String str = this.httpClientTemplate.getForObject("http://127.0.0.1:8090/test", String.class);
        System.out.println(str);
    }
}
