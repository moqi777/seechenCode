import com.ms.mapper.HuserMapper;
import com.ms.mapper.HuserinfoMapper;
import com.ms.pojo.Huser;
import com.ms.pojo.Huserinfo;
import com.ms.util.MybatisUtil;
import org.junit.Test;
import java.util.Date;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/8 20:06
 **/
public class TestHuser {
    @Test
    public void testSelectAll(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        List<Huser> list = mapper.selectAll2();
        for (Huser huser : list) {
            System.out.println(huser);
        }
        MybatisUtil.close();
    }

    @Test
    public void TestA(){
        HuserinfoMapper mapper = MybatisUtil.getMapper(HuserinfoMapper.class);
        Huserinfo huserinfo = mapper.selectByPrimaryKey(30);
        System.out.println(huserinfo);
        MybatisUtil.close();
    }
}
