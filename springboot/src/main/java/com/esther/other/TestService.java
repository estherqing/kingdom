package com.esther.other;

public class TestService {
    public TestService() {
        System.out.println("这是一个不在springboot扫描范围内的测试类");
    }

    public String test(){
        return "这是一个不在springboot扫描范围内的测试类";
    }
}
