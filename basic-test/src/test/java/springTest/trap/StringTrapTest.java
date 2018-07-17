package springTest.trap;

public class StringTrapTest {

	public static void main(String[] args) {
		String str = "hello world的长度：11";
		String newStr = "hello " + "world的长度：11";// 都是字符直接量，在编译时确定，指向字符缓冲池中的常量

		String subStr = "hello ";
		String nStr = subStr + "world的长度：11";// 包含变量，运行时确定

		final String sub = "hello ";
		String sStr = sub + "world的长度：11";// 包含宏替换，编译时确定

		String mStr = "hello world的长度：" + "hello world".length();// 包含方法，运行时确定

		System.out.println(str == newStr);// true
		System.out.println(str == nStr);// false
		System.out.println(str == sStr);// true
		System.out.println(str == mStr);// false
		System.out.println(str.equals(newStr));
		
		str = "hello";
		newStr = "hello";
		char v1[] = str.toCharArray();
		char v2[] = newStr.toCharArray();
		int i = 0;
		int n = 5;
		int flag = 1;
		while (n-- != 0) {
			if (v1[i] != v2[i])
				flag = 0;
			System.out.println(n + "," + i);
			i++;
		}
		System.out.println(flag);
	}

}
