<%@ page import="dao.UserDao" %>
<%@ page import="dao.Impl.UserDaoImpl" %>
<%@ page import="pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");
    UserDao userDao = new UserDaoImpl();
    User login = userDao.login(phone, password);
    if (login == null){
        response.sendRedirect("/day1/login.jsp");
    }else {
        session.setAttribute("user",login);
        response.sendRedirect("/day1/show.jsp");
    }
%>
