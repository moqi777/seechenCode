package com.seechen.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 18:51
 **/
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true){
            Socket client = server.accept();
            System.out.println(client+"连接成功");
            new ServerThread2(client).start();
        }
    }
}

class Client{
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream os = client.getOutputStream();
        while (true){
            String s = reader.readLine();
            os.write((s+"\n").getBytes());
        }
    }
}

class ServerThread2 extends Thread{
    Socket client;
    public ServerThread2(Socket client){
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                String s = reader.readLine();
                System.out.println(client.getInetAddress()+"："+s);
            }
        } catch (Exception e) {

        }
    }
}

