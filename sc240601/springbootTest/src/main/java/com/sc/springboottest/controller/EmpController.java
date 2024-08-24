package com.sc.springboottest.controller;

import com.sc.springboottest.pojo.Emp;
import com.sc.springboottest.pojo.Result;
import com.sc.springboottest.server.EmpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/24 9:24
 **/
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpServer empServer;
    @RequestMapping("/show")
    public Result show(){
        return new Result(1,"查询成功",empServer.queryAll());
    }
    @RequestMapping("/del")
    public Result del(@RequestBody Emp emp){
        int i = empServer.delById(emp.getEmpno());
        if (i==1){
            return new Result(1,"删除成功",null);
        }else {
            return new Result(0,"删除失败",null);
        }
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Emp emp){
        int i = empServer.add(emp);
        if (i==1){
            return new Result(1,"新增成功",null);
        }else {
            return new Result(0,"新增失败",null);
        }
    }
    @RequestMapping("/update")
    public Result update(@RequestBody Emp emp){
        int i = empServer.update(emp);
        if (i==1){
            return new Result(1,"修改成功",null);
        }else {
            return new Result(0,"修改失败",null);
        }
    }
}
