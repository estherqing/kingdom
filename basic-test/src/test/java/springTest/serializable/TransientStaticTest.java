package springTest.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @ClassName: TransientStaticTest 
 * @Description: 使用transient关键字不序列化某个变量
 * 这说明反序列化后类中static型变量username的值为当前JVM中对应static变量的值，为修改后jmwang，而不是序列化时的值Alexia。
 * @author esther
 * @date 2017年3月21日 上午9:50:19
 *
 *1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 *2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 *3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 */
public class TransientStaticTest {

	 public static void main(String[] args) {
	        
	        User user = new User();
	        user.setUsername("Alexia");
	        user.setPasswd("123456");
	        
	        System.out.println("read before Serializable: ");
	        System.out.println("username: " + user.getUsername());
	        System.err.println("password: " + user.getPasswd());
	        
	        try {
	            ObjectOutputStream os = new ObjectOutputStream(
	                    new FileOutputStream("user.txt"));
	            os.writeObject(user); // 将User对象写进文件
	            os.flush();
	            os.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            // 在反序列化之前改变username的值
	            User.username = "jmwang";
	            
	            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
	                    "user.txt"));
	            user = (User) is.readObject(); // 从流中读取User的数据
	            is.close();
	            
	            System.out.println("\nread after Serializable: ");
	            System.out.println("username: " + user.getUsername());
	            System.err.println("password: " + user.getPasswd());
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}

	class User implements Serializable {
	    private static final long serialVersionUID = 8294180014912103005L;  
	    
	    public static String username;
	    private transient String passwd;
	    
	    public String getUsername() {
	        return username;
	    }
	    
	    public void setUsername(String username) {
	        User.username = username;
	    }
	    
	    public String getPasswd() {
	        return passwd;
	    }
	    
	    public void setPasswd(String passwd) {
	        this.passwd = passwd;
	    }

	}
