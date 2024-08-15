package com.spring.dao;

import com.spring.pojo.User;

public interface UserDao {
    public int add(User u);
    int login();
    int del();
}
