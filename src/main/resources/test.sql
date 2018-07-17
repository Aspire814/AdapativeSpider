/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-07-17 22:20:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_task_info
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_task_info`;
CREATE TABLE `qrtz_task_info` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `beanClass` varchar(255) NOT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `methodName` varchar(255) DEFAULT NULL COMMENT '任务调用的方法名',
  `isConcurrent` varchar(255) DEFAULT NULL COMMENT '任务是否有状态',
  `description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `updateBy` varchar(64) DEFAULT NULL COMMENT '更新者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `jobStatus` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `jobGroup` varchar(255) NOT NULL COMMENT '任务分组',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `createBy` varchar(64) DEFAULT NULL COMMENT '创建者',
  `jobName` varchar(255) NOT NULL COMMENT '任务名',
  `params` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of qrtz_task_info
-- ----------------------------
INSERT INTO `qrtz_task_info` VALUES ('1', 'com.storm.task.framework.job.TestJob', null, null, '这是个测试job', 'storm', '2018-07-17 21:32:13', '1', 'test', '2018-07-17 21:32:22', 'strom', 'testJob', null);

-- ----------------------------
-- Table structure for qrtz_task_trigger
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_task_trigger`;
CREATE TABLE `qrtz_task_trigger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(200) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  `cron_expression` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_task_trigger
-- ----------------------------
INSERT INTO `qrtz_task_trigger` VALUES ('1', '1', 'testTrigger', 'test', '0', '* * * * * ? *');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
