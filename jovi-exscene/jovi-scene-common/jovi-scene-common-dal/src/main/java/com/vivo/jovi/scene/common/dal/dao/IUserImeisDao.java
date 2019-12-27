package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.UserImeisEntity;

public interface IUserImeisDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserImeisEntity record);

    int insertSelective(UserImeisEntity record);

    UserImeisEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserImeisEntity record);

    int updateByPrimaryKey(UserImeisEntity record);

    UserImeisEntity selectByUserId(String userId);
}