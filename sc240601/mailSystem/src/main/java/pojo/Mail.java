package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

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
public class Mail {
    private Integer id;
    private String fromname;
    private String title;
    private String content;
    private Integer state;
    private Timestamp toname;
}
