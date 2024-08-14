package com.sc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:mybatis自己测试使用的 以后整合SSM这些功能都实现完了
 * @DateTime:2024/8/8 10:50
 **/
public class MybatisUtil {
    static SqlSessionFactory sf;
    static SqlSession session;//以后不能静态
    static {
        //加载核心配置文件
        InputStream rs = null;
        try {
            rs = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建session工程
        sf = new SqlSessionFactoryBuilder().build(rs);
    }
    //获取mapper接口对象
    //定义一个通用泛型A 返回值是A的泛型   Class<A>相当于实际参数传入 A就是什么类型
    //<A>                   A         getMapper(Class<A> c)
    public static <A> A getMapper(Class<A> c){
        session = sf.openSession();
        return session.getMapper(c);
    }
    //收尾工作
    public static void close(){
        session.commit();
        session.close();
    }
}
