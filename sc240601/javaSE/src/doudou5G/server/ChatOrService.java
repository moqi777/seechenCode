package doudou5G.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:与客服聊天界面
 * @DateTime:2024/7/6 16:25
 **/
public class ChatOrService {
    //定义静态变量用于通知子线程该关闭了
    static boolean exit = false;
    public ChatOrService() {
        System.out.println("\n*****欢迎进入兜兜客服群聊，兜兜客服将回答您所遇到的问题*****");
        System.out.println("兜兜客服：尊敬的 "+Index.nowMobileCard.getCardNumber()+" 用户您好，请问您有什么需要？(如需退出输入\"退出\"即可)");
        try {
            Socket client = new Socket("localhost", 9999);
            String cardNumber = Index.nowMobileCard.getCardNumber();
            while (true){
                //定义线程监听来的信息
                new ChatOrServiceThreat(client).start();
                String next = Index.scanner.next();
                client.getOutputStream().write((cardNumber+"："+next+"\n").getBytes());
                if (next.contains("退出")) {
                    exit = true;
                    System.out.println("兜兜客服：祝您生活愉快，再见");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChatOrServiceThreat extends Thread{
    private Socket client;
    public ChatOrServiceThreat(Socket client){
        this.client = client;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            while (!ChatOrService.exit){
                String msg = br.readLine();//此时线程阻塞，断开连接前就会进入到这里，所以要在下面再次进行一次判断是否断开了
                if (msg.equals("再见")) {
                    return;
                }
                if (msg!=null){
                    System.out.println("兜兜客服："+msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

