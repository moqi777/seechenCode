package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:模拟多人聊天室
 * @DateTime:2024/7/2 17:19
 **/
public class Server3 {
    //用于保存进入聊天室的客户端对象
    static List<Socket> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //创建服务端对象
        ServerSocket server = new ServerSocket(9999);
        //死循环 等待无数个客户端连接 保存进入聊天室的客户端对象
        System.out.println("***********多人聊天室开启成功*********");
        while (true){
            Socket client = server.accept();
            list.add(client);//类似于进入群聊
            System.out.println("聊天室"+list.size()+"人");
            //创建每个客户端的线程单独处理每个人的任务
            new ServerThread3(client).start();
        }
    }
}

class ServerThread3 extends Thread{
    Socket client;
    public ServerThread3(Socket client){
        this.client = client;
    }
    //创建每个客户端的线程 去监听每个客户端写入的数据
    //将读到的信息 群发其他客户端（除了当前哪个客户端）
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = br.readLine();
                if(msg!=null){
                    //在服务端传输一次数据
                    System.out.println(msg);
                    if(msg.contains("退出")){//退出聊天室
                        Server3.list.remove(client);
                        System.out.println("聊天室的人数："+Server3.list.size());
                        break;
                    }
                    //接收到传递过来的信息向其他客户端转发数据
                    for (Socket s : Server3.list) {
                        if(s!=client){//对象只需要比较地址
                            try {
                                s.getOutputStream().write((msg+"\n").getBytes());
                            }catch (SocketException e){
                                //对list中其他的用户可能断开连接导致传输信息失败进行捕获
                                System.out.println(s+"退出了");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

    }
}
//向服务端写入数据（控制台输入），接收服务端返回的数据
class Client3{
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        //开启客户端线程 监听服务器信息
        new ClientThread3(client).start();
        //1.控制台输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2.向服务端写
        OutputStream os = client.getOutputStream();
        System.out.println("请输入你的姓名");
        String name = br.readLine();
        while (true){
            System.out.println("请输入内容：esc退出聊天室");
            String msg = br.readLine();
            if (msg!=null){
                if ("esc".equals(msg)){
                    os.write((name+"退出聊天室\n").getBytes());
                    break;
                }else {
                    os.write((name+"说："+msg+"\n").getBytes());
                }
            }
        }
        System.out.println("退出聊天室");
    }
}
//3.监听服务端返回的数据（单独写个线程处理）
class ClientThread3 extends Thread{
    Socket client;
    public ClientThread3(Socket client){
        this.client=client;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = br.readLine();
                if (msg!=null) System.out.println(msg);
            }
        }catch (Exception e){

        }
    }
}

