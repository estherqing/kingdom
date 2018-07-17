package springTest.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {

	public static void main(String[] args) {
		// 输入
		File file = new File("d:/helloWorld.txt");
		InputStream in = null;
		try {
			if (!file.exists()) { // 文件不存在则创建
				file.createNewFile();
			}
			in = new FileInputStream(file);
			byte[] buf = new byte[1024]; // 先写到缓存中，然后再一起写到其他外设中
			int length = 0;
			while ((length = in.read(buf)) != -1) { // -1 represent the end of
													// the file is reached ，
													// 字节一个一个地读入到内存
				System.out.println(new String(buf, 0, length)); // 需要将int转为字节，如果为中文的话输出乱码字符
																// ，
				// 此处其实是写出到了外设（控制台）上，System.out返回的是PrintStream对象
			}
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
		}

		// 输出
		File ofile = new File("d:/helloworld2.txt"); // 没有<span style="font-family:KaiTi_GB2312;">会自动创建</span>
		OutputStream out = null;
		try {
			if (!file.exists()) { // 文件不存在则创建
				file.createNewFile();
			}
			out = new FileOutputStream(ofile);
			out.write(100); // 文件中产生ASC码对应的字符
			String string="hello world2......";
			out.write(string.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//从一个文件复制到另一个文件 
		//FileInputStream  & FileOutputStream   协同完成文件复制(不会乱码) 
		File origin = new File("d:/helloWorld.txt");//原始文件  
        if (!origin.exists()){  
            try {  
                origin.createNewFile();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        File destination = new File("d:/helloWorld4.txt");//目的文件  
        InputStream in2 = null;  
        OutputStream out2 = null;  
        try {  
            in2 = new FileInputStream(origin);  
            out2 = new FileOutputStream(destination);  
            byte [] buff = new byte[1024];  
            int len = 0;  
            while ((len=in2.read(buff))!=-1){  
                out2.write(buff,0,len);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (in2 != null){  
                    in2.close();  
                }  
                if (out2 != null){  
                    out2.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
	}

}
