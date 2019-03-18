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

