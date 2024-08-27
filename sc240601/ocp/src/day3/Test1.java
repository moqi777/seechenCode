package day3;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/26 19:49
 **/
public class Test1 {
    public static void main(String[] args) {
        var roster = List.of(
                new Employee("aa",LocalDate.now(),30),
                new Employee("bb",LocalDate.now(),15),
                new Employee("cc",LocalDate.now(),27)
        );
        //断言：判断的条件 jdk1.8开始的特性
        Predicate<Employee> p = e->e.getSalary()>25;
        LocalDate d = LocalDate.of(1989,1,1);
        long young = roster.stream()
                .filter(p)
                .filter(e->e.getBirthday().isAfter(d))
                .count();
                //收集器(工具类.分组函数 条件满足分一组 不满足分一组)
                //.filter(p).collect(Collectors.partitioningBy(e->e.getBirthday().isAfter(d)))
                //.get(true)//获取满足的一组
                // .count();//它是流的方法 不是集合的方法
    }
}
class Employee{
    private String name;
    private LocalDate birthday;
    private int salary;

    public Employee() {
    }

    public Employee(String name, LocalDate birthday, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
