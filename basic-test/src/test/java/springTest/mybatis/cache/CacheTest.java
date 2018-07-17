package springTest.mybatis.cache;


import com.esther.code.modules.entity.User;
import com.esther.code.modules.mapper.UserMapper;
import com.esther.code.modules.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

/**
 * @author esther
 * 2018-04-10 15:11
 * $DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/applicationContext.xml", "classpath:/config/spring-servlet.xml"})
public class CacheTest {
    @Autowired
    private UserService userService;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private static Logger logger= LoggerFactory.getLogger(CacheTest.class);

    /**
     * 同一个sqlSession
     */
    @Test
    public  void testFirstCache(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user=userMapper.selectByPrimaryKey(56);
        System.out.println(user);

/*       对sqlsession执行commit操作，也就意味着用户执行了update、delete等操作，那么数据库中的数据势必会发生变化，如果用户请求数据仍然使用之前内存中的数据，那么将读到脏数据。
        所以在执行sqlsession操作后，会清除保存数据的HashMap，用户在发起查询请求时就会重新读取数据并放入一级缓存中了。*/
     //   sqlSession.commit();

        user=userMapper.selectByPrimaryKey(56);
        System.out.println(user);
    }

    /**
     * 不同的sqlSession
     */
    @Test
    public  void testSecondaryCache(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user=userMapper.selectByPrimaryKey(56);
        System.out.println(user);
        sqlSession.commit();
        checkCacheStatus(sqlSession);

        userMapper=sqlSession.getMapper(UserMapper.class);
        user=userMapper.selectByPrimaryKey(55);
        sqlSession.commit();
        checkCacheStatus(sqlSession);

//        即使开启了二级缓存，不同的sqlsession之间的缓存数据也不是想互访就能互访的，必须等到sqlsession关闭了以后，才会把其一级缓存中的数据写入二级缓存。
//        关闭session
//        sqlSession.close();

//        通过sqlSessionFactory创建一个新的session
        sqlSession=sqlSessionFactory.openSession();
//        获取mapper对象
        userMapper=sqlSession.getMapper(UserMapper.class);

        user=userMapper.selectByPrimaryKey(56);
        System.out.println(user);
        sqlSession.commit();
        checkCacheStatus(sqlSession);
    }

    /**
     * 不同的sqlSession
     */
    @Test
    public void testSecondaryCache2() {
       /* User user=new User("cache","123456","cache","","male",20);
        userService.insert(user);*/

        User user = userService.get(56);
        System.out.println(user);

        User user1 = userService.get(56);
        System.out.println(user1);
    }

    @Test
    public void testFirstCache2() {
       /* User user=new User("cache","123456","cache","","male",20);
        userService.insert(user);*/

        User user = userService.getTwo(56);
        System.out.println(user);
    }

    @Test
    public void testRedisCache(){
        User user=userService.get(55);
        System.out.println(user);

        User user2=userService.get(56);
        System.out.println(user2);

        User user3=userService.get(55);
        System.out.println(user3);

    }

    public static void checkCacheStatus(SqlSession sqlSession)
    {
        logger.info("------------Cache Status------------");
        Iterator<String> iter = sqlSession.getConfiguration().getCacheNames().iterator();
        while(iter.hasNext())
        {
            String it = iter.next();
            logger.info(it+":"+sqlSession.getConfiguration().getCache(it).getSize());
        }
        logger.info("------------------------------------");

    }

}
