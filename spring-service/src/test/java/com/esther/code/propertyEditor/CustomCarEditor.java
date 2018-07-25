package com.esther.code.propertyEditor;

import com.esther.code.factoryBean.Car;
import java.beans.PropertyEditorSupport;

/**
 * @author esther
 * 2018-07-25 10:20
 * $DESCRIPTION}
 */
public class CustomCarEditor extends PropertyEditorSupport {

    //1. 将字面值转换为属性类型对象
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.indexOf(",") == -1) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setPrice(Double.parseDouble(infos[1]));
        car.setMaxSpeed(Integer.parseInt(infos[2]));

        //2. 调用父类的setValue()方法设置转换后的属性对象
        setValue(car);
        System.out.println("调用了自定义的车辆类型转换器" + car);
    }
}
