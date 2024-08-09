# JAVA全栈学习代码与项目

## sc240601

> 这是一整个项目，分成了多个模块

### javaSE

包括了javaSE进阶（从多线程开始往后）代码，还有一个基于控制台的兜兜5G营业厅项目，数据通过序列化存储在文件中，具体功能实现在项目中有个PPT可以看到。技术应用就是一些javaSE的。

### jdbc

学习jdbc代码

### servlet

学习servlet代码

### emailSystem

该模块是一个基于jdbc+servlet的邮件管理系统，使用的是同步请求，mysql版本为8.0。相关的静态资源和ppt解析都已存在一个压缩包中放于目录下，还有一个sql文件用于创建数据库。具体功能ppt中也可看到。

### SpringMVC

学习SpringMVC框架代码

### emailSystemSpringMVC

该模块是一个基于jdbc+SpringMVC部分(控制层的输入输出)的邮件管理系统。与emailSystem模块系统的区别只有controller层的区别，还有一点是使用了MVC三层架构模式编写代码，新增了一个service层。email_user表新增了一个字段用于存放头像地址，项目中注册也新增了一个可以上传头像的功能，登录到主页后右上角会显示头像，此处运用了springMVC的上传文件功能。想要clone该项目部署数据库可以使用emailSystem模块项目下的sql文件，记得加上一个头像字段img。

### ratepaySystem

该模块是一个基于jdbc+SpringMVC+Mybatis的纳税管理系统，使用ajax异步请求+同步请求，页面为jsp页面，使用EL表达式嵌套。只实现了一个纳税服务下的用户管理模块功能：

- 是一个前后端不分离项目，异步同步请求都有
- 所有资源和页面都放进了WEB-INF中，在外面只有一个index.jsp用于重定向进controller中的中间层转发访问WEB-INF资源
- 使用了拦截器对未登录用户进行拦截
- 分页显示用户信息，可根据需要切换页数，可选择显示的页面数量
- 可全选或单选，批量删除用户
- 可新增用户信息
- 可根据用户名迷糊查询用户信息

## study

学了一小点线程的代码