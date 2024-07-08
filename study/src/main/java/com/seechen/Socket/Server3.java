package com.seechen.Socket;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/7 16:13
 **/
public class Server3 {
    static List<Socket> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(9999);
        System.out.println("服务开启成功");
        while (true){
            Socket client = server.accept();
            list.add(client);
            System.out.println("聊天室"+list.size()+"人");
            new ServerThread3(client).start();
        }
    }
}

class ServerThread3 extends Thread{
    private Socket client;
    public ServerThread3(Socket client){
        this.client=client;
    }

    public void run() {
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = br.readLine();
                if (msg != null){
                    System.out.println(msg);
                    if (msg.contains("退出")){
                        Server3.list.remove(client);
                        System.out.println("聊天室的人数："+Server3.list.size());
                        break;
                    }
                    for (Socket s : Server3.list) {
                        if (s!=client){
                            s.getOutputStream().write(((msg+"\n")).getBytes());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client3{
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        new ClientThread3(client).start();
        Scanner scanner = new Scanner(System.in);
        OutputStream os = client.getOutputStream();
        System.out.println("请输入你的姓名");
        String name = scanner.next();
        while (true){
            System.out.println("请输入内容：esc退出聊天室");
            String msg = scanner.next();
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

