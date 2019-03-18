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




