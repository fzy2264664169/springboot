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

----------------------------------------------
--2系统表优化合并    外部表ht_sys_user

drop table if exists ht_attach;
create table ht_attach(
	attach_id int(11) not null auto_increment comment '系统附件表id',
	attach_name varchar(32) default null comment '附件名称',
	create_time datetime default null comment '创建时间',
	attach_type varchar(16) default null comment '附件类型（附件文件后缀提取）',
	attach_size  varchar(32) default null comment '附件大小',
	attach_module  varchar(32) default null comment '附件模块',
	is_delete char(1) default null comment '是否删除（1：删除）',
	primary key(attach_id)
)engine=InnoDB comment '系统附件表' default charset=utf8;

drop table if exists ht_image;
create table ht_image(
	image_id int(11) not null auto_increment comment '系统图片表id',
	image_name varchar(32) default null comment '图片名称',
	image_url varchar(255) default null comment '图片url',
	create_time datetime default null comment '创建时间',
	image_title  varchar(32) default null comment '图片标题',
	image_module  varchar(32) default null comment '图片模块',
	is_delete char(1) default null comment '是否删除（1：删除）',
	primary key(image_id)
)engine=InnoDB comment '系统图片表' default charset=utf8;

drop table if exists ht_comment;
create table ht_comment(
	comment_id int(11) not null auto_increment comment '系统评论表id',
	create_time datetime default null comment '创建时间',
	comment_title varchar(16) default null comment '评论标题',
	comment_content  varchar(255) default null comment '评论内容',
	comment_module  varchar(32) default null comment '评论模块',
	is_delete char(1) default null comment '是否删除（1：删除）',
	primary key(comment_id)
)engine=InnoDB comment '系统评论表' default charset=utf8;

drop table if exists ht_announce;
create table ht_announce(
	announce_id int(11) not null auto_increment announce '系统公告表id',
	create_time datetime default null announce '创建时间',
	announce_title varchar(16) default null announce '公告标题',
	announce_content  varchar(255) default null announce '公告内容',
	announce_module  varchar(32) default null announce '公告模块',
	is_delete char(1) default null announce '是否删除（1：删除）',
	primary key(announce_id)
)engine=InnoDB announce '系统公告表' default charset=utf8;

------------------------------------------------
--3请求管理表     关联的外部表ht_attach,ht_sys_user


drop table if exists request_status;
create table request_status(
	status_id int(1) not null auto_increment comment '请求状态表id',
	status_description varchar(16) default null comment '状态描述',
	primary key(status_id)
)engine = InnoDB comment '请求状态表' default charset=utf8;

drop table if exists request_type;
create table request_type(
	type_id int(1) not null auto_increment comment '请求类型表id',
	type_description varchar(16) default null comment '类型描述',
	primary key(type_id)
)engine = InnoDB comment '请求类型表' default charset=utf8;

drop table if exists request_form;
create table request_form(
	form_id int(1) not null auto_increment comment '请求服务形式表id',
	form_description varchar(16) default null comment '服务形式描述',
	primary key(form_id)
)engine = InnoDB comment '请求服务形式表' default charset=utf8;

drop table if exists request_module;
create table request_module(
	module_id int(1) not null auto_increment comment '请求服务模块表id',
	module_description varchar(16) default null comment '服务模块描述',
	primary key(module_id)
)engine = InnoDB comment '请求服务模块表' default charset=utf8;

drop table if exists request_fault;
create table request_fault(
	fault_id int(1) not null auto_increment comment '请求故障表id',
	fault_description varchar(16) default null comment '故障描述',
	primary key(fault_id)
)engine = InnoDB comment '请求故障表' default charset=utf8;

---------------------------------------------------

drop table if exists ht_ope_request;
create table ht_ope_request(
	request_id int(11) not null auto_increment comment '请求表id',
	request_member varchar(32) default null comment '请求编号（自动递增生成：REQ+年月日+当天序号',
	request_content varchar(255) default null comment '请求内容',
	create_time datetime default null comment '请求创建时间（自动生成系统当前时间）',
	close_time datetime default null comment '请求关闭时间',
	request_evaluate int(3) default null comment '请求服务评价（百分制）',
	module_id int(1) not null comment '服务模块类型',
	form_id int(1) not null comment '服务形式模块',
	type_id int(1) not null comment '请求类型',
	status_id int(1) not null comment '请求状态',
	fault_id int(1) not null comment '请求故障',
	user_id int(11) not null comment '请求创建人信息',
	attach_id int(11) not null comment '请求附件',
	primary key(request_id),
	constraint fk_module_request foreign key(module_id) references request_module(module_id),
	constraint fk_form_request foreign key(form_id) references request_form(form_id),
	constraint fk_type_request foreign key(type_id) references request_type(type_id),
	constraint fk_status_request foreign key(status_id) references request_status(status_id),
	constraint fk_fault_request foreign key(fault_id) references request_fault(fault_id),
	constraint fk_user_request foreign key(user_id) references ht_sys_user(user_id),
	constraint fk_attach_request foreign key(attach_id) references ht_attach(attach_id)
)engine=InnoDB comment '请求表' default charset=utf8;

