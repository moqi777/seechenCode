import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/31 1:14
 **/
public class Main {
    @Test
    public void Te() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        Set<Map.Entry<Object, Object>> entrySet = map.entrySet();
        System.out.println(entrySet);
    }
}
