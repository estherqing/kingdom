package com.esther.code.schema.service.decorator;

import com.esther.code.schema.api.decorator.IProgrammer;

/**
 * @author esther
 * 2018-05-07 16:40
 * 业务类
 */

public class JavaProgrammer implements IProgrammer {
    @Override
    public void coding() {
        System.out.println("Java程序员编码。");
    }
}
