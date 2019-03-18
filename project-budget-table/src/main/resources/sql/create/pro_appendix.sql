use springboot;

drop table if exists appendix_idea;
create table appendix_idea(
	aidea_id int(1) not null auto_increment comment '项目附录意见表',
	appendix_idea varchar(16) default null comment '项目附录意见',
	primary key(aidea_id)
)engine=InnoDB comment '项目附录意见表' default charset=utf8;

drop table if exists pro_appendix;
create table pro_appendex(
	appendix_id int(11) not null auto_increment comment '项目附录表id',
	principal_name varchar(16) default null comment '项目负责人签名',
	principal_date datetime default null comment '项目负责人签名日期',
	section_name varchar(16) default null comment '部门签名',
	section_date datetime default null comment '部门签名日期',
	center_name varchar(16) default null comment 'S1服务管理中心签名',
	center_date datetime default null comment 'S1服务管理中心签名日期',
	aidea_id int(1) not null comment '项目附录意见表id',
	primary key(appendix_id),
	constraint fk_idea_appendix foreign key(aidea_id) references appendix_idea(aidea_id)
)engine=InnoDB comment '项目附录表' default charset=utf8;