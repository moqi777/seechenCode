package com.seechen.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 18:44
 **/
public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocket sercer = new ServerSocket(9999);
        Socket client = sercer.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s = reader.readLine();
        System.out.println(s);
    }
}

