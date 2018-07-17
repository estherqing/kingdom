package springTest.thread;

public class StaticThreadInitTest {
	// 静态初始化
	static {
		Thread t = new Thread() {
			public void run() {
				System.out.println("进入run方法");
				System.out.println(website);
				website = "www.taobao.com";
				System.out.println("退出run方法");
			}
		};
		t.start();

		// 注释掉下面的join()方法，再查看运行结果
		// try {
		// t.join();// 启动一条新线程，main线程必须等待新线程执行完毕
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// 加上下面的代码试试
		// try {
		// Thread.sleep(1);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

	}
	static String website = "www.baidu.com";

	public static void main(String[] args) {
		System.out.println(StaticThreadInitTest.website);
	}

}
