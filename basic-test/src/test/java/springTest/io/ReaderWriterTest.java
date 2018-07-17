package springTest.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ReaderWriterTest {

	public static void main(String[] args) {
		 
		File file = new File("d:/helloWorld2.txt");// 会覆盖之前的数据
		OutputStream out = null;
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(System.in);
			out = new FileOutputStream(file);
			int len = 0;
			while ((len = reader.read()) != -1) {
				out.write(len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		//键盘输入，控制台输出
		BufferedReader buff = null;
		BufferedWriter bufferedWriter = null;
		String line = null;
		try {
			buff = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
			while ((line = buff.readLine()) != null) {
				bufferedWriter.write(line);
			}
			bufferedWriter.flush(); // 一定要刷新
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
