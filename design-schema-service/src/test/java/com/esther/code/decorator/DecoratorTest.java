package com.esther.code.decorator;

import com.esther.code.api.schema.decorator.IProgrammer;
import com.esther.code.api.schema.service.decorator.DesignDecorator;
import com.esther.code.api.schema.service.decorator.JavaProgrammer;
import com.esther.code.api.schema.service.decorator.TestDecorator;

/**
 * @author esther
 * 2018-05-07 16:48
 * $DESCRIPTION}
 */

public class DecoratorTest {
    public static void main(String[] args) {
        IProgrammer programmer=new JavaProgrammer();
        DesignDecorator designDecorator=new DesignDecorator(programmer);
        TestDecorator testDecorator=new TestDecorator(designDecorator);
        testDecorator.coding();
    }
}


