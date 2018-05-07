package com.esther.code.schema.service.impl;

import com.esther.code.schema.api.IUserService;
import com.esther.code.dao.UserMapper;
import com.esther.code.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author esther
 * 2018-04-18 17:00
 * $DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring/applicationContext.xml"})
public class UserServiceTest  {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser() {
        User user=userMapper.selectByPrimaryKey(1);
        User user2 = userService.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
