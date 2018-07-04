package com.esther.code.controller;

import com.esther.code.spring.api.ILogService;
import com.esther.code.spring.model.Log;
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
@RequestMapping("/log")
public class LogController {
    @Autowired
    private ILogService logService;

    @ResponseBody
    @RequestMapping("/get")
    public String get(Integer id){
        Log user= logService.getById(id);
        return WebUtil.getSuccessJson(user);
    }


}
