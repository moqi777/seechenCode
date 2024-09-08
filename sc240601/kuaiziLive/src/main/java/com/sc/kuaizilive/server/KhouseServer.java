package com.sc.kuaizilive.server;

import com.sc.kuaizilive.pojo.Khouse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface KhouseServer {
    void addIssue1(Khouse khouse, MultipartFile[] files,HttpServletRequest req);
    void addIssue2(Khouse khouse);
    void addIssue3(Khouse khouse);
    void addIssue4(Khouse khouse, MultipartFile[] files,HttpServletRequest req);
}
