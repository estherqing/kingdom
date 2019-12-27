package com.esther.springboot.controller;

import com.esther.other.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "helloworld", produces = "test测试")
@RestController
public class HelloWorldController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "测试", notes = "测试")
    public String test() {
        //return "Dear,Hello World!";
        return testService.test();
    }
}
