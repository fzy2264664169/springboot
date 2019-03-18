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