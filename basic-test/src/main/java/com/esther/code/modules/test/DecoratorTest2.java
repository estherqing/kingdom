package com.esther.code.modules.test;

import com.esther.code.modules.decorator2.ChickenBurger;
import com.esther.code.modules.decorator2.Chilli;
import com.esther.code.modules.decorator2.Humburger;
import com.esther.code.modules.decorator2.Lettuce;

public class DecoratorTest2 {
	public static void main(String[] args) {
		Humburger humburger = new ChickenBurger();
		System.out.println(humburger.getName() + "  价钱：" + humburger.getPrice());
		Lettuce lettuce = new Lettuce(humburger);
		System.out.println(lettuce.getName() + "  价钱：" + lettuce.getPrice());
		Chilli chilli = new Chilli(humburger);
		System.out.println(chilli.getName() + "  价钱：" + chilli.getPrice());
		Chilli chilli2 = new Chilli(lettuce);
		System.out.println(chilli2.getName() + "  价钱：" + chilli2.getPrice());
	}
}
