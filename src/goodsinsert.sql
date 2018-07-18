/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : onlylady

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-07-18 14:13:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goodsinsert`
-- ----------------------------
DROP TABLE IF EXISTS `goodsinsert`;
CREATE TABLE `goodsinsert` (
  `goodsID` varchar(255) NOT NULL,
  `goodsBrand` varchar(255) NOT NULL,
  `goodsCategory` varchar(255) NOT NULL,
  `goodsNumber` int(11) NOT NULL,
  PRIMARY KEY (`goodsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsinsert
-- ----------------------------
