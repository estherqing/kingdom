package springTest.thread;

class ThreadA {
	public static void main(String[] args) {
		ThreadC b2=new ThreadC();
		b2.start();
		System.out.println("是否持有b2的资源锁："+Thread.holdsLock(b2));
		
		ThreadB b = new ThreadB();
		b.start();
		System.out.println("b is start...."); 
		
		synchronized (b)// 定义一个同步块,使用b作为资源锁
		{
			//检测一个线程是否持有对象监视器
			System.out.println("是否持有b的资源锁："+Thread.holdsLock(b));
			
			System.out.println("同步。。。");
			 try {
				System.out.println("Waiting for b to complete...");
				b.wait();// 这一句是什么意思，究竟让谁wait?
				b.notify();
				//临时释放锁，并阻塞当前线程,好让其他使用同一把锁的线程有机会执行,在这里要用同一把锁的就是b线程本身
				System.out.println("Completed.Now back to main thread");
			 } 
			 catch (InterruptedException e) {
			 }
			 finally {
				
			}
		}  
		System.out.println("Total is :" + b.total);
		 
	}
}

class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			System.out.println("ThreadB is running..");
			for (int i = 0; i < 10; i++) {
				total += i;
				System.out.println("total is " + total);
			}
			//notify();
			System.out.println("notify.....");
		}
	}
}
class ThreadC extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			System.out.println("ThreadC is running..");
			for (int i = 0; i < 10; i++) {
				total += i;
				System.out.println("c--total is " + total);
			}
			//notify();
			System.out.println("c--notify.....");
		}
	}
}
