package springTest.basic;

public class Test3 {
	public static void main(String[] args) {
		System.out.println(fun(12345678));
		System.out.println("-----------");
		InnerTest inner = new InnerTest();
		Test t = inner.get(3);
		System.out.println(t.getI());
		System.out.println("-----------");
		new InnerClass() {
			public void print() { /// ——————
				System.out.println(this.getClass().getName() + " Do nothing.");
			}
		}.print();
		System.out.println("-----------");
		System.out.println(Math.round(11.5) + "," + Math.round(-11.5));
		System.out.println("-----------");
	}

	public static String fun(int num) {
		if (num >= 10) {
			System.out.println(num % 10 + "," + num / 10);
			return (num % 10) + fun(num / 10);
		} else {
			return String.valueOf(num);
		}
	}
}

class Test { // 超类

	private int i;

	public Test(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}
}

class InnerTest { // 用于内部类的测试

	public Test get(int x) {
		return new Test(x) { // 创建匿名内部类，调用父类的构造方法

			@Override
			public int getI() {
				return super.getI() * 10;
			}
		};
	}
}

class InnerClass {
	public void print() {
		System.out.println(this);
	}
}
