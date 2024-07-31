package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:敏感词实体
 * @DateTime:2024/7/31 14:33
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Words {
    private Integer id;
    private String word;
}
