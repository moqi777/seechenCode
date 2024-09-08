package com.sc.kuaizilive.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhouseImg implements Serializable {
    private Integer id;

    private Integer propertyId;

    private String photoUrl;

    private static final long serialVersionUID = 1L;
}