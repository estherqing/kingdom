package springTest.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;

/**
 * 
 * @ClassName: InputStreamTest
 * @Description: 要从文件"file.dat"中读出第10个字节到变量c中
 * @author esther
 * @date 2017年3月20日 下午7:43:24
 *
 */
public class InputStreamTest {

	private static RandomAccessFile in2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream out = new FileOutputStream("file.dat");

		byte[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		out.write(b);
		out.close();

		FileInputStream in = new FileInputStream("file.dat");
		in.skip(9); // 跳过前面的9个字节
		int c = in.read();
		System.out.println(c); // 输出为10
		in.close();

		in2 = new RandomAccessFile("file.dat", "r");
		in2.skipBytes(9);
		int c2 = in2.readByte();
		System.out.println(c2);

		PushbackInputStream pbin = new PushbackInputStream(new BufferedInputStream(new FileInputStream("file.dat")));
		int bb;
		while ((bb = pbin.read()) != -1) {
			if (bb == 5) {
				pbin.unread(bb);
			} else {
				System.out.println(bb);
			}
		}
		pbin.close();
	}

}
