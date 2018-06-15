package com.esther.code.simple.service.impl;

import com.esther.code.simple.api.IRoleService;
import com.esther.code.simple.dao.RoleMapper;
import com.esther.code.simple.model.Role;
import com.esther.code.simple.model.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author esther
 * 2018-06-15 16:24
 * $DESCRIPTION}
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int countByExample(RoleExample example) {
        return roleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoleExample example) {
        return roleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public List<Role> selectByExample(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Role record, RoleExample example) {
        return roleMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Role record, RoleExample example) {
        return roleMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
