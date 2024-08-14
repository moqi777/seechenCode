import com.github.pagehelper.PageInfo;
import com.sc.pojo.Uuser;
import com.sc.service.UuserService;
import com.sc.service.impl.UuserServiceImpl;
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
        UuserService uuserService = new UuserServiceImpl();
        Integer[] arr = {1,2};
        uuserService.delbyIds(arr);
    }
}
