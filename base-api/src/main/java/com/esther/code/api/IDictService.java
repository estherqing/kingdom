package com.esther.code.api;

import com.esther.code.model.Dict;
import com.esther.code.model.DictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author esther
 * 2018-04-18 15:49
 * $DESCRIPTION}
 */

public interface IDictService {
    int countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);
}
