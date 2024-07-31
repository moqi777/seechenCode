package controller;

import com.google.gson.Gson;
import dao.Impl.UserDaoImpl;
import dao.UserDao;
import pojo.User;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/25 16:11
 **/
//控制层：负责处理用户所有的请求：登录、注册、新增、删除、搜索
//1.继承 HttpServlet
//2.重写 doGet doPost
//3.配置Servlet
public class UserController extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    //get请求进入该方法处理
    //request：请求对象 可以设置转发跳转 可以提交的数据
    // 表示前端发送的一次请求 每次请求request都是独立的
    //类型是HttpServletRequest 父类是ServletRequest
    //response：响应对象 可以设置重定向跳转 可以添加缓存Cookie
    //表示请求处理后 响应结果 通常是给前端响应的
    //类型是HttpServletResponse 父类是ServletResponse
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何知道请求来源 后面就可以控制不同的请求做不同的处理
        String type = req.getParameter("type");
        switch (type){
            case "login":login(req, resp);break;
            case "userShow":show(req,resp);break;
            case "addUser":addUser(req,resp);break;
            case "deleteUser":deleteUser(req,resp);break;
            case "updateUser":updateUser(req,resp);break;
            case "exit":exit(req,resp);break;
        }
    }

    private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("loginUser");
        resp.sendRedirect("/day2/login.jsp");
    }
    //修改用户信息
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = new Integer(req.getParameter("id"));
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        double maney = 0;
        int serviceId = 0;
        try {
            maney = Double.parseDouble(req.getParameter("money"));
            serviceId = Integer.parseInt(req.getParameter("serviceId"));
        } catch (NumberFormatException e) {
            req.setAttribute("updateStatus",0);
            req.getRequestDispatcher("day2/updateUser.jsp").forward(req,resp);
        }
        User doudouUser = new User(id,phone, password, maney, serviceId);
        int i = userDao.updateUser(doudouUser);
        req.setAttribute("updateStatus",i);
        //如果修改的是当前用户，更新session
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null && loginUser.getId()==doudouUser.getId()){
            session.setAttribute("loginUser",doudouUser);
        }
        req.getRequestDispatcher("day2/updateUser.jsp").forward(req,resp);
    }

    //删除用户
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = new Integer(req.getParameter("id"));
        int i = userDao.deleteUser(id);
        show(req, resp);
    }
    //新增用户
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        double maney = 0;
        int serviceId = 0;
        try {
            maney = Double.parseDouble(req.getParameter("money"));
            serviceId = Integer.parseInt(req.getParameter("serviceId"));
        } catch (NumberFormatException e) {
            req.setAttribute("addStatus",0);
            req.getRequestDispatcher("day2/addUser.jsp").forward(req,resp);
            return;
        }
        User doudouUser = new User(null,phone, password, maney, serviceId);
        int i = userDao.reg(doudouUser);
        req.setAttribute("addStatus",i);
        req.getRequestDispatcher("day2/addUser.jsp").forward(req,resp);
    }
    //查询用户数据
    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userDao.show();
        //作用域一共有四种：page request session application
        req.setAttribute("userList",list);
        //将数据转换成json格式，也一起传入request
        Gson gson = new Gson();
        String s = gson.toJson(list);
        req.setAttribute("userListJson",s);
        //跳转到userShow 不能使用重定向 跨越请求了 上面通过request作用域存储的数据就丢失了
        //只能使用转发 因为转发只属于一次请求 属于内部跳转 一定不能写绝对路径 必须写相对路径
        req.getRequestDispatcher("day2/userShow.jsp").forward(req,resp);
    }
    //登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //2.获取前端提交的数据
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        //3.调用dao层 跟数据库交互（后期会调用业务层service）
        User user = userDao.login(phone, password);
        //4.通过dao层返回的结果控制成功和失败
        if (user!=null){
            //判断用户是否记住了密码
            String remember = req.getParameter("remember");
            if ("1".equals(remember)){
                Cookie userName = new Cookie("userName", phone);
                Cookie passWord = new Cookie("password", password);
                passWord.setMaxAge(60);//设置60秒有效期
                resp.addCookie(userName);
                resp.addCookie(passWord);
            }
            req.getSession().setAttribute("loginUser",user);
            resp.sendRedirect("/day2/home.jsp");
        }else {
            //如果登录失败删除cookie
            Cookie passWord = new Cookie("password", "");
            resp.addCookie(passWord);
            resp.sendRedirect("/day2/login.jsp");
        }
    }

    //post请求进入该方法处理
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
