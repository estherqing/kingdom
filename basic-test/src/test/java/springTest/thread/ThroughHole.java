package springTest.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThroughHole {
	static Object hole = new Object();

	public static void main(String[] args) {
		Random r = new Random();
		String[] names = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		// List<String> list = Arrays.asList(names);

		List<String> nameList = new ArrayList<String>(Arrays.asList(names));

		while (nameList.size() > 0) {
			int i = r.nextInt(nameList.size());
			final String name = nameList.remove(i);
			System.out.println(name + " is starting");
			new Thread(new Runnable() {

				@Override
				public void run() {
					synchronized (hole) {
						System.out.println(name + ": is throughing");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();// 改成.run()方法执行试试看;
			/**
			 * run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，
			 * 还是要顺序执行，还是要等待run方法体执行完毕后才可继续执行下面的代码，这样就没有达到写线程的目的。
			 * 
			 * 
			 * 用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。
			 * 通过调用Thread类的start()方法来启动一个线程，这时此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，
			 * 就开始执行run()方法，这里方法 run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程随即终止。
			 * 
			 * 
			 * 调用start方法方可启动线程，而run方法只是thread的一个普通方法调用，还是在主线程里执行。这两个方法应该都比较熟悉，
			 * 把需要并行处理的代码放在run()方法中，start()方法启动线程将自动调用
			 * run()方法，这是由jvm的内存机制规定的。并且run()方法必须是public访问权限，返回值类型为void
			 */

		}

	}
}
