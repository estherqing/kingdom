package com.esther.code.api.schema.service.adapter.springmvc.controller.impl;

import com.esther.code.api.schema.adapter.springmvc.Controller;

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
