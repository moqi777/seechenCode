package controller;

import com.google.gson.Gson;
import dao.EmailDao;
import dao.EmailUserDao;
import dao.Impl.EmailDaoImpl;
import dao.Impl.EmailUserDaoImpl;
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
    private EmailUserDao emailUserDao = new EmailUserDaoImpl();
    Gson gson = new Gson();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type){
            case "selectEmail":selectEmail(req, resp);break;
            case "sendEmail":sendEmail(req, resp);break;
            case "readEmail":readEmail(req, resp);break;
        }
    }

    private void readEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        Integer email_id = new Integer(req.getParameter("email_id"));
        //根据邮件id获取到该邮件
        Email email = emailDao.selectEmailById(email_id);
        //判断是不是当前登录用户在看，如果是就不设置已读，因为已读状态只针对接收者
        String loginUserName = ((EmailUser) req.getSession().getAttribute("loginUser")).getUsername();
        if (!email.getFromname().equals(loginUserName)){//如果不是自己在看
            //判断邮件状态 如果为1 即未读 需要设置成0 已读
            if (email.getState() == 1) emailDao.updateState(email_id);
        }
        //将结果封装在request对象中
        req.setAttribute("email",email);
        //转发到查看的页面
        req.getRequestDispatcher("/emailView/readMsg.jsp").forward(req,resp);
    }

    private void sendEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String toUser = req.getParameter("toUser");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        //根据用户名或邮箱查询接收方是否存在
        List<EmailUser> userFromName = emailUserDao.selectEmailUser(new EmailUser(null, toUser, null, null));
        List<EmailUser> userFromEmail = emailUserDao.selectEmailUser(new EmailUser(null, null, null, toUser));
        if (userFromName.size() == 0 && userFromEmail.size() == 0) {//如果为0条说明没有查到该用户
            resp.getWriter().print("<script>alert('" + "发送失败：用户不存在" + "');location.href = '/emailView/newMsg.jsp';</script>");
            return;
        }
        //无论是用户名还是邮箱都转成用户名
        toUser = userFromName.size() == 1 ? toUser : userFromEmail.get(0).getUsername();
        //获取到发送方
        String loginUser = ((EmailUser) req.getSession().getAttribute("loginUser")).getUsername();
        //如果发送方是自己的话错误
        if (loginUser.equals(toUser)){
            resp.getWriter().print("<script>alert('" + "发送失败：不可以给自己发邮件" + "');location.href = '/emailView/newMsg.jsp';</script>");
            return;
        }
        //开始发送邮箱
        Email email = new Email(null, loginUser, title, content, null, toUser, null);
        int i = emailDao.addEmail(email);
        if (i!=1){//影响行数不为1说明失败
            resp.getWriter().print("<script>alert('" + "发送失败" + "');location.href = '/emailView/newMsg.jsp';</script>");
        }else {
            resp.getWriter().print("<script>alert('" + "发送成功" + "');location.href = '/email?type=selectEmail&fromOrTo=1&index=1';</script>");
        }
    }

    //因为查看已收到的邮件和已发送的邮件代码几乎一样，在此通过参数的不同来划分
    private void selectEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取配置文件中设置好的页面容量
        Integer pageSize = new Integer(getInitParameter("pageSize"));
        //获取当前页码，并设置页面实体类
        int index = Integer.parseInt(req.getParameter("index"));
        Page page = new Page();
        page.setCurrentIndex(index);
        page.setPageSize(pageSize);
        //获取到是接收邮件还是发送邮件 0是接收邮件数，1是发送邮件数
        int fromOrTo = Integer.parseInt(req.getParameter("fromOrTo"));

        //查询登录用户收到的邮件和总数
        HttpSession session = req.getSession();
        String username = ((EmailUser) session.getAttribute("loginUser")).getUsername();
        int count = emailDao.emailCount(fromOrTo, username);
        List<Email> emails = emailDao.emaiLimit(fromOrTo, username, page);

        //将总邮件数设置进page中
        page.setTotalCount(count);
        //总页数 设置进page
        if (count % pageSize == 0) page.setTotalPages(count/pageSize);
        else page.setTotalPages(count/pageSize + 1);

        //将分页信息和邮件信息存入request
        req.setAttribute("page",page);
        req.setAttribute("emailList",emails);

        //转发回页面 0是接收邮件数 跳转main.jsp，1是发送邮件数 跳转yifaMsg.jsp
        if (fromOrTo==0) req.getRequestDispatcher("emailView/main.jsp").forward(req,resp);
        if (fromOrTo==1) req.getRequestDispatcher("emailView/yifaMsg.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
