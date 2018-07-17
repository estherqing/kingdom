package springTest.genericity;

public class Box<T> {
	// T stands for "Type"
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	//边界符
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0) // e>elm compiler error,可能是如string类型的不能用>的比较
				++count;
		return count;
	}

	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		Box<Double> doubleBox = new Box<Double>();
		Box<String> stringBox = new Box<String>();
		integerBox.set(1);
		doubleBox.set(1.11);
		stringBox.set("hello");
		System.out.println(integerBox.get());
		Double d = doubleBox.get();
		System.out.println(d);
		System.out.println(stringBox.get());

		Integer[] integers = { 1, 2, 3, 4, 5, 6 };
		int c = Box.countGreaterThan(integers, 2);
		System.out.println(c);
	}
}
