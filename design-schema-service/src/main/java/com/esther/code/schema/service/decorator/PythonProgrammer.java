package com.esther.code.schema.service.decorator;

import com.esther.code.schema.api.decorator.IProgrammer;

/**
 * @author esther
 * 2018-05-07 16:41
 * $DESCRIPTION}
 */

public class PythonProgrammer implements IProgrammer {
    @Override
    public void coding() {
        System.out.println("Python程序员编码。");
    }
}
