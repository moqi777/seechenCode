-- 光年项目一共八张表

-- 管理员表(id,账号,密码,真实姓名,手机号,
-- 邮件,状态(0未验证 1正常 2禁用),创建时间,
-- 性别,角色id(外键),头像,操作者)
create table O_ADMIN(
  ID int primary key auto_increment,
  ACCOUNT VARCHAR(50) not null,
  PASSWORD VARCHAR(32) not null,
  NAME VARCHAR(50),
  PHONE VARCHAR(20) not null,
  EMAIL VARCHAR(100),
  STATUS CHAR(1) default 0,
  CREATETIME date,
  SEX CHAR(1) default '0',
  ROLEID int,
  HEAD_PIC VARCHAR(100),
  OPERATOR int
);
-- 角色表(id,角色名称,描述,状态(0禁用 1正常),操作者,创建时间)
create table O_ROLE(
  ID int primary key auto_increment,
  ROLENAME VARCHAR(100) not null,
  OVERVIEW VARCHAR(200),
  STATUS CHAR(1) default '1',
  OPERATOR int,
  CREATETIME date
);
-- 添加用户表的外键 对应角色表主键
alter table O_ADMIN
  add constraint O_ADMIN_ROLE_FK
foreign key (ROLEID) references O_ROLE(id);
-- 文章表(id,标题,作者,内容,类型,文章所属栏目,关键字,
-- 状态(0不发布  1发布),操作者,创建时间,访问量,文章图片,最后更新者,更新时间)
create table O_ARTICLE(
  ID int primary key auto_increment,
  TITLE VARCHAR(100),
  AUTHOR VARCHAR(50),
  CONTENT varchar(500),
  TYPE int,
  CATEGORY int,
  KEYWORDS VARCHAR(300),
  STATUS CHAR(1) default 0,
  CREATE_BY int,
  CREATE_TIME date,
  PV int,
  PIC VARCHAR(100),
  UPDATE_BY int,
  UPDATE_TIME date
);
-- 栏目表(id,栏目名,栏目缩略图,父级栏目id(-1表示一级栏目),
-- 栏目描述,创建者,创建时间,最后更新者,更新时间,排序,
-- 状态(0 不可用  1可用),是否前台显示菜单(1是  0不是))
create table O_CATEGORY(
  ID int primary key auto_increment,
  NAME VARCHAR(100) not null,
  LITIMG VARCHAR(100),
  PARENTID int default -1,
  DESCRIPTION VARCHAR(200),
  CREATE_BY int,
  CREATE_TIME date,
  UPDATE_BY int,
  UPDATE_TIME date,
  SORT int,
  STATUS CHAR(1) default 1,
  ISMENU CHAR(1) default '1'
);
-- 菜单表(id,菜单名称,请求地址,图标,排序,父级菜单id(-1表示一级菜单),
-- 创建者,创建时间,状态(0 禁用 1正常))
create table O_MENU(
  ID int primary key auto_increment,
  NAME VARCHAR(100) not null,
  URL VARCHAR(100),
  ICON VARCHAR(100),
  SORT int,
  PARENTID int,
  CREATE_BY int,
  CREATE_TIME date,
  STATUS CHAR(1) default 1
);
-- 日志表(id,日志类型(1登录 2新增 3修改 4删除 5修改密码),
-- 操作者,操作时间,操作数据信息,ip地址,日志描述)
create table O_LOG(
  ID int primary key auto_increment,
  TYPE CHAR(1),
  OPERATOR int,
  TIME date,
  DATA VARCHAR(2000),
  IP VARCHAR(20),
  CONTENT VARCHAR(200)
);
-- 角色和菜单关系表(角色id(外键),菜单id(外键))
create table O_ROLE_MENU(
  ROLEID int,
  MENUID int
);
-- 添加关系表外键对应角色表主键
alter table O_ROLE_MENU
add constraint O_ROLE_MENU_ROLEID_FK
foreign key (ROLEID) references O_ROLE(id);
-- 添加关系表外键对应菜单表主键
alter table O_ROLE_MENU
  add constraint O_ROLE_MENU_MENUID_FK
foreign key (MENUID) references O_MENU(id);
-- 客户反馈表(id,客户姓名,职务,邮件,手机号,公司,地址,
-- 交易状态(0 未处理 1已处理),操作者,交易时间)
create table O_FEEDBACK(
  ID int primary key auto_increment,
  NAME VARCHAR(50),
  JOB VARCHAR(50),
  EMAIL VARCHAR(100),
  PHONE VARCHAR(20),
  COMPANY VARCHAR(100),
  ADDRESS VARCHAR(500),
  DEAL CHAR(1) default '0',
  OPERATOR int,
  DEAL_TIME date
);