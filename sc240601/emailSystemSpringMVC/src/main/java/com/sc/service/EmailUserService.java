package com.sc.service;

import com.sc.pojo.EmailUser;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EmailUserService {
    int register(EmailUser emailUser,MultipartFile upImg,HttpServletRequest req);
    public Object login(String username, String password);
}
