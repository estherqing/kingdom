package com.esther.code.dao;

import com.esther.code.model.Dict;
import com.esther.code.model.DictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {
    Dict selectByPrimaryKey(Integer id);

    int countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);
}