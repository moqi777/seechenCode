package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.mapper.MyuserMapper;
import com.sc.pojo.Myuser;
import com.sc.service.UserService;
import com.sc.util.MybatisUtil;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/13 16:08
 **/
public class UserServiceImpl implements UserService {
    public PageInfo<Myuser> page(int currentIndex, int pageSize) {
        //1.设置分页 底层是拦截器 必须写在查询功能上面 否则失效
        //原因：因为它会帮你给sql语句拼接limit ?,?  如果顺序写错了 数据都查完了 就无法拼接了
        PageHelper.startPage(currentIndex,pageSize);
        //2.封装数据 借助于有参构造(表中的数据)
        MyuserMapper mapper = MybatisUtil.getMapper(MyuserMapper.class);
        List<Myuser> list = mapper.show();
        MybatisUtil.close();
        return new PageInfo<>(list);
    }
}
