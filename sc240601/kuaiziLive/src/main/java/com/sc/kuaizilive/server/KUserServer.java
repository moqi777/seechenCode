package com.sc.kuaizilive.server;

import com.sc.kuaizilive.pojo.KUser;
import com.sc.kuaizilive.pojo.Result;

public interface KUserServer {
    Result pwLogin(KUser user);
    KUser codeLogin(KUser user);
    Integer getCode();
    Result updatePw(KUser user);
}
