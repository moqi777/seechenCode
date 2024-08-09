package com.sc.dao;

import com.sc.pojo.Uuser;
import com.sc.util.PageUtil;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/5 20:46
 **/
public interface UuserDao {
    Uuser selectToAccount(String account);
    int selectUuserCount();
    List<Uuser> selectUuserLimit(PageUtil<Uuser> pageUtil);
}
