package com.esther.springboot.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObject {

    private int code;

    private String desc;

    private Object data;

    public ResultObject(int code) {
        this.code = code;
    }

    public ResultObject(int code, Object data) {
        this.code = code;
        this.data = data;
    }
}
