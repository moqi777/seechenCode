package com.sc.controller;

import com.sc.pojo.Usermvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//测试输入和输出
@Controller  //目的：没有任何作用  只表示当前这个类标记成控制层
//springmvc只要找到这个注解  就会创建控制层
public class InOutController {
    @RequestMapping("/in")
    public void inSimple(String name,int age,double score){
        System.out.println("进入in()");
        System.out.println("参数："+name+" "+age+" "+score);
    }
    @RequestMapping("/inMany")
    //使用集合做参数  需要考虑 List是接口  不能实例化 只能写实现类
    //还需要添加一个注解@RequestParam("别名") 只能通过别名来识别   给哪个集合赋值
    //使用比较麻烦  不推荐使用      推荐使用数组
    public void inMany(@RequestParam("ids") ArrayList<Integer> ids, ArrayList<String> like){//Integer[] ids,String[] like
        System.out.println(ids);
        System.out.println(like);
        //System.out.println(Arrays.toString(ids));
        //中文乱码 还没有解决
        //System.out.println(Arrays.toString(like));
    }
    @RequestMapping("/inAdd")
    public void inAdd(Usermvc m,String name){
        System.out.println(m);
        System.out.println(name);
    }
    //springmvc底层实现 默认返回的是ModelAndView对象
    //模型和视图对象：模型就是要存储的数据（存储request作用域的数据）
    //视图就是要跳转的页面（默认转发）
    @RequestMapping("/testOut")
    public ModelAndView test(ModelAndView modelAndView){
        // ModelAndView modelAndView = new ModelAndView();
        Usermvc u = new Usermvc();
        u.setName("张三");
        u.setMoney(19999.99);
        //等价于存储rquest作用域
        modelAndView.addObject("userMvc",u);
        //设置转发跳转的地址
        modelAndView.setViewName("/day1/show.jsp");
        return modelAndView;
    }
    //springMVC底层返回需要ModeAndView 代码比较繁琐 不推荐
    //1.存储request作用域 形参定义不同的类型来存储
    //HttpServletRequest Model Map ModeMap
    //2.页面跳转    通过方法返回值 直接写地址 默认也是转发
    @RequestMapping("/testOut2")
    public String testOut2(HttpServletRequest req, Model m1, Map m2, ModelMap m3){
        //这四种方式都是request存值 底层实现都是map存值
        req.setAttribute("req","reqValue");
        m1.addAttribute("m1","m1Value");
        m2.put("m2","m2Value");
        m3.addAttribute("m3","m3Value");
        return "/day1/show.jsp";
    }
    //如果存储其他作用域 session appliction
    //如果跳转方式不是默认请求 需要重定向
    @RequestMapping("/testOut3")
    public String testOut3(HttpSession session){
        session.setAttribute("session","sessionValue");
        session.getServletContext().setAttribute("application","applicationValue");
        //默认值："forward:/day1/show.jsp"，就是转发，所以不用写 直接"/day1/show.jsp"
        return "redirect:/day1/show.jsp";
    }
}
