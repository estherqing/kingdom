package com.esther.springboot;

import com.alibaba.fastjson.JSON;
import com.esther.springboot.bean.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
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

    private Map<String, Mutex> mutexMap = new ConcurrentHashMap<>();

    class Mutex {

    }

    @Test
    public void testCache() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
        long t = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    getData(Integer.toString((int) Math.random() * 100), 1800, () -> new Book("spring" + Math.random() * 100, "spring book"), Book.class);
                }
            });
        }
        long tt = System.currentTimeMillis();
        log.info("花费的时间为：" + (tt - t) + "ms");
    }

    public <R> R getData(String key, int timeout, Supplier<R> supplier, Class<R> clazz) {
        R cr = getCache(key, clazz);
        if (cr != null) {
            return cr;
        }
        mutexMap.putIfAbsent(key, new Mutex());
        Mutex mutex = mutexMap.get(key);
        synchronized (mutex) {
            //double chcek,防止已经放入缓存再次查询DB
            cr = getCache(key, clazz);
            if (cr != null) {
                return cr;
            }
            try {
                R r = supplier.get();
                stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(r), timeout, TimeUnit.SECONDS);
                return r;
            } catch (Exception e) {
                log.error("CacheServiceHelper|doCache|error|key={}", key, e);
            } finally {
                mutexMap.remove(key);
            }
        }
        return getCache(key, clazz);
    }

    private <R> R getCache(String key, Class<R> clazz) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (value != null) {
            return JSON.parseObject(value, clazz);
        }
        return null;
    }

}
