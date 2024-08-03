package com.sc.controller;

import com.sc.pojo.Email;
import com.sc.pojo.EmailUser;
import com.sc.service.EmailService;
import com.sc.service.impl.EmailServiceImpl;
import com.sc.service.impl.EmailUserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:邮件控制层
 * @DateTime:2024/8/3 16:13
 **/
@Controller
@RequestMapping("/email")
public class EmailController {
    EmailService emailService = new EmailServiceImpl();
    //因为查看已收到的邮件和已发送的邮件代码几乎一样，在此通过参数的不同来划分
    //添加一个搜索功能
    //index：当前页码
    //value：搜索条件
    //fromOrTo：获取到是接收邮件还是发送邮件 0是接收邮件数，1是发送邮件数
    @RequestMapping("/selectEmail")
    public String selectEmail(HttpServletRequest req,HttpSession session,int index,String value,int fromOrTo){
        //获取配置文件中设置好的页面容量
        Integer pageSize = new Integer(req.getServletContext().getInitParameter("pageSize"));
        //如果有传条件把条件设入request作用域回传给页面让搜索框该值还在
        if (value != null) req.setAttribute("value",value);
        //查询登录用户名字
        String username = ((EmailUser) session.getAttribute("loginUser")).getUsername();
        //调用service方法查询分页信息和邮件
        Map<String, Object> map = emailService.selectEmail(pageSize, index, fromOrTo, value, username);

        req.setAttribute("page",map.get("page"));
        req.setAttribute("emailList",map.get("emailList"));

        //转发回页面 0是接收邮件数 跳转main.jsp，1是发送邮件数 跳转yifaMsg.jsp
        if (fromOrTo==0) return "/emailView/main.jsp";
        else return "/emailView/yifaMsg.jsp";
    }

    @RequestMapping("/sendEmail")
    public void sendEmail(String toUser, String title, String content, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置内容类型为 HTML，并指定字符编码
        resp.setContentType("text/html;charset=UTF-8");
        //获取到发送方
        String loginUser = ((EmailUser) req.getSession().getAttribute("loginUser")).getUsername();
        //返回：0成功；1发送失败；2不可以给自己发邮件；3用户不存在
        int i = emailService.sendEmail(toUser, title, content, loginUser);
        switch (i){
            case 0:resp.getWriter().print("<script>alert('" + "发送成功" + "');location.href = '/email/selectEmail?fromOrTo=1&index=1';</script>");
            case 1:resp.getWriter().print("<script>alert('" + "发送失败" + "');location.href = '/emailView/newMsg.jsp';</script>");
            case 2:resp.getWriter().print("<script>alert('" + "发送失败：不可以给自己发邮件" + "');location.href = '/emailView/newMsg.jsp';</script>");
            case 3:resp.getWriter().print("<script>alert('" + "发送失败：用户不存在" + "');location.href = '/emailView/newMsg.jsp';</script>");
        }
    }

    @RequestMapping("/readEmail")
    public String readEmail(Integer email_id,HttpServletRequest req){
        String loginUserName = ((EmailUser) req.getSession().getAttribute("loginUser")).getUsername();
        Email email = emailService.readEmail(email_id, loginUserName);
        //将结果封装在request对象中
        req.setAttribute("email",email);
        return "/emailView/readMsg.jsp";
    }

    @RequestMapping("/deleteCheckbox")
    public String deleteCheckbox(int[] checkbox,int currentIndex,int mainOrYifaMsg) {
        emailService.deleteCheckbox(checkbox);
        return "redirect:/email/selectEmail?fromOrTo="+mainOrYifaMsg+"&index="+currentIndex;
    }

    @RequestMapping("/yesRead")
    public String yesRead(int[] checkbox,Integer currentIndex,HttpServletResponse resp) throws IOException {
        emailService.yesRead(checkbox);
        return "redirect:/email/selectEmail?fromOrTo=0&index="+currentIndex;
    }
}
