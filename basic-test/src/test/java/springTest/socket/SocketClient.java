package springTest.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		 String mString="Client data";
		 try {
			 //创建一个Socket，和本机的8080端口连接
			Socket socket=new Socket("localhost",8080);
			//使用Socket创建PrintWriter和BufferedReader进行数据读写
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream()); 
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//发送数据
			printWriter.println("客户端输入的数据："+mString);
			printWriter.flush();
			//接收数据
			String line=bufferedReader.readLine();
			System.out.println("Received from server:"+line);
			//关闭资源
			printWriter.close();
			bufferedReader.close();
			//socket.close();
		} catch (UnknownHostException e) {  
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

}
