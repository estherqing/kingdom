package springTest.threadLocal;

import java.util.HashMap;

public class ThreadLocalTest {

	static ThreadLocal<HashMap<Integer, Integer>> map0 = new ThreadLocal<HashMap<Integer, Integer>>() {
		/**
		 * 返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。
		 * 这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。
		 * ThreadLocal中的缺省实现直接返回一个null。
		 */
		@Override
		protected HashMap<Integer, Integer> initialValue() {
			System.out.println(Thread.currentThread().getName() + "initialValue");
			return new HashMap<Integer, Integer>();
		}
	};

	public void run() {
		Thread[] runs = new Thread[3];
		for (int i = 0; i < runs.length; i++) {
			runs[i] = new Thread(new T1(i));
		}
		for (int i = 0; i < runs.length; i++) {
			runs[i].start();
		}
	}

	public static class T1 implements Runnable {
		int id;

		public T1(int id0) {
			id = id0;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + ":start");
			HashMap<Integer, Integer> map = map0.get();
			for (int i = 0; i < 10; i++) {
				map.put(i, i + id * 100);
				try {
					map0.set(map);
					Thread.sleep(100);
				} catch (Exception ex) {
				}
			}
			System.out.println(Thread.currentThread().getName() + ':' + map0.get());
		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadLocalTest test = new ThreadLocalTest();
		test.run();
		//运行结果：
//		Thread-0:start
//		Thread-1:start
//		Thread-1initialValue
//		Thread-0initialValue
//		Thread-2:start
//		Thread-2initialValue
//		Thread-2:{0=200, 1=201, 2=202, 3=203, 4=204, 5=205, 6=206, 7=207, 8=208, 9=209}
//		Thread-1:{0=100, 1=101, 2=102, 3=103, 4=104, 5=105, 6=106, 7=107, 8=108, 9=109}
//		Thread-0:{0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9}
		/**
		 * 1：可以看到map0 虽然是个静态变量，但是initialValue被调用了三次，通过debug发现，initialValue是从map0.get处发起的。
		 * 而且每个线程都有自己的map，虽然他们同时执行。
		 *:2：这说明ThreadLocal确实只有一个变量，但是它内部包含一个map，针对每个thread保留一个entry，
		 * 如果对应的thread不存在则会调用initialValue。
		 */
	}

}
