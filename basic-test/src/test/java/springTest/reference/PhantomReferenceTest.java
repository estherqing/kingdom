package springTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用，不能单独使用，必须和引用队列ReferenceQueue联合使用，
 * 主要作用是跟踪对象被垃圾回收的状态，通过检查与虚引用关联的引用队列是否包含指定的虚引用，
 * 从而了解虚引用所引用的对象是否即将被回收。
 * @Decription:
 * @author Esther
 *
 */
public class PhantomReferenceTest {

	public static void main(String[] args) {
		String str = new String("hello world!");// "hello world!";
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		PhantomReference<String> pr = new PhantomReference<String>(str, rq);
		str = null;
		// 程序不能通过虚引用访问被引用的对象，此处为null
		System.out.println(pr.get());
		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// 取出引用队列中最先进入队列的引用，与pr比较
		System.out.println(rq.poll() == pr);
	}

}
