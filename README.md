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

### Mybatis

学习Mybatis框架代码

### ratepaySystem

该模块是一个基于SpringMVC+Mybatis的纳税管理系统，使用ajax异步请求+同步请求，页面为jsp页面，使用EL表达式嵌套。只实现了一个纳税服务下的用户管理模块功能：

- 是一个前后端不分离项目，异步同步请求都有
- 所有资源和页面都放进了WEB-INF中，在外面只有一个index.jsp用于重定向进controller中的中间层转发访问WEB-INF资源
- 使用了拦截器对未登录用户进行拦截
- 分页显示用户信息，可根据需要切换页数，可选择显示的页面数量
- 可全选或单选，批量删除用户
- 可新增用户信息
- 可根据用户名迷糊查询用户信息

就这样吧，用户模块差一个新增功能，懒的写了，PPT和sql文件都放在模块根目录了

### MybatisJoinSpringMVC

刚刚学完springMVC和mybatis后整合在一起的一个小demo项目

### Spring

学习spring代码

### SSM

该模块为一个SSM的光年项目，整合了SSM。静态资源和sql文件在模块根目录下的压缩包中，项目中将html修改成了jsp。

开发重点：

- 登录有一个图片验证码的功能，使用了CodeUtil工具类，使用该工具类传入req和resp就可以自动传一张验证码图片到前端，并将其对应的验证码存入session以供使用
- 进入到用户管理页面后，使用mybatis的分页插件做分页
- 新增用户、一键启用 禁用 删除所选用户、退出登录、新增用户可以上传图片、首页右上角可以显示图片、根据需求动态搜索

### springboot

学习springboot代码

### springbootTest

练习springboot代码

### ocp

java11的语法，考ocjp证学习代码

### springbootVue

![image-20240828215703592](https://s2.loli.net/2024/08/28/ULctAfV4YhDMPBk.png)

使用springboot+mybatis+vue3完成了页面所示所有功能，vue项目代码在另一个仓库

## study

学了一小点线程的代码