package day1;

import com.sc.mapper.Mybatis_empMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/7 19:50
 **/
public class TestMybatis_emp {
    @Test
    public void add() throws IOException {
        InputStream rs = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(rs);
        SqlSession session = build.openSession();
        Mybatis_empMapper mapper = session.getMapper(Mybatis_empMapper.class);
        // mapper.add(new Mybatis_emp(null,"战三",85.5));
        // mapper.addMoney(1,50);
        mapper.del(1);
        session.commit();
        session.close();
    }
}
