<%@ page import="pojo.User" %>
<%@ page import="util.DBUtil" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.Impl.UserDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //这个页面是起到了可以控制注册是否成功的作用
  //注册页面最终提交的数据 是给这个控制页面处理
  //1.获取注册页面的信息 根据表单提交的name值来决定的
  String phone = request.getParameter("phone");
  String password = request.getParameter("password");
  double maney = Double.parseDouble(request.getParameter("maney"));
  int serviceId = Integer.parseInt(request.getParameter("serviceId"));
  User doudouUser = new User(null,phone, password, maney, serviceId);
  UserDao userDao = new UserDaoImpl();
  int i = userDao.reg(doudouUser);
  if (i>0){
    //请求重定向
    response.sendRedirect("/day1/login.jsp");
  }else {
    response.sendRedirect("/day1/reg.jsp");
  }
%>