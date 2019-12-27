package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.AnswerCountEntity;

import java.util.List;

public interface IAnswerCountDao {

    int insertSelective(AnswerCountEntity record);

    int updateByPrimaryKeySelective(AnswerCountEntity record);

    List<AnswerCountEntity> getSelective(AnswerCountEntity record);
}