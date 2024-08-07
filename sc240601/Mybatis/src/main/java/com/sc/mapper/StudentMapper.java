package com.sc.mapper;

import com.sc.pojo.Student;

import java.util.List;

//就是原来的StudentDao
public interface StudentMapper {
    public int add(Student student);
    public List<Student> show();
}
