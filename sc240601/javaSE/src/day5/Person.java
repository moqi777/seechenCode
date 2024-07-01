package day5;

import java.util.Date;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/28 11:52
 **/
public class Person extends Animal{
    //得到4个Field类 来表示下面的4个属性 也能获取父类的
    private String name;
    Integer age;
    protected double money;
    public Date time;

    //学习
    public void study(){
        System.out.println("人类开始学习");
    }
    private void play(String str){
        System.out.println("人类开始玩游戏");
    }

    public Person(String name, Integer age, double money, Date time) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.time = time;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Person() {}
}

 class Animal{
    String type;//高级动物
     public void est(){
         System.out.println("动物开始吃饭");
     }
 }