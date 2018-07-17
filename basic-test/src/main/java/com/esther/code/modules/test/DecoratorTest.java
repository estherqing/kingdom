package com.esther.code.modules.test;


import com.esther.code.modules.decorator.*;

public class DecoratorTest {

	public static void main(String[] args) {
		Human person = new Person();
		Decorator decorator = new Decorator_two(new Decorator_first(new Decorator_zero(person)));
		decorator.wearClothes();
		decorator.walkToWhere();

	}

}
