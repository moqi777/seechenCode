package day7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试服务端
 * @DateTime:2024/7/2 15:44
 **/
public class TestServer {
    public static void main(String[] args) throws IOException {
        //1.创建对象
        ServerSocket server = new ServerSocket(9999);
        while (true){
            //2.等待客户端连接
            Socket client = server.accept();//阻塞
            System.out.println(client+"连接成功");
            //获取输入流
            InputStream is = client.getInputStream();
            //读取信息
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            System.out.println(s);
        }
    }
}

