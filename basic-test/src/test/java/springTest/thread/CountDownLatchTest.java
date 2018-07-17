package springTest.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author esther
 * 2018-07-13 10:20
 * CountDownLatch.await() 方法在倒计数为0之前会阻塞当前线程。
 */

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish
        System.out.println("work is done.");

        //当 startSignal.await() 会阻塞线程，当 startSignal.countDown() 被调用之后，所有 Worker 线程开始执行 doWork() 方法，
        // 所以 Worker.doWork() 是几乎同时开始执行的。当 Worker.doWork() 执行完毕后，调用 doneSignal.countDown()，在所有 Worker 线程执行完毕之后，主线程继续执行。
    }

    private static void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        }
    }

    void doWork() {
        System.out.println("Worker's working.");
    }
}
