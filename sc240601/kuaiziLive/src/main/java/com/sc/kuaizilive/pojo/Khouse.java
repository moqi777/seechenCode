package com.sc.kuaizilive.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Khouse implements Serializable {
    private KUser user;
    private KhouseContact contact;
    private KhouseProperty property;

    private Integer id;

    private Integer accountId;

    private Integer contactId;

    private Integer propertyId;

    private Integer propertyType;

    private Integer status;

    private static final long serialVersionUID = 1L;
    //当contact和property中的值赋完后，在本实体类中可以直接获取id

    public Integer getContactId() {
        return contact.getId();
    }
    public Integer getPropertyId() {
        return property.getId();
    }
}