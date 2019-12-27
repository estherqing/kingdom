package com.esther.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StringRedisTemplateService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public String getString(String key){
      return   stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置list
     */
    public void setList(String k, String v) {
        stringRedisTemplate.opsForList().rightPush(k, v);
    }

    /**
     * 删除同一个元素v
     */
    public void removeAllElement(String k, String v) {
        stringRedisTemplate.opsForList().remove(k, 0, v);
    }

    /**
     * 获取k
     */
    public List<String> getList(String k) {
        return stringRedisTemplate.opsForList().range(k, 0, -1);
    }

    /**
     * 设置hash
     * {bigK:[{k:v},{k:v}]}
     *
     * @param bigK 最外层k
     * @param k    内层k
     * @param v    内层v
     */
    public void setHash(String bigK, String k, String v) {
        stringRedisTemplate.opsForHash().put(bigK, k, v);
    }

    /**
     * 获取hash
     *
     * @param bigK
     * @return
     */
    public Map<String, String> getHash(String bigK) {
        return stringRedisTemplate.<String, String>opsForHash().entries(bigK);
    }

    /**
     * 删除内层k
     *
     * @param bigK
     * @param k
     */
    public void removeK(String bigK, String k) {
        stringRedisTemplate.opsForHash().delete(bigK, k);
    }
}
