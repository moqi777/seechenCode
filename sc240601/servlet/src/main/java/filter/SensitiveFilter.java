package filter;

import dao.Impl.WordsDaoImpl;
import dao.WordsDao;
import pojo.Words;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:敏感词过滤器：在JSP和Servlet设计思路 就是把请求对象重写了
 * 重写请求对象getParameter
 * @DateTime:2024/7/31 14:13
 **/
public class SensitiveFilter implements Filter {
    static List<Words> wordsList;
    public void init(FilterConfig filterConfig) throws ServletException {
        //服务器启动执行
        WordsDao wordsDao = new WordsDaoImpl();
         wordsList = wordsDao.show();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MyRequest req = new MyRequest((HttpServletRequest) servletRequest);
        //放行的请求是自定义请求，不是原来的请求
        filterChain.doFilter(req,servletResponse);
    }

    public void destroy() {

    }
}

//自定义一个请求对象
class MyRequest extends HttpServletRequestWrapper{
    public MyRequest(HttpServletRequest request) {
        super(request);
    }
    //重写getParameter 目的后续Servlet获取数据都是使用下面的获取的
    public String getParameter(String name) {
        //获取请求原来的数据
        String oldValue = super.getParameter(name);
        //如果没有传值直接返回
        if (oldValue==null) return oldValue;
        //验证原来的数据 是否有敏感词 如果有要处理 返回新的值
        for (Words w : SensitiveFilter.wordsList) {
            //循环遍历原数据是否包含敏感词
            if (oldValue.contains(w.getWord())){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < w.getWord().length(); i++) {
                    sb.append("*");
                }
                //处理之后重新赋值
                oldValue = oldValue.replaceAll(w.getWord(), sb.toString());
            }
        }

        return oldValue;
    }
}