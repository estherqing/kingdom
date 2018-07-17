package springTest.reference;

import java.lang.ref.WeakReference; 

/**
 * 弱引用，所引用的对象的生命周期更短
 * 
 * @Description: 对于只有弱引用的对象而言，当系统垃圾回收机制运行时，不管系统内存是否足够，总会回收该对象所占用的内存。
 * 警惕空指针异常NullPointerException
 * @author esther
 *
 */
public class WeakReferenceTest {

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		WeakReference<Person2>[] people = new WeakReference[100];
		for (int i = 0; i < people.length; i++) {
			people[i] = new WeakReference<Person2>(new Person2("name" + i, (i + 1) * 4 % 100));
		}
		System.out.println(people[2].get());
		System.out.println(people[4].get());
		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// 垃圾回收机制运行之后，WeakReference数组里的元素为空
		System.out.println(people[2].get());
		System.out.println(people[4].get());

		String str = new String("hello world");
		//如换成str="hello world"，系统会缓存这个字符串直接量（会使用强引用来引用它），系统不会回收被缓存的字符串常量。
		WeakReference<String> wr = new WeakReference<String>(str);
		str = null;
		System.out.println(wr.get());//hello world
		
		System.gc();
		System.runFinalization();
		
		System.out.println(wr.get());//null
	}

}
