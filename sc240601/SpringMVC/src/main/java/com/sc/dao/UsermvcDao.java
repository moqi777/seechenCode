package com.sc.dao;

import com.sc.pojo.Usermvc;

import java.util.List;

public interface UsermvcDao {
    public int add(Usermvc u);
    public List<Usermvc> show();
}
