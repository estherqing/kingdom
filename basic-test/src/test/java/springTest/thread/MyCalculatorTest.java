package springTest.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCalculatorTest {

	private int groupNum = 10;
	/**
	 * 开始和结束开关
	 */
	private CountDownLatch startSwitch = new CountDownLatch(1);

	private CountDownLatch stopSwitch = new CountDownLatch(groupNum);
	/**
	 * 线程池
	 */
	private ExecutorService service = Executors.newFixedThreadPool(groupNum);
	/**
	 * 保存计算结果
	 */
	private List<Future<Integer>> result = new ArrayList<Future<Integer>>();

	/**
	 * 启动groupNum条线程计算数值
	 */
	public void init() {

		for (int i = 1; i <= groupNum; i++) {
			result.add(service.submit(new MyCalculator(startSwitch, stopSwitch, i)));
		}
		System.out.println("init is ok!");
	}

	public void printRes() throws InterruptedException, ExecutionException {

		int sum = 0;

		for (Future<Integer> f : result) {
			sum += f.get();
		}
		System.out.println("the result is " + sum);
	}

	public void start() {
		this.startSwitch.countDown();
	}

	public void stop() throws InterruptedException {
		this.stopSwitch.await();
		this.service.shutdown();
	}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		MyCalculatorTest MyCalculatorTest = new MyCalculatorTest();
		MyCalculatorTest.init();
		System.out.println("please enter start command....");

		reader.readLine();
		MyCalculatorTest.start();
		MyCalculatorTest.stop();

		MyCalculatorTest.printRes();
	}
}