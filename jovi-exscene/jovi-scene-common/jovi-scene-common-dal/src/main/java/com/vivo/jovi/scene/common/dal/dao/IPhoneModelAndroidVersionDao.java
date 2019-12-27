package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.PhoneModelAndroidVersionEntity;

import java.util.List;

public interface IPhoneModelAndroidVersionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PhoneModelAndroidVersionEntity record);

    int insertSelective(PhoneModelAndroidVersionEntity record);

    PhoneModelAndroidVersionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhoneModelAndroidVersionEntity record);

    int updateByPrimaryKey(PhoneModelAndroidVersionEntity record);

    List<PhoneModelAndroidVersionEntity> selectByType(Integer type);
}