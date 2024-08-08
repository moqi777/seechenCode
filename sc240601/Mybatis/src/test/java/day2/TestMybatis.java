package day2;

import com.sc.mapper.HuserMapper;
import com.sc.mapper.StudentMapper;
import com.sc.pojo.Huser;
import com.sc.pojo.Student;
import com.sc.util.MybatisUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/8 11:02
 **/
public class TestMybatis {
    @Test
    public void testSelect(){
        StudentMapper mapper = MybatisUtil.getMapper(StudentMapper.class);
        List<Student> show = mapper.show();
        for (Student student : show) {
            System.out.println(student);
        }
        MybatisUtil.close();
    }
    @Test
    public void selectByUsername(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        List<Huser> list = mapper.selectByUsername("张三");
        MybatisUtil.close();
    }
    @Test
    public void testAddUser1(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        mapper.addUser1("张三","123123");
        MybatisUtil.close();
    }
    @Test
    public void testAddUser2(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        mapper.addUser2("李四",new Huser(null,null,"123123",null,2),new Date());
        MybatisUtil.close();
    }
    @Test
    public void testBatchAdd(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        List<Huser> list = new ArrayList<>();
        list.add(new Huser(null,"小黑","123123",new Date(),2));
        list.add(new Huser(null,"小白","123123",new Date(),1));
        list.add(new Huser(null,"小黄","123123",new Date(),3));
        mapper.batchAdd(list);
        MybatisUtil.close();
    }
    @Test
    public void testBatchDel(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        Integer[] ids = {4,5,6};
        mapper.batchDel(ids);
        MybatisUtil.close();
    }
    @Test
    public void testSelectMap(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("begin",1);
        map.put("length",5);
        map.put("pw","123");
        mapper.selectByMap(map);
        MybatisUtil.close();
    }
}
