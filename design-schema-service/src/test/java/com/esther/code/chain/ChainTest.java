package com.esther.code.chain;

import com.esther.code.schema.api.chain.AbstractHandler;
import com.esther.code.schema.service.chain.ConcreteHandlerA;
import com.esther.code.schema.service.chain.ConcreteHandlerB;
import com.esther.code.schema.service.chain.ConcreteHandlerC;
import com.esther.code.schema.service.pipeline.BasicValve;
import com.esther.code.schema.service.pipeline.SecondValve;
import com.esther.code.schema.service.pipeline.ThirdValve;

/**
 * @author esther
 * 2018-05-23 17:53
 * $DESCRIPTION}
 */

public class ChainTest {
    public static void main(String[] args) {
        AbstractHandler handlerA = new ConcreteHandlerA();
        AbstractHandler handlerB = new ConcreteHandlerB();
        AbstractHandler handlerC = new ConcreteHandlerC();
        // 如A处理不掉转交给B
        handlerA.setHandler(handlerB);
        handlerB.setHandler(handlerC);
        handlerA.handleRequest("A");
        System.out.println("-----------------------");

        handlerA.handleRequest("B");
        System.out.println("-----------------------");

        handlerA.handleRequest("C");


        String handling = "aabb1122zzyy";
        BasicValve basicValve = new BasicValve();
        SecondValve secondValve = new SecondValve();
        ThirdValve thirdValve = new ThirdValve();
        // 责任链模式的写法
        basicValve.setNext(secondValve);
        secondValve.setNext(thirdValve);
        basicValve.invoke(handling);
    }
}
