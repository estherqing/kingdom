package com.esther.code;


import com.esther.code.model.Test;
import com.esther.code.util.BeanPropertyUtils;
import com.esther.code.vo.TestVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author esther
 * 2018-06-22 17:45
 * $DESCRIPTION}
 */

public class Demo {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        TestVo testVo = new TestVo();
        Test test = new Test(1,"rose",22);
//        BeanPropertyUtils.copyProperties(testVo,test);
//        System.out.println(testVo);

        BeanUtils.copyProperties(test,testVo);
        System.out.println(testVo);
    }
}
