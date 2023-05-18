/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : miniwechat

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-09-21 11:56:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `aid` int(11) NOT NULL auto_increment,
  `tel` varchar(45) default NULL,
  `address` varchar(100) default NULL,
  `uid` int(11) default NULL,
  PRIMARY KEY  (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '15039102695', '河南焦作河南理工大学', '1');
INSERT INTO `t_address` VALUES ('2', '232786786786', 'anhuixuencheng', '1');
INSERT INTO `t_address` VALUES ('4', '13901341234', '四川成都红星路10号', '2');
INSERT INTO `t_address` VALUES ('6', '13904243942', '四川成都市锦江区春熙路', '2');

-- ----------------------------
-- Table structure for `t_collection`
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection` (
  `cid` int(11) NOT NULL auto_increment,
  `gid` int(11) default NULL,
  `uid` int(11) default NULL,
  `isselect` int(11) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_collection
-- ----------------------------
INSERT INTO `t_collection` VALUES ('3', '4', '1', '0');
INSERT INTO `t_collection` VALUES ('5', '3', '1', '0');
INSERT INTO `t_collection` VALUES ('6', '2', '1', '0');
INSERT INTO `t_collection` VALUES ('7', '10', '1', '0');
INSERT INTO `t_collection` VALUES ('8', '5', '1', '0');
INSERT INTO `t_collection` VALUES ('9', '5', '2', '0');
INSERT INTO `t_collection` VALUES ('10', '11', '2', '0');

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `gid` int(11) NOT NULL auto_increment,
  `gname` varchar(45) default NULL,
  `gimage` varchar(500) default NULL,
  `gdesc` varchar(100) default NULL,
  `gnum` int(11) default NULL,
  `gprice` int(11) default NULL,
  `uid` int(11) default NULL,
  `gstate` int(11) default NULL,
  PRIMARY KEY  (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('4', 'xiaomi9', 'http://localhost:8080/MiniWechat/image/pinpai2.png', '九成新的手表，完美无缺，这个价格很公道', '1', '3200', '1', '3');
INSERT INTO `t_goods` VALUES ('5', 'xiaomi888', 'http://localhost:8080/MiniWechat/image/pinpai3.png', '九五新，买来几乎没用过，想换新手机了', '1', '2133', '1', '3');
INSERT INTO `t_goods` VALUES ('6', 'xiaomi888', 'http://localhost:8080/MiniWechat/image/pinpai1.png', '6成新，换过屏幕，正常使用没有任何的问题', '1', '2133', '1', '2');
INSERT INTO `t_goods` VALUES ('10', '魅族16th', 'http://localhost:8080/MiniWechat/image/liebiao_hongmin42.jpg', '魅族旗舰机，九五新，买来不想用了', '1', '1888', '1', '1');
INSERT INTO `t_goods` VALUES ('11', '魅族16s', 'http://localhost:8080/MiniWechat/image/liebiao_xiaomi5c.jpg', '新上市的，新手机，直接卖', '1', '6779', '1', '1');
INSERT INTO `t_goods` VALUES ('12', '鼠标', 'http://localhost:8080/MiniWechat/image/liebiao_xiaomimix.jpg', '这是一个神奇的鼠标请爱惜她', '1', '100', '1', '1');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `oid` int(11) NOT NULL auto_increment,
  `price` double default NULL,
  `createtime` datetime default NULL,
  `uid` int(11) default NULL,
  `aid` int(11) default NULL,
  `gid` int(11) default NULL,
  `gstatus` int(11) default NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '21908', '2019-05-10 20:19:53', '1', '1', '3', '1');
INSERT INTO `t_order` VALUES ('2', '3200', '2019-05-11 09:51:20', '1', '1', '4', '1');
INSERT INTO `t_order` VALUES ('3', '2133', '2019-05-11 10:20:40', '1', '1', '5', '1');
INSERT INTO `t_order` VALUES ('4', '2133', '2019-05-14 19:11:48', '1', '1', '6', '0');
INSERT INTO `t_order` VALUES ('5', '100', '2019-06-16 15:47:57', '1', '1', '12', '0');
INSERT INTO `t_order` VALUES ('6', '2133', '2019-09-21 11:16:29', '2', '4', '5', '1');
INSERT INTO `t_order` VALUES ('7', '1888', '2019-09-21 11:34:21', '2', '6', '10', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `uroleId` int(11) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'lanlan', '123', '1');
INSERT INTO `t_user` VALUES ('2', 'hahah', '123', '0');
INSERT INTO `t_user` VALUES ('3', 'tttt', '122', '0');
