package springTest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class MyCalculator implements Callable<Integer> {
	/**
	 * 开始开关
	 */
	private CountDownLatch startSwitch;
	/**
	 * 结束开关
	 */
	private CountDownLatch stopSwitch;
	/**
	 * 要计算的分组数
	 */
	private int groupNum;

	/**
	 * 构造函数
	 */
	public MyCalculator(CountDownLatch startSwitch, CountDownLatch stopSwitch, Integer groupNum) {
		this.startSwitch = startSwitch;
		this.stopSwitch = stopSwitch;
		this.groupNum = groupNum;
	}

	@Override
	public Integer call() throws Exception {

		startSwitch.await();
		int res = compute();
		System.out.println(Thread.currentThread().getName() + " is ok wait other thread...");
		stopSwitch.countDown();
		stopSwitch.await();
		System.out.println(
				Thread.currentThread().getName() + " is stop! the group" + groupNum + " temp result is sum=" + res);
		return res;
	}

	/**
	 * 累计求和
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public int compute() throws InterruptedException {
		int sum = 0;
		for (int i = (groupNum - 1) * 10 + 1; i <= groupNum * 10; i++) {
			sum += i;
		}
		return sum;
	}
}
