package com.esther.code.schema.service.adapter.springmvc.controller.impl;

import com.esther.code.schema.api.adapter.springmvc.Controller;

/**
 * @author esther
 * 2018-05-04 14:15
 * $DESCRIPTION}
 */

public class SimpleController implements Controller {
    public void doSimplerHandler(){
        System.out.println("执行SimpleController.doSimplerHandler()");
    }
}
