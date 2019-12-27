package com.vivo.jovi.scene.common.exception;

/**
 * @author WangWenqian
 * @version 1.0
 * @describe
 * @date 2017/12/22
 */
public class HttpClientException extends RuntimeException{

    public HttpClientException(){

    }

    public HttpClientException(String s){
        super(s);
    }

    public HttpClientException(String s, Exception e) {
        super(s,e);
    }
}
