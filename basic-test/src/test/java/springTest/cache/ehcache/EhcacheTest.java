package springTest.cache.ehcache;


import com.esther.code.modules.vo.DictVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author esther
 * 2018-04-16 10:46
 * $DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/applicationContext.xml", "classpath:/config/spring-servlet.xml"})
public class EhcacheTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private static Logger logger= LoggerFactory.getLogger(EhcacheTest.class);

    /**
     * 同一个sqlSession
     */
    @Test
    public  void testEhcache(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<DictVo> list = sqlSession.selectList("com.hsmdata.springTest.modules.mapper.DictMapper.getAllDictList");

        list = sqlSession.selectList("com.hsmdata.springTest.modules.mapper.DictMapper.getAllDictList");
    }
}
