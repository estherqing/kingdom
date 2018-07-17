package springTest;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SpringTest extends Thread {

	public static void main(String[] args) {
		/*try {
			sleep(1000); 
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		 System.out.println("Hello World!");*/

		BigDecimal value=BigDecimal.valueOf(13223.3879);
		DecimalFormat df = new DecimalFormat("0.00");//四舍五入
		System.out.println(df.format(value));
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
}
