package controller;

import dao.Impl.MailUserDaoImpl;
import dao.MailUserDao;
import pojo.MailUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:用户控制层
 * @DateTime:2024/7/29 21:18
 **/
public class MailUserController extends HttpServlet {
    private MailUserDao mailUserDao = new MailUserDaoImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String type = req.getParameter("type");
        switch (type){
            case "register":register(req, resp);break;
        }
    }
    private void register(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int i = mailUserDao.register(new MailUser(null, username, password, email));
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
