package com.esther.code.schema.service.impl.cache.ehcache;

import com.esther.code.model.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author esther
 * 2018-04-20 20:01
 * $DESCRIPTION}
 */

public class MyEhcache {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUserName("rose");
        user.setUserRealName("rose green");
        user.setAddress("china");
        user.setAge(25);
        user.setPassword("111111");
        user.setSex("female");

        // 获取缓存管理器
        // 从resources目录下获取默认ehcache.xml文件
        CacheManager manager = CacheManager.getInstance();
        //CacheManager manager= CacheManager.create();

//        从classpath中找寻配置文件并创建:
//        MyEhcache myEhcache = new MyEhcache();
//        CacheManager  manager = CacheManager.create(myEhcache.getClass().getResource("/ehcache.xml"));


        // 根据配置文件获得Cache实例
        Cache demo = manager.getCache("demoCache");

        // 清空Cache中的所有元素
        demo.removeAll();
        demo.put(new Element("hello", "world"));
        demo.put(new Element(user.getUserName(), user));


        Element e = demo.get(user.getUserName());

        System.out.println(demo.get("hello").getObjectValue());
        System.out.println(((User) e.getObjectValue()).getUserRealName());

        System.out.println("-------------------------");

        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(manager.getCacheNames()).forEach(c -> {
            List list = manager.getCache(c).getKeys();
            map.put(c, list);

        });
        System.out.println(map);

        //卸载缓存管理器，关闭Cache
        manager.shutdown();
    }
}