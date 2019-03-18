use springboot;

drop table if exists info_ptype;
create table info_ptype(
	ptype_id int(1) not null auto_increment comment '项目类型id',
	project_type varchar(16) default null comment '项目类型',
	primary key(ptype_id)
)engine=InnoDB comment '项目类型表' default charset=utf8;

drop table if exists info_pform;
create table info_pform(
	pform_id int(1) not null auto_increment comment '项目性质id',
	project_form varchar(16) default null comment '项目性质',
	primary key(pform_id)
)engine=InnoDB comment '项目性质表' default charset=utf8;

drop table if exists info_sform;
create table info_sform(
	sform_id int(1) not null auto_increment comment '服务形式id',
	service_form varchar(16) default null comment '服务形式',
	primary key(sform_id)
)engine=InnoDB comment '服务形式表' default charset=utf8;


drop table if exists pro_info;
create table pro_info(
	info_id int(11) not null auto_increment comment '项目基本信息表',
	customer_name varchar(32) default null comment '客户名称',
	project_name varchar(32) default null comment '项目名称',
	contract_number varchar(32) default null comment '合同编号',
	response_department varchar(32) default null comment '负责部门',
	project_manager varchar(32) default null comment '项目经理',
	project_money int(11) default null comment '项目金额',
-- apply_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请最后修改时间',
	apply_date datetime default null comment '申请时间',
	start_time datetime default null comment '开始时间',
	end_time datetime default null comment '结束时间',
	ptype_id int(1) not null comment '项目类型id',
	pform_id int(1) not null comment '项目性质id',
	sform_id int(1) not null comment '服务形式id',
	primary key(info_id),
	constraint fk_ptype_info foreign key(ptype_id) references info_ptype(ptype_id),
	constraint fk_pform_info foreign key(pform_id) references info_pform(pform_id),
	constraint fk_sform_form foreign key(sform_id) references info_sform(sform_id)
)engine=InnoDB comment '项目基本信息表' default charset=utf8;
