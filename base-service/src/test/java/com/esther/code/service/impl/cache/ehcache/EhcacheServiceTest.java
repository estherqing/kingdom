package com.esther.code.service.impl.cache.ehcache;

import com.esther.code.api.IEhcacheService;
import com.esther.code.service.impl.base.BaseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author esther
 * 2018-04-23 11:07
 * $DESCRIPTION}
 */

public class EhcacheServiceTest extends BaseService {
    @Autowired
    private IEhcacheService ehcacheService;

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
        ehcacheService.findUserById(55); // 模拟从数据库中查询数据
        ehcacheService.findUserById(55);
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
}
