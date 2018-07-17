package springTest.basic;

public class Agg {
	public static void main(String argv[]) {
		Agg a = new Agg();
		a.go();
	}

	public void go() {
		DSRoss ds1 = new DSRoss("one");
		ds1.start();
	}
}

class DSRoss extends Thread {
	private String sTname = "";

	DSRoss(String s) {
		sTname = s;
	}

	public void run() {
		notwait();
		System.out.println("finished");
	}

	public void notwait() {
		while (true) {
			try {
				System.out.println("waiting");
				wait();//wait()必须在Synchronize块或者函数里
			} catch (InterruptedException ie) {
			}
			System.out.println(sTname);
			notifyAll();
		}
	}
}
