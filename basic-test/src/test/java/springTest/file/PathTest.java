package springTest.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get("user.dir");
		System.out.println(path);
		
		System.out.println(System.getProperty("user.dir"));

		File file = new File("/Users/esther/logs/springTest/2017-04-01/user.log");
		if (!file.exists()) {
			try {
				System.out.println("not exist");
				file.createNewFile();
				System.out.println(file.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.getName() + "," + file.length());
	}

}
