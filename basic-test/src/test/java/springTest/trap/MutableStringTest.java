package springTest.trap;

/**
 * 可变序列：StringBuiler和StringBuffer，唯一区别，后者线程安全
 * @author Esther
 *
 */
public class MutableStringTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");
		System.out.println(sb);
		System.out.println(System.identityHashCode(sb));
		sb.append(" world");
		System.out.println(sb);
		System.out.println(System.identityHashCode(sb));
	}

}
