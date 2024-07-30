package controller;

import com.google.gson.Gson;
import dao.Impl.EmailUserDaoImpl;
import dao.EmailUserDao;
import pojo.EmailUser;
import pojo.Page;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:用户控制层
 * @DateTime:2024/7/29 21:18
 **/
public class EmailUserController extends HttpServlet {
    private EmailUserDao emailUserDao = new EmailUserDaoImpl();
    Gson gson = new Gson();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        ServletContext servletContext = req.getServletContext();
        String reqCharSet = servletContext.getInitParameter("reqCharSet");
        String respCharSet = servletContext.getInitParameter("respCharSet");
        req.setCharacterEncoding(reqCharSet);
        resp.setContentType(respCharSet);

        String type = req.getParameter("type");
        switch (type){
            case "register":register(req, resp);break;
            case "login":login(req, resp);break;
            case "exit":exit(req, resp);break;
        }
    }

    private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        req.getSession().removeAttribute("loginUser");
        resp.sendRedirect("/index.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //先验证一下用户是否存在
        List<EmailUser> emailUsersToName = emailUserDao.selectEmailUser(new EmailUser(null, username, null, null));
        if (emailUsersToName.size() == 0){//等于0说明用户不存在
            resp.getWriter().print("<script>alert('" + "用户不存在" + "');location.href = 'index.jsp';</script>");
        }else {//用户存在再判断一下密码
            EmailUser emailUser = (EmailUser)emailUsersToName.get(0);
            String passwordToMysql = emailUser.getPassword();
            if (!passwordToMysql.equals(password)) {//密码错误
                resp.getWriter().print("<script>alert('" + "密码错误" + "');location.href = 'index.jsp';</script>");
            }else {//到这一步说明验证成功可以登录
                //将当前登录的用户信息存在session中
                HttpSession session = req.getSession();
                session.setAttribute("loginUser",emailUser);
                //重定向到分页的servlet中去
                resp.sendRedirect("/email?type=selectEmail&index=1");
            }
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //先验证一下用户名和邮箱是否已存在
        List<EmailUser> emailUsersToName = emailUserDao.selectEmailUser(new EmailUser(null, username, null, null));
        List<EmailUser> emailUsersToEmail = emailUserDao.selectEmailUser(new EmailUser(null, null, null, email));
        String regMsg = "";
        if (emailUsersToName.size() != 0){//用户名已存在
            regMsg = "用户名已存在";
        }else if(emailUsersToEmail.size() != 0){//邮箱已存在
            regMsg = "邮箱已存在";
        }else {//都不存在，注册
            int i = emailUserDao.register(new EmailUser(null, username, password, email));
            if (i != 1){//影响的行数不是1，说明失败
                regMsg = "注册失败";
            }else {//注册成功
                resp.getWriter().print("<script>alert('" + "注册成功" + "');location.href = 'index.jsp';</script>");
            }
        }
        resp.getWriter().print("<script>alert('" + regMsg + "');location.href = 'register.jsp';</script>");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
