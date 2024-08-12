package com.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Huserinfo implements Serializable {
    private Integer id;

    private String sex;

    private Integer age;

    private String mess;

    private static final long serialVersionUID = 1L;
}