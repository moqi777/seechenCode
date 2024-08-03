package com.sc.service.impl;

import com.sc.dao.EmailDao;
import com.sc.dao.EmailUserDao;
import com.sc.dao.Impl.EmailDaoImpl;
import com.sc.dao.Impl.EmailUserDaoImpl;
import com.sc.pojo.Email;
import com.sc.pojo.EmailUser;
import com.sc.pojo.Page;
import com.sc.service.EmailService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/3 19:22
 **/
public class EmailServiceImpl implements EmailService {
    private EmailDao emailDao = new EmailDaoImpl();
    private EmailUserDao emailUserDao = new EmailUserDaoImpl();

    public Map<String, Object> selectEmail(Integer pageSize,int index,int fromOrTo,String value,String username){
        // //获取配置文件中设置好的页面容量
        // Integer pageSize = new Integer(getInitParameter("pageSize"));
        // //获取当前页码，并设置页面实体类
        // int index = Integer.parseInt(req.getParameter("index"));
        Page page = new Page();
        page.setCurrentIndex(index);
        page.setPageSize(pageSize);
        // //获取查询条件value值
        // String value = req.getParameter("value");
        // //如果有传条件把条件设入request作用域回传给页面让搜索框该值还在
        // if (value != null) req.setAttribute("value",value);
        // //获取到是接收邮件还是发送邮件 0是接收邮件数，1是发送邮件数
        // int fromOrTo = Integer.parseInt(req.getParameter("fromOrTo"));

        // //查询登录用户收到的邮件和总数
        // HttpSession session = req.getSession();
        // String username = ((EmailUser) session.getAttribute("loginUser")).getUsername();
        int count = emailDao.emailCount(fromOrTo, username,value);
        List<Email> emails = emailDao.emaiLimit(fromOrTo, username, page,value);

        //将总邮件数设置进page中
        page.setTotalCount(count);
        //总页数 设置进page
        if (count % pageSize == 0) page.setTotalPages(count/pageSize);
        else page.setTotalPages(count/pageSize + 1);

        Map<String, Object> map = new HashMap<>();
        map.put("page",page);
        map.put("emailList",emails);
        return map;
    }
    //返回：0成功；1发送失败；2不可以给自己发邮件；3用户不存在
    public int sendEmail(String toUser,String title,String content,String loginUser){
        //根据用户名或邮箱查询接收方是否存在
        List<EmailUser> userFromName = emailUserDao.selectEmailUser(new EmailUser(null, toUser, null, null));
        List<EmailUser> userFromEmail = emailUserDao.selectEmailUser(new EmailUser(null, null, null, toUser));
        if (userFromName.size() == 0 && userFromEmail.size() == 0) {//如果为0条说明没有查到该用户
            // resp.getWriter().print("<script>alert('" + "发送失败：用户不存在" + "');location.href = '/emailView/newMsg.jsp';</script>");
            return 3;
        }
        //无论是用户名还是邮箱都转成用户名
        toUser = userFromName.size() == 1 ? toUser : userFromEmail.get(0).getUsername();
        // //获取到发送方
        // String loginUser = ((EmailUser) req.getSession().getAttribute("loginUser")).getUsername();
        //如果发送方是自己的话错误
        if (loginUser.equals(toUser)){
            // resp.getWriter().print("<script>alert('" + "发送失败：不可以给自己发邮件" + "');location.href = '/emailView/newMsg.jsp';</script>");
            return 2;
        }
        //开始发送邮箱
        Email email = new Email(null, loginUser, title, content, null, toUser, null);
        int i = emailDao.addEmail(email);
        if (i!=1){//影响行数不为1说明失败
            // resp.getWriter().print("<script>alert('" + "发送失败" + "');location.href = '/emailView/newMsg.jsp';</script>");
            return 1;
        }else {
            // resp.getWriter().print("<script>alert('" + "发送成功" + "');location.href = '/email?type=selectEmail&fromOrTo=1&index=1';</script>");
            return 0;
        }
    }

    public Email readEmail(Integer email_id,String loginUserName){
        //根据邮件id获取到该邮件
        Email email = emailDao.selectEmailById(email_id);
        //判断是不是当前登录用户在看，如果是就不设置已读，因为已读状态只针对接收者
        if (!email.getFromname().equals(loginUserName)){//如果不是自己在看
            //判断邮件状态 如果为1 即未读 需要设置成0 已读
            if (email.getState() == 1) emailDao.updateState(email_id);
        }
        return email;
    }

    public void deleteCheckbox(int[] checkbox){
        int i = emailDao.deleteEmailByIds(checkbox);
        System.out.println("已读了"+i+"条数据");
    }

    public void yesRead(int[] checkbox){
        int i = emailDao.updateEmailStateByIds(checkbox);
        System.out.println("已读了"+i+"条数据");
    }
}
