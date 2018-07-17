package com.esther.code.modules.test;

import com.esther.code.modules.entity.Employee;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * BeanWrapper是Spring提供的一个用来操作JavaBean属性的工具，使用它可以直接修改一个对象的属性。
 * @author esther
 *
 */
public class BeanWrapperTest {

	public static void main(String[] args) {
		Employee employee = new Employee("jack", 12000, 2015, 5, 6);
		System.out.println(employee);
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(employee);
		bw.setPropertyValue("name", "enis");
		System.out.println(employee);
		PropertyValue pValue = new PropertyValue("salary", 15000);
		bw.setPropertyValue(pValue);
		System.out.println(employee);
	}

}
