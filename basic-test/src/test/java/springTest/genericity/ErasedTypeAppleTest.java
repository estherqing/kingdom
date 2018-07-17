package springTest.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description
 * @author esther
 * @date 2017年4月12日 下午1:47:13
 *
 */
public class ErasedTypeAppleTest {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		Apple<Integer> apple = new Apple<Integer>(6);
		Integer size = apple.getSize();
		System.out.println(size);
		System.out.println(apple.getApples());// 返回List<String>
		for (String string : apple.getApples()) {
			System.out.println(string);
		}

		Apple rawApple = apple;// 类型擦除，包括所有的尖括号里的信息
		Number number = rawApple.getSize();
		Integer i = (Integer) rawApple.getSize();
		System.out.println(number);
		System.out.println(rawApple.getApples());// 返回List
		for (Object string : rawApple.getApples()) { // 类型为Object
			System.out.println(string);
		}
	}

}

class Apple<T extends Number> {
	private T size;

	public Apple() {
	}

	public Apple(T size) {
		this.size = size;
	}

	public T getSize() {
		return size;
	}

	public void setSize(T size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Apple [size=" + size + "]";
	}

	public List<String> getApples() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list.add(new Apple<Integer>(10 * i).toString());
		}
		return list;
	}

}
