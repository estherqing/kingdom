package springTest.thread;

/**
 * 
 * @Description 模拟多线程下的取钱
 * @author esther
 * @date 2017年4月13日 上午10:10:09
 *
 */
public class DrawMoneyTest {

	public static void main(String[] args) {
		Account account = new Account("No123456", 1000);
		new DrawThread("甲", account, 800).start();
		new DrawThread("乙", account, 800).start();

		/**
		 * 可能的运行结果： 乙取钱成功！吐出钞票：800.0 余额为：200.0 甲取钱成功！吐出钞票：800.0 余额为：-600.0
		 **/
	}

}

class DrawThread extends Thread {
	private Account account;
	private double drawMoney;

	public DrawThread(String name, Account account, double drawMoney) {
		super(name); // 线程的名字
		this.account = account;
		this.drawMoney = drawMoney;
	}

	public void run() {
		account.drawMoney(drawMoney);
	}
}

class Account {
	private String accountNo;
	private double balance;

	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	// 对drawMoney加synchronized同步，消除多线程共享变量的问题
	// 或使用synchronized(this)同步代码块
	public void drawMoney(double drawMoney) { 
		if (balance >= drawMoney) {
			// 下面的sleep方法显示切换线程，不是必须的，实际中也可能发生这种线程切换
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawMoney);
			balance -= drawMoney;
			System.out.println("\t余额为：" + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足。");
		}
	}

	@Override
	public int hashCode() {
		return (accountNo == null) ? 0 : accountNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj != null && obj.getClass() == this.getClass()) {
			Account account = (Account) obj;
			return account.accountNo.equals(accountNo);
		}
		return false;
	}

}
