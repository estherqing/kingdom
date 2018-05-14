package com.esther.code.api;

import com.esther.code.model.User;
import com.esther.code.model.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author esther
 * 2018-04-18 15:48
 * $DESCRIPTION}
 */

public interface IUserService {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUserListForFlowNode(@Param("flowType") String flowType,@Param("flowNode") String flowNode);
}
