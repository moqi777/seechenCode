package com.ssm.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc://文件上传下载工具类：只适用于SSM项目
 * @DateTime:2024/8/16 11:25
 **/
@Component
public class UpDownUtil {
    //上传通用方法
    public String upload(HttpServletRequest req, MultipartFile multipartFile){
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
        //如果不穿文件 直接返回null
        if ("".equals(oldName)) return null;
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
    //下载通用方法
    public ResponseEntity download(String fileName, HttpServletRequest req){
        //1.获取请求头信息
        HttpHeaders headers = new HttpHeaders();
        //2.设置文档类型 原来默认是text/html 设置成流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] bytes = new byte[0];
        try {
            //2.1设置文件名编码方式 如果文件名是中文也可以识别（可选）
            fileName = URLEncoder.encode(fileName, "utf-8");
            //3.指定附件形式下载，参数1：属性名附件；参数2：下载后的文件名
            headers.setContentDispositionFormData("attachment",fileName);
            //4.指定返回值 ResponseEntity<byte[]>
            //参数1：下载的文件的字节数组
            //参数2：请求头部信息
            //参数3：响应实体的状态(新建状态)
            File file = new File(req.getServletContext().getRealPath("/upload/") + fileName);
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(bytes,headers, HttpStatus.CREATED);
    }
}
