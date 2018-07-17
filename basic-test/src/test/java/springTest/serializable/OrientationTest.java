package springTest.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class OrientationTest {

	private static ObjectInputStream inputStream;

	public static void main(String[] args) {
		Orientaion original = Orientaion.HORIZOTAL;
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("orientation.txt"));
			outputStream.writeObject(original);
			outputStream.close();

			inputStream = new ObjectInputStream(new FileInputStream("orientation.txt"));
			try {
				Orientaion saved = (Orientaion) inputStream.readObject();
				if (saved == Orientaion.HORIZOTAL) {
					// 增加readResolve方法之后，返回true
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Orientaion implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	public static final Orientaion HORIZOTAL = new Orientaion(1);
	public static final Orientaion VERTICAL = new Orientaion(2);
	private int value;

	private Orientaion(int v) {
		value = v;
	}

	/**
	 *
	 * @Description: 特殊的序列化方法，在对象被序列化之后调用，必须返回一个对象，该对象就是readObject的返回值。
	 * @param @return
	 *            设定文件 @return Object 返回类型 @throws
	 */
	protected Object readResolve() {
		if (value == 1)
			return Orientaion.HORIZOTAL;
		if (value == 2)
			return Orientaion.VERTICAL;
		return null;
	}

}
