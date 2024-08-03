package com.sc.service;

import com.sc.pojo.Email;

import java.util.Map;

public interface EmailService {
    public Map<String, Object> selectEmail(Integer pageSize, int index, int fromOrTo, String value, String username);
    public int sendEmail(String toUser,String title,String content,String loginUser);
    public Email readEmail(Integer email_id, String loginUserName);
    public void yesRead(int[] checkbox);
    public void deleteCheckbox(int[] checkbox);
}
