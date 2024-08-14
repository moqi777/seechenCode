package day4;

import com.sc.mapper.HuserMapper;
import com.sc.mapper.TestlockMapper;
import com.sc.pojo.Huser;
import com.sc.pojo.Testlock;
import com.sc.util.MybatisUtil;
import org.junit.Test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/13 10:46
 **/
public class TestMybatis {
    @Test
    public void testOneCache(){
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        //第一次查询 先访问mysql 存储在缓存中 发情一次sql语句
        Huser u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        //第二次查询 缓存已经有了 不走mysql了
        u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        //如果修改了数据 为了防止脏读 会清空缓存
        u.setPassword("111111");
        mapper.updateByPrimaryKey(u);
        //再次查询 发现缓存没了 只能再查mysql 发送sql语句
        u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        MybatisUtil.close();

        //获取新的sqlsession创建mapper
        mapper = MybatisUtil.getMapper(HuserMapper.class);
        //它是新的sqlsession得到的结果，不能和之前的sqlsession的缓存
        //所以查询mysql  发送一次sql语句
        u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        MybatisUtil.close();
    }

    @Test
    public void testTwoCache(){
        //开了二级缓存 可以在不同sqlSession共享 只有一级没了 才会实现二级
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        //第一次查 会查mysql 默认存储一级缓存 二级缓存只要开启了也会存
        Huser u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        //一级缓存 存在 不走mysql
        u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        MybatisUtil.close();//一级缓存sqlSession回收了 没了

        mapper = MybatisUtil.getMapper(HuserMapper.class);
        //一级没了 才开始走二级缓存 这个时候也不走mysql
        u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        //修改数据 一级和二级都会清空缓存
        u.setPassword("666666666");
        mapper.updateByPrimaryKey(u);
        MybatisUtil.close();

        mapper = MybatisUtil.getMapper(HuserMapper.class);
        //由于前面更新了 二级缓存也清空了 再查相同的数据 只能访问mysql
        u = mapper.selectByPrimaryKey(35);
        System.out.println(u);
        MybatisUtil.close();
    }

    @Test
    public void testHappyLock1() throws InterruptedException {
        TestlockMapper mapper = MybatisUtil.getMapper(TestlockMapper.class);
        //先查询一遍数据
        Testlock lock = mapper.selectByPrimaryKey(1);
        Thread.sleep(5000);
        // 更新的时候 匹配版本号
        mapper.updateLock(new Testlock(1,"张三1",lock.getVersion()));
        MybatisUtil.close();
    }

    @Test
    public void testHappyLock2(){
        TestlockMapper mapper = MybatisUtil.getMapper(TestlockMapper.class);
        //先查询一遍数据
        Testlock lock = mapper.selectByPrimaryKey(1);
        // 更新的时候 匹配版本号
        mapper.updateLock(new Testlock(1,"张三2",lock.getVersion()));
        MybatisUtil.close();
    }

    @Test
    public void testNotHappyLock1() throws InterruptedException {
        TestlockMapper mapper = MybatisUtil.getMapper(TestlockMapper.class);
        //先查询一遍数据 是为了给数据加锁
        Testlock lock = mapper.selectForUpdate(1);
        Thread.sleep(10000);
        lock.setName("1111");
        mapper.updateLock(lock);//底层id条件 version条件
        MybatisUtil.close();//提交事务 释放了数据的锁 其他用户才可以操作
    }
    @Test
    public void testNotHappyLock2() throws InterruptedException {
        TestlockMapper mapper = MybatisUtil.getMapper(TestlockMapper.class);
        //先查询一遍数据 是为了给数据加锁
        Testlock lock = mapper.selectForUpdate(2);
        Thread.sleep(3000);
        lock.setName("2222");
        mapper.updateLock(lock);//底层id条件 version条件
        MybatisUtil.close();//提交事务 释放了数据的锁 其他用户才可以操作
    }
}
