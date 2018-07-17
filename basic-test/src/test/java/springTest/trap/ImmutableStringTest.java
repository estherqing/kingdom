package springTest.trap;

public class ImmutableStringTest {

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		str += " world";
		System.out.println(System.identityHashCode(str));
	}

}
