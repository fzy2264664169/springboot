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

