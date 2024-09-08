package com.sc.kuaizilive.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

//适用于springboot环境
//上传和下载工具类:
// SSM环境 （自己部署的tomcat服务器,地址是确定的）
//springboot环境(内置tomcat服务器,地址是虚拟的)
//如果换了环境 主要路径 /upload
public class UpdownUtilSpringBoot {
    public static String getPath(){
        String realPath= null;
        try {
            //获取内置tomcat虚拟路径
            realPath = ResourceUtils.getFile("classpath:").getPath();
            realPath=realPath+"/static/upload";
            //虚拟路径中 如果包含中文，要处理中文乱码
            realPath=URLDecoder.decode(realPath,"utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return realPath;
    }
    public static String upload(HttpServletRequest req, MultipartFile myHead){
        File f=new File(getPath());
        if(!f.exists()){ //文件如果不能存在 自动创建
            f.mkdirs();
        }
        //不上传头像 文件是空的 返回null
        if(myHead.isEmpty()){
            return null;
        }
        //获取上传的文件名  /upload  dog.png
        String fileName=myHead.getOriginalFilename();
        //上传的文件名 不能是存储的文件名,否则替换同名的文件
        //UUID会动态生成32位 永不重复字符串
        // 1.png        XXXXXXXX.png  存储文件名=随机名字+原后缀名
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        fileName= UUID.randomUUID()+suffix;
        //File.separator 动态斜杠 根据操作系统不同 自动分配 / \
        File file=new File(getPath()+File.separator+fileName);
        //文件上传的方法
        try {
            myHead.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
    public static ResponseEntity<byte[]> download(String fileName,HttpServletRequest req){
        ResponseEntity<byte[]> re= null;
        try {
            //1.获取头部信息
            HttpHeaders headers=new HttpHeaders();
            //2.设置文档类型设置成流
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //3.执行附件形式下载   附件attachment,下载后的文件名
            //3.1 封装好下载文件数据(byte[])
            String path=getPath()+File.separator+fileName;
            File f=new File(path);
            FileInputStream fis=new FileInputStream(f);
            byte[] bs=new byte[fis.available()];
            fis.read(bs);
            //3.2 如果文件名保存中文一定要处理
            fileName= URLEncoder.encode(fileName,"utf-8");
            headers.setContentDispositionFormData("attachment",fileName);
            //4.封装ResponseEntity对象 (数据,头部信息,状态)
            re = new ResponseEntity<>(bs,headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return re;
    }
    public static void delete(String fileName){
        File f=new File(getPath()+File.separator+fileName);
        if(f.exists()){
            f.delete();
        }
    }
}
