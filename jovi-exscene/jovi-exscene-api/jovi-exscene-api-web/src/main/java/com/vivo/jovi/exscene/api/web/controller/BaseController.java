package com.vivo.jovi.exscene.api.web.controller;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-03-29
 */
public class BaseController {

    String getTraceSource(Exception e){
        if(e!=null && e.getStackTrace()!=null) {
            StackTraceElement[] traces = e.getStackTrace();
            if(traces.length>0) {
                return traces[0].toString();
            }
        }
        return null;
    }
}
