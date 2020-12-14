-- ----------------------------
-- Table structure for hello
-- ----------------------------
DROP TABLE IF EXISTS `hello`;
CREATE TABLE `hello` (
  `name` varchar(64) DEFAULT NULL,
  `port` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hello
-- ----------------------------
INSERT INTO `hello` VALUES ('scaffold', '8080');
