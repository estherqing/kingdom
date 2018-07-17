package springTest.mybatis.cache;

import com.esther.code.modules.vo.DictVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author esther
 * @create 2017-09-23 12:09
 * $DESCRIPTION}
 */

public class MyBatisUtilTest {
    public static void main(String[] args) {
        String[] xmls = {"/config/applicationContext.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(xmls);
        SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<DictVo> list = sqlSession.selectList("com.hsmdata.springTest.modules.mapper.DictMapper.getAllDictList");
        System.out.println(list);
    }
}
