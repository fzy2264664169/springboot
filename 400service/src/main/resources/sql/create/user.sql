--本sql为创建用户相关的表

--1、如果springboot数据库存在则删除
drop database if exists springboot1;
--2、创建名为springboot的数据库，默认编码是utf8支持中文
create datebase springboot1 default character set utf8;

user springboot1;
--3、创建数据库（原则：主表基数据先创建，即无外键的数据库）
--模板
--drop table if exists ;
--create table (
--	
--	primary key(),
--	constraint 
--)engine = InnoDB comment '' default charset = utf8;

------------------------组织架构表-------------------------------------------
drop table if exists user_department2;
create table user_department2(
	department2_id int(2) not null auto_increment comment '二级部门id',
	department2_name varchar(32) default null comment '二级部门名称',
	primary key(department2_id)
)engine = InnoDB comment '组织结构——二级部门表' default charset = utf8;

drop table if exists user_department1;
create table user_department1(
	department1_id int(2) not null auto_increment comment '一级部门id',
	department1_name varchar(32) default null comment '一级部门名称',
	department2_id int(2) not null comment '关联二级部门',
	primary key(department1_id),
	constraint fk_dep2_dep1 foreign key(department2_id) references user_department2(department2_id)
)engine = InnoDB comment '组织结构——一级部门表' default charset = utf8;

drop table if exists user_company;
create table user_company(
	company_id int(5) not null auto_increment comment '企业id',
	company_name varchar(64) default null comment '企业名称',
	company_address varchar(255) default null comment '企业地址',
	company_phone int(12) default null comment '企业对外咨询电话',
	department1_id int(2) not null comment '关联一级部门表',
	primary key(company_id),
	constraint fk_dep1_company foreign key(department1_id) references user_department1(department1_id)
)engine = InnoDB comment '组织结构——企业表' default charset = utf8;

--------------------------------------用户表----------------------------------
drop table if exists user_status;
create table user_status(
	status_id int(1) not null auto_increment comment '用户状态表id',
	status_description varchar(32) default null comment '状态描述',
	primary key(status_id)
)engine = InnoDB comment '用户状态表' default charset = utf8;

drop table if exists user_permission;
create table user_permission(
	permission_id int(1) not null auto_increment comment '用户权限表id',
	permission_description varchar(32) default null comment '权限描述',
	primary key(permission_id)
)engine = InnoDB comment '用户权限表' default charset = utf8;

drop table if exists user_info;
create table user_info(
	info_id int(11) not null auto_increment comment '用户信息表id',
	info_name varchar(32) default null comment '用户名字',
	info_gender char(1) default null comment '用户性别',
	info_phone int(12) default null comment '用户电话',
	info_email varchar(64) default null comment '用户邮箱',
--	不明白这个字段的设计
	modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	company_id int(5) not null comment '关联企业表',
	status_id int(1) not null comment '关联用户状态表',
	permission_id int(1) not null comment '关联用户权限表',
	primary key(info_id),
	constraint fk_company_info foreign key(company_id) references user_company(company_id),
	constraint fk_status_info foreign key(status_id) references user_status(status_id),
	constraint fk_perm_info foreign key(permission_id) referendes user_permission(permission_id)
)engine = InnoDB comment '用户信息表' default charset = utf8;


drop table if exists ht_sys_user;
create table ht_sys_user(
	user_id varchar(64) not null auto_increment comment '用户登录表id',
	user_name varchar(16) default null comment '用户登录名称（不可重复）',
	user_password varchar(16) default null comment '用户登录密码（大于六位小于17位）',
--	不明白这个字段的设计
	modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	status_id int(1) not null comment '用户状态（关联状态表）',
	permission_id int(1) not null comment '用户权限（关联权限表）',
	primary key (user_id),
	constraint fk_status_user foreign key(status_id) references user_status(status_id),
	constraint fk_permission_user foreign key(permission_id) references user_permission(permission_id),
)engine = InnoDB comment '用户登录表' default charset = utf8;


drop table if exists user_log;
create table (
	log_id int(11) not null auto_increment comment '用户日志id',
	login_time datetime default null comment '用户登录时间',
	login_ip varchar(64) default null comment '用户登录IP',
	login_type char(1) default null comment '登录类型（成功与否）',
	user_id not null default null comment '关联用户登录表登录用户',
	primary key(log_id),
	constraint fk_user_log foreign key(user_id) references ht_sys_user(user_id)
)engine = InnoDB comment '用户登录日志表' default charset = utf8;


