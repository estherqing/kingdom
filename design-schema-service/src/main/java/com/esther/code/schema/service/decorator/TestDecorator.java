package com.esther.code.schema.service.decorator;

import com.esther.code.schema.api.decorator.Decorator;
import com.esther.code.schema.api.decorator.IProgrammer;

/**
 * @author esther
 * 2018-05-07 16:47
 * $DESCRIPTION}
 */

public class TestDecorator extends Decorator {
    public TestDecorator(IProgrammer programmer) {
        super(programmer);
    }

    @Override
    public void coding() {
        super.coding();
        System.out.println("编码后再测试。");
    }
}