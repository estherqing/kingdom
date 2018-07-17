package com.esther.code.modules.service;

import com.esther.code.modules.entity.User;
import com.esther.code.modules.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esther
 * 2018-04-02 15:57
 * $DESCRIPTION}
 */
@Service("userServiceB")
public class UserServiceImpl2 implements IUserService2 {
    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.NOT_SUPPORTED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int insertB(User user) {
        return userMapper.insert(user);
    }
}
