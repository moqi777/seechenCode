import com.sc.mapper.HuserMapper;
import com.sc.pojo.Huser;
import com.sc.util.MybatisUtil;
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
        List<Huser> list = mapper.selectAll();
        for (Huser huser : list) {
            System.out.println(huser);
        }
        MybatisUtil.close();
    }

    @Test
    public void testInsertHuser(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        Huser huser = new Huser(null, "小白", "456789", new Date(), 2);
        mapper.insertSelective(huser);
        MybatisUtil.close();
    }
}
