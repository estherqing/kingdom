package springTest.cache.ehcache;


import com.esther.code.modules.entity.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author esther
 * 2018-04-16 15:49
 *  通过编程方式使用Ehcache
 */

public class MyEhcache {
  public static void main(String[] args) {
        User user=new User("cache","123456","cache cache","","male",20);

        // 获取缓存管理器
        CacheManager cacheManager = CacheManager.create("src/main/resources/config/ehcache.xml");
       // 根据配置文件获得Cache实例
        Cache demo = cacheManager.getCache("demoCache");

        // 清空Cache中的所有元素
        demo.removeAll();
        demo.put(new Element("hello","world"));
        demo.put(new Element(user.getUserName(),user));


        Element e=demo.get(user.getUserName());

        System.out.println(demo.get("hello").getObjectValue());
        System.out.println(((User)e.getObjectValue()).getUserRealName());

        //卸载缓存管理器
        cacheManager.shutdown();
    }
}
