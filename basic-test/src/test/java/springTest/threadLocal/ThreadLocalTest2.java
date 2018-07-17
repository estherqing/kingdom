package springTest.threadLocal;


import com.esther.code.modules.entity.Employee;

public class ThreadLocalTest2 {

	static ThreadLocal<Employee> map0 = new ThreadLocal<Employee>() {
		@Override
		protected Employee initialValue() {
			System.out.println(Thread.currentThread().getName() + ":initialValue employee");
			return new Employee();
		}
	};

	static ThreadLocal<Long> time = new ThreadLocal<Long>() {
		@Override
		protected Long initialValue() {
			System.out.println(Thread.currentThread().getName() + ":initialValue time");
			return System.currentTimeMillis();
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
			long startTime = 0;
			long endTime = 0;
			Employee employee = map0.get();
			try {
				startTime = System.currentTimeMillis();
				time.set(startTime);
				employee = new Employee("jack" + id, 100 + id);
				map0.set(employee);
				Thread.sleep(1000);
				endTime = System.currentTimeMillis();
			} catch (Exception ex) {
			}
			System.out.println(Thread.currentThread().getName() + "(" + time.get() + "," + endTime + "):" + map0.get());
		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadLocalTest2 test = new ThreadLocalTest2();
		test.run();
	}

}
