-- ----------------------------
-- 菜单权限表
-- ----------------------------
drop table if exists sys_menu;
create table sys_menu (
  menu_id 			int(11) 		  not null auto_increment    comment '菜单ID',
  menu_name 		varchar(50) 	not null 				           comment '菜单名称',
  parent_id 		int(11) 		  default 0 			           comment '父菜单ID',
  order_num 		int(4) 			  default null 			         comment '显示顺序',
  url 				  varchar(200) 	default ''				   			 comment '请求地址',
  menu_type 		char(1) 		  default '' 			       		 comment '菜单类型（0目录 1菜单 2按钮）',
  visible 			char(1) 		  default 0 				   			 comment '菜单状态（0显示 1隐藏）',
  perms 			  varchar(100) 	default '' 				   			 comment '权限标识',
  icon 				  varchar(100) 	default '' 				   			 comment '菜单图标',
  create_by     varchar(64)   default ''                 comment '创建者',
  create_time 	datetime                                 comment '创建时间',
  update_by 		varchar(64) 	default ''			           comment '更新者',
  update_time 	datetime                                 comment '更新时间',
  remark 			  varchar(500) 	default '' 				         comment '备注',
  primary key (menu_id)
) engine=innodb auto_increment=2000 default charset=utf8 comment = '菜单权限表';

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
insert into sys_menu values('1', '首页', '0', '1', 'main.html', '1', '0', '', 'fa fa-home',         'admin', '2018-03-16 11-33-00', 'admin', '2018-03-16 11-33-00', '首页');
insert into sys_menu values('2', '系统管理', '0', '2', '#', '0', '0', '', 'fa fa-gear',         'admin', '2018-03-16 11-33-00', 'admin', '2018-03-16 11-33-00', '系统管理目录');

-- 二级菜单
insert into sys_menu values('100',  '用户管理', '2', '1', 'demo/user.html',        '1', '0', 'system:user:view',         '#', 'admin', '2018-03-16 11-33-00', 'admin', '2018-03-16 11-33-00', '用户管理菜单');
insert into sys_menu values('101',  '角色管理', '2', '2', 'demo/role.html',        '1', '0', 'system:role:view',         '#', 'admin', '2018-03-16 11-33-00', 'admin', '2018-03-16 11-33-00', '角色管理菜单');