---------------------------------------------
--4服务管理

drop table if exists ht_ser_project;
create table ht_ser_project(
	project_id int(11) not null auto_increment comment '项目表id',
	project_name varchar(64) default null comment '项目名称',
	project_customer varchar(32) default null comment '项目客户',
	project_money int(11) default null comment '项目金额',
	project_organize varchar(64) default null comment '项目负责部门',
	project_saler varchar(16) default null comment '项目销售人员',
	project_type varchar(16) default null comment '项目类型',
	project_status varchar(16) default null comment '项目状态',
	project_stage varchar(16) default null comment '项目阶段',
	primary key(project_id)
)engine = InnoDB comment '项目表' default charset = utf8;

-------------------------------------------
drop table if exists ht_ser_contract;
create table ht_ser_contract(
	contract_id int(11) not null auto_increment comment '合同表id',
	contract_name varchar(64) default null comment '合同名称',
	contract_money int(11) default null comment '合同金额',
	contract_type varchar(16) default null comment '合同类型',
	party_first varchar(32) default null comment '合同甲方',
	party_second varchar(32) default null comment '合同乙方',
	start_time datetime default null comment '合同开始时间',
	end_time datetime default null comment '合同结束时间',
	contract_status varchar(32) default null comment '合同状态',
	contract_description varchar(255) default null comment '合同描述',
	project_id int(11) not null comment '隶属的项目',
	primary key(contract_id),
	constraint fk_project_contract foreign key(project_id) references ht_ser_project(project_id)
)engine = InnoDB comment '合同表' default charset = utf8;

-----------------------------------------------------
drop table if exists ht_ser_catelog;
create table ht_ser_catelog(
	catelog_id int(11) not null auto_increment comment '服务目录id',
	contract_id int(11) not null comment '合同列表',
	project_id int(11) not null comment '项目列表',
	primary key(catelog_id),
	constraint fk_contract_catelog foreign key(contract_id) references ht_ser_contract(contract_id),
	constraint fk_project_catelog foreign key(project_id) references ht_ser_project(project_id)
)engine = InnoDB comment '服务目录表' default charset = utf8;

-----------------------------------------------
--5知识库表    关联的外部表ht_image,ht_attach,ht_sys_user,ht_comment



drop table if exists ht_kno_knoledge;
create table ht_kno_knoledge(
	knoledge_id int(11) not null auto_increment comment '知识库表id'，
	knoledge_title varchar(32) default null comment '知识标题',
	knoledge_type varchar(16) default null comment '知识类型',
	knoledge_scope varchar(16) default null comment '知识适用范围',
	knoledge_source varchar(16) default null comment '知识来源',
	knoledge_key varchar(32) default null comment '知识关键词',
	knoledge_content varchar(255) default null comment '知识内容',
	image_id int(11) not null comment '知识图片',
	attach_id int(11) not null comment '知识附件',
	user_id int(11) not null comment '用户信息',
	comment_id  int(11) not null comment '知识评论',
	primary key(knoledge_id),
	constraint fk_image_knoledge foreign key(image_id) references ht_image(image_id),
	constraint fk_attach_knoledge foreign key(attach_id) references ht_image(attach_id),
	constraint fk_user_knoledge foreign key(user_id) references ht_sys_user(user_id),
	constraint fk_comment_knoledge foreign key(comment_id) references ht_image(comment_id)
)engine = InnoDB comment '知识库表' default charset = utf8;

----------------------------------------------
--6接口管理表
drop table if exists ht_sys_interface;
create table ht_sys_interface(
	interface_id int(11) not null auto_increment comment '接口表id',
	interface_name varchar(32) default null comment '接口名称',
	interface_address varchar(255) default null comment '接口地址',
	interface_time datetime default null comment '接口创建时间'，
	interface_description varchar(255) default null comment '接口描述',
	user_id int(11) not null comment '接口创建人信息',
	primary key(interface_id),
	constraint fk_user_interface foreign key(user_id) references ht_sys_user(user_id)
)engine=InnoDB comment '接口表' default charset=utf8;

-----------------------------------------------
--7拓展模块管理表    关联的外部表ht_sys_user

drop table if exists ht_exp;
create table ht_exp(
	exp_id int(11) not null auto_increment comment '拓展模块表id',
	exp_name varchar(32) default null comment '拓展模块名称',
	exp_content varchar(255) default null comment '拓展模块内容',
	exp_time datetime default null comment '拓展模块创建时间'，
	exp_reason varchar(255) default null comment '拓展模块原因',
	exp_function varchar(255) default null comment '拓展模块功能',
	user_id int(11) not null comment '拓展模块创建人信息',
	primary key(exp_id),
	constraint fk_user_exp foreign key(user_id) references ht_sys_user(user_id)
)engine=InnoDB comment '拓展模块表' default charset=utf8;



