package filter;

import dao.Impl.WordsDaoImpl;
import dao.WordsDao;
import pojo.Words;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:敏感词过滤器
 * @DateTime:2024/7/31 20:03
 **/
public class SensitiveFilter implements Filter {
    static List<Words> wordsList;
    public void init(FilterConfig filterConfig) throws ServletException {
        WordsDao wordsDao = new WordsDaoImpl();
         wordsList = wordsDao.show();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //将req替换成自定义的req传给
        MyRequest myRequest = new MyRequest(req);
        filterChain.doFilter(myRequest,servletResponse);
    }

    public void destroy() {

    }
}
//自定义一个请求对象
class MyRequest extends HttpServletRequestWrapper{
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    //重写getParameter方法，使得经过过滤得到的参数
    public String getParameter(String name) {
        //获取原来的请求数据
        String oldValue = super.getParameter(name);
        //如果为空就不过滤
        if (oldValue == null) return oldValue;
        //循环遍历数据库中的敏感词
        for (Words words : SensitiveFilter.wordsList) {
            //如果传来的参数中含有敏感词，将其所有包含了的都替换成*
            if (oldValue.contains(words.getWord())){
                //根据违规词长度拼接对应长度的*
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < words.getWord().length(); i++) {
                    stringBuilder.append("*");
                }
                System.out.println("过滤了一次敏感词："+words.getWord());
                oldValue = oldValue.replaceAll(words.getWord(),stringBuilder.toString());
            }
        }
        return oldValue;
    }
}


