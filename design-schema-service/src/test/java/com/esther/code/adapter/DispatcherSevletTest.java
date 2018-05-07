package com.esther.code.adapter;

import com.esther.code.schema.service.adapter.springmvc.DispatcherServlet;
import com.esther.code.schema.service.adapter.springmvc.controller.impl.AnnotationController;
import com.esther.code.schema.service.adapter.springmvc.controller.impl.HttpController;
import com.esther.code.schema.service.adapter.springmvc.controller.impl.SimpleController;

/**
 * @author esther
 * 2018-05-04 14:31
 * $DESCRIPTION}
 */

public class DispatcherSevletTest {
    public static void main(String[] args) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        HttpController httpController = new HttpController();
        AnnotationController annotationController = new AnnotationController();
        SimpleController simpleController = new SimpleController();

        dispatcherServlet.doDispatch(httpController);

        System.out.println("_______________________");
        dispatcherServlet.doDispatch(annotationController);

        System.out.println("________________________");
        dispatcherServlet.doDispatch(simpleController);

    }
}
