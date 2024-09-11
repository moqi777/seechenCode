package com.sv.springbootvue.controller;

import com.github.pagehelper.PageInfo;
import com.sv.springbootvue.pojo.Myuser;
import com.sv.springbootvue.pojo.Result;
import com.sv.springbootvue.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/27 14:40
 **/
@RestController
@RequestMapping("/myUser")
public class MyUserController {
    @Autowired
    MyUserService us;
    //增 删 改 查(查分页搜索 查指定数据)

    @RequestMapping("/add")
    public Result add(@RequestBody Myuser u){
        int i = us.add(u);
        if (i>0){
            return new Result(1,"新增成功");
        }
        return new Result(0,"新增失败");
    }

    @RequestMapping("/del")
    public Result del(Integer id){
        int i = us.del(id);
        if (i>0){
            return new Result(1,"删除成功");
        }
        return new Result(0,"删除失败");
    }

    @RequestMapping("/dels")
    public Result dels(@RequestBody List<Myuser> myusers){
        int i = us.dels(myusers);
        if (i>0){
            return new Result(1,"删除成功");
        }
        return new Result(0,"删除失败");
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Myuser u){
        int i = us.update(u);
        if (i>0){
            return new Result(1,"更新成功");
        }
        return new Result(0,"更新失败");
    }

    @RequestMapping("/selectAll")
    public Result selectAll(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "5")Integer pageSize,
            @RequestBody Myuser u){
        PageInfo<Myuser> pageInfo = us.selectAll(pageNum, pageSize, u);
        return new Result(1,"查询分页搜索成功",pageInfo);
    }

    @RequestMapping("/selectById")
    public Result selectById(Integer id){
        System.out.println("进来");
        Myuser myuser = us.selectById(id);
        if (myuser!=null){
            return new Result(1,"查询成功",myuser);
        }
        return new Result(0,"没有指定数据");
    }
}
