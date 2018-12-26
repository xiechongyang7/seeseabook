/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : ssbc

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-05-27 22:13:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `address_id` varchar(20) NOT NULL COMMENT '地址表id',
  `address_user_id` varchar(20) NOT NULL COMMENT '用户id',
  `address_province` varchar(255) DEFAULT NULL COMMENT '省',
  `address_city` varchar(255) DEFAULT NULL COMMENT '市',
  `address_area` varchar(255) DEFAULT NULL COMMENT '区',
  `address_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `唯一` (`address_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_id` varchar(20) NOT NULL COMMENT '管理员id',
  `admin_account` varchar(255) NOT NULL COMMENT '管理员账户',
  `admin_passward` varchar(255) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_blist
-- ----------------------------
DROP TABLE IF EXISTS `tb_blist`;
CREATE TABLE `tb_blist` (
  `blist_id` varchar(20) NOT NULL COMMENT '书单id',
  `blist_user_id` varchar(20) NOT NULL COMMENT '书单创建者id',
  `blist_name` varchar(255) NOT NULL COMMENT '书单名称',
  `blist_create_time` date NOT NULL COMMENT '书单创建时间',
  `blist_remark` varchar(255) NOT NULL COMMENT '书单备注',
  PRIMARY KEY (`blist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_blist_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_blist_book`;
CREATE TABLE `tb_blist_book` (
  `blist_book_id` varchar(20) NOT NULL COMMENT '书单书籍表id',
  `blist_book_blist_id` varchar(20) NOT NULL COMMENT '书单id',
  `blist_book_book_id` varchar(20) NOT NULL COMMENT '书单收藏书的id',
  PRIMARY KEY (`blist_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `book_id` varchar(20) NOT NULL COMMENT '书籍id',
  `book_user_id` varchar(20) NOT NULL COMMENT '上传者id',
  `book_name` varchar(255) NOT NULL COMMENT '书籍名字',
  `book_author` varchar(255) DEFAULT NULL COMMENT '书籍作者',
  `book_introduce` varchar(1000) DEFAULT NULL COMMENT '书记介绍',
  `book_catalog` varchar(255) DEFAULT NULL COMMENT '书籍目录',
  `book_value` int(20) NOT NULL DEFAULT '20' COMMENT '书籍价值',
  `book_mark` double DEFAULT NULL COMMENT '书籍评分',
  `book_tag` varchar(255) DEFAULT NULL COMMENT '书籍标签',
  `book_replace` date DEFAULT NULL COMMENT '书籍更新时间',
  `book_remark` varchar(255) DEFAULT NULL COMMENT '书籍备注',
  `book_statu` int(2) NOT NULL DEFAULT '1' COMMENT '是否可见',
  `book_cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `book_first_classify` int(255) NOT NULL COMMENT '一级分类',
  `book_second_classify` int(255) NOT NULL COMMENT '二级分类',
  `book_third_classify` int(255) DEFAULT NULL COMMENT '三级分类',
  PRIMARY KEY (`book_id`),
  KEY `book_first_classify` (`book_first_classify`),
  KEY `book_second_classify` (`book_second_classify`),
  KEY `book_third_classify` (`book_third_classify`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_collection
-- ----------------------------
DROP TABLE IF EXISTS `tb_collection`;
CREATE TABLE `tb_collection` (
  `collection_id` varchar(20) NOT NULL COMMENT '收藏表id',
  `collection_user_id` varchar(20) NOT NULL COMMENT '收藏人id',
  `collection_book_id` varchar(20) DEFAULT NULL COMMENT '收藏书id',
  `collection_folder` varchar(255) DEFAULT '我的收藏' COMMENT '收藏标志',
  PRIMARY KEY (`collection_id`),
  KEY `user` (`collection_user_id`),
  KEY `book` (`collection_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `comment_id` varchar(20) NOT NULL COMMENT '评论表id',
  `comment_user_id` varchar(20) NOT NULL COMMENT '评论人id',
  `comment_appraise` int(11) DEFAULT NULL COMMENT '评价三个等级',
  `comment_book_id` varchar(20) DEFAULT NULL COMMENT '评价书籍id',
  `comment_review_id` varchar(20) DEFAULT NULL COMMENT '评价书评id',
  `comment_reply` varchar(20) DEFAULT NULL COMMENT '回复的id',
  `comment_content` varchar(255) NOT NULL COMMENT '评论内容',
  `comment_time` date DEFAULT NULL COMMENT '评论时间',
  `comment_score` int(11) DEFAULT NULL COMMENT '打分',
  `comment_read` int(11) NOT NULL DEFAULT '0' COMMENT '已读未读默认未读',
  PRIMARY KEY (`comment_id`),
  KEY `comment_user_id` (`comment_user_id`),
  KEY `comment_book_id` (`comment_book_id`),
  KEY `comment_review_id` (`comment_review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_download
-- ----------------------------
DROP TABLE IF EXISTS `tb_download`;
CREATE TABLE `tb_download` (
  `download_id` varchar(20) NOT NULL COMMENT '下载表id',
  `download_book_id` varchar(20) NOT NULL COMMENT '下载书id',
  `download_link_first` varchar(255) DEFAULT NULL COMMENT '下载地址1',
  `download_link_second` varchar(255) DEFAULT NULL COMMENT '下载地址2',
  `download_link_third` varchar(255) DEFAULT NULL COMMENT '下载地址3',
  `download_resource` varchar(255) DEFAULT NULL COMMENT '本地资源',
  PRIMARY KEY (`download_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_download_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_download_record`;
CREATE TABLE `tb_download_record` (
  `download_record_id` varchar(20) NOT NULL COMMENT '下载记录id',
  `download_record_user_id` varchar(20) NOT NULL COMMENT '用户id',
  `download_record_book_id` varchar(20) NOT NULL COMMENT '下载书id',
  `download_record_time` datetime NOT NULL COMMENT '下载时间',
  PRIMARY KEY (`download_record_id`),
  KEY `record_user_id` (`download_record_user_id`),
  KEY `record_book_id` (`download_record_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_first_classify
-- ----------------------------
DROP TABLE IF EXISTS `tb_first_classify`;
CREATE TABLE `tb_first_classify` (
  `first_classify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级分类id',
  `first_classify_content` varchar(255) NOT NULL COMMENT '一级分类内容',
  PRIMARY KEY (`first_classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_friend
-- ----------------------------
DROP TABLE IF EXISTS `tb_friend`;
CREATE TABLE `tb_friend` (
  `friend_id` varchar(20) NOT NULL COMMENT '粉丝表id',
  `friend_fan_id` varchar(20) NOT NULL COMMENT '粉丝的id',
  `friend_attention_id` varchar(20) NOT NULL COMMENT '关注人id',
  PRIMARY KEY (`friend_id`),
  KEY `fan` (`friend_fan_id`),
  KEY `attention` (`friend_attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `login_id` varchar(5) NOT NULL COMMENT '登陆表主键',
  `login_user_id` varchar(5) NOT NULL COMMENT '登录表用户id',
  `login_series` varchar(255) DEFAULT NULL COMMENT ' 用户使用密码登录成功之后获取的一个UUID值，同时用户端保存的cookie记录就是：EncryptionUtil.base64Encode(用户名:此UUID值)',
  `login_card` varchar(11) DEFAULT NULL COMMENT 'token    在拦截器中校验是否能够登录的密文，其加密方式是：EncryptionUtil.sha256Hex(用户名 + “_” + 密码 + “_” + 自动登录失效的时间点的字符串 + “_” +  自定义的salt)',
  `login_end` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `login_user_id` (`login_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_praise
-- ----------------------------
DROP TABLE IF EXISTS `tb_praise`;
CREATE TABLE `tb_praise` (
  `praise_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '点赞表id',
  `praise_user_id` varchar(20) NOT NULL COMMENT '点赞人id',
  `praise_book_id` varchar(20) DEFAULT NULL COMMENT '点赞的书id',
  `praise_comment_id` varchar(20) DEFAULT NULL COMMENT '点赞评论id',
  `praise_review_id` varchar(20) DEFAULT NULL COMMENT '点赞书评id',
  PRIMARY KEY (`praise_id`),
  KEY `praise_user_id` (`praise_user_id`),
  KEY `praise_book_id` (`praise_book_id`),
  KEY `praise_review_id` (`praise_review_id`),
  KEY `praise_comment_id` (`praise_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_review
-- ----------------------------
DROP TABLE IF EXISTS `tb_review`;
CREATE TABLE `tb_review` (
  `review_id` varchar(20) NOT NULL COMMENT '书评表id',
  `review_user_id` varchar(20) NOT NULL COMMENT '书评人',
  `review_book_id` varchar(20) NOT NULL COMMENT '书',
  `review_name` varchar(255) DEFAULT NULL COMMENT '书评名字',
  `review_content` varchar(5000) NOT NULL COMMENT '书评内容',
  `review_time` datetime DEFAULT NULL COMMENT '发表时间',
  PRIMARY KEY (`review_id`),
  KEY `review_user_id` (`review_user_id`),
  KEY `review_book_id` (`review_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_second_classify
-- ----------------------------
DROP TABLE IF EXISTS `tb_second_classify`;
CREATE TABLE `tb_second_classify` (
  `second_classify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '二级分类的id',
  `second_classify_content` varchar(255) NOT NULL COMMENT '二级分类内容',
  PRIMARY KEY (`second_classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_third_classify
-- ----------------------------
DROP TABLE IF EXISTS `tb_third_classify`;
CREATE TABLE `tb_third_classify` (
  `third_classify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '三级分类id',
  `third_classify_content` varchar(255) NOT NULL COMMENT '三级分类内容',
  PRIMARY KEY (`third_classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `user_sex` int(11) DEFAULT NULL COMMENT '用户性别',
  `user_portrait` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_nickname` varchar(255) NOT NULL DEFAULT '游客' COMMENT '用户昵称',
  `user_signature` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `user_email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `user_birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `user_vip` int(1) DEFAULT '0' COMMENT '是否为vip',
  `user_coin` int(20) DEFAULT '20000' COMMENT '用户金币',
  `user_phone` varchar(255) NOT NULL COMMENT '用户手机号码',
  `user_passward` varchar(255) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
