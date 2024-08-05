package com.sc.dao;

import com.sc.pojo.Usermvc;

import java.util.List;

public interface UsermvcDao {
    public int add(Usermvc u);
    // public List<Usermvc> show();
    //查询总条数
    public int Count();
    //查询分页的数据集合
    public List<Usermvc> show(int currentIndex,int pageSize);
}
