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