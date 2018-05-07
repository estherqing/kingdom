package com.esther.code.schema.service.adapter.springmvc.controller.impl;

import com.esther.code.schema.api.adapter.springmvc.Controller;

/**
 * @author esther
 * 2018-05-04 14:16
 * $DESCRIPTION}
 */

public class HttpController implements Controller {
    public void doHttpHandler() {
        System.out.println("执行HttpController.doHttpHandler()");
    }
}
