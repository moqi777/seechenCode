package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uuser implements Serializable{
	private static final long serialVersionUID = -1575796884783896181L;
	
	private String id;
	private String name;
	private String account;
	private String password;
	private String dept;
	private String headImg;
	private boolean gender;
	private String email;
	private String mobile;
	private String memo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String state;//用户的状态，有效，无效
}
