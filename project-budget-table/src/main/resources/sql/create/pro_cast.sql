use springboot;

drop table if exists pro_cast;
create table pro_cast(
	cast_id int(11) not null auto_increment comment '项目费用表id',
	subcontract_content varchar(255) default null comment '外/分包内容',
	subcontract_message varchar(255) default null comment '外/分包信息',
	subcontract_money int(11) default null comment '外/分包金额',
	purchase_list varchar(255) default null comment '采购清单',
	purchase_money int(11) default null comment '采购金额',
	main_list varchar(255) default null comment '主要清单',
	framentary_money int(11) default null comment '零星采购金额',
	cost_breakdown varchar(255) default null comment '项目费用明细',
	cost_money int(11) default null comment '费用金额',
	primary key(cast_id)
)engine=InnoDB comment '项目费用表' default charset=utf8;