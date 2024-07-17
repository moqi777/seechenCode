# MYSQL

## 1. 数据库简介

数据库(Database)DB是按照数据结构来组织、存储和管理数据的仓库，每个数据库还具有一个或者多个API用于创建和管理或者复制我所保存的数据，之前我们可以将数据存储到本地文件中(序列化)但是在本地文件中读写速度特别慢 不适合大量的数据存储 所以存储到数据库是最好的方式

主要分为两种：

- 关系型数据库
- 非关系型数据库(nosql数据库)

#### 1.1 关系系数据库

关系系数据库：建立在关系模型的基础上的，关系模型就是二维表的方式进行存储 类似于excel表格

![933255eea6ba440f2568d9c2ab01105a](https://s2.loli.net/2024/07/08/PY2LAKcrxbfOjFV.png)

常用关系系数据库：

- mysql         常用
- sql server
- oracle         常用
- db2
- 达梦        国内
- GaussDB        国内，华为

#### 1.2非关系系数据库

非关系系数据库(nosql)：没有特定的关系，不需要创建表结构，存储的数据之间也可以没有关系 适合存储海量的 复杂的 碎片化数据 读写速度特别快 所以一般是基于内存操作的

![dd4a34d91a67f678a565ab3878cdd209](https://s2.loli.net/2024/07/08/bihJNG6X1WeOEgk.png)

常见的非关系型有哪些

- redis
- mongodb

## 2. Mysql安装

==前提：群里发布的版本mysql5.6免安装版==

- 下载后解压mysql-5.6.37-winx64到本地磁盘

- 配置环境变量

  - 添加变量：MYSQL_HOME 变量值：解压的目录

  ![5740744acb2f0f871ec0b1a38569cb54](https://s2.loli.net/2024/07/08/71YKJBCREPMAu6m.png)

  - path追加变量：%MYSQL_HOME%\bin

  ![c8358909f91853bcecd7f7f69360acc3](https://s2.loli.net/2024/07/08/rGBe12HWz3oEm8w.png)

- 通过命令提示窗口(管理员权限)

  - 安装mysql服务：mysqld -install     /     卸载：mysqld --remove
  - 启动mysql服务：net start mysql      /     关闭：net stop mysql

![8f94a5bfea3a6abbf44be472ed16208c](https://s2.loli.net/2024/07/08/w9ysIXSvW8PDBm4.png)

#### 2.1 Navicat快捷键

```mysql
ctrl+q	打开查询窗口
ctrl+/	注释sql语句		-- 
ctrl+shift+/	取消注释sql语句
ctrl+r	运行查询窗口所有sql语句
ctrl+shift+r	只会运行选中的sql语句
```

==使用navicat图形化工具创建数据库记得设置字符集==

![ca3d090082d2768b1ceb483b97e6b919](https://s2.loli.net/2024/07/08/SHczds39BJb5Wou.png)

## 3. Mysql简介

mysql是一种关系型数据库，是由瑞典Mysql AB公司研发的，目前属于Oracle公司

优势：

- mysql开源的，免费的
- mysql支持大型的数据量存储，可以处理千万级的数据
- mysql使用标准sql语言格式（其他数据库如果也支持说明语法基本是一样的）
- mysql可以运行在多个系统上，并且支持多种语言C C++ java Python...
- mysql是可以定制化的，你可以修改源码开发属于自己公司mysql系统

## 4. Sql语句分类 ---笔试题

- DDL：数据定义语言，用于创建和删除数据库对象的命令(创建数据库 创建表 创建视图 创建索引 创建触发器 创建函数...) 共同特性：不能回滚事务
  - create（创建）
  - drop（删除）
  - alter（修改）
  - truncate（截断表）
- DML：数据操作语言，用于操作(增 删 改)数据表中的数据
  - insert（新增数据）
  - delete（删除数据）
  - update（修改数据）
- DQL：数据查询语言，用于查询数据库表中的数据
  - select（查询数据）---最常用 最难用
- DCL：数据控制语言，用来控制数据库组件许可或者权限
  - grant（授权）
  - revoke（撤销权限）
- TCL：事务控制语言，用于提交事务或者回滚事务
  - commit（提交）rollback（回滚/撤销）

## 5. DDL语言

#### 5.1 create命令创建表

```sql
-- 语法规则：[] => 可选字段
-- 创建 表关键字
create table 表名(
	字段1 数据类型 [约束] [索引] [注释],
    字段2 数据类型 [约束] [索引] [注释]，
    ...
    字段n 数据类型 [约束] [索引] [注释]
) [表类型] [字符集] [注释];
-- 第一天内容：在数据库中 关键字不区分大小写，底层实现全部转换大写执行
-- 创建表(学生表)
-- 类型：
-- 整数：int
-- 字符串：varchar(长度)
-- 浮点型：double(10,2)表示8个整数2个小数
-- 日期类型：date 表示年-月-日
create table student(
	stuno int comment '学生编号',
	stuname varchar(100) comment '学生姓名',
	money double(10,2) comment '学生存款',
	time date comment '入学时间'
)comment='学生表';

select * from student;
```

```sql
-- 还可以使用as 查询语句(类似于创建视图)
create table 表名 as 查询语句;
```

==注：关键字是table，字段和字段之间通过`,`分隔，结束语通过`;`==

#### 5.2 alter命令修改表

```sql
-- 修改表名
alter table 表名 rename 新表名;
-- 添加字段
alter table 表名 add 字段名 类型;
-- 修改字段
alter table 表名 change 原字段名 新字段名 类型;
-- 删除字段
alter table 表名 drop 字段名;
```

#### 5.3 drop命令删除表

```sql
drop table 表名;	
```

## 6. DML语言

#### 6.1 insert插入命令

```sql
-- 新增语法1：指定字段插入(注：前面声明的字段必须和后面值一一对应)
insert into 表名(字段1，字段5，字段3) values (值1，值5，值3);

-- 新增语法2：全字段插入(注：全字段新增，后面的值必须和表声明的字段一一对应)
insert into 表名 values (值1，...，值n);

-- 新增语法3：批量插入
insert into 表名(字段1，字段5) values(值1,值5),(值1,值5),(值1,值5);
insert into 表名 values(值1，...，值n),(值1，...，值n),(值1，...，值n);

-- 新增语法4：借助于select
insert into 表 select 值1，...,值n union 
				select 值1，...,值n union 
				select 值1，...,值n union ;
insert into student
select 1000,'郭浩7',8000,NOW() union
select 1000,'郭浩8',8000,NOW() union
select 1000,'郭浩9',8000,NOW() union
select 1000,'郭浩10',8000,NOW() union
select 1000,'郭浩11',8000,NOW();
				
-- 注：数据库中单引号和双引号都可以表示字符串
-- 注：Mysql中 日期类型 存入字符串自动变日期
```

#### 6.2 update修改命令

```sql
update 表名 set 字段1=值1，字段2=值2 where 条件
注：where后面的条件 一般来说必须要加 否则全表更新
条件目的：限制数据集 比如：> < = 来进行控制
```

#### 6.3 delete删除命令

```sql
delete from 表名 where 条件
注：删除必须添加条件，否则全表删除
```

## 7. Mysql数据类型 ---面试题

- 数值类型：

|     类型      |  大小  |      介绍      |
| :-----------: | :----: | :------------: |
|   smallint    | 2字节  |     小整型     |
|      int      | 4字节  |      整型      |
|    bigint     | 8字节  |     大整型     |
|     float     | 4字节  |     单精度     |
|    double     | 8字节  |     双精度     |
| decimal(参数) | 31字节 | 精确数值浮点型 |

double：是一种双精度浮点型，可以存储大约15位有效数字。适合做一些精度较高，但是可以接受一些误差的 比如工程学的计算

decimal：是一种精确数值类型，用于存储精度非常高的数据，最大可以支持65位有效数字，它可以精确保存小数位 避免四舍五入产生的误差存在 比如财务计算	

==注：浮点型的使用都是类似于float(6,2) => 4个整数2个小数，double(6,2) decimal(6,2)==

- 字符串类型：

|  类型   |                             大小                             |    介绍    |
| :-----: | :----------------------------------------------------------: | :--------: |
|  char   |                          255个字符                           | 定长字符串 |
| varcahr |        65535字节 根据不同字符集存储字符个数也是不同的        | 变成字符串 |
|  text   |                          65535字符                           | 长文本类型 |
|  blob   | 2的16次方-1字节(64kb)，将文件转换成二进制保存，但不推荐存储数据库，推荐存储文件服务器或者云服务器 数据库只需要存储地址 | 二进制类型 |

>  char类型和varchar类型的区别 ---面试题
>
>  char是属于定长类型，无论存储多少数据所占的空间都是固定的，比如char(10)存储字符'1'字符也会占10个 比较浪费空间 适合存储一些长度固定的数据 比如：性别 状态
>
>  varchar是属于变长类型，所占的空间是根据存储数据决定的 比如：varchar(1000)存储字符'1'也只会占1个 比较节省空间

- 日期类型：

|   类型    |        格式         |    介绍    |
| :-------: | :-----------------: | :--------: |
|   date    |     YYYY-MM-DD      |   日期值   |
|   time    |      HH:mm:ss       |   时间值   |
|   year    |        YYYY         |    年份    |
| timestamp | YYYY-MM-DD HH:mm:ss |   时间戳   |
| datetime  | YYYY-MM-DD HH:mm:ss | 日期时间值 |

> timestamp和datetime区别 ---面试题
>
> - 容量不同：timestamp占4个字节 datetime在mysql 5.6之后占5个字节
> - 存储不同：timestamp存储的值转换成UTC时间再存入 datetime不会转换 所存即所得
> - 存储null：timestamp在mysql 8之前自动转换成now()，datetime给啥存啥
> - 存储now()：timestamp可能与当前时间不一致 因为它会把当前时间转换成UTC来存储 datetime不会转换 和当前时间不一致

## 8.  DQL ---重点

==别名：通常复杂查询时，可能会涉及到多张表，很可能会出现 字符/表 重复的问题
可以给这些重复的内容 添加一个临时的名称，也可以减少代码复杂度
语法：字段名 as 别名   表名 as 别名。注：as 可以省略==

#### 8.1 基础查询

```sql
基本语法：[] 可有可无 但是只要写了 前后的顺序不能颠倒
select 查询的字段1,字段2... from 表名或视图名
[where 分组前条件]
[group by 分组的字段]
[having 分组后条件]
[order by 排序的字段 升序(ASC)或降序(DESC)]
[limit [起始下标,]条数];
```

#### 8.2 where字句

就是将前面的查询结果 做一次筛选

涉及到的关键字：

`<`	`>`	`=`	`!=`	`<>`	`<=`	`>=`	
`and`	`or`
`is null`	`is not null`	
`in()`	`between and`	`not between and`

```sql
1.查询成绩的范围	mysql逻辑运算符：and or not
select * from 表 where 成绩>60;
select * from 表 where 成绩>60 and 成绩<80;
-- 属于闭区间 包括80 和 90
select * from 表 where 成绩 between 80 and 90;

2.筛序是否为null值
select * from 表 where 字段 is null;
select * from 表 where 字段 is not null;

3.筛选不等于
select * from 表 where 科目编号 != 'java';
select * from 表 where 科目编号 <> 'java';


4.筛选等于 或者等于多个值
select * from 表 where 部门编号=20；
-- 统计10 30 50部门的员工信息
select * from 表 where 部门编号=10 or 部门编号=30 or 部门编号=50;
-- 简化版写法in() 函数 等价于或者的意思
select * from 表 where 部门编号 in(10,30,50);
```

#### 8.3 like字句

如果做查询时，这个条件如果不具体，只知道一部分，所以这个条件很模糊，在Mysql中可以使用模糊查询方式来实现它

```sql
语法：
select 查询字段 from 表 where 字段 like ' ';

-- 模糊查询自带两种占位符：
_ ：只能表示一个字符
% ：表示0-n个字符  
```

#### 8.4 unino子句

mysql中union用于链接多个select语句的结果集 最终合并成一个结果集，特点：这些多个select语句 如果有重复的数据会自动去重，并且还可以实现数据库的列转行

```sql
语法：
select 字段1，字段2 from 表
unino
select 字段1，字段2 from 表

语法2：如果不想去重 多个结果集重复数据 使用union all
select 字段1，字段2 from 表
unino all
select 字段1，字段2 from 表
```

==注：要求多个查询语句字段的个数是一样的，字段类型可以不一样，即只看字段个数==

#### 8.5 order by子句

数据库本身的数据默认无序的，因为不知道该用什么规则排序，如果想排序，需要通过关键字order by来实现，并且排序关键字是有先后 顺序的 一般是写在除了limit语句的最后

```sql
语法：
order by 排序的字段 排序规则;
排序规则：ASC升序(默认)	DESC降序

-- 要求公司工资从低到高
select * from emp order by sal asc; / select * from emp order by sal;
-- 要求公司工资从高到低，如果工资相同，按照员工编号升序
select * from emp order by sal desc,emo asc;
```

#### 8.6 limit子句

limit是mysql中用于通过下标(索引值)来限定查询条数的一种方式，它后期也是实现数据分页非常重要的途径，并且limit一般要写在sql语句末尾

```sql
语法：
limit [起始索引值,]查询的条数;

-- 查询一张表 每页实现5条 查询第三页数据
limit 10,5;	//10表示从下标为10的数据开始查询，查询5条
-- 查询一张表 前10条数据
limit 0,10;		/		limit 10;
```

## 9. Mysql约束 ---面试题

约束：用于限定表中数据，凡是不符合约束要求的数据，是无法插入到数据库表中，是为了增加表中数据的准确性，添加约束可以在创建表时编写，也可以在表存在的时候 单独添加。约束主要分为以下几种：

- 非空约束：not null	保证字段不能为空
- 默认约束：default   保证字段一定会有值，如果没有插入会设置默认值，如果插入null也算插入了值
- 唯一约束：unique   保证字段唯一性 但是数据可以为空 并且唯一约束还会自动添加 唯一索引
- 检查性约束：check   用于给字段做一些简单校验 但是mysql 8以下会失效，语法通过但是无效果
  - 主键约束：primary key用于控制数据唯一的方式，主键约束自带 唯一 和 非空 两种功能，但是主键约束每张表只能写一个，并且主键约束也会自动添加索引，叫做主键索引
    一般配合`auto_increment`自增使用
- 外键约束：foreign key 定义在具有父子关系的子表中，子表中的外键 必须对应 父表中的主键(或者唯一键) 目的是为了确保数据的完整性  可以重复 为null==前提：添加外键时，一定先创建父表再创建子表==

```sql
-- 1.创建表时 添加约束
create table person(
	id int primary key,	-- 编号 唯一 非空
    name varchar(100) not null,	-- 非空
    age int default 18,	-- 默认18
    sex char(1) check(sex in('男','女')),	-- 检查性约束
    phone varchar(11) not null unique,	-- 唯一 非空
    city_id int,	-- 可重复 可以非空(外键)
    foreign key(city_id) references city(id)
);

create table city(
	id int primary key auto_increment,
    name varchar(100)
);

-- 2.表已经存在时 添加约束
alter table person add primary key(id);
alter table person add unique(phone);
alter table person add check(sex in('男','女'));
alter table person modify name varchar(255) not null;
alter table person alter column age set default 18;
alter table person add foreign key(city_id) references city(id);
```

## 10. 数据库范式 ---面试题

设计数据库表，遵循一些规则和要求，才能设计出合理表结构，这些要求和规则就是范式，范式是一种分层结构 主要包含6层 每一层都必须比上一层更加严格，层数越高 数据安全越好 但是效率也会越低 由于数据库不仅仅只考虑安全性 效率也非常重要 所以开发过程中只需要满足前三范式即可

- 第一范式（1NF）：要求设计数据库时字段具有原子性，就是说不能类似于对象 集合 数组 这类不符合原子性的数据当成字段
- 第二范式（2NF）：前提是需要先满足1NF，又要求其数据必须依赖于主键 本质上就是为了强制添加主键 因为主键是唯一非空 这样可以防止数据的冗余
- 第三范式（3NF）：前提是必须满足3NF，又要求不能有其他表中的非主键，其实就是不能有重复的列的意思，这样数据冗余了，强调你要添加主外键关联

> 但是：第三范式在实际开发过程中是可以违反的，因为有很多需求可能会用到两张表的数据，如果经常用，每次查两张表速度肯定会有影响，所以我违反第三范式，额外添加一个冗余字段，这样后期只需要查询一张表 查询速度一定会更快 以空间换时间的方式

## 11. Mysql函数 ---重点

mysql有很多内置函数，类似于java中的方法，mysql函数也可以传递参数，而且一定会有返回值 主要分为两大类：

- 聚合函数：对多条数据 最终只会返回一个值 比如：最高分
- 单行函数：对多条数据 最终每行数据都会返回一个结果 比如：拼接字符串

#### 11.1 聚合函数

前提：聚合函数一般可以写在select后面，同时还可以写在having后面

- avg(字段)：返回平均值
- count(字段)：返回数据的行数        不写字段情况不推荐使用count(*)，推荐使用count(1)
- max(字段)：返回数据的最大值
- min(字段)：返回数据的最小值
- sum(字段)：返回数据的总和

`distinct`去重，添加在字段前面

#### 11.2 单行行数

- 数字函数：主要用于处理数字（整数和浮点数的）

```sql
-- abs(字段)：返回这个数据绝对值
-- ceil(字段)：返回字段向上取整
-- floor(字段)：返回字段向下取整的值
-- rand()：返回0-1随机数
-- round(字段，数值)：对这个字段第几位小数点进行四舍五入
```

- 字符串函数：

```sql
-- char_length(字段)：该字段字符数量
select char_length('中文123'); -- 5
-- length(字段)：返回该字段的字节长度
select length('中文123'); -- 9

-- upper(s)：将字符串s大写
-- lower(s)：将字符串s小写

-- substring(字符串,1,[长度])：截取字符串 1表示第一个元素 长度不写截取到末尾
-- left(s,n)：返回字符串s前n个字符	获取前缀
-- right(s,n)：返回字符串s后n个字符	获取后缀

-- concat(s1,s2,s3,...)：拼接字符串
-- replace(字符串,原内容,新内容)：替换字符串内容
-- instr(字符串,'内容')：返回字符串指定内容下标
-- reverse(字符串)：将字符串反转
```

- 日期函数：

```sql
-- now()：当前时间 年-月-日 时:分:秒
-- curdate：当前时间	年-月-日
-- year()、month()、day()、hour()：获取日期的一部分
-- adddate(日期,天数)：给日期添加几天
-- last_day(日期)：该日期所在月的最后一天
-- datediff(日期1,日期2)：求日期1-日期2天数差
-- from_days(天数)：可以将天数转换成日期类型，只支持365以上

-- str_to_date(字符串,日期格式)：将字符串变日期，但是mysql会自动转，没必要
-- date_format(日期)：将日期按照指定格式转换成字符串
-- 注：mysql日期格式会特殊一点
%W 表示星期名字		%D 表示月份英文前缀		%a返回星期缩写
%Y 四位年		%y 二位年		%m 月份		%d 日
%H 24进制小时 		%h 12进制小时		%i 分钟		%s 秒
```

- 条件判断函数：

```sql
-- if(表达式,值1,值2)：表达式true返回值1，false返回值2 类似三目运算
select if(1>0,'正确','错误');
-- ifnull(含null字段,新值)：如果字段null返回新值，不为空返回原值
-- case函数：能够实现与java中if和switch，同时也可以实现列转行的功能
-- 语法1：类似于java的多重if
case
	when 条件1 then 结果1
	when 条件2 then 结果2
	...
	else 其他结果
end
-- 语法2：类似于java中的switch
case 字段
	when 值1 then 结果1
	when 值2 then 结果2
	...
	else 其他结果
end
```

- 其他函数：了解

```sql
version()：返回你数据库的版本
database()：当前数据库名
md5(数据)：通过md5算法对数据加密
...
```

## 12. 分组查询 ---难点

group by：将查询到的数据按照某个条件进行分组，这样就会将原来只有一个数据集，变成很多组的数据集 如果再使用聚合函数时，每组数据集都会返回一个值

```sql
分组语法：
select [聚合函数,],分组字段 from 表
[where 分组前条件]
[group by 分组字段]
[having 分组后条件] -- 筛选的是每组的数据

-- 比如：我想统计公司每个部门 平均工资 工资总合 并且统计的是平均工资大于2000的(只有分组才知道每个部门平均值)
select deptno,avg(sal) 平均工资,sum(sal) from emp
group by deptno
having 平均工资>2000;
```

==注：如果添加了分组之后，查询的字段只能是分组的字段或者聚合函数。否则在mysql默认把第一行数据显示，在oracle直接报错==

## 13. 连接查询 ---面试题

如果当我们要查询的数据 它分散在不同的表中，如果只查询一张表无法满足我的需求了 就需要实现多张表之间如何实现联合的查询 这种情况称之为连接查询 连接查询主要分两种：

- 内连接：只会把满足匹配条件的数据查询出来，不匹配的数据查不出来，匹配条件也叫关联条件
- 外连接：
  - 左外连接：会将左边的表当成主表，右边的表当成副表，主表的数据会全部展示，副表只会展示满足关联条件的数据，如果有不满足的 显示null
  - 右外连接：类似于外右连接 只不过以右边的表作为主表
  - 全外连接：mysql不支持 类似于左外连接 只不过左右两张表都是主表 两种表的数据都会全部展示

#### 13.1 内连接

```sql
-- 语法结构：inner join on
select * form 表1 inner join 表2 on 关联条件
				  ...
				  inner join 表n on 关联条件
-- 关联条件：就是两张表可以共同描述同一个内容的字段，名称可以不同 但是含义一般是一样的

-- 比如：员工和部门表的关联 
-- 内连接：如果员工没有部门编号就查不出来 反之部门里面没有员工也查不出来
select * from emp inner join dept 
on emp.deptno=dept.deptno;

-- 简化版语法：重点
select * from 表,表2，表3
where 表1.X=表2.X and 表2.XX=表3.XX
```

#### 13.2 外连接

```sql
-- 左外语法结构：left join on
--           左表(主)       右表(副)
select * from 表1 left join 表2 on 关联条件

-- 右外语法结构：right join on
--           左表(副)       右表(主)
select * from 表1 left join 表2 on 关联条件

-- 语法结构：full join on
--           左表(主)       右表(主)
select * from 表1 left join 表2 on 关联条件

-- 比如：查询员工对应的部门信息，同时还要包括没有部门的员工
-- 比如：查询学生表 和成绩表的信息 还包括没有考试的学生
```

#### 13.3 自连接

自连接比较特殊，不是连接类型，而是连接的一种方式，其实本质上就是把一张表当成两张表类处理，自己连接自己。一般来说有一些非常抽象的题目，通过自连接非常好解决

```sql
-- 查询同一个学生 3-105 比 6-166成绩高的学生信息
select s.* from student s,
t_score s1,t_score s2
where s.sno=s1.sno and s1.sno=s2.sno 
and s1.cno='3-105'
and s2.cno='6-166' 
and s1.degree>s2.degree
```

## 14. 子查询

子查询：也叫内部查询，就是一个sql语句嵌套了其他的查询语句。可以被嵌套insert、delete、update、select等语句中，任何可以放在表达式的地方都可以使用子查询。

- where型子查询
- from型子查询
- exists子查询（类似于in）

#### 14.1 where型子查询

把内层查询的查询结果当做外层查询的条件

```sql
-- 比如：查询ID最大的一件商品
-- 查询1：查询最大ID是什么
select max(id) from 表
-- 查询2：通过上面的最大ID当成本次查询的条件
select * from 表 where id=最大ID
```

#### 14.2 from型查询

把内层查询的查询结果 当成一张临时表 同时临时表也需要添加别名，一般用于和外层查询做表关联使用

```sql
-- 查询每个科目最高分学生信息
select * from student s,...
-- 查询1：先查询每个科目最高分信息
select cno,max(degree) 最高分 from t_score
group by con
-- 查询2：成绩表 和 上面每个最高分的临时表 做表连接
select distinct s.sno from t_score s,(上面子查询) s2
where s.cno=s2.cno and s.degree=s2.最高分
-- 查询3：根据上面查询的学号 查询学生信息
select * from student where sno in(上面查询语句)
```

#### 14.3 exists型子查询 ---难点 sql优化

把内层查询的结果 拿到外层查询去测试，如果内层查询的结果成立(有对应的数据)则取出该行数据，如果不成立，则不执行外层查询（等价于in基本使用）

```sql
-- 语法1：判断子查询的结果是否存在
-- 执行方式：如果子查询结果存在 则执行外层查询匹配的数据
-- 如果子查询结果不存在 则外层查询什么都查不到
select * from 表 where exists (子查询)
-- 语法2：判断子查询的结果是否不存在
select * from 表 where not exists (子查询)
```

```sql
-- exists型子查询 只关注于子查询有没有
-- 跟几条数据没有关系 类似于if判断
-- 查询 考过 6-166 的学生信息
select * from student s
where not EXISTS
(select * from t_score sc 
where cno='6-166' and sc.sno=s.sno)
-- in()的方式
select * from student s
where sno not in
(select sno from t_score where cno='6-166')
-- exists相比于in 更使用于子查询结果数据量特别大的时候 增加很高的效率
```

==注：exists子查询如果子查询数据量特别大 执行效率会高于in() 也是后期优化sql语句一种方式==

## 15. 索引 ---重点 难点 面试题

> 比如：
>
> 什么是索引？
>
> 索引有哪些分类？
>
> 索引什么时候失效？
>
> 怎么查询一条sql语句执行性能？
>
> 联合索引 最左匹配原则？
>
> 索引底层数据结构是什么？

#### 15.1 什么是索引 ---面试题

索引就是用来加快查询效率的一种方式，可以不断的缩小查询数的范围 从而节省了查询的时间，类似于字典中的目录 只需要找到一定范围内的数据 而不需要逐一的去查询（底层是B+树实现的）

#### 15.2 索引的分类 --- 面试题

- 普通索引：index
- 唯一索引：
  - 主键索引：primary key 添加约束自动添加
  - 唯一索引：unique 添加约束自动添加（也可以手动）
- 全文索引：fulltext 用于搜索很长一篇文章的
- 联合索引：
  - 联合普通索引：index(id,name)
  - 联合主键索引：primary key(sid,cid)
  - 联合唯一索引：unique(name,card)

```sql
-- 假设一张表
会员编号 int    	-- 适合主键索引
会员姓名 varchar	-- 适合普通索引 联合普通索引
身份证号 varchar	-- 适合唯一索引
会员电话 varchar	-- 适合唯一索引 联合普通索引
会员地址 varchar	-- 适合普通索引
会员备注信息 text	   -- 适合全文索引

-- 但是：索引不是越多越好
```

#### 15.3 索引的创建和删除

```sql
-- 创建索引语法1：
create [unique | fulltext] index 索引名
on 表名(字段)

-- 创建索引语法2：
alter table 表名 add [unique | fulltext] index 索引名(字段名)

-- 删除索引语法：
drop index 索引名 on 表

-- 使用索引：通过添加了索引的字段 作为查询条件时 就会通过索引快速定位数据范围 进而提高查询速度
```

#### 15.4 如何查看是否走了索引 --- 面试题

> 通过mysql一个命令 explain 查看一条sql语句执行计划，也可以查看sql语句整体性能 也可以查看到是否执行了索引
>
> 语法：explain + 查询语句

![image-20240715161832009](https://s2.loli.net/2024/07/15/tralF9JIhos4Cn1.png)

- select_type：表示是否有多表关联 或者子查询 或者unino

- table：查看这条sql语句中涉及到了几张表

- type：可以查看sql语句整体性能 也可以查看是否走了索引

  sql语句性能从高到低：优化sql最低级别至少达到range以上

  system>const>eq_ref>ref>fulltext>range>index>all

  - system：表中只有一行数据或者空表 但是InnoDB引擎都是all
  - const：表示使用主键索引或者唯一索引
  - eq_ref：用于连接查询，一个表只返回一个记录 并且这个记录是另一个表的主键或者唯一键 并且必须not null
  - ref：相比上面 没有那么多要求 返回数据不唯一的 等值查找(非唯一索引)
  - fulltext：全文索引，如果全文索引和普通索引都存在，优先使用全文索引
  - range：索引扫描范围 常用于> < between in like ...
  - index：索引全表扫描 把索引从头到尾 都扫描一遍
  - all：全表扫描

- possible_keys和key：这两者是类似的 如果不走索引 值为null 走了索引一般是有值的

- rows：执行sql语句过程中估算的行数 不是精确的值

```sql
-- 测试如何查看sql语句性能和索引
create table testIndex2(
	id int PRIMARY KEY,
	name varchar(100),
	card varchar(100) unique,
	mess varchar(1000)
);
create index name_index on testIndex2(name);
create fulltext index mess_index on testIndex2(mess);

insert into testIndex2 values
(1,'姓名1','身份证1','结束1'),
(2,'姓名2','身份证2','结束2'),
(3,'姓名3','身份证3','结束3'),
(4,'姓名4','身份证4','结束4'),
(5,'姓名5','身份证5','结束5');

explain select * from testIndex2;
-- system：最高级别 表里面只有一行或者空
-- INNODB引擎 返回all
-- 借助于虚拟表来处理
explain select * from city;
explain select * from (select 1) s;

-- const：泛指使用了主键或者唯一键 作为查询条件时
explain select * from testIndex2 where id=5;
explain select * from testIndex2 where card='身份证2';

-- ref：一般非唯一索引（普通索引） 作为条件
EXPLAIN select * from testIndex2 WHERE
name='姓名2';

-- fulltext：全文索引 特殊的是嵌套一个match() 否则不会使用全文索引
explain select * from testIndex2
where match(mess) against('结束1');

-- range：范围查询(between > < in like)
explain select * from testIndex2
where id between 1 and 5;

-- all：随便写
```

==注：索引不是越多越好，索引增加了确实可以提高查询速度，但是如果每列都添加了索引，会降低增删的效率，因为每次增删时都需要去维护这个索引值==

#### 15.5 最左匹配原则 ---面试题

最左匹配原则主要是联合索引使用的，在联合索引中，如果查询条件涉及到索引的多个字段，只有联合索引最左边的字段匹配了才能充分利用索引去查询

```sql
-- 一个联合索引包含（A,B）
select * from 表 where A='值1' and B='值2';
-- 只有在A条件满足后 索引才会被使用，如果A不满足 B满足 它不会走索引
```

#### 15.6 索引失效 ---面试题

- 使用 or 由于是或者的原因 不一定所有的条件都创建了索引 会导致失效
- 使用模糊查询 使用前%不走索引 后%走索引，原因在于前%包含0-n个字符 不知道从谁开始
- 如果条件是字符串内容，没有添加引号 msyql会自动类型转换 也不会走索引
- 使用 is null 或 is not null 不走索引
- 索引的列参与了运算 不走索引		 比如：where id+10=30; 
- 索引的列使用了函数 不走索引        比如：where concat(name,'100')='name100'
- 使用 不等于<>作为条件 也不会走索引
- ...

#### 15.7 索引数据结构 ---面试题

> 为什么mysql会采用B+树数据结构作为索引？
>
> 背其他数据类型为什么不适合做索引，B+树原理

- 数组：数据库对增删改查都要考虑性能，数组查询快 但是增删慢

- 链表：增删快 查询慢

- 哈希表：底层兼容了数组和链表两种结构的特点 增删 查询都很快，不考虑hash冲突 时间复杂度是O(1)，但是hash表是无序的 无法实现范围查询，

- 二叉树：又叫二叉排序树(BST)，底层主要包含三类的内容

  - 根节点：树的最顶端 只有一个
  - 子节点：除了根节点 它下面还连接其他节点 左子树和右子树
  - 叶子节点：下面没有连接其他节点了 就是树的底端

  ```txt
  二叉树查找元素的方式：首先先和根节点进行比较 相等则查找成功，如果不等，当根节点的值 大于查找的内容 则继续往左子树里面查询，反之 则继续往 右子树里面查询...
  
  二叉树是如何插入元素：首先判断二叉树是否为空 如果是空直接插入根节点，如果非空 就要拿这个值和根节点值比较 
  如果插入元素<根节点 则插入到左子树
  如果插入元素>根节点 则插入到右子树
  
  二叉树是否适合做索引：不适合	如果我插入数据时 是有顺序的 那么二叉树就可能形成一个链(链表) 这样查询就特别慢了
  ```

  ![c72e989b35cdc00849d911b6debc4df1](https://s2.loli.net/2024/07/16/njovBSFGJLdhrK4.png)

- 平衡二叉树(AVL)：任何节点的两个子树高度差不会超过1 而且左右两个子树 又是一个平衡二叉树  也会满足二叉树的特点

```txt
平衡二叉树是否适合做索引：不适合	因为这是一个树的通病 树的高度越高 效率越低，高度越低 效率才会越高。无法控制高度 所以如果数据量小才可以 但是数据量庞大时 查询效率就非常低了
```



![d3059a27be7eb50d0f6b32251ce17efe](https://s2.loli.net/2024/07/16/YLkHCvTVR6gWSay.png)

- 红黑树(RB-Tree)：红黑树是一种可以实现自我平衡有序二叉树，但它不是通过子树高度来控制平衡的，而是根据每个节点设置红色和黑色 达到颜色平衡

```txt
红黑树特点：
1.每个节点只能红色或者黑色
2.根节点必须是黑色的
3.每个存储null叶子节点也是黑色的
4.如果有一个节点是红色 那么它的子节点必须黑色的 就是红黑树不允许有两个红色的
最后：可以保证从根节点开始到任何一个叶子节点 黑色数量一定是一样的 达到颜色的平衡

红黑树插入规则：插入规则 和普通二叉树一样的 大的元素放入右子树 小的元素放入左子树 但是有两个点比较重要：1.颜色的改变 2.旋转（左旋和右旋）因为红黑树 插入前和插入后 特点是不变的 如果出现比如说两个连续红色 立马触发左旋或右旋 来调整颜色 来达到自我平衡

插入元素时 这个元素默认是红色的，如果双亲节点颜色是黑的，没有违反红黑树规则（黑色数量一致 没有连续红色）则不用调整 如果双亲节点是红色的 则违反了规则 这个时期触发旋转

红黑树是否适合做索引：不适合	因为类似于平衡二叉树 同样无法控制树的高度 高度越高 查询性能越低....
```

![591b2b8b5dece5da4936d823a07a3f39](https://s2.loli.net/2024/07/16/POmkHuRFGMiNUYh.gif)

![772eb4f59b7f5ba6da045f220a506d04](https://s2.loli.net/2024/07/16/aY61wcxsNEOqTmU.gif)

- B-树：底层就是一个平衡二叉树，区别在于每个节点存储了很多内容（key[主键]和value[除了主键的数据]和指向下一个节点的指针）这样就可以降低树的高度 而且也可以减少IO读取磁盘的次数

```txt
B-树是否适合做索引：不适合	原因在于每个节点都存储了很多数据，单个节点存储容量很小 虽然高度降低了 但是每个节点在数据量特别庞大时 可能会出现空间不足 所以不适合做大量数据存储
```

![b-tree](https://s2.loli.net/2024/07/16/6j8dAcZKBQXOEYh.png)

- B+树：其实就是对B-树升级版，同样可以降低树的高度，同样也能减少IO读取磁盘次数，相比B-树 它的每个节点不会存储这么多的内容 根节点和左右子树 一般只存储指针和数据主键，最后所有数据 全部存储到叶子节点 这样就可以给叶子节点分配更大的空间 适合做大量存储 而且它的每个叶子节点 是连接在一起的 这样又形成了一个有序的链表 非常适合做范围查找 所以mysql适合使用B+树做索引

![b+tree](https://s2.loli.net/2024/07/16/KdtAe6Qxql7gf4G.png)

## 16. 视图 ---面试题

视图(view)是一种虚拟的表(本身不存在的)，只会封装一条查询语句，每次执行视图的时候，只相当于把里面封装的查询语句执行一遍

#### 16.1 视图的优劣势

- 优点

  - 简单：使用视图时只需要关注于视图本身，而视图里面封装了多么复杂的查询语句 不用考虑，对使用者来说非常简单

  - 安全：使用视图的用户 只能访问被允许查询数据字段 而具体表中的结构是无法查看的

- 缺点
  - 视图不能提高查询效率，原因在于，每次使用视图 只相当于把里面的查询语句重新走一遍 没有优化过

#### 16.2 视图的基本使用

```sql
-- 创建视图
create view 视图名 as 查询语句;
注：只能放查询语句 其他语句都写不了
-- 如何使用视图：把视图名当成一张表使用即可
select * from 视图;
-- 修改视图
alter view 视图名 as 新的查询语句
-- 如何删除视图
drop view 视图名;
```

- 测试案例

```sql
-- 查询每个学生考试的科目和成绩和任课老师和学生姓名
create view student_exam_info as
select s.sname,c.cname,sc.degree,t.tname
from student s,t_score sc,
t_course c,t_teacher t
where s.sno=sc.sno
and sc.cno=c.cno
and c.tno=t.tno;

-- 使用视图：当成表使用
select * from student_exam_info;

-- 视图基础上再处理数据封装2次视图
-- 统计每个老师 任课的人数 和平均分	平均分大于50的
create view teacher_course_info as
select tname,count(1) num,avg(degree) avg 
from student_exam_info
group by tname
HAVING avg>50;

select * from teacher_course_info;

-- 修改视图
alter view 视图名 as 新的查询语句

alter view teacher_course_info as
select tname,count(1) num,round(avg(degree),1) avg 
from student_exam_info
group by tname
HAVING avg>50;

-- 删除视图	视图1(视图2)
-- 删除内外层视图都可以
-- 只不过删除内层视图后 外层视图使用会受影响
drop view student_exam_info;
drop view teacher_course_info;
```

## 17. 事务 ---面试题

#### 17.1 什么是事务 ---面试题

事务是绑定在一起的逻辑工作单元，这个工作单元可能会包含很多个sql语句 保证这么多个sql语句要同时成功 同时失败

> 比如：工作单元就是后期做项目实现每一个功能，比如一个员工系统 实现一个删除员工的功能，随着项目越来越大 不仅仅只是使用一次delete就可以搞定的

#### 17.2 事务四大特性ACID ---面试题

- 原子性：绑定在一起的sql语句 不能分割 要么都成功 要么都失败
- 一致性：数据在运行前后 结果一定要保持一致
- 隔离性：一个事务和其他事务是不能相互干扰的

```txt
如果userA数据正在被一个事务进行操作，其他事务是无法再对userA数据操作的 只有等事务提交时 其他事务才可以操作
```

- 持久性：事务一旦提交了，对数据的修改是永久的

```txt
如果没有提交事务，可以回滚事务（可以将之前的操作撤销），但是 事务提交后就无法回滚事务了
```

#### 17.3 事务并发问题 ---面试题

- 脏读：事务A读取了事务B更新的数据，然后事务B回滚了事务，那么事务A读取的数据就是脏数据
- 不可重复读：事务A多次读取同一个数据，事务B在事务A读取过程中 对数据更新并提交了事务，导致了事务A多次读取相同的数据 不一致
- 幻读：事务A多次读取同一些数据，事务B在事务A读取过程中 对数据新增或者删除并提交了事务，导致了事务A多次读取数据行数 不一致

#### 17.4 隔离级别 ---面试题

既然存在三种并发问题，数据库同样也提供了解决这三种问题的机制 这种机制可以通过控制事务隔离级别来实现

数据库本身是支持多个事务之间对数据进行读写的能力，隔离级别可以防止多个事务之间并发执行 导致数据不一致的问题

| 隔离级别 | 脏读 | 不可重复读 | 幻读 |
| :------: | :--: | :--------: | :--: |
| 读未提交 |  ×   |     ×      |  ×   |
| 读已提交 |  √   |     ×      |  ×   |
| 可重复读 |  √   |     √      |  ×   |
|  串行化  |  √   |     √      |  √   |

==注：mysql默认事务隔离级别：可重复读。oracle默认事务隔离级别：读已提交。因为隔离级别越高数据安全性越高 但是性能也会降低，所以数据库采用的不是最高的也不是最低的==

#### 17.5 mysql事务处理

oracle数据库本身是手动提交事务的，mysql是自动提交事务的，每次mysql做完增删改之后，都会自动执行commit;(提交事务)，如果mysql想手动做事务，需要设置一个命令

```sql
set autocommit=0;	关闭自动提交(手动)
set autocommit=1;	开启自动提交(默认：自动)

-- 手动做事务的方式
begin       -- 开启一个新事物
...	        -- 这里可以插入很多条sql语句（内存中执行的）
commit;     -- 事务提交（把上面的语句真正执行）
rollback;	-- 事务回滚（把上面的语句执行全部撤销）

比如：java
try{
	begin;//开启一个事务
	执行sql1;
	执行sql2;
	执行sql3;
	commit;//提交真正修改
}catch(){
	rollback;//撤销操作
}finally{
	资源回收
}
```

## 18. 行转列和列转行 ---笔试题

- 行转列

![image-20240717143536906](https://s2.loli.net/2024/07/17/oNVBZDOqw2Y1kp5.png)

```sql
-- 代码实现
-- if实现行转列
select name,
max(if(course='java',score,0)) java,
max(if(course='mysql',score,0)) mysql,
max(if(course='project',score,0)) project
from rowToCol
GROUP BY name;
-- case实现行转列
select name,
max(case course when 'java' then score else 0 end) java,
max(case course when 'mysql' then score else 0 end) mysql,
max(case course when 'project' then score else 0 end) project
from rowToCol
GROUP BY name;
```

- 列转行

![image-20240717145146099](https://s2.loli.net/2024/07/17/jkE8Js9CYnmoS7A.png)

```sql
-- 列转行：借助于 union 或者 union all 合并结果集
select name,'java' course,java score
from colToRow
union
select name,'mysql',mysql
from colToRow
union
select name,'project',project
from colToRow
order by name;
```

## 19. SQL语句优化 ---面试题

- 添加索引 可以加快查询速度
- 避免索引失效
- 禁止使用`*`来做查询，需要编写具体查询字段
- 如果子查询结果集数据量比较大时 可以考虑exists
- 尽量不使用子查询 可以适当使用连接查询
- 如果查询数据很少 可以合理使用limit 限定行数
- 分库 和 分表
  - 分库：将一个库 拆分成很多子数据库，查询时只需要针对其中一个子库查询即可
  - 分表：将一个大表 拆分成很多子表，查询时根据需求查询某个子表
  - 分库和分表的方式：
    - 垂直拆分：相当于把表中不同字段的数据 分别放在不同的子表中
    - 水平拆分：相当于表中每行数据 分别存储在几个不同子表中

## 20. sql语句执行顺序 ---笔试题

```sql
笔试题：select、from、where、group by、having、order by、limlt ... 问这些关键词的执行顺序是什么？

答案：from > where > group > having > select > order by > limit
```

## 21. 存储引擎 ---面试题

存储引擎是数据库底层的软件组织，目的可以管理创建数据、查询数据、删除数据的不同方式，不同存储引擎他们管理的方式不同 比如：存储机制 索引机制 约束机制。。。

```sql
-- 查看mysql所有存储引擎
语法：show engines;
```

![image-20240717164403257](https://s2.loli.net/2024/07/17/FD3BeaSMTAyjG7J.png)

#### 21.1 MyISAM引擎和InnoDB引擎区别 ---面试题

- MyISAM：
  - mysql 5.5之前默认存储引擎 是mysql较早的引擎
  - 不支持事务
  - 适用于读操作远远大于写操作的时候  比如：数据仓库
  - 不支持外键 要确保完整性需要自行控制
- InnoDB：
  - mysql 5.5之后默认存储引擎
  - 支持事务 满足事务的ACID特性 支持事务提交 回滚
  - 更适用于需要频繁数据更新、插入操作
  - 支持外键

## 22. MYSQL总结(所有面试题)

> 1.关系型和非关系型区别？
>
> 2.SQL语句分类？
>
> 3.mysql常用的数据类型？
>
> 4.char和varchar区别？
>
> 5.datetime和timestamp区别？
>
> 6.mysql约束？
>
> 7.mysql三范式？
>
> 8.内连接和左外连接区别？
>
> 9.什么是索引？
>
> 10.索引的分类？
>
> 11.怎么查看索引？
>
> 12.索引什么时候失效？
>
> 13.最左匹配原则？
>
> 14.索引数据结构是什么？
>
> 15.什么是视图？
>
> 16.视图能否提高效率？为什么？
>
> 17.怎么查看一条sql语句的性能(explain)？
>
> 18.什么是事务？
>
> 19.事务四大特征（ACID）？
>
> 20.事务并发问题？
>
> 21.事务隔离级别（默认级别）？
>
> 22.行转列（重点）和列转行？ ---笔试题
>
> 23.sql语句优化？
>
> 24.sql语句关键字的执行顺序？
>
> 25.MyISAM和InnoDB存储引擎的区别？
