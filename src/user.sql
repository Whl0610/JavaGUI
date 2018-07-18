/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : onlylady

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-07-18 14:13:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('xiaolizi', '123', '1', '1');
INSERT INTO `user` VALUES ('xiaochengzi', '123', '2', '0');
INSERT INTO `user` VALUES ('zhoujiajia', '456', '3', '0');
INSERT INTO `user` VALUES ('小栗子', '123', '17', '0');
INSERT INTO `user` VALUES ('小橙子', '111', '18', '0');
INSERT INTO `user` VALUES ('', '', '25', '0');
INSERT INTO `user` VALUES ('xiaolili', '111', '26', '0');
