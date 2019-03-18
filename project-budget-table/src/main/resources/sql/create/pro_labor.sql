--关联表缺少指定名称的外键名

use springboot;

drop table if exists labor_sposition;
create table labor_sposition(
	sposition_id int(1) not null auto_increment comment '服务人员职位id',
	servicer_position varchar(16) default null comment '服务人员职位',
	average_cost int(11) default null comment '日均成本',
	primary key(sposition_id)
)engine=InnoDB comment '人员职位薪资表' default charset=utf8;

drop table if exists labor_type;
create table labor_type(
	wtype_id int(1) not null auto_increment comment '项目工作类型id',
	work_type varchar(32) default null comment '项目工作类型',
	primary key(wtype_id)
)engine=InnoDB comment '项目工作类型表' default charset=utf8;

drop table if exists pro_labor;
create table pro_labor(
	labor_id int(11) not null auto_increment comment '项目人力职责表id',
	servicer_name varchar(16) default null comment '服务人员姓名',
	everyday int(11) default null comment '日常薪资',
	weekendsday int(11) default null comment '双休日薪资',
	nationalday int(11) default null comment '国定日薪资',
	duty_note varchar(255) default null comment '项目职责备注',
	sposition_id int(1) not null comment '人员职位薪资表id',
	wtype_id int(1) not null comment '项目工作类型表id',
	primary key(labor_id),
	constraint foreign key(sposition_id) references labor_sposition(sposition_id),
	constraint foreign key(wtype_id) references labor_type(wtype_id)
)engine=InnoDB comment '项目人力职责表' default charset=utf8;
