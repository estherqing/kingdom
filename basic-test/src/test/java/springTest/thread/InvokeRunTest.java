package springTest.thread;

public class InvokeRunTest extends Thread {

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			if (i == 20) {
				new InvokeRunTest().start();// 换成run()方法试试
				new InvokeRunTest().start();
			}
		}
	}

}
