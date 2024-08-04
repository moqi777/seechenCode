package com.sc.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:文件上传下载工具类：只适用于SSM项目
 * @DateTime:2024/8/4 14:48
 **/
public class UpDownUtil {
    //上传通用方法
    public static String upload(HttpServletRequest req, MultipartFile multipartFile){
        //文件保存地址：存储在服务器的特定包（后期可以存储在云服务器）
        //假设在服务器定义一个包：upload 专门保存上传的地址
        //获取项目运行的真实路径 得到：真实路径+/upload/
        String path = req.getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if (!file.exists()) file.mkdirs();
        //文件名：由于会替换不能拿上传名字保存 需要唯一处理
        // a.jpg 文件名(随机的：随机数 时间戳 UUID)+后缀名(固定不变的)
        //1.获取提交的文件名
        String oldName = multipartFile.getOriginalFilename();
        //2.获取后缀名
        int lastIndexOf = oldName.lastIndexOf(".");
        String suffixName = oldName.substring(lastIndexOf);
        //3.保存文件名需要随机 UUID：32位不重复的字符串
        String name = UUID.randomUUID().toString();
        //4.新文件名
        String newName = name+suffixName;
        File f = new File(path + newName);
        //开始上传
        try {
            multipartFile.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newName;
    }
}
