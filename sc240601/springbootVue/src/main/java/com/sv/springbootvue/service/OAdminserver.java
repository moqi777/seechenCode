package com.sv.springbootvue.service;

import com.sv.springbootvue.pojo.OAdmin;

public interface OAdminserver {
    OAdmin login(OAdmin admin);
    int reg(OAdmin admin);
}
