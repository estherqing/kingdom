package springTest.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 
 * @ClassName: FastCopyFileTest
 * @Description: 如何快速复制1G的大文件
 * @author esther
 * @date 2017年3月21日 下午4:41:38
 *
 */
public class FastCopyFileTest {
	public static void main(String[] args) throws Exception {

		getInputStream("user2.txt", "to.txt");

	}

	private static void getInputStream(String pathName, String copyName) throws Exception {

		File file = new File(pathName);

		if (!file.exists()) {
			file.createNewFile();
			throw new RuntimeException("文件不存在呀！");
		} else {

			getCopy(copyName, new BufferedInputStream(new FileInputStream(file)));

		}

	}

	private static void getCopy(String copyName, BufferedInputStream bis) throws Exception {

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyName));

		BufferedInputStream biss = bis;

		byte[] b = new byte[biss.available()];

		int len = 0;

		while ((len = biss.read(b)) != -1) {

			bos.write(b, 0, len);

		}

		bos.close();

		biss.close();

		System.out.println(copyName + "复制成功！");

	}

}
