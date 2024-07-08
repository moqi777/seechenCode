package doudou5G;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:服务器
 * @DateTime:2024/7/6 16:27
 **/
public class Services {
    static Scanner scanner = new Scanner(System.in);
    //确保只会有一个连接，只有一个客服
    static Socket NowClient = null;
    public static void main(String[] args) throws IOException {
        ServerSocket service = new ServerSocket(9999);
        System.out.println("启动服务器成功");
        while (true){
            Socket client = service.accept();//开始监听是否有人请求进线
            //判断客服在不在忙
            if (NowClient==null){
                System.out.println("用户进线");
                //将NowClient占用，防止其他用户进线
                NowClient = client;
                //等于空说明没在忙，可以建立连接
                //用于接收客户端的信息，如果客户端发来断开连接的请求就在子线程中将NowClient设置为null，这样下个客户端就能进来了
                new ServicesThread(client).start();
                //用户服务端输入信息传给客户端
                new ServicePrint(client).start();
            }else {
                //进入到这里说明客服在忙，回复一条信息表示客服正在忙
                client.getOutputStream().write("客服繁忙".getBytes());
            }
            //然后就进入到下一次循环监听
        }
    }
}
//客服接收信息控制台输出线程
class ServicesThread extends Thread{
    private Socket client;
    public ServicesThread(Socket client) {
        this.client = client;
    }
    public void run() {
        try{
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = br.readLine();
                if (msg!=null){
                    //输出用户的话
                    System.out.println(msg);
                    //如果用户出入退出就将NowClient设置为空，并退出线程使该线程死亡
                    if (msg.contains("退出")){
                        Services.NowClient = null;
                        System.out.println("用户退出");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//定义一个客服输入线程
class ServicePrint extends Thread{
    private Socket client;
    public ServicePrint(Socket client) {
        this.client = client;
    }
    public void run() {
        //只有NowClient不为空的时候这个子线程才会循环执行
        while (Services.NowClient!=null){
            try {
                String next = Services.scanner.next();//此时线程阻塞，断开连接前就会进入到这里，所以要在下面再次进行一次判断是否断开了。断开连接被唤醒
                //如果断开了，发最后一次确认断开的信息，然后循环结束，这一步很重要
                if (Services.NowClient==null) {
                    System.out.println("111111111111");
                    client.getOutputStream().write(("再见\n").getBytes());
                    return;
                }
                client.getOutputStream().write((next+"\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("线程意外死亡");
            }
        }
    }
}

