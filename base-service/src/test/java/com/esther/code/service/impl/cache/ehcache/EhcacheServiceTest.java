package com.esther.code.service.impl.cache.ehcache;

import com.esther.code.api.IEhcacheService;
import com.esther.code.service.impl.base.BaseService;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author esther
 * 2018-04-23 11:07
 * spring cache 的原理，即它是基于动态生成的 proxy 代理机制来对方法的调用进行切面，这里关键点是对象的引用问题，
 * 如果对象的方法是内部调用（即 this 引用）而不是外部引用，则会导致 proxy 失效，那么我们的切面就失效，
 * 也就是说上面定义的各种注释包括 @Cacheable、@CachePut 和 @CacheEvict 都会失效。
 * 要避免这个问题，就是要避免对缓存方法的内部调用，或者避免使用基于 proxy 的 AOP 模式，可以使用基于 aspectJ 的 AOP 模式来解决这个问题。
 *
 * 和内部调用问题类似，非 public 方法如果想实现基于注释的缓存，必须采用基于 AspectJ 的 AOP 机制，
 */

public class EhcacheServiceTest extends BaseService {
    @Autowired
    private IEhcacheService ehcacheService;

    @Autowired
    private CacheManager cacheManager;

    // 有效时间是5秒，第一次和第二次获取的值是一样的，因第三次是5秒之后所以会获取新的值
    @Test
    public void testTimestamp() throws InterruptedException {
        System.out.println("第一次调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(4000);
        System.out.println("再过4秒之后调用：" + ehcacheService.getTimestamp("param"));
    }

    @Test
    public void testCache() {
        String key = "zhangsan";
        System.out.println(ehcacheService.getDataFromDB(key)); // 从数据库中获取数据...
        System.out.println(ehcacheService.getDataFromDB(key));  // 从缓存中获取数据，所以不执行该方法体
        ehcacheService.removeDataAtDB(key); // 从数据库中删除数据
        System.out.println(ehcacheService.getDataFromDB(key));  // 从数据库中获取数据...（缓存数据删除了，所以要重新获取，执行方法体）
    }

    @Test
    public void testPut() {
        String key = "mengdee";
        System.out.println(ehcacheService.refreshData(key));  // 模拟从数据库中加载数据
        String data = ehcacheService.getDataFromDB(key);
        System.out.println("data:" + data); // data:mengdee::103385

        System.out.println(ehcacheService.refreshData(key));  // 模拟从数据库中加载数据
        String data2 = ehcacheService.getDataFromDB(key);
        System.out.println("data2:" + data2);   // data2:mengdee::180538    
    }


    @Test
    public void testfindUserById() {
        ehcacheService.removeAllUser();
        ehcacheService.findUserById(1); // 模拟从数据库中查询数据
        lookCacheStatus();
        ehcacheService.findUserById(1);
    }

    @Test
    public void testIsReserved() {
        ehcacheService.isReserved(1);
        ehcacheService.isReserved(12);
    }

    @Test
    public void testRemoveUser() {
        // 先添加到缓存
        ehcacheService.findUserById(1);
        // 从缓存中获取数据，所以不执行该方法体
        ehcacheService.findUserById(1);

        // 再删除
        ehcacheService.removeUser(1);

        // 如果不存在会执行方法体
        // 从数据库中获取数据...（缓存数据删除了，所以要重新获取，执行方法体）
        ehcacheService.findUserById(1);
    }

    @Test
    public void testRemoveAllUser() {
        ehcacheService.findUserById(1);
        ehcacheService.findUserById(2);

        ehcacheService.removeAllUser();

        ehcacheService.findUserById(1);
        ehcacheService.findUserById(2);


//      模拟从数据库中查询数据
//      模拟从数据库中查询数据
//      UserCache delete all
//      模拟从数据库中查询数据
//      模拟从数据库中查询数据
    }

    @Test
    public void testCaching() {
        lookCacheStatus();
        ehcacheService.findUserById(1);

        lookCacheStatus();
        ehcacheService.findUserById(1);

        lookCacheStatus();
        ehcacheService.testCaching("param");

        lookCacheStatus();
        ehcacheService.findUserById(1);

        lookCacheStatus();
        ehcacheService.testCaching("param");
    }

    @Test
    public void testgetUserById() {
        ehcacheService.removeAllUser();
        lookCacheStatus();
        ehcacheService.get(1); // 模拟从数据库中查询数据
        lookCacheStatus();
        ehcacheService.get(1);
    }

    public void lookCacheStatus(){
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(cacheManager.getCacheNames()).forEach(c -> {
            List list = cacheManager.getCache(c).getKeys();
            map.put(c, list);
        });
        System.out.println(map);
    }
}
