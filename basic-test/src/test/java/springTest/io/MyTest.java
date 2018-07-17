package springTest.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyTest {

	public static void main(String[] args) {
		File from = new File("d:/helloworld.txt");
		File to=new File("d:/hellworld1.txt");
		InputStream in = null;
		OutputStream out = null;
		InputStreamReader reader = null;
		OutputStreamWriter writer=null;
		BufferedReader bReader=null;
		BufferedWriter bWriter=null;
		
		if (!from.exists()) {
			try {
				from.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			in = new FileInputStream(from);
			out = new FileOutputStream(to);
			reader = new InputStreamReader(in,"ISO-8859-1");
			writer=new OutputStreamWriter(out, "ISO-8859-1");
			//out的流写法
			/**
			int len = 0;
			while ((len = reader.read()) != -1) {
				out.write(len);
			}
			**/
			//缓冲写法
			bReader=new BufferedReader(reader);
			bWriter=new BufferedWriter(writer);
			String line=null;
			while((line=bReader.readLine())!=null){
				bWriter.write(line);
				bWriter.newLine();
			}
			bWriter.flush();//刷新流，必须写
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
		}

	}

}
