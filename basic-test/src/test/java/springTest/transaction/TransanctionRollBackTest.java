package springTest.transaction;

import com.esther.code.modules.entity.User;
import com.esther.code.modules.service.IUserService;
import com.esther.code.modules.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author esther
 * 2018-03-30 15:19
 * $DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/config/applicationContext.xml", "classpath:/config/spring-servlet.xml" })
public class TransanctionRollBackTest {

    @Autowired
    private UserService userService;

    @Autowired
    private IUserService userServiceA;

    @Test
    public void parent() throws Exception{
        userService.parent();
    }

    @Test
    public void test(){
        User user=new User("jack","123456","jack","china","male",1);
        userServiceA.insert(user);
    }
}
