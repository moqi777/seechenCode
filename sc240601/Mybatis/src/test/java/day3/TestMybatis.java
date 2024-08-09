package day3;

import com.sc.dao.StudentMapper;
import com.sc.pojo.Student;
import com.sc.util.MybatisUtil;
import org.junit.Test;

import java.util.Date;

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
    @Test
    public void str(){
        String String="String";
        System.out.println(String);
    }
}
