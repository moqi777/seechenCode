create database sc240601;

create table Uuser(
    id int primary key auto_increment comment 'ID',
    name varchar(255) comment '用户名',
    account varchar(255) comment '账号',
    password varchar(255) comment '密码',
    dept varchar(255) comment '部门',
    headImg varchar(255) comment '头像地址',
    gender int comment '性别，true男1  false女0',
    email varchar(255) comment '邮箱',
    mobile varchar(255) comment '手机号',
    memo varchar(255) comment '备注',
    birthday DATE comment '生日',
    state int comment '状态，有效1无效0'
);
desc Uuser;
select * from Uuser;
INSERT INTO Uuser (name, account, password, dept, headImg, gender, email, mobile, memo, birthday, state) VALUES
    ('张伟', 'zhangwei', '123123', '人力资源部', NULL, 1, 'zhangwei@example.com', '13800000001', '无备注', '1985-05-12', 1),
    ('李娜', 'lina', '123123', '技术部', NULL, 0, 'lina@example.com', '13800000002', '无备注', '1990-08-22', 1),
    ('John Smith', 'johnsmith', '123123', '市场部', NULL, 1, 'john.smith@example.com', '13900000001', 'No remarks', '1988-11-30', 1),
    ('Emily Davis', 'emilydavis', '123123', '财务部', NULL, 0, 'emily.davis@example.com', '13900000002', 'No remarks', '1992-02-19', 1),
    ('王芳', 'wangfang', '123123', '行政部', NULL, 0, 'wangfang@example.com', '13800000003', '无备注', '1987-07-25', 1),
    ('Michael Johnson', 'michaeljohnson', '123123', '客服部', NULL, 1, 'michael.johnson@example.com', '13900000003', 'No remarks', '1991-06-15', 1),
    ('Anna Zhang', 'annazhang', '123123', '销售部', NULL, 0, 'anna.zhang@example.com', '13800000004', '无备注', '1995-01-09', 1),
    ('David Lee', 'davidlee', '123123', '研发部', NULL, 1, 'david.lee@example.com', '13900000004', 'No remarks', '1983-12-31', 1),
    ('赵强', 'zhaoqiang', '123123', '人力资源部', NULL, 1, 'zhaoqiang@example.com', '13800000005', '无备注', '1989-04-20', 1),
    ('Jessica Wang', 'jessicawang', '123123', '市场部', NULL, 0, 'jessica.wang@example.com', '13900000005', 'No remarks', '1994-09-11', 1),
    ('陈杰', 'chenjie', '123123', '技术部', NULL, 1, 'chenjie@example.com', '13800000006', '无备注', '1986-10-02', 1),
    ('Laura Wilson', 'laurawilson', '123123', '行政部', NULL, 0, 'laura.wilson@example.com', '13900000006', 'No remarks', '1993-07-18', 1),
    ('Matthew Brown', 'matthewbrown', '123123', '财务部', NULL, 1, 'matthew.brown@example.com', '13800000007', 'No remarks', '1982-03-07', 1),
    ('Sophia Kim', 'sophiakim', '123123', '客服部', NULL, 0, 'sophia.kim@example.com', '13900000007', 'No remarks', '1996-05-23', 1),
    ('李静', 'lijing', '123123', '销售部', NULL, 0, 'lijing@example.com', '13800000008', '无备注', '1991-11-02', 1),
    ('Daniel Scott', 'danielscott', '123123', '研发部', NULL, 1, 'daniel.scott@example.com', '13900000008', 'No remarks', '1984-09-29', 1),
    ('Hannah Chen', 'hannahchen', '123123', '人力资源部', NULL, 0, 'hannah.chen@example.com', '13800000009', 'No remarks', '1992-04-16', 1),
    ('Ryan Anderson', 'ryananderson', '123123', '市场部', NULL, 1, 'ryan.anderson@example.com', '13900000009', 'No remarks', '1987-10-03', 1),
    ('王鹏', 'wangpeng', '123123', '技术部', NULL, 1, 'wangpeng@example.com', '13800000010', '无备注', '1990-12-27', 1),
    ('Emily Zhang', 'emilyzhang', '123123', '销售部', NULL, 0, 'emily.zhang@example.com', '13900000010', 'No remarks', '1995-06-14', 1);
