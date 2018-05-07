package com.esther.code.controller;

import com.esther.code.schema.api.IUserService;
import com.esther.code.model.User;
import com.esther.code.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author esther
 * 2018-04-18 16:02
 * $DESCRIPTION}
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/get")
    public String get(Integer id){
        User user= userService.selectByPrimaryKey(id);
        return WebUtil.getSuccessJson(user);
    }


}
