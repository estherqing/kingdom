package springTest.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		
		try {
			// 创建一个ServerSocket，监听8080端口
			ServerSocket serverSocket = new ServerSocket(8080);
			System.out.println("服务器端启动。。。。");
			while(true) {
				// 等待请求
				Socket socket = serverSocket.accept();
				System.out.println("有新的客户端连接了。。");
				//  接收请求后使用Socket进行通信，创建BufferedReade`r用于读取数据
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 接收数据
				String line = bufferedReader.readLine();
				System.out.println("客户端输入的数据Received from client:" + line);
				// 创建PrintWriter用于发送数据
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				// 发送数据
				printWriter.println("服务器返回的数据received data:" + line);
				printWriter.flush();
				// 关闭资源
				printWriter.close();
				bufferedReader.close();
				//socket.close();
				//serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
