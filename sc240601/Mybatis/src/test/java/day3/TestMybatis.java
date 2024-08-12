package day3;

import com.sc.mapper.*;
import com.sc.pojo.*;
import com.sc.util.MybatisUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/9 11:30
 **/
public class TestMybatis {
    @Test
    public void testAddSelective(){
        StudentMapper mapper = MybatisUtil.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setSno(10);
        student.setSname("张三");
        student.setSsex("男");
        mapper.addSelective(student);
        MybatisUtil.close();
    }
    @Test
    public void testupdateSelective1(){
        StudentMapper mapper = MybatisUtil.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setSno(10);
        student.setSname("萨博");
        student.setSbirthday(new Date());
        mapper.updateSelecttive1(student);
        MybatisUtil.close();
    }
    @Test
    public void testupdateSelective2(){
        StudentMapper mapper = MybatisUtil.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setSno(10);
        student.setSname("张三");
        student.setSsex("男");
        student.setClassname("5");
        mapper.updateSelecttive2(student);
        MybatisUtil.close();
    }
    @Test
    public void testquerySelective1(){
        StudentMapper mapper = MybatisUtil.getMapper(StudentMapper.class);
        Student student = new Student();
        mapper.querySelective1(student);
        MybatisUtil.close();
    }
    @Test
    public void testquerySelective2(){
        StudentMapper mapper = MybatisUtil.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setSname("王");
        student.setClassname("95033");
        mapper.querySelective2(student);
        MybatisUtil.close();
    }
    @Test   //新增用户的同时 新增用户信息 保证id是一致的
    public void oneToOneInsert(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        Huser user = new Huser();//springMVC可以得到的
        user.setUsername("李四");
        user.setPassword("123");
        user.setDid(2);
        user.setInfo(new Huserinfo());
        mapper.insertSelective(user);
        MybatisUtil.close();

        user.getInfo().setId(user.getId());
        user.getInfo().setAge(18);
        user.getInfo().setSex("男");
        HuserinfoMapper mapper2 = MybatisUtil.getMapper(HuserinfoMapper.class);
        mapper2.insertSelective(user.getInfo());
        MybatisUtil.close();
    }
    @Test
    public void testOneToOneSelect(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        Huser huser = mapper.selectById(25);
        MybatisUtil.close();
    }
    @Test
    public void testOneToOneSelect2(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        Huser huser = mapper.selectById2(25);
        MybatisUtil.close();
    }
    @Test
    public void testOneToMany(){
        HdeptMapper mapper = MybatisUtil.getMapper(HdeptMapper.class);
        List<Hdept> hdepts = mapper.selectAll2();
        for (Hdept hdept : hdepts) {
            System.out.println(hdept);
            for (Huser user : hdept.getUsers()) {
                System.out.println(user);
                System.out.println(user.getInfo());
            }
        }
        MybatisUtil.close();
    }
    @Test
    public void testManyToMany(){
        SstudentMapper mapper = MybatisUtil.getMapper(SstudentMapper.class);
        Sstudent s = mapper.selectById2(1);
        System.out.println(s);
        System.out.println(s.getTeachers());
        MybatisUtil.close();
    }
}
