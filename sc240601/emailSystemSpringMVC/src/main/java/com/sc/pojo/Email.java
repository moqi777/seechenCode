package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:邮件实体类
 * @DateTime:2024/7/29 20:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private Integer id;
    private String fromname;
    private String title;
    private String content;
    private Integer state;
    private String toname;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdate;
}
