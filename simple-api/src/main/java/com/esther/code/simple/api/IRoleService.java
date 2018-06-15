package com.esther.code.simple.api;

import com.esther.code.simple.model.Role;
import com.esther.code.simple.model.RoleExample;

import java.util.List;

/**
 * @author esther
 * 2018-06-15 16:21
 * $DESCRIPTION}
 */

public interface IRoleService {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(Role record, RoleExample example);

    int updateByExample(Role record, RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
