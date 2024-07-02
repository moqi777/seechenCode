package day7;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试客户端
 * @DateTime:2024/7/2 15:43
 **/
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);
        OutputStream os = client.getOutputStream();
            //写入信息
            os.write(("你好"+"\n").getBytes());
    }
}

