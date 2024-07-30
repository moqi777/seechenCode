package controller;

import com.google.gson.Gson;
import dao.EmailDao;
import dao.Impl.EmailDaoImpl;
import pojo.Email;
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
 * @desc:
 * @DateTime:2024/7/31 0:05
 **/
public class EmailController extends HttpServlet {
    private EmailDao emailDao = new EmailDaoImpl();
    Gson gson = new Gson();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        ServletContext servletContext = req.getServletContext();
        String reqCharSet = servletContext.getInitParameter("reqCharSet");
        String respCharSet = servletContext.getInitParameter("respCharSet");
        req.setCharacterEncoding(reqCharSet);
        resp.setContentType(respCharSet);

        String type = req.getParameter("type");
        switch (type){
            case "selectEmail":selectEmail(req, resp);break;
        }
    }

    private void selectEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取配置文件中设置好的页面容量
        Integer pageSize = new Integer(getInitParameter("pageSize"));
        //获取当前页码，并设置页面实体类
        int index = Integer.parseInt(req.getParameter("index"));
        Page page = new Page();
        page.setCurrentIndex(index);
        page.setPageSize(pageSize);

        //查询登录用户的邮件和总数
        HttpSession session = req.getSession();
        String username = ((EmailUser) session.getAttribute("loginUser")).getUsername();
        int count = emailDao.emailCount(1, username);
        List<Email> emails = emailDao.emaiLimit(1, username, page);

        //将总邮件数设置进page中
        page.setTotalCount(count);
        //总页数 设置进page
        if (count % pageSize == 0) page.setTotalPages(count/pageSize);
        else page.setTotalPages(count/pageSize + 1);

        //将分页信息和邮件信息存入request
        req.setAttribute("page",page);
        req.setAttribute("emailList",emails);

        //转发回页面
        req.getRequestDispatcher("main.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
