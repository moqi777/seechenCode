package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:scoket通过多线程接收数据
 * @DateTime:2024/7/2 16:39
 **/
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true){
            Socket client = server.accept();
            System.out.println(client+"连接成功");
            //通过线程负责每个客户端的读写任务
            new ServerThread(client).start();
        }
    }
}
//客户端数据通过Scanner动态写入
class Client2{
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);
        OutputStream os = client.getOutputStream();
        //System.in 系统输入流 读取控制台的输入的数据
        //Scanner是基于它的封装
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //添加一个客户端线程：负责接受服务端返回的数据
        while (true){
            System.out.print("请输入你要向服务端写入的内容：");
            String msg = br.readLine();
            os.write((msg+"\n").getBytes());
        }
    }
}
//服务端线程：目的是监控每一个人数据读写
class ServerThread extends Thread{
    Socket client;
    public ServerThread(Socket client){
        this.client = client;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                String clientMsg = br.readLine();
                System.out.println(client.getInetAddress()+"："+clientMsg);
            }
        } catch (IOException e) {

        }

    }
}