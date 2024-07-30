package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:邮箱用户实体类
 * @DateTime:2024/7/29 20:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailUser {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
