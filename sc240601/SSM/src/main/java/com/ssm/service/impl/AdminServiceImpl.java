package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.mapper.OAdminMapper;
import com.ssm.pojo.OAdmin;
import com.ssm.service.AdminService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/16 14:49
 **/
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    OAdminMapper mapper;
    public OAdmin login(OAdmin admin) {
        return mapper.login(admin);
    }

    public int checkAccount(String account) {
        int i = mapper.selectByAccount(account);
        return i>0?0:1;
    }

    public PageInfo<OAdmin> show(Integer currentIndex, Integer pageSize,String conditional,String options) {
        PageHelper.startPage(currentIndex,pageSize);
        OAdmin admin = new OAdmin();
        switch (options==null?"":options){
            case "account":admin.setAccount(conditional);break;
            case "name":admin.setName(conditional);break;
            case "phone":admin.setPhone(conditional);break;
            case "email":admin.setEmail(conditional);break;
            case "sex":
                switch (conditional){
                    case "男":admin.setSex("1");break;
                    case "女":admin.setSex("0");break;
                }
                break;
            case "status":
                switch (conditional){
                    case "未验证":admin.setStatus("0");break;
                    case "正常":admin.setStatus("1");break;
                    case "禁用":admin.setStatus("2");break;
                }
        }
        return new PageInfo<>(mapper.show(admin));
    }

    public void del(Integer[] ids) {
        mapper.deleteByIds(ids);
    }

    public void startUsing(Integer[] ids) {
        mapper.startUsingByIds(ids);
    }

    public void disable(Integer[] ids) {
        mapper.disableByIds(ids);
    }

    public int add(OAdmin admin) {
        return mapper.insertSelective(admin);
    }
}
