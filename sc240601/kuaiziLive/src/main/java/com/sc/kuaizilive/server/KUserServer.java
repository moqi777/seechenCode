package com.sc.kuaizilive.server;

import com.sc.kuaizilive.pojo.KUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface KUserServer {
    KUser codeLogin(KUser user);
    Integer getCode();
}
