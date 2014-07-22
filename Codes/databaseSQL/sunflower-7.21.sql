/*
Navicat MySQL Data Transfer

Source Server         : JDBCConnection
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : sunflower

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2014-07-22 10:49:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `business_id` char(36) NOT NULL COMMENT '服务主键,UUID()自动生成\n服务主键，UUID()自动生成，固定36位，非空，无默认值\n',
  `business_type` varchar(16) NOT NULL COMMENT '服务类型\n服务类型，无默认值，目前为手动填写，非空，最长为8位\n',
  `business_introduction` varchar(64) NOT NULL COMMENT '服务概要\n服务概要，无默认值，非空，最长为64位\n',
  `business_memo` text NOT NULL COMMENT '服务描述\n服务描述，无默认值，非空，无长度限制\n',
  `user_id` char(36) NOT NULL COMMENT '服务创建人ID，USER表外键\n服务创建人，非空，长度为固定36位，无默认值\n',
  `business_create_date` date NOT NULL COMMENT '服务创建时间\n服务创建时间，非空，无默认值\n',
  `business_state` int(11) NOT NULL COMMENT '服务状态\n服务状态，0：未使用，1：使用中，2：已停用\n',
  PRIMARY KEY (`business_id`),
  UNIQUE KEY `business_id_UNIQUE` (`business_id`),
  KEY `FK_business_userID_idx` (`user_id`),
  CONSTRAINT `FK_business_userID` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------

-- ----------------------------
-- Table structure for `business_distribution`
-- ----------------------------
DROP TABLE IF EXISTS `business_distribution`;
CREATE TABLE `business_distribution` (
  `business_distribution_id` char(36) NOT NULL COMMENT '服务分配主键，UUID()自动生成\n服务分配主键，UUID()自动生成，固定36位，非空，无默认值\n',
  `business_id` char(36) NOT NULL COMMENT 'BUSINESS表外键，服务ID\n对应的服务主键，非空，固定36位，无默认值\n',
  `customer_id` char(36) NOT NULL COMMENT 'CUSTOMER表外键，服务对应的客户ID\n对应的客户主键，非空，固定36位，无默认值\n',
  `business_distribution_date` date NOT NULL COMMENT '分配时间\n服务分配日期，非空，无默认值，在分配服务时自动生成\n',
  `business_distribution_state` int(11) NOT NULL DEFAULT '0' COMMENT '处理结果\n服务分配状态，0：新创建，1：已分配，2：已处理，3：已归档，4.已停用，默认为0，不可为空\n',
  `business_distribution_process_date` date NOT NULL COMMENT '处理时间\n服务处理时间，非空，无默认值，服务状态变为“已处理”时自动生成\n',
  `business_distribution_memo` text NOT NULL COMMENT '服务处理信息\n服务处理信息，只能在状态为“已分配”时填写\n',
  `business_disrtibution_satisfaction` int(11) NOT NULL COMMENT '服务满意度\n服务满意度，只能在状态为“已处理”时填写\n',
  PRIMARY KEY (`business_distribution_id`),
  UNIQUE KEY `business_distribution_id_UNIQUE` (`business_distribution_id`),
  KEY `FK_business_distribution_BusinessID_idx` (`business_id`),
  KEY `FK_business_distribution_CustomerID_idx` (`customer_id`),
  CONSTRAINT `FK_business_distribution_BusinessID` FOREIGN KEY (`business_id`) REFERENCES `business` (`business_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_business_distribution_CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_distribution
-- ----------------------------

-- ----------------------------
-- Table structure for `contact_record`
-- ----------------------------
DROP TABLE IF EXISTS `contact_record`;
CREATE TABLE `contact_record` (
  `customer_id` char(36) NOT NULL COMMENT '交往记录对应的客户，外键（CUSTOMER表主键），固定36位，非空，无默认值\n',
  `contact_record_id` char(36) NOT NULL COMMENT '交往记录主键，UUID()自动生成，固定36位，非空，无默认值\n',
  `contact_record_date` date NOT NULL COMMENT '交往时间，手动填写，格式为yyyy-mm-dd，非空，无默认值\n',
  `contact_record_location` varchar(64) NOT NULL COMMENT '交往地点，非空，无默认值，最长为32位\n',
  `contact_record_introduction` varchar(64) NOT NULL COMMENT '交往概要，非空，无默认值，最长为32位\n',
  `contact_record_memo` varchar(128) DEFAULT NULL COMMENT '交往备注，可以为空，无默认值，最长为64位\n',
  `contact_record_info` text NOT NULL COMMENT '交往信息，非空，无默认值，长度不限\n',
  PRIMARY KEY (`contact_record_id`),
  UNIQUE KEY `contact_record_id_UNIQUE` (`contact_record_id`),
  KEY `FK_contact_record_CustomerID_idx` (`customer_id`),
  CONSTRAINT `FK_contact_record_CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact_record
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` char(36) NOT NULL COMMENT '客户编号，UUID()函数自动生成，全局唯一\n客户主键，UUID()自动生成，非空，全局唯一，固定36位\n',
  `user_id` char(36) NOT NULL COMMENT '负责该客户的客户经理，USER表外键\n客户对应的客户经理，非空，无默认值，全局唯一，固定36位\n',
  `customer_name` varchar(128) NOT NULL COMMENT '客户名称\n客户名称，非空，无默认值，最长为64位\n',
  `customer_area` varchar(16) NOT NULL COMMENT '客户所在地区\n客户所在地区，非空，无默认值，最长为8位\n',
  `customer_level` varchar(32) NOT NULL COMMENT '客户等级\n客户等级，非空，无默认值，最长为16位\n',
  `customer_satisfaction` int(11) NOT NULL DEFAULT '1' COMMENT '客户满意度\n客户满意度，非空，默认值为1，取值范围为1,2,3,4,5\n',
  `customer_credit` int(11) NOT NULL DEFAULT '1' COMMENT '客户信用度\n客户信用度，非空，默认值为1，取值范围为1,2,3,4,5\n',
  `customer_address` varchar(256) NOT NULL COMMENT '客户地址\n客户地址，非空，无默认值，最长为128位\n',
  `customer_postcode` char(6) NOT NULL COMMENT '客户邮编\n客户邮编，非空，无默认值，只能填写纯数字，固定6位\n',
  `customer_telephone` varchar(16) NOT NULL COMMENT '客户电话\n客户电话，非空，无默认值，只能填写纯数字\n',
  `customer_fax` varchar(16) NOT NULL COMMENT '客户传真\n客户传真，非空，无默认值，只能填写纯数字\n',
  `customer_website` varchar(32) NOT NULL COMMENT '客户网站\n客户网站，非空，无默认值，最长32位\n',
  `customer_license` varchar(32) DEFAULT NULL COMMENT '客户营业执照注册号\n客户营业执照注册号，可以为空，无默认值，最长32位\n',
  `customer_corporation` varchar(32) NOT NULL COMMENT '企业法人\n企业法人，非空，无默认值，最长为16位\n',
  `customer_reg_finance` int(11) DEFAULT '0' COMMENT '企业注册金额\n企业注册金额，可以为空，默认值为0，对应为空情况，只能为正数\n',
  `customer_annual_benefit` int(11) DEFAULT '0' COMMENT '企业营业额\n企业营业额，可以为空，默认值为0，对应空的情况，只能为正数\n',
  `customer_bank` varchar(64) NOT NULL COMMENT '开户银行\n开户银行，不可为空，无默认值，最长为32位\n',
  `customer_bank_account` varchar(64) NOT NULL COMMENT '银行账号\n银行账号，不可为空，无默认值，最长为64位\n',
  `customer_local_tax_code` varchar(64) DEFAULT NULL COMMENT '地税登记号\n地税登记号，可以为空，无默认值，最长为64位\n',
  `customer_national_tax_code` varchar(64) DEFAULT NULL COMMENT '国税登记号\n国税登记号，可以为空，无默认值，最长为64位\n',
  `customer_state` int(11) NOT NULL DEFAULT '0' COMMENT '客户状态\n客户状态，默认值为0，不可为空， 0:正常，1:申报流失，2：预警；3:流失暂缓，4：确认流失',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`),
  KEY `user_id_UNIQUE` (`user_id`) USING BTREE,
  CONSTRAINT `FK_customer_UserID` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_lost_pause`
-- ----------------------------
DROP TABLE IF EXISTS `customer_lost_pause`;
CREATE TABLE `customer_lost_pause` (
  `customer_lost_pause_id` char(36) NOT NULL COMMENT '暂缓流失主键，UUID()自动生成\n客户流失暂缓项主键，UUID()自动生成，固定36位，非空，无默认值\n',
  `customer_id` char(36) NOT NULL COMMENT 'CUSTOMER表外键，对应暂缓流失的客户\n流失客户外键，固定36位，非空，无默认值\n',
  `customer_lost_pause_reason` varchar(128) NOT NULL COMMENT '客户流失原因\n客户流失原因，非空，无默认值，无长度限制\n',
  `customer_lost_pause_method` varchar(256) DEFAULT NULL COMMENT '暂缓措施',
  PRIMARY KEY (`customer_lost_pause_id`),
  UNIQUE KEY `customer_lost_pause_id_UNIQUE` (`customer_lost_pause_id`),
  KEY `FK_customer_lost_pause_CustomerID_idx` (`customer_id`),
  CONSTRAINT `FK_customer_lost_pause_CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_lost_pause
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_person`
-- ----------------------------
DROP TABLE IF EXISTS `customer_person`;
CREATE TABLE `customer_person` (
  `customer_person_id` char(36) NOT NULL COMMENT '联系人编号，UUID()自动生成，全局唯一\n客户对应的联系人主键，非空，全局唯一，UUID()自动生成，固定36位\n',
  `customer_id` char(36) NOT NULL COMMENT 'CUSTOMER表外键，联系人所属CUSTOMER\n联系人对应的客户，CUSTOMER表外键，固定36位，不可为空，无默认值\n',
  `customer_person_name` varchar(32) NOT NULL COMMENT '联系人姓名\n联系人姓名，不可为空，最长16位，无默认值\n',
  `customer_person_sex` int(11) NOT NULL DEFAULT '1' COMMENT '联系人性别，0为女，1为男，默认值为1，不可为空\n',
  `customer_person_position` varchar(32) NOT NULL COMMENT '联系人职位，不可为空，无默认值，最长为16位\n\n',
  `customer_person_tel` varchar(16) NOT NULL COMMENT '联系人电话，不可为空，无默认值，必须为纯数字，最长为16位\n',
  `customer_person_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机，不可为空，无默认值，必须为纯数字，最长为16位\n',
  `customer_person_memo` varchar(64) DEFAULT NULL COMMENT '联系人备注，不可为空，最长为32位\n',
  PRIMARY KEY (`customer_person_id`),
  UNIQUE KEY `customer_person_id_UNIQUE` (`customer_person_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`),
  CONSTRAINT `FK_customer_person_CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_person
-- ----------------------------

-- ----------------------------
-- Table structure for `history_record`
-- ----------------------------
DROP TABLE IF EXISTS `history_record`;
CREATE TABLE `history_record` (
  `history_record_id` char(36) NOT NULL COMMENT '订单id\n历史订单主键，36位固定长度，UUID()自动生成，非空，无默认值\n',
  `customer_id` char(36) NOT NULL COMMENT 'CUSTOMER表外键，订单所属的CUSTOMER\n订单对应的客户ID，外键，非空，固定36位，无默认值\n',
  `history_record_date` date NOT NULL COMMENT '订单创建时间\n订单创建日期，非空，无默认值\n',
  `history_record_delivery_address` varchar(128) NOT NULL COMMENT '订单配送地址\n订单配送地址，非空，无默认值，最长为64位\n',
  `history_record_status` int(11) NOT NULL COMMENT '订单状态\n订单状态，0:未回款 1:已回款，无默认值，不可为空\n',
  PRIMARY KEY (`history_record_id`),
  UNIQUE KEY `history_record_id_UNIQUE` (`history_record_id`),
  KEY `FK_history_record_CustomerID_idx` (`customer_id`),
  CONSTRAINT `FK_history_record_CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history_record
-- ----------------------------

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` char(36) NOT NULL COMMENT '开发计划主键，UUID()自动生成，非空，全局唯一，固定36位\n开发计划主键，UUID()函数自动生成，全局唯一\n',
  `plan_date` date NOT NULL COMMENT '开发计划创建时间\n开发计划创建时间，非空，利用DATE自动生成\n',
  `sales_id` char(36) NOT NULL COMMENT '开发计划对应的销售机会\n外键，对应相应的销售机会，不可为空，全局唯一，固定36位\n',
  `plan_state` int(11) NOT NULL DEFAULT '0' COMMENT '开发计划标志位\n开发计划标志位，0:初建，1:执行中，2:完成，3：终止开发，不可为空，默认为0 \n',
  PRIMARY KEY (`plan_id`),
  UNIQUE KEY `plan_id_UNIQUE` (`plan_id`),
  UNIQUE KEY `sales_id_UNIQUE` (`sales_id`),
  CONSTRAINT `FK_plan_SalesID` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`sales_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('000000000000000000000000000000000000', '2014-07-14', '80438530-0a6a-11e4-9de8-1d1a2c8d4097', '3');
INSERT INTO `plan` VALUES ('073054c8-0bee-11e4-88d9-caf77b8116e9', '2014-07-14', 'c587e49a-0a69-11e4-9de8-1d1a2c8d4097', '0');

-- ----------------------------
-- Table structure for `record_item`
-- ----------------------------
DROP TABLE IF EXISTS `record_item`;
CREATE TABLE `record_item` (
  `record_item_id` char(36) NOT NULL COMMENT '订单项id\n订单项主键，固定36位，UUID()自动生成，非空，无默认值\n',
  `history_record_id` char(36) NOT NULL COMMENT 'HISTORY_RECORD表外键，对应的订单id\n外键，订单项对应订单，固定36位，非空，无默认值\n',
  `record_item_name` varchar(64) NOT NULL COMMENT '商品名称\n商品名称，最长为32位，不可为空，无默认值\n\n',
  `record_item_count` int(11) NOT NULL COMMENT '商品数量\n商品个数，大于等于0，不可为空，无默认值\n',
  `record_item_price` double NOT NULL COMMENT '商品单价\n商品单价，大于等于0.0，不可为空，无默认值\n',
  `record_item_unit` varchar(16) NOT NULL COMMENT '商品单位\n商品单位（个，台，等），最长8位，不可为空，无默认值\n',
  `record_item_total_price` double NOT NULL COMMENT '订单金额\n订单项总额，不可为空，大于等于0.0d，无默认值\n',
  PRIMARY KEY (`record_item_id`),
  UNIQUE KEY `record_item_id_UNIQUE` (`record_item_id`),
  KEY `FK_record_item_HistoryRecordID_idx` (`history_record_id`),
  CONSTRAINT `FK_record_item_HistoryRecordID` FOREIGN KEY (`history_record_id`) REFERENCES `history_record` (`history_record_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_item
-- ----------------------------

-- ----------------------------
-- Table structure for `sales`
-- ----------------------------
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `sales_id` char(36) NOT NULL COMMENT '销售机会主键，UUID()函数生成，全局唯一\nSALES表主键，非空，全局唯一，UUID()程序自动生成\n',
  `sales_source` varchar(64) DEFAULT NULL COMMENT '机会来源\n销售机会来源，可为空，最长为32位，无默认值\n',
  `sales_customer_name` varchar(64) NOT NULL COMMENT '客户名称\n客户名称，不可为空，最长为32位，无默认值\n',
  `sales_success_prob` int(11) NOT NULL COMMENT '成功几率\n成功几率，不可为空，无默认值\n',
  `sales_brief_intro` varchar(256) DEFAULT NULL COMMENT '概要\n客户摘要，最长为128位，可为空，无默认值\n',
  `sales_contact_person` varchar(32) DEFAULT NULL COMMENT '联系人\n联系人，最长为16位，可为空，无默认值\n',
  `sales_contact_tel` varchar(16) DEFAULT NULL COMMENT '联系电话\n联系电话，可为空，无默认值，如不为空，格式应为纯数字，最长为16位\n',
  `sales_description` text NOT NULL COMMENT '机会描述\n机会描述，不可为空，无默认值，文本类型\n',
  `create_user_id` char(36) NOT NULL COMMENT '外键，创建人\n创建人，该字段必须为USER表中已有行，且角色为销售主管，无默认值，不可为空，固定36位\n',
  `sales_create_time` date NOT NULL COMMENT '表创建时间\n创建时间，在插入时程序中自动生成，取当前时间细分到秒\n',
  `sales_state` int(11) NOT NULL COMMENT '销售机会状态\n机会状态，取值范围为：0：未分配，1：已指派，2：已删除，不可为空，无默认值，\n',
  `responsible_user_id` char(36) NOT NULL DEFAULT '12345678901234567890123456' COMMENT '外键，被指派人\n被指派人，默认值为USER表中Dummy row（即默认的“未指派”客户经理），不可为空，固定36位\n',
  PRIMARY KEY (`sales_id`),
  UNIQUE KEY `sales_id_UNIQUE` (`sales_id`),
  KEY `create_user_id_idx` (`create_user_id`,`responsible_user_id`),
  KEY `FK_sales_ResponsibleUserID_idx` (`responsible_user_id`),
  CONSTRAINT `FK_sales_CreateUserID` FOREIGN KEY (`create_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sales_ResponsibleUserID` FOREIGN KEY (`responsible_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sales
-- ----------------------------
INSERT INTO `sales` VALUES ('16becadb-0a6b-11e4-9de8-1d1a2c8d4097', '来源', '联华有限公司', '40', '介绍', 'Julian', '13390221213', '描述', 'c5669fac-0a69-11e4-9de8-1d1a2c8d4097', '2014-07-13', '0', '12345678901234567890123456');
INSERT INTO `sales` VALUES ('244842cf-0a69-11e4-9de8-1d1a2c8d4097', '来源', '北京果果科技有限公司', '60', '介绍', '张力', '18810923331', '描述', 'ec8c86e9-0a64-11e4-9de8-1d1a2c8d4097', '2014-07-13', '1', 'ec8c86e9-0a64-11e4-9de8-1d1a2c8d4097');
INSERT INTO `sales` VALUES ('80438530-0a6a-11e4-9de8-1d1a2c8d4097', '这个机会来源', '新创思源公司', '50', '介绍', '元远', '18810021120', '描述', 'b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097', '2014-07-13', '1', 'b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097');
INSERT INTO `sales` VALUES ('93f15231-0a6a-11e4-9de8-1d1a2c8d4097', '来源', '某某有限公司', '50', '介绍', '元远', '18810021120', '描述', 'b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097', '2014-07-13', '0', '12345678901234567890123456');
INSERT INTO `sales` VALUES ('9a589829-0a6a-11e4-9de8-1d1a2c8d4097', '来源', '某某有限公司', '50', '介绍', '元远', '18810021120', '描述', 'b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097', '2014-07-13', '2', 'b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097');
INSERT INTO `sales` VALUES ('c587e49a-0a69-11e4-9de8-1d1a2c8d4097', '来源', '北京创新科技有限公司', '50', '介绍', '元远', '18810021120', '描述', 'b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097', '2014-07-13', '1', '61a8ad1d-0a5f-11e4-9de8-1d1a2c8d4097');
INSERT INTO `sales` VALUES ('fbe5ef6c-0a65-11e4-9de8-1d1a2c8d4097', 'salesSource', 'salesCustomerName', '10', 'salesBriefIntro', 'salesContactPerson', 'salesContactTel', 'salesDescription', '61a8ad1d-0a5f-11e4-9de8-1d1a2c8d4097', '2014-07-13', '1', '61a8ad1d-0a5f-11e4-9de8-1d1a2c8d4097');

-- ----------------------------
-- Table structure for `schedule_item`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_item`;
CREATE TABLE `schedule_item` (
  `schedule_id` char(36) NOT NULL COMMENT '开发计划项主键，UUID()自动生成，全局唯一\n开发计划项主键，UUID()自动生成，非空，全局唯一，固定36位\n',
  `plan_id` char(36) NOT NULL COMMENT 'DEVELOPMENT_PLAN外键，对应的开发计划\n开发计划项对应的开发计划，外键，非空，固定36位，无默认值\n',
  `schedule_time` date NOT NULL COMMENT '开发计划项制定日期\n开发计划项创建时间，自动生成。不可为空，无默认值\n',
  `schedule_content` varchar(128) NOT NULL COMMENT '开发计划项内容\n开发计划项的内容，不可为空，最长64位，无默认值\n',
  `schedule_memo` varchar(256) DEFAULT NULL COMMENT '开发计划项执行效果\n开发计划项的执行效果，可为空，最长128位，无默认值\n',
  PRIMARY KEY (`schedule_id`),
  UNIQUE KEY `schedule_id_UNIQUE` (`schedule_id`),
  UNIQUE KEY `plan_id_UNIQUE` (`plan_id`),
  CONSTRAINT `FK_schedule_item_PlanID` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`plan_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule_item
-- ----------------------------
INSERT INTO `schedule_item` VALUES ('be8f2ab7-0bee-11e4-88d9-caf77b8116e9', '073054c8-0bee-11e4-88d9-caf77b8116e9', '2014-07-15', '打电话询问', '');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` char(36) NOT NULL COMMENT 'USER表主键字段，非空，全局唯一,UUID()程序内自动生成.\n用户主键，UUID()函数生成，全局唯一.\n\n',
  `user_account` varchar(32) NOT NULL COMMENT '用户账户，长度为32，为用户的Email\n最短6位，最长32位，必须有@和.字符，无默认值，表内唯一，非空',
  `user_password` char(32) NOT NULL COMMENT '用户密码，长度为32位，MD5加密，全大写\n固定32位，字符只能是大写字母或数字，无默认值，非空\n',
  `user_level` int(11) NOT NULL COMMENT '用户角色字段\n取值为：0:超级管理员，1:客户经理，2:销售主管，无默认值，非空\n',
  `user_department` varchar(32) DEFAULT NULL COMMENT '用户所属部门\n用户部门，可为空，手动填写，无默认值，最长16位\n',
  `user_name` varchar(32) NOT NULL COMMENT '用户姓名\n用户姓名，不可为空，手动填写，无默认值，最长16位\n',
  `user_telephone` varchar(32) NOT NULL COMMENT '用户联系方式\n用户联系方式，不可为空，手动填写，无默认值，应为纯数字，最长16位\n',
  `user_state` int(11) NOT NULL DEFAULT '0' COMMENT '标志位，用户状态\n取值为 0：可用，1：不可用，默认为0\n',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `user_account_UNIQUE` (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账号表，存储账号、密码、角色信息、联系方式、所属部门、真实姓名、用户状态	';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12345678901234567890123456', 'numm@bbb.xom', '123456', '1', 'ITE', '未指派', '11111111111', '1');
INSERT INTO `user` VALUES ('61a8ad1d-0a5f-11e4-9de8-1d1a2c8d4097', 'sina@bjtu.edu.cn', '123', '1', 'CLD', 'cycai', '18810986754', '0');
INSERT INTO `user` VALUES ('b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097', 'lyx5398@163.com', '7FEF6171469E80D32C0559F88B377245', '1', '市场部', '卢宇勋', '13810414528', '0');
INSERT INTO `user` VALUES ('c5669fac-0a69-11e4-9de8-1d1a2c8d4097', 'kk@gmail.com', '123', '1', 'CLD', 'Kay', '15639191176', '0');
INSERT INTO `user` VALUES ('ec8c86e9-0a64-11e4-9de8-1d1a2c8d4097', '11301087@bjtu.edu.cn', '123', '2', 'CLD', 'my', '1881122332', '0');
DROP TRIGGER IF EXISTS `business_trigger`;
DELIMITER ;;
CREATE TRIGGER `business_trigger` BEFORE INSERT ON `business` FOR EACH ROW BEGIN
     set NEW.business_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `business_distribution_trigger`;
DELIMITER ;;
CREATE TRIGGER `business_distribution_trigger` BEFORE INSERT ON `business_distribution` FOR EACH ROW BEGIN
     set NEW.business_distribution_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `contact_record_trigger`;
DELIMITER ;;
CREATE TRIGGER `contact_record_trigger` BEFORE INSERT ON `contact_record` FOR EACH ROW BEGIN
     set NEW.contact_record_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `customer_trigger`;
DELIMITER ;;
CREATE TRIGGER `customer_trigger` BEFORE INSERT ON `customer` FOR EACH ROW BEGIN
     set NEW.customer_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `customer_lost_pause_trigger`;
DELIMITER ;;
CREATE TRIGGER `customer_lost_pause_trigger` BEFORE INSERT ON `customer_lost_pause` FOR EACH ROW BEGIN
     set NEW.customer_lost_pause_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `customer_person_triggerS`;
DELIMITER ;;
CREATE TRIGGER `customer_person_triggerS` BEFORE INSERT ON `customer_person` FOR EACH ROW BEGIN
     set NEW.customer_person_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `plantrigger`;
DELIMITER ;;
CREATE TRIGGER `plantrigger` BEFORE INSERT ON `plan` FOR EACH ROW BEGIN
	set NEW.plan_id = (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `sales_BINS`;
DELIMITER ;;
CREATE TRIGGER `sales_BINS` BEFORE INSERT ON `sales` FOR EACH ROW BEGIN
	set NEW.sales_id = (select uuid());
	set NEW.responsible_user_id = '12345678901234567890123456';
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `schedule_item_trigger`;
DELIMITER ;;
CREATE TRIGGER `schedule_item_trigger` BEFORE INSERT ON `schedule_item` FOR EACH ROW BEGIN
     set NEW.schedule_id= (select uuid());
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `user_BINS`;
DELIMITER ;;
CREATE TRIGGER `user_BINS` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
	set NEW.user_id = (select uuid());
END
;;
DELIMITER ;
