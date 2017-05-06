/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60003
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 60003
File Encoding         : 65001

Date: 2017-04-23 21:10:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` varchar(10) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', 'tom', 'math', '64');
INSERT INTO `grade` VALUES ('2', 'tom', 'english', '34');
INSERT INTO `grade` VALUES ('3', 'tom', 'cpp', '67');
INSERT INTO `grade` VALUES ('4', 'bob', 'math', '23');
INSERT INTO `grade` VALUES ('5', 'bob', 'english', '89');
INSERT INTO `grade` VALUES ('6', 'bob', 'cpp', '45');
INSERT INTO `grade` VALUES ('7', 'lily', 'math', '78');
INSERT INTO `grade` VALUES ('8', 'lily', 'english', '89');
INSERT INTO `grade` VALUES ('9', 'lily', 'cpp', '34');
INSERT INTO `grade` VALUES ('10', 'timo', 'math', '56');
INSERT INTO `grade` VALUES ('11', 'timo', 'english', '79');
INSERT INTO `grade` VALUES ('12', 'timo', 'cpp', '34');
INSERT INTO `grade` VALUES ('13', 'ez', 'math', '78');
INSERT INTO `grade` VALUES ('14', 'ez', 'english', '56');
INSERT INTO `grade` VALUES ('15', 'ez', 'cpp', '98');
