package springTest.basic;

import com.esther.code.modules.entity.TestModel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class EqualsTest {
	public static void main(String[] args) {
		int i = 1, j = 1;
		System.out.println(i == j);
		String string = new String("hello");
		String string1 = new String("hello");
		String string2 = new String("hello");
		System.out.println(string1 == string2);
		System.out.println(string1.equals(string2));
		string1 = string;
		string2 = string;
		System.out.println(string1 == string2);
		System.out.println(string1.equals(string2));

		System.out.println("-----------");
		TestModel t = new TestModel();
		TestModel t1 = new TestModel();
		TestModel t2 = new TestModel();
		System.out.println(t1 == t2);
		System.out.println(t1.equals(t2));
		t1 = t;
		t2 = t;
		System.out.println(t1.equals(t2));
		System.out.println("------------");

		Set<String> set = new HashSet<String>();
		set.add("aa");
		set.add("bb");
		if (set.contains("aa")) {
			System.out.println("already contains aa");
		}
		set.add("aa");
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
		}
		
		System.out.println("------------");
		
		// 7在常量池中，a1和a2都指向它的引用地址
		Integer a1 = 7;
		Integer a2 = 7;
		System.out.println(a1 == a2);

		// 178不在Integer范围（-128，127）内，故需要new一个实例，所以b1和b2不相等
		Integer b1 = 178;
		Integer b2 = 178;
		System.out.println(b1 == b2);
		
		System.out.println("------------");
		
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);
	}
}
