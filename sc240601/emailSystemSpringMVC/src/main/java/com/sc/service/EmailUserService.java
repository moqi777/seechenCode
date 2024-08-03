package com.sc.service;

import com.sc.pojo.EmailUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EmailUserService {
    int register(String username,String password,String email);
    public Object login(String username, String password);
}
