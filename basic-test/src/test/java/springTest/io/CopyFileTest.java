package springTest.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1.首先创建File对象，并且和需要操作的文件相关联，这时候需要对文件进行判断是否存在，不存在则会报错
 * 
 * 2.既然是读取文件并且写到文件，属于纯文本，可以选择FileReader和FileWriter进行读写操作,如果出现乱码可以使用其父类指定编码方式
 * 
 * 3.创建FileReader对象用于读取文件中的数据，这里可以使用缓冲流进行处理，提高效率，创建一个BufferedReader对象
 * 
 * BufferedReader buffr = new BufferedReader(new InputStreamReader(new
 * FileReader(file)));
 * 
 * 4.创建FileWriter，同上使用缓存
 * 
 * @author E2
 *
 */
public class CopyFileTest {

	public static void main(String[] args) {
		File origin = new File("d:/helloWorld.txt");
		File destination = new File("d:/helloWorld6.txt");
		InputStreamReader in = null;
		OutputStreamWriter out = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		if (!origin.exists()) {
			try {
				origin.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(origin), "ISO-8859-1"));
			// reader = new BufferedReader(new FileReader(origin));//中文乱码  
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "ISO-8859-1"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
