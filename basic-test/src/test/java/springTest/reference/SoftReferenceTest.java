package springTest.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 
 * @ClassName: SoftReferenceTest
 * @Description: 对于只有软引用的对象而言，当系统内存空间足够时，它不会被系统回收，程序也可使用该对象；当系统内存空间不足时，系统将会回收它。
 * @author esther
 * @date 2017年4月10日 下午9:52:34
 *
 */
public class SoftReferenceTest {

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		SoftReference<Person>[] people = new SoftReference[100000];
		for (int i = 0; i < people.length; i++) {
			people[i] = new SoftReference<Person>(new Person("name" + i, (i + 1) * 4 % 100));
		}
		System.out.println(people[2].get());
		System.out.println(people[4].get());
  
		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// 垃圾回收机制运行之后，SoftReference数组里的元素保持不变
		System.out.println(people[2].get());
		System.out.println(people[4].get());
	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Person [ name = ");
		sb.append(name);
		sb.append(", age = ");
		sb.append(age);
		sb.append(" ]");
		return sb.toString();
	}
}
