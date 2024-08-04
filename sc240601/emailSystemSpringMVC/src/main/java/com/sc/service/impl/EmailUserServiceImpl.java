package com.sc.service.impl;

import com.sc.dao.EmailUserDao;
import com.sc.dao.Impl.EmailUserDaoImpl;
import com.sc.pojo.EmailUser;
import com.sc.service.EmailUserService;
import com.sc.util.UpDownUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/3 19:22
 **/
public class EmailUserServiceImpl implements EmailUserService {
    private EmailUserDao emailUserDao = new EmailUserDaoImpl();
    //返回：0成功；1失败；2用户名已存在；3邮箱已存在
    public int register(EmailUser emailUser, MultipartFile upImg,HttpServletRequest req){
        //先验证一下用户名和邮箱是否已存在
        List<EmailUser> emailUsersToName = emailUserDao.selectEmailUser(new EmailUser(null, emailUser.getUsername(), null, null,null));
        List<EmailUser> emailUsersToEmail = emailUserDao.selectEmailUser(new EmailUser(null, null, null, emailUser.getEmail(),null));
        if (emailUsersToName.size() != 0){//用户名已存在
            // regMsg = "用户名已存在";
            return 2;
        }else if(emailUsersToEmail.size() != 0){//邮箱已存在
            // regMsg = "邮箱已存在";
            return 3;
        }else {//都不存在，注册
            //先把头像存起来
            emailUser.setImg(UpDownUtil.upload(req, upImg));
            int i = emailUserDao.register(emailUser);
            if (i != 1){//影响的行数不是1，说明失败
                // regMsg = "注册失败";
                return 1;
            }else {//注册成功
                // resp.getWriter().print("<script>alert('" + "注册成功" + "');location.href = 'index.jsp';</script>");
                return 0;
            }
        }
    }

    public Object login(String username, String password){
        //先验证一下用户是否存在
        List<EmailUser> emailUsersToName = emailUserDao.selectEmailUser(new EmailUser(null, username, null, null,null));
        if (emailUsersToName.size() == 0){//等于0说明用户不存在
            // resp.getWriter().print("<script>alert('" + "用户不存在" + "');location.href = 'index.jsp';</script>");
            return "用户不存在";
        }else {//用户存在再判断一下密码
            EmailUser emailUser = emailUsersToName.get(0);
            String passwordToMysql = emailUser.getPassword();
            if (!passwordToMysql.equals(password)) {//密码错误
                // resp.getWriter().print("<script>alert('" + "密码错误" + "');location.href = 'index.jsp';</script>");
                return "密码错误";
            }else {//到这一步说明验证成功可以登录
                //将当前登录的用户信息存在session中
                // HttpSession session = req.getSession();
                // session.setAttribute("loginUser",emailUser);
                // //重定向到分页的servlet中去
                // resp.sendRedirect("/email?type=selectEmail&fromOrTo=0&index=1");
                return emailUser;
            }
        }
    }
}
