import com.google.gson.Gson;
import dao.Impl.UserDaoImpl;
import dao.UserDao;
import org.junit.Test;
import pojo.User;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/27 23:28
 **/
public class JsonTest {
    @Test
    public void start(){
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.show();
        //将数据转换成json格式
        Gson gson = new Gson();
        String s = gson.toJson(list);
        System.out.println(s);
    }
}
