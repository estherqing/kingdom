package com.esther.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StringRedisTemplateTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {

        stringRedisTemplate.opsForValue().set("youcong", "ok");
        System.out.println(stringRedisTemplate.opsForValue().get("youcong"));

        double incrementScore = stringRedisTemplate.opsForZSet().incrementScore("zSetValue", "C", 5);
        System.out.print("通过incrementScore(K key, V value, double delta)方法修改变量中的元素的分值:" + incrementScore);
        Double score = stringRedisTemplate.opsForZSet().score("zSetValue", "C");
        System.out.print(",修改后获取元素的分值:" + score);
    }

}
