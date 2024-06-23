package com.seechen.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:登录系统
 * @DateTime:2024/6/23 16:45
 **/
public class LoginSystem {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //有一个存储了所有用户信息的对象
        List<User> list = null;
        //从文件中读取这个集合
        try (FileInputStream fis = new FileInputStream("user.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);){
            list = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            //文件不存在，list初始化失败
            //e.printStackTrace();
            list = new ArrayList<>();
        }catch (EOFException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //list初始化完成
        int c = 0;//选择的数值
        User u = null;//标识当前登录的用户
        while (true){
            System.out.println("1.登录 2.注册 3.退出");
            c=sc.nextInt();
            if(c==1){
                u = login(list);
//                if (u!=null){
//                    //二级菜单
//                }
            }else if(c==2){
                register(list);
            }else {
                exit(list);
            }
        }
    }

    public static User login(List<User> list){
        //让用户输入账号密码，验证是否存在这个账号
        //并将获取到的用户返回回去
        System.out.println("请输入账号：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        for (User u : list) {
            //循环集合，看在是否存在这个用户
            if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
                System.out.println("登录成功!");
                return u;
            }
        }
        //没有这个用户
        System.out.println("账号或密码错误！");
        return null;
    }
    public static void register(List<User> list){
        System.out.println("请输入账号：");
        String username = sc.next();
        //账号是否存在
        for (User u : list) {
            if (u.getUsername().equals(username)){
                System.out.println("账号已存在");
                return;
            }
        }
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请输入昵称：");
        String nickname = sc.next();
        //创建user对象，添加进List
        User user = new User(username, password, nickname);
        list.add(user);
    }
    public static void exit(List<User> list){
        try(FileOutputStream fos = new FileOutputStream("user.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

