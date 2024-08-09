package com.sc.dao;

import com.sc.pojo.Student;

import java.util.List;

//就是原来的StudentDao
public interface StudentMapper {
    public int add(Student student);
    public List<Student> show();
    //动态新增
    public int addSelective(Student s);
    //动态更新
    public int updateSelecttive1(Student s);
    public int updateSelecttive2(Student s);
    //动态搜索（模糊查询）
    public List<Student> querySelective1(Student s);
    public List<Student> querySelective2(Student s);
}
