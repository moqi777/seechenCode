package day1;

import com.sc.dao.StudentMapper;
import com.sc.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/7 17:14
 **/
public class TestMybatis {
    @Test
    public void first() throws IOException {
        //4.通过session动态创建Mapper接口实现类
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        //5.持久化操作
        List<Student> list = mapper.show();
        System.out.println(list);
    }
    SqlSession session;
    @Before
    public void before() throws IOException {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("Mybatis.xml");
        //2.创建session工厂
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
        //3.创建session 不是HttpSession 是SqlSession
        session = sf.openSession();
    }
    @After
    public void after(){
        //6.session提交或回滚事务
        session.commit();//一定要提交 否则 内存完成的 不是真的sql语句
        // session.rollback();
        //7.关闭资源
        session.close();
    }
    @Test
    public void add(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.add(new Student(null,"王五","男",new Date(),"0601"));
    }
}
