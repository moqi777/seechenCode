package com.sc.springboottest;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/11 11:21
 **/
public class TestRedis {
    //测试哨兵可读性
    @Test
    public void testRedisStart(){
        Set<String> set = new HashSet<>();
        set.add("192.168.11.27:10000");
        set.add("192.168.11.27:10001");
        set.add("192.168.11.27:10002");
        //1.定义Redis哨兵池对象
        //参数1：主服务器名(主节点名) 参数2：哨兵地址集合
        JedisSentinelPool pool = new JedisSentinelPool("mymaster",set);
        Jedis jedis = null;
        int i=1;
        while (true){
            try {
                jedis = pool.getResource();
                jedis.set("key-"+i,"value-"+i);
                System.out.println("插入数据成功：key-"+i++);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("可能主节点宕机了，请等待30秒");
            }finally {
                try {
                    jedis.close();
                } catch (Exception e) {
                    System.out.println("可能主节点宕机了，请等待30秒");
                }
            }
        }
    }
    //测试集群可用性
    @Test
    public void testCluster(){
        Set<HostAndPort> set=new HashSet<>();
        for (int i=7000;i<=7005;i++){
            set.add(new HostAndPort("192.168.11.27",i));
        }
        //创建集群对象
        JedisCluster cluster = new JedisCluster(set);
        int count = 1;
        while (true){
            try {
                cluster.set("key-"+count,"value-"+count);
                System.out.println("集群添加数据成功：key-"+count++);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("主节点可能宕机了 请等待...");
            }
        }
    }
}
