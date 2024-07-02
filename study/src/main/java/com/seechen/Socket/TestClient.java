package com.seechen.Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 18:44
 **/
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        OutputStream os = client.getOutputStream();
        os.write("你好\n".getBytes());
    }
}

