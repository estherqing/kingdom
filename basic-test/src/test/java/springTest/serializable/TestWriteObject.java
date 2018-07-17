package springTest.serializable;

import com.esther.code.modules.serializable.Course;
import com.esther.code.modules.serializable.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * [1].当一个对象被序列化时，只保存对象的非静态成员变量，不能保存任何的成员方法,静态的成员变量和transient标注的成员变量。
 * [2].如果一个对象的成员变量是一个对象，那么这个对象的数据成员也会被保存还原，而且会是递归的方式。
 * [3].如果一个可序列化的对象包含对某个不可序列化的对象的引用，那么整个序列化操作将会失败，并且会抛出一个NotSerializableException。
 * 可以将这个引用标记transient,那么对象仍然可以序列化。
 * 
 * @author E2
 *
 */

// 将对象写入文件序列化
public class TestWriteObject {
	public static void main(String[] args) {
		String filePath = "obj.txt";
		ObjectOutputStream objOutput = null;
		Course c1 = new Course("C language", 3);
		Course c2 = new Course("OS", 4);
		Student s1 = new Student("king", 25);
		s1.setCourse(c1);
		s1.schoolName = "HIT";
		Student s2 = new Student("jason", 23);
		s2.setCourse(c2);
		s2.schoolName = "BD";
		try {
			objOutput = new ObjectOutputStream(new FileOutputStream(filePath));
			objOutput.writeObject(s1);
			objOutput.writeObject(s2);
			objOutput.writeInt(123);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Info:对象被写入" + filePath);
	}
}
