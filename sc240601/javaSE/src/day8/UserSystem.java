package day8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:Socket综合案例（面向对象+集合+IO+线程+Socket+异常处理）
 * @DateTime:2024/7/3 14:03
 **/
//one：注册(系列化) 登录(序列化，正常登录，多次时间免登录) 退出
//two：聊天功能...
public class UserSystem {
    public static String nowUser;
    public static Scanner sc = new Scanner(System.in);
    //用来保存所有注册成功的用户信息，ArrayList实现了Serializable接口，所以可以被序列化
    public static List<User> users = new ArrayList<>();
    static {//随着类加载执行一次（注意放在新建users后面，否者读取保存后会被new users操作清空）
        //本地读取（反序列化）    最开始读取更加适合
        in();
    }
    //周期线程池，进行延迟操作，定时30s关闭登录验证，如果退出手动调用shutdownNow();
    static ScheduledThreadPoolExecutor ses = new ScheduledThreadPoolExecutor(1);
    public static void main(String[] args) {
        one();
    }
    public static void one(){//一级菜单
        while (true){
            System.out.println("****XXX用户系统****");
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("3.退出");
            System.out.println("*******************");
            int n = sc.nextInt();//输入数字
            switch (n){
                case 1: reg();break;
                case 2: login();break;
                case 3:
                    ses.shutdownNow();
                    //checkCookie会验证返回现在所登录的用户，传入delCookie，删除cookie文件中该user
                    delCookie(checkCookie());
                    System.out.println("退出系统");
                    return;
                default: System.out.println("无效指令，请重新输入");
            }
        }
    }
    public static void two(User user){//二级菜单
        while (true){
            System.out.println("用户"+user.phone+"登录成功");
            System.out.println("1.聊天功能");
            System.out.println("2.退出登录");
            System.out.println("0.返回上级");
            int n =sc.nextInt();
            switch (n){
                case 1:chat(user);break;
                case 2:logOut(user);break;
                case 0:return;
            }
        }
    }
    public static void reg(){//注册功能
        System.out.println("****开始进行注册****");
        System.out.println("请输入手机号：");
        //输入的内容后期可以添加不同的验证...
        //如果手机号重复了 也是注册失败...
        String phone = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        //对用户名是否存在和重复输入密码是否一致进行一系列验证，允许输入的手机号为汉字，即识别为用户名，在此就不多做处理
        if (checkReg(phone, password)){
            //将注册成功的用户信息存储到list中
            users.add(new User(phone,password));
            //本地保存（序列化）
            out();
            System.out.println("注册成功!!!");
        }else {
            System.out.println("注册失败");
        }
    }
    public static boolean checkReg(String phone,String password){
        //对users集合进行遍历看一下注册的用户是否已存在
        for (User user : users) {
            if (user.phone.equals(phone)){
                System.out.print("该用户已存在，");
                return false;
            }
        }
        System.out.println("请输入确认密码：");
        String passwordTo = sc.next();
        if (!password.equals(passwordTo)){
            System.out.print("两次密码不一致，");
            return false;
        }
        //验证成功 返回true
        return true;
    }
    public static void login(){//登录功能
        System.out.println("****开始进行登录****");
        //验证一下是否登录过 如果是就可以免登录
        User checkUser = checkCookie();
        if (checkUser!=null){//验证缓存成功 进入二级
            two(checkUser);return;
        }
        //输入账号密码
        System.out.println("请输入账号：");
        String phone = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        //匹配账号密码是否正确(本地集合users匹配 以后根据数据库匹配)
        for (User user : users) {
            if(user.phone.equals(phone) && user.password.equals(password)){
                //正确 提示一下是否模拟缓存 设置这个缓存存活时间 进入二级菜单
                System.out.println("是否(Y/N)本地缓存你的登录信息，30s有效期");
                String yn = sc.next();
                if ("y".equalsIgnoreCase(yn)){//不区分大小写
                    //开始缓存
                    addCookie(user);
                    nowUser = user.phone;
                    //设置时间30s有效期(前期通过周期线程池 后期redis自带方法控制时间)
                    ses.schedule(()->{
                        nowUser = null;
                        delCookie(user);
                    },30, TimeUnit.SECONDS);
                }
                two(user);return;
            }
        }
        //错误 重新登录
        System.out.println("账号密码输入失败，请重新登录");
    }
    public static void chat(User user){
        //消息发送方(当前登录账号)和接收方(手动输入)
        System.out.println("********开始聊天********");
        System.out.println("请输入对方的手机号：");
        String toPhone = sc.next();
        //判断输入的手机号是否和当前登录用户一样，如果是，返回并提示

        try {
            Socket client = new Socket("localhost", 9999);
            //创建客户端线程 用来实现监听信息
            new UserClientThread(client).start();
            //第一次写入数据告诉服务端 发送方 和 接收方
            client.getOutputStream().write((user.phone+"=>"+toPhone+"\n").getBytes());
            System.out.println("输入你要向 "+toPhone+" 说的内容，如果想退出请输入退出");
            while (true){
                String msg = sc.nextLine();
                if (msg.contains("退出")){
                    client.getOutputStream().write((user.phone+"退出\n").getBytes());
                    break;
                }
                client.getOutputStream().write((msg+"\n").getBytes());
            }
            System.out.println("退出聊天功能");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void logOut(User user){
        System.out.println("退出登录");
        delCookie(user);
        //代码待完成
    }
    public static void out(){//序列化(写)
        //借助于try(){}catch(){} 来实现异常处理
        //try(创建流的代码) try结束后自动关闭流 无需手动关闭
        try (FileOutputStream fos = new FileOutputStream("./javaSE/src/day8/users.xx");
             ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(users);
            System.out.println("用户集合保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void in(){//反序列化
        //第一次如何处理 File对象处理 异常处理
//        File file = new File("./javaSE/src/day8/users.xx");
//        if (file.exists()){
//            //正常反序列化
//        }else {
//            System.out.println("第一次使用该系统");
//        }
        try (FileInputStream fis = new FileInputStream("./javaSE/src/day8/users.xx");
        ObjectInputStream ois = new ObjectInputStream(fis)){
            users = (List<User>)ois.readObject();
        }catch (FileNotFoundException e){
            System.out.println("欢迎你第一次使用本系统");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //添加缓存（根据账号）
    public static void addCookie(User u){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./javaSE/src/day8/cookie.xx"))){
            List<String> cookies = new ArrayList<>();
            cookies.add(u.phone);
            oos.writeObject(cookies);
            //并将已登录的用户存入nowUser
            nowUser = u.phone;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //删除缓存
    public static void delCookie(User u){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./javaSE/src/day8/cookie.xx"))){
            List<String> cookies = (List<String>) ois.readObject();//先读取cookie文件
            cookies.remove(u.phone);
            //同时读写会有冲突，分开来
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./javaSE/src/day8/cookie.xx"));
            oos.writeObject(cookies);//将删除了该用户的list重新写进文件
            oos.close();
            //将nowUser赋值为空
            nowUser = null;
            System.out.println("用户登录信息失效");
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //验证缓存
    public static User checkCookie(){
        if (!(nowUser==null)){
            for (User user : users) {
                if (user.phone.equals(nowUser)) return user;
            }
        }
        return null;
    }
}

class User implements Serializable {//用户类 注册 登录 聊天。。。
    String phone;//手机号——账号
    String password;//密码
    public User() {}
    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}

//Socket服务端实现私聊功能
class UserServer{
    //定义一个Map集合 key表示手机号 Value对应的客户端对象
    static Map<String,Socket> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("启动用户服务端成功");
        while (true){
            Socket client = server.accept();
            //线程处理每个用户消息 读写
            new UserServerThread(client).start();
        }
    }
}

class UserServerThread extends Thread{
    Socket client;
    public UserServerThread(Socket client){
        this.client=client;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            //客户端 发送消息只要包含发送方 和 接收方
            String msg = br.readLine();
            String from = msg.split("=>")[0];//发送方
            String to=msg.split("=>")[1];//接收方
            //如果服务器map集合中没有这个用户，创建一个socket对象，并存储进map中
            if (!UserServer.map.containsKey(from)) UserServer.map.put(from,client);

            //服务端用户状态提示log
            System.out.print(from+"上线，目前在线的有：");
            for (String s : UserServer.map.keySet()) {
                System.out.print(s+"   ");
            }
            System.out.println();

            while (true){
                msg = br.readLine();//客户端发送真正的消息
                if(msg!=null){
                    if (msg.contains("退出")){
                        UserServer.map.remove(from);
                        break;
                    }
                    //判断是否在线 如果不在线 无法发送消息(以后可以离线发送)
                    if (UserServer.map.containsKey(to)){
                        System.out.println(from+"向"+to+"发了一条信息："+msg);
                        //在线 服务端就需要给对方客户端发送消息
                        UserServer.map.get(to).getOutputStream().write((from+"："+msg+"\n").getBytes());
                    }else {
                        System.out.println(from+"向"+to+"发了一条信息：\""+msg+"\" 但是"+to+"不在线，未能接收到");
                        //如果不在线，服务端给客户端返回消息 目标账号不在线
                        client.getOutputStream().write((to+"目前不在线\n").getBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserClientThread extends Thread{
    Socket client;
    public UserClientThread(Socket client){
        this.client=client;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = br.readLine();
                if (msg!=null) System.out.println(msg);
                //待完成关闭代码
            }
        }catch (Exception e){

        }
    }
}