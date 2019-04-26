create table `user`(
`id` int(10) not null  AUTO_INCREMENT COMMENT 'id',
`name` varchar(20) not null comment '姓名',
`age` int(3) not null comment '年龄',
`desc` varchar(100) default null comment '备注',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;