package com.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hdept implements Serializable {
    private Integer id;

    private String deptname;

    private static final long serialVersionUID = 1L;
}