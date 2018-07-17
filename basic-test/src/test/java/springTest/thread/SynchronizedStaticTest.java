package springTest.thread;

/**
 * 
 * @Description 静态同步方法和以当前类为同步监视器（锁）的同步代码块不能同步执行，因为锁都是类本身
 * @author esther
 * @date 2017年4月12日 下午5:37:26
 *
 */
public class SynchronizedStaticTest implements Runnable {

	public static boolean staticFlag = true;

	// 静态同步方法的锁为类本身
	public static synchronized void test0() {
		for (int i = 0; i < 100; i++) {
			System.out.println("test0---" + Thread.currentThread().getName() + ":" + i);
		}
	}
	

	// 非静态同步代码块的锁为this，即调用该方法的java对象
	public void test1() {
		synchronized (this) { // 修改为SynchronizedStaticTest.class试试，锁变成类本身，而不是this的对象，证明了静态同步方法的锁为类本身
			for (int i = 0; i < 100; i++) {
				System.out.println("test1---" + Thread.currentThread().getName() + ":" + i);
			}
		}
	}

	@Override
	public void run() {
		if (staticFlag) {
			staticFlag = false;
			test0(); // 获取类的锁
		} else {
			staticFlag = true;
			test1(); // 获取this对象的锁
		}

	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedStaticTest ss = new SynchronizedStaticTest();
		new Thread(ss).start();
		// Thread.sleep(1);
		new Thread(ss).start();
	}

}
