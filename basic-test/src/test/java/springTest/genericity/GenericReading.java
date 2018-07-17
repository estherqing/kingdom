package springTest.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @ClassName: GenericReading
 * @Description: 对于实现了<? extends T>的集合类只能将它视为Producer向外提供(get)元素，
 *               而不能作为Consumer来对外获取(add)元素。 ”Producer Extends, Consumer Super”：
 *               “Producer Extends” – 如果你需要一个只读List，用它来produce T，那么使用? extends
 *               T。 “Consumer Super” – 如果你需要一个只写List，用它来consume T，那么使用? super T。
 *               如果需要同时读取以及写入，那么我们就不能使用通配符了。
 * @author esther
 * @date 2017年3月28日 下午5:26:50
 *
 */

public class GenericReading {
	static List<Banana> bananas = Arrays.asList(new Banana());
	static List<Fruit> fruit = Arrays.asList(new Fruit());

	static class Reader<T> {
		// List<T>加了通配符List<? extends T>，编译不会出错
		T readExact(List<? extends T> list) {
			return list.get(0);
		}
	}

	static void f1() {
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		// Errors: List<Fruit> cannot be applied to List<Banana>.
		Fruit f = fruitReader.readExact(bananas);
		System.out.println(f);
	}

	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}

	static void f2() {
		writeExact(bananas, new Banana());
		writeExact(fruit, new Banana());
	}

	static <T> void writeWithWildcard(List<? super T> list, T item) {
		list.add(item);
	}

	static void f3() {
		writeWithWildcard(bananas, new Banana());
		writeWithWildcard(fruit, new Banana());
	}

	public static void main(String[] args) {
		f1();
		// f2();// 编译出错
		// f3();// 编译出错

		// Wildcards allow covariance:
		List<? extends Fruit> flist = new ArrayList<Banana>();
		// Compile Error: can't add any type of object:
		// flist.add(new Banana());
		// flist.add(new Orange());
		// flist.add(new Fruit());
		// flist.add(new Object());
		flist.add(null); // Legal but uninteresting
		// We Know that it returns at least Fruit:
		Fruit f = flist.get(0);
		System.out.println(f);

		List<? super Fruit> list = new ArrayList<Fruit>();
		list.add(new Banana());
		list.add(new Fruit());
		System.out.println(list.get(1));
	}
}

class Fruit {
}

class Banana extends Fruit {
}

class Orange extends Fruit {
}