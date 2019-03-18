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