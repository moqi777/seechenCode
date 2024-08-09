import com.sc.dao.impl.UuserDaoimpl;
import org.junit.Test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/9 16:39
 **/
public class TestDB {
    @Test
    public void testSELECTCount(){
        UuserDaoimpl uuserDaoimpl = new UuserDaoimpl();
        int count = uuserDaoimpl.selectUuserCount();
        System.out.println(count);
    }
}
