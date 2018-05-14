package com.esther.code.singleton;

import com.esther.code.api.schema.singleton.lazy.Singleton;
import org.junit.Test;

/**
 * @author esther
 * 2018-05-11 16:32
 * $DESCRIPTION}
 */

public class SingletonTest {

    @Test
    public void test() {
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
    }

}
