package com.esther.code;

import com.esther.code.simple.api.IRoleService;
import com.esther.code.simple.model.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author esther
 * 2018-06-15 17:30
 * $DESCRIPTION}
 */

public class ServiceTest extends BaseJunit4Test {
    @Autowired
    private IRoleService roleService;

    @Test
    public void testService() {
        Role role = roleService.selectByPrimaryKey(1L);
        System.out.println(role);
    }
}
