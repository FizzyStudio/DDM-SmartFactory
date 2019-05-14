-- Table: product_type_status 
create table product_type_status
(
   type_status_id       int(2) not null,
   seq                  int(2) comment '序号',
   name                 varchar(20) comment '名称',
   primary key (type_status_id)
);

alter table product_type_status comment '产品类型状态代码表';


-- Table: product_type 
create table product_type
(
   product_tid          bigint(20) not null,
   descripe             varchar(500) comment '型号描述',
   name                 varchar(500) comment '名称',
   status               int(2) comment '状态(是否已经弃用等)',
   primary key (product_tid)
);

alter table product_type comment '产品型号表';
alter table product_type add constraint fk_product_type_status foreign key (status)
      references product_type_status (type_status_id) on delete restrict on update restrict;
	  
	  
-- Table: product_status
create table product_status
(
   status_id            int(2) not null,
   seq                  int(2) comment '序号',
   name                 varchar(20) comment '名称',
   primary key (status_id)
);

alter table product_status comment '产品状态代码表';


-- Table: product
create table product
(
   product_id           bigint(20) not null,
   product_tid          bigint(20),
   qr_code              varchar(2000) comment '二维码',
   descripe             varchar(500) comment '产品描述',
   status               int(2) comment '状态',
   produce_plan_item_id bigint(20),
   produce_plan_id      bigint(20),
   num                  int(11) comment '数量（默认1）',
   primary key (product_id)
);

alter table product comment '产品表';

alter table product add constraint FK_product_status foreign key (status)
      references product_status (status_id) on delete restrict on update restrict;

alter table product add constraint FK_product_produce_item foreign key (produce_plan_item_id)
      references produce_plan_item (produce_plan_item_id) on delete restrict on update restrict;

alter table product add constraint FK_product_produce_plan foreign key (produce_plan_id)
      references produce_plan (produce_plan_id) on delete restrict on update restrict;

alter table product add constraint FK_product_tid foreign key (product_tid)
      references product_type (product_tid) on delete restrict on update restrict;
	  
	  
	  
	  

-- Table: procedure_status

create table procedure_status
(
   status_id            int(2) not null,
   seq                  int(2) comment '序号',
   name                 varchar(20) comment '名称',
   primary key (status_id)
);

alter table procedure_status comment '工序状态代码表';


-- Table: work_procedure
create table work_procedure
(
   procedure_id         bigint(20) not null,
   name                 varchar(200) comment '工序名称',
   descripe             varchar(500) comment '工序描述',
   status               int(2) comment '状态',
   primary key (procedure_id)
);

alter table work_procedure comment '工序表';

alter table work_procedure add constraint FK_work_procedure_status foreign key (status)
      references procedure_status (status_id) on delete restrict on update restrict;
	  


-- Table: procedure_group_status
create table procedure_group_status
(
   status_id            int(2) not null,
   seq                  int(2) comment '序号',
   name                 varchar(20) comment '名称',
   primary key (status_id)
);

alter table procedure_group_status comment '工序组状态代码表';


-- Table: procedure_group
create table procedure_group
(
   procedure_group_id   bigint(20) not null,
   status               int(2),
   name                 varchar(200) comment '工序组名称',
   descripe             varchar(500),
   primary key (procedure_group_id)
);

alter table procedure_group comment '工序组表';

alter table procedure_group add constraint FK_procedure_group_status foreign key (status)
      references procedure_group_status (status_id) on delete restrict on update restrict;
	  

-- Table: procedure_group_relation
create table procedure_group_relation
(
   relation_id          bigint(20) not null,
   group_id             bigint(20),
   procedure_id         bigint(20),
   step                 int(3) comment '工序步骤',
   necessary            int(1),
   primary key (relation_id)
);

alter table procedure_group_relation comment '工序组-工序关系表';

alter table procedure_group_relation add constraint FK_procedure_group_relation_group foreign key (group_id)
      references procedure_group (procedure_group_id) on delete restrict on update restrict;

alter table procedure_group_relation add constraint FK_procedure_group_relation_procedure foreign key (procedure_id)
      references work_procedure (procedure_id) on delete restrict on update restrict;

	  
-- Table: produce_plan_status  
create table produce_plan_status
(
   status_id            int(2) not null,
   seq                  int(2) comment '序号',
   name                 varchar(20) comment '名称',
   primary key (status_id)
);

alter table produce_plan_status comment '生产计划状态代码表';


-- Table: produce_plan 
create table produce_plan
(
   produce_plan_id      bigint(20) not null,
   name                 varchar(200) comment '计划名称',
   begin_time           date comment '计划开始时间',
   end_time             date comment '计划结束时间',
   descripe             varchar(500) comment '计划描述',
   pid          bigint(20) comment '父id',
   status               int(2),
   primary key (produce_plan_id)
);

alter table produce_plan comment '生产计划表';

alter table produce_plan add constraint FK_produce_plan_pid foreign key ("pid(子计划用)")
      references produce_plan (produce_plan_id) on delete restrict on update restrict;

alter table produce_plan add constraint FK_produce_plan_status foreign key (status)
      references produce_plan_status (status_id) on delete restrict on update restrict;
	  


-- Table: produce_plan_item 
create table produce_plan_item
(
   produce_plan_item_id bigint(20) not null,
   produce_plan_id      bigint(20),
   product_tid          bigint(20),
   procedure_group_id   bigint(20),
   num                  int(11) comment '数量',
   primary key (produce_plan_item_id)
);

alter table produce_plan_item comment '生产计划内容';

alter table produce_plan_item add constraint FK_produce_plan_item_planid foreign key (produce_plan_id)
      references produce_plan (produce_plan_id) on delete restrict on update restrict;

alter table produce_plan_item add constraint FK_produce_plan_item_tid foreign key (product_tid)
      references product_type (product_tid) on delete restrict on update restrict;

alter table produce_plan_item add constraint FK_produce_plan_item_groupid foreign key (procedure_group_id)
      references procedure_group (procedure_group_id) on delete restrict on update restrict;	 



-- Table: work_seat 
create table work_seat
(
   work_seat_id         bigint(20) not null,
   primary key (work_seat_id)
);

alter table work_seat comment '工位';



-- Table: employer
create table employer
(
   employer_id          bigint(20) not null,
   primary key (employer_id)
);

alter table employer comment '雇员表';

-- Table: product_log 
create table product_log
(
   product_log_id       bigint(20) not null,
   product_id           bigint(20),
   work_seat_id         bigint(20),
   employer_id          bigint(20),
   procedure_id         bigint(20),
   create_at            date comment '时间',
   num                  int(11) comment '数量',
   primary key (product_log_id)
);

alter table product_log comment '产品生产日志表';

alter table product_log add constraint FK_product_log_work_seat foreign key (work_seat_id)
      references work_seat (work_seat_id) on delete restrict on update restrict;

alter table product_log add constraint FK_product_log_employer foreign key (employer_id)
      references employer (employer_id) on delete restrict on update restrict;

alter table product_log add constraint FK_product_log_work_procedure foreign key (procedure_id)
      references work_procedure (procedure_id) on delete restrict on update restrict;

alter table product_log add constraint FK_product_log_product foreign key (product_id)
      references product (product_id) on delete restrict on update restrict;
	  