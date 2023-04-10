/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/11/28 14:05:45                          */
/*==============================================================*/


drop table if exists fq_apply;

drop table if exists fq_employee;

drop table if exists fq_employee_certificate;

drop table if exists fq_project;

drop table if exists fq_project_employee;

drop table if exists fq_project_supplier;

drop table if exists fq_project_worker;

drop table if exists fq_stuff;

drop table if exists fq_stuff_type;

drop table if exists fq_supplier;

drop table if exists fq_work_plan;

drop table if exists fq_work_summarize;

drop table if exists fq_worker;

/*==============================================================*/
/* Table: fq_apply                                              */
/*==============================================================*/
create table fq_apply
(
   id                   varchar(36) not null,
   type                 varchar(36) comment '类型',
   content              varchar(36) comment '盖章主要内容',
   send_company         varchar(36) comment '发送单位',
   amount               varchar(36) comment '涉及金额',
   draft_depart         char(36) comment '起草部门',
   handler              varchar(36) comment '经办人',
   trial_depart         char(36) comment '会审部门',
   approval_depart      char(36) comment '审批部门',
   date                 date comment '日期',
   belong_company       varchar(36) comment '所属单位',
   document             varchar(255) comment '附件',
   create_by            char(36) comment '创建人',
   create_time          date comment '创建时间',
   update_by            char(36) comment '更新人',
   update_time          date comment '更新时间',
   primary key (id)
);

alter table fq_apply comment '申请表汇总';

/*==============================================================*/
/* Table: fq_employee                                           */
/*==============================================================*/
create table fq_employee
(
   id                   varchar(36) not null,
   name                 varchar(20) not null,
   gender               char(2) not null,
   post                 char(16) comment '岗位',
   id_card              char(20) not null comment '身份证号码',
   id_card_addr         char(64) not null comment '身份证地址',
   permanent_addr       char(64) comment '常住地',
   start                date comment '入职日期',
   depart               char(36) comment '部门',
   insure_date          char(10) comment '社保日期',
   end                  char(10) comment '离职日期',
   mobile               char(24) not null comment '联系电话',
   relation             varchar(255) comment '家庭应急人及电话',
   job_title            varchar(255) not null comment '职称',
   education            text comment '学历',
   document             char(10) comment '附件',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_employee comment '公司员工表';

/*==============================================================*/
/* Table: fq_employee_certificate                               */
/*==============================================================*/
create table fq_employee_certificate
(
   id                   varchar(36) not null,
   employee_id          varchar(36) not null,
   level                varchar(20) not null comment '等级',
   major                varchar(64) not null comment '专业',
   institution          varchar(64) not null comment '发证机关',
   start                date not null comment '注册日期/发证日期',
   end                  date not null comment '有效期止',
   document             varchar(255) comment '附件',
   is_search            char(4) comment '是否网查',
   has_review           char(6) comment '有无评审表',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   type                 char(16) comment '类别',
   primary key (id)
);

alter table fq_employee_certificate comment '员工证书中间表';

/*==============================================================*/
/* Table: fq_project                                            */
/*==============================================================*/
create table fq_project
(
   id                   char(36) not null,
   name                 varchar(72) not null,
   principal            char(36) comment '负责人',
   principal_mobile     char(24) comment '负责人电话',
   kind                 varchar(32) not null comment '类型',
   type                 char(20) not null comment '项目类别',
   description          varchar(255) comment '项目描述',
   contract_price       decimal(12,2) not null comment '合同价',
   last_price           decimal(12,2) comment '结算价',
   change_price         decimal(12,2) comment '变更价',
   start                date comment '开工日期',
   end                  date comment '竣工日期 如果为空，则仍然在建',
   gain_date            date comment '中标日期',
   contract_date        date comment '合同日期',
   post_employee        varchar(255) not null comment '岗位人员',
   area                 varchar(32) not null comment '区域',
   data_progress        char(24) comment '资料完成情况',
   storage_state        char(20) not null comment '入库情况',
   remark               varchar(400) comment '备注',
   document             varchar(255) comment '附件',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_project comment '项目表';

/*==============================================================*/
/* Table: fq_project_employee                                   */
/*==============================================================*/
create table fq_project_employee
(
   id                   varchar(36) not null,
   project_id           varchar(36) not null,
   employee_id          varchar(36) not null,
   post                 char(20) not null comment '岗位',
   start                date comment '在岗日期',
   end                  date comment '离岗日期',
   remark               varchar(255) not null comment '备注',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_project_employee comment '人员业绩信息表';

/*==============================================================*/
/* Table: fq_project_supplier                                   */
/*==============================================================*/
create table fq_project_supplier
(
   id                   char(36) not null,
   supplier_id          char(36) not null,
   project_id           char(36) not null,
   start                date comment '开始日期',
   end                  date comment '结束时间',
   service              varchar(255) not null comment '主要服务内容',
   contract_price       decimal(10,2) comment '合同价钱',
   last_price           decimal(10,2) comment '结算价钱',
   document             varchar(255) comment '附件',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_project_supplier comment '供应商合作信息表';

/*==============================================================*/
/* Table: fq_project_worker                                     */
/*==============================================================*/
create table fq_project_worker
(
   id                   char(36) not null,
   worker_id            char(36) not null,
   project_id           char(36) not null,
   start                date comment '入职日期',
   end                  date comment '离职日期',
   salary_type          char(10) not null comment '计薪方式',
   salary               decimal(10,2) not null comment '待遇',
   group_leader         char(36) not null comment '所属班组长',
   document             char(255) comment '附件',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_project_worker comment '项目表和工人表的中间表';

/*==============================================================*/
/* Table: fq_stuff                                              */
/*==============================================================*/
create table fq_stuff
(
   id                   varchar(36) not null,
   unit                 varchar(32) comment '单位',
   tax_rate             decimal(6,2) comment '税率',
   exclude_tax          decimal(12,2) comment '不含税价',
   include_tax          decimal(12,2) comment '含税价',
   area                 varchar(36) comment '区域',
   supplier_id          varchar(36) comment '供应商',
   data_soure           varchar(36) comment '数据来源',
   check_date           date comment '检查日期',
   purcher_date         date comment '采购日期',
   content              varchar(36) comment '标准or内容',
   remark               varchar(255) comment '备注',
   trend                varchar(36) comment '走势',
   type_id              varchar(36) comment '材料类型',
   create_by            char(36) comment '创建人',
   create_time          date comment '创建时间',
   update_by            char(36) comment '更新人',
   update_time          date comment '更新时间',
   primary key (id)
);

alter table fq_stuff comment '材料表';

/*==============================================================*/
/* Table: fq_stuff_type                                         */
/*==============================================================*/
create table fq_stuff_type
(
   id                   varchar(36) not null,
   name                 varchar(36),
   code                 varchar(32) comment '编号',
   level                varchar(36) comment '等级',
   sort                 varchar(32) comment '排序',
   create_by            char(36) comment '创建人',
   create_time          date comment '创建时间',
   update_by            char(36) comment '更新人',
   update_time          date comment '更新时间',
   pid                  varchar(36) comment '父id',
   primary key (id)
);

alter table fq_stuff_type comment '材料类别';

/*==============================================================*/
/* Table: fq_supplier                                           */
/*==============================================================*/
create table fq_supplier
(
   id                   char(36) not null,
   company_name         char(50) not null comment '单位名称',
   taxpayer_num         varchar(32) not null comment '纳税人识别号',
   company_mobile       char(24) comment '单位电话',
   company_addr         varchar(64) comment '办公地址',
   register_time        date not null comment '注册时间',
   register_addr        varchar(72) comment '注册地址',
   attribute            char(8) comment '经济性质',
   principal_name       char(20) not null comment '负责人姓名',
   principal_mobile     char(24) not null comment '负责人电话',
   sell_subject         char(24) comment '经营主体类别',
   taxation_scale       char(18) not null comment '税务规模',
   bank_account         varchar(255) not null comment '开户行及账号  json数组',
   market_goods         varchar(64) not null comment '主要销售货物',
   taxation_credit_level varchar(255) not null comment '税务诚信等级
            分年度',
   storage_bring_man    char(36) not null comment '入库引进人',
   site_state           varchar(128) comment '场所勘察情况',
   evaluate_state       varchar(128) comment '负面及正面情况',
   orther_info          varchar(255) comment '其他信息',
   document             varchar(255) comment '附件',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_supplier comment '供应商信息';

/*==============================================================*/
/* Table: fq_work_plan                                          */
/*==============================================================*/
create table fq_work_plan
(
   id                   varchar(36) not null,
   work_type            char(20) comment '工作类型',
   work_content         varchar(255) comment '主要内容',
   staff                varchar(255) comment '配合人员',
   end                  date comment '完成时间',
   start_date           date comment '立项时间',
   expect_end           date comment '预期完成时间',
   expect_result        varchar(128) comment '预期成效',
   is_remain            char(8) comment '是否遗留',
   is_end               char(8) comment '完成或废除',
   remark               varchar(255) comment '备注',
   create_by            char(36) comment '创建人',
   create_time          date comment '创建时间',
   update_by            char(36) comment '更新人',
   update_time          date comment '更新时间',
   primary key (id)
);

alter table fq_work_plan comment '月工作计划和完成情况';

/*==============================================================*/
/* Table: fq_work_summarize                                     */
/*==============================================================*/
create table fq_work_summarize
(
   id                   varchar(36) not null,
   date                 date comment '日期',
   handler              varchar(36) comment '经办人',
   charge               varchar(36) comment '主管',
   evaluate_state       varchar(128) comment '正负面情况',
   situation            varchar(128) comment '情况描述',
   method               varchar(128) comment '经验修正措施',
   summarizer           varchar(36) comment '经验总结人',
   fault_num            int comment '同类失误第*次',
   remakr               varchar(128) comment '备注说明',
   create_by            char(36) comment '创建人',
   create_time          date comment '创建时间',
   update_by            char(36) comment '更新人',
   update_time          date comment '更新时间',
   primary key (id)
);

alter table fq_work_summarize comment '总结性工作台账';

/*==============================================================*/
/* Table: fq_worker                                             */
/*==============================================================*/
create table fq_worker
(
   id                   char(36) not null,
   name                 char(20) not null,
   gender               char(2) not null,
   mobile               char(24) not null,
   id_card              char(20) not null comment '身份证号码',
   id_card_addr         char(64) not null comment '身份证地址',
   permanent_addr       char(64) comment '常住地',
   has_illegal          char(2) comment '有无犯罪记录、失信记录',
   credit_state         varchar(10) not null comment '诚信情况',
   adept_major          char(30) not null comment '擅长专业',
   create_by            char(36) not null comment '创建人',
   create_time          date not null comment '创建时间',
   update_by            char(36) not null comment '更新人',
   update_time          date not null comment '更新时间',
   primary key (id)
);

alter table fq_worker comment '工人表，农民工表';

