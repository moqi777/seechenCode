package com.sc.kuaizilive.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhouseProperty implements Serializable {
    private KhouseImg[] imgs;

    private Integer id;

    private String title;

    private Integer houseType;

    private Integer area;

    private BigDecimal price;

    private Integer balcony;

    private Integer decoration;

    private String region;

    private Integer paymentMethod;

    private String features;

    private String equipment;

    private String details;

    private static final long serialVersionUID = 1L;
}