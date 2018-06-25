package com.esther.code.service.impl;

import com.esther.code.api.IDictService;
import com.esther.code.api.IUserService;
import com.esther.code.BaseJunit4Test;
import com.esther.code.dao.UserMapper;
import com.esther.code.model.Dict;
import com.esther.code.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseJunit4Test {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IDictService dictService;

    @Test
    public void testMapper() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void getUser() {
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void testDict() {
        Dict dict = dictService.selectByPrimaryKey(1);
        System.out.println(dict);
    }
}
