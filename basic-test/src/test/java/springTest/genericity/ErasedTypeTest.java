package springTest.genericity;

import java.util.ArrayList;
import java.util.List;

public class ErasedTypeTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		MyNode mn = new MyNode(5);
		Node<Integer> n = mn; // A raw type - compiler throws an unchecked
								// warning
		n.setData(2); // Causes a ClassCastException to be thrown.
		Integer x = mn.data;
		System.out.println(x);

		List<String> ls = new ArrayList<>();
		System.out.println(ls.size());
		append(ls, String.class);
		System.out.println(ls.size());
	}

	public static <E> void append(List<E> list, Class<E> cls) throws InstantiationException, IllegalAccessException {
		E elem = cls.newInstance(); // compile-time error
		list.add(elem);
	}
}

class Node<T> {
	public T data;

	public Node(T data) {
		this.data = data;
	}

	public void setData(T data) {
		System.out.println("Node.setData");
		this.data = data;
	}
}

class MyNode extends Node<Integer> {
	public MyNode(Integer data) {
		super(data);
	}

	public void setData(Integer data) {
		System.out.println("MyNode.setData");
		super.setData(data);
	}
}