/*
SQLyog Ultimate v11.42 (64 bit)
MySQL - 5.7.16-log : Database - zzhjoa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zzhjoa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zzhjoa`;

/*Table structure for table `abnormal` */

DROP TABLE IF EXISTS `abnormal`;

CREATE TABLE `abnormal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `abnormal_type` varchar(20) DEFAULT NULL,
  `abnormal_date` datetime DEFAULT NULL,
  `abnormal_text` varchar(250) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `abnormal` */

insert  into `abnormal`(`id`,`user_id`,`abnormal_type`,`abnormal_date`,`abnormal_text`,`DATE`,`approver`,`state`) values (1,2,'全天','2017-04-27 07:37:00','1234','2017-04-27 03:37:58',NULL,'待审批');

/*Table structure for table `bus_card` */

DROP TABLE IF EXISTS `bus_card`;

CREATE TABLE `bus_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(60) DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `bus_card` */

insert  into `bus_card`(`id`,`card_number`,`state`) values (1,'1111','可用'),(2,'222','可用'),(3,'3333','可用'),(4,'888','可用');

/*Table structure for table `bus_card_record` */

DROP TABLE IF EXISTS `bus_card_record`;

CREATE TABLE `bus_card_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bus_card_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `START` varchar(30) DEFAULT NULL,
  `over` varchar(30) DEFAULT NULL,
  `start_date` varchar(30) DEFAULT NULL,
  `over_date` varchar(30) DEFAULT NULL,
  `start_money` float DEFAULT NULL,
  `over_money` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bus_card_id` (`bus_card_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bus_card_record_ibfk_1` FOREIGN KEY (`bus_card_id`) REFERENCES `bus_card` (`id`),
  CONSTRAINT `bus_card_record_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `bus_card_record` */

insert  into `bus_card_record`(`id`,`bus_card_id`,`user_id`,`START`,`over`,`start_date`,`over_date`,`start_money`,`over_money`) values (7,2,2,'大兴','朝阳','2017-05-26T22:58','',7,7);

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carNo` varchar(20) DEFAULT NULL,
  `carName` varchar(20) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`id`,`carNo`,`carName`,`state`) values (1,'黑A888','奔驰s500','不可用'),(2,'京A000','梅赛德斯S450','不可用'),(3,'农A666','声控驴子车','可用'),(4,'京B444Q','奥迪','可用');

/*Table structure for table `car_info` */

DROP TABLE IF EXISTS `car_info`;

CREATE TABLE `car_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(11) DEFAULT NULL,
  `requestName` varchar(20) DEFAULT NULL,
  `driver` varchar(20) DEFAULT NULL,
  `departmentName` varchar(20) DEFAULT NULL,
  `requestText` text,
  `startDate` datetime DEFAULT NULL,
  `startNumber` float DEFAULT NULL,
  `overDate` datetime DEFAULT NULL,
  `overNumber` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `carId` (`carId`),
  CONSTRAINT `car_info_ibfk_1` FOREIGN KEY (`carId`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `car_info` */

insert  into `car_info`(`id`,`carId`,`requestName`,`driver`,`departmentName`,`requestText`,`startDate`,`startNumber`,`overDate`,`overNumber`) values (4,1,'123','1','123','1','2017-06-23 09:54:00',11,NULL,0),(5,2,'admin','123','1112','123','2017-06-23 10:01:00',123,NULL,0);

/*Table structure for table `contract` */

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(60) DEFAULT NULL,
  `NAME` varchar(60) DEFAULT NULL,
  `partyA` varchar(20) DEFAULT NULL,
  `partyB` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contract` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`NAME`) values (8,'测绘部'),(9,'房产经纪部'),(10,'地理信息部'),(11,'工装设计部'),(12,'人事部'),(13,'行政部'),(14,'财务部');

/*Table structure for table `departure` */

DROP TABLE IF EXISTS `departure`;

CREATE TABLE `departure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requestName` varchar(20) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `departureText` varchar(250) DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `departure` */

/*Table structure for table `expense` */

DROP TABLE IF EXISTS `expense`;

CREATE TABLE `expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requestName` varchar(20) DEFAULT NULL,
  `expenseText` varchar(250) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `expense` */

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `request_name` varchar(10) DEFAULT NULL,
  `request_date` date DEFAULT NULL,
  `task_id` int(11) DEFAULT NULL,
  `info` varchar(250) DEFAULT NULL,
  `refuse_info` varchar(250) DEFAULT NULL,
  `approver` varchar(10) DEFAULT NULL,
  `over_date` date DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

/*Table structure for table `function` */

DROP TABLE IF EXISTS `function`;

CREATE TABLE `function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TEXT` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `icon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `function` */

insert  into `function`(`id`,`TEXT`,`url`,`parentId`,`state`,`icon`) values (1,'出勤管理',NULL,NULL,'closed','icon-cq'),(2,'人事管理',NULL,NULL,'closed','icon-rs'),(3,'工作任务管理',NULL,NULL,'closed','icon-gr'),(4,'报销单管理',NULL,NULL,'closed','icon-bx'),(5,'行政管理',NULL,NULL,'closed','icon-xz'),(6,'统计报表',NULL,NULL,'closed','icon-tj'),(7,'公告管理',NULL,NULL,'closed','icon-gg'),(8,'审批管理',NULL,NULL,'closed','icon-sp'),(9,'合同管理',NULL,NULL,'closed','icon-ht'),(10,'工作报告管理',NULL,NULL,'closed','icon-gz'),(11,'用户权限管理',NULL,NULL,'closed','icon-yongHu'),(12,'盖章管理',NULL,NULL,'closed','icon-gaiZhang'),(13,'用车信息','istrativeManager\\carInfo.jsp',5,'open',NULL),(14,'用户信息','userRole\\userManager.jsp',11,'open',NULL),(15,'角色管理','userRole\\roleManager.jsp',11,'open',NULL),(28,'请假/休假','kaoQin\\rest.jsp',1,'open',NULL),(29,'打卡异常','kaoQin\\abnormal.jsp',1,'open',NULL),(30,'工作报告','jobLog\\jobLog.jsp',10,'open',NULL),(31,'写日志','jobLog\\writeLog.jsp',10,'open',NULL),(32,'资质章管理','seal\\apply.jsp',12,'open',NULL),(33,'资质章审批','seal\\approve.jsp',8,'open',NULL),(34,'公章管理','seal\\apply_officialSeal.jsp',12,'open',NULL),(35,'公章审批','seal\\approve_officialSeal.jsp',8,'open',NULL),(36,'公章经办','seal\\handling_officialSeal.jsp',5,'open',NULL),(37,'资质章经办','seal\\handling.jsp',5,'open',NULL),(39,'公交一卡通管理','busCard\\busCardRecord.jsp',5,'open',NULL),(40,'发布公告','notice\\writeNotice.jsp',7,'open',NULL),(41,'个人信息',NULL,NULL,'closed','icon-grxx'),(42,'修改完善信息','userRole\\writeUser.jsp',41,'open',NULL),(43,'员工通讯录','HRManager\\userInfo.jsp',2,'open',NULL),(44,'发布任务','task\\addtask.html',3,'open',NULL),(45,'下达任务','task\\queryOwnTask.html',3,'open',NULL),(46,'查看所有任务','task\\queryAllTask.html',3,'open',NULL),(47,'接收任务','task\\OwnTask.html',3,'open',NULL),(48,'审批反馈信息','task\\feedbackApproval.html',3,'open',NULL),(49,'申请任务反馈信息','task\\requestFeedback.html',3,'open',NULL),(50,'公告管理','notice\\noticeManager.jsp',7,'open',NULL),(51,'工作质量检测','task\\qualityTask.html',3,'open',NULL);

/*Table structure for table `function_roles` */

DROP TABLE IF EXISTS `function_roles`;

CREATE TABLE `function_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `function_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `functionId` (`function_id`),
  KEY `roleId` (`role_id`),
  CONSTRAINT `function_roles_ibfk_1` FOREIGN KEY (`function_id`) REFERENCES `function` (`id`),
  CONSTRAINT `function_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=538 DEFAULT CHARSET=utf8;

/*Data for the table `function_roles` */

insert  into `function_roles`(`id`,`role_id`,`function_id`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,1,13),(14,1,14),(17,1,15),(35,1,28),(36,1,29),(37,1,30),(59,1,31),(164,1,32),(169,1,33),(186,1,34),(187,1,35),(211,1,36),(212,1,37),(213,1,39),(233,1,40),(234,1,41),(235,1,42),(240,1,43),(241,1,44),(260,1,45),(273,1,46),(280,1,47),(286,1,49),(287,1,48),(288,4,1),(289,4,28),(290,4,29),(291,4,2),(292,4,43),(293,4,3),(294,4,47),(295,4,49),(296,4,4),(297,4,5),(298,4,13),(299,4,39),(300,4,6),(301,4,7),(302,4,40),(303,4,9),(304,4,10),(305,4,30),(306,4,31),(307,4,12),(308,4,32),(309,4,34),(310,4,41),(311,4,42),(312,3,1),(313,3,28),(314,3,29),(315,3,2),(316,3,43),(317,3,3),(318,3,45),(319,3,48),(320,3,4),(321,3,5),(322,3,13),(323,3,39),(324,3,6),(325,3,7),(326,3,40),(327,3,9),(328,3,10),(329,3,12),(330,3,32),(331,3,34),(332,3,41),(333,3,42),(435,1,50),(436,2,1),(437,2,2),(438,2,3),(439,2,45),(440,2,48),(441,2,4),(442,2,5),(443,2,6),(444,2,7),(445,2,9),(446,2,10),(447,2,12),(505,7,1),(506,7,2),(507,7,3),(508,7,4),(509,7,5),(510,7,6),(511,7,7),(512,7,8),(513,7,9),(514,7,10),(515,7,30),(516,7,31),(517,7,11),(518,7,12),(519,7,41),(520,8,1),(521,8,2),(522,8,3),(523,8,44),(524,8,46),(525,8,48),(526,8,4),(527,8,5),(528,8,6),(529,8,7),(530,8,8),(531,8,9),(532,8,10),(533,8,12),(534,8,41),(535,1,51),(536,17,3),(537,17,51);

/*Table structure for table `joblog` */

DROP TABLE IF EXISTS `joblog`;

CREATE TABLE `joblog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `theme` varchar(60) DEFAULT NULL,
  `text` text,
  `date` date DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `joblog_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `joblog` */

insert  into `joblog`(`id`,`user_id`,`theme`,`text`,`date`,`type`) values (1,2,'123','123','2017-05-04',NULL),(2,2,'666','666','2017-05-04',NULL),(9,17,'测试','<p>测试阿斯顿发<br/></p>','2017-05-05','工作日报'),(13,2,'wwwwwww','<p><strong>wwwwwwww</strong></p>','2017-05-09','工作周报'),(14,2,'wwwwwww','<p><strong>wwwwwwww</strong></p>','2017-05-09','工作周报'),(15,18,'我就不信你能不点开看看','<h1 style=\"text-align: center;\">是不是傻</h1><ol class=\" list-paddingleft-2\" style=\"list-style-type: decimal;\"><li><p>还记得许多年前的春天</p></li><li><p>那时的我还没有减去长发</p></li><li><p>没有信用卡没有她</p></li><li><p>没有24小时热水的家</p></li><li><p>可当初的我是多么快乐</p></li><li><p>虽然只有一把破木吉他</p></li><li><p>接在街上在桥下在人群中</p></li><li><p>唱着那无人问津的歌谣</p></li><li><p>如果有一天</p></li><li><p>我老无所依</p></li><li><p>请把我留在</p></li><li><p>在那时光里</p></li><li><p>如果有一天</p></li><li><p>我悄然离去</p></li><li><p>请把我埋在</p></li><li><p>在这春天里</p></li><li><p>春天里。。。。。。。</p><h2>此处该有掌声，呱唧呱唧。。。<img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0013.gif\"/><img src=\"http://img.baidu.com/hi/ldw/w_0014.gif\"/><img src=\"http://img.baidu.com/hi/face/i_f48.gif\"/><br/></h2></li></ol><p><br/></p>','2017-05-09','工作日报'),(16,2,'6','<table><tbody><tr class=\"firstRow\"><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\"><br/></td></tr><tr><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\" style=\"word-break: break-all;\">666</td><td width=\"133\" valign=\"top\"><br/></td><td width=\"133\" valign=\"top\"><br/></td></tr></tbody></table><p><br/></p>','2017-06-21','工作日报');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(60) DEFAULT NULL,
  `TEXT` text,
  `user_id` int(11) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`theme`,`TEXT`,`user_id`,`release_date`) values (1,'活动','今天阳光明媚，今天多云转晴，',2,'2017-06-01'),(2,'好消息','<p>厂家清仓大甩卖，所有商品一律十五元，十五元你买了吃亏，买不了上当</p>',2,'2017-06-01'),(3,'333','<p>333</p>',2,'2017-06-02'),(4,'很反感','<p>电饭锅电饭锅</p>',14,'2017-07-05');

/*Table structure for table `office_supplies` */

DROP TABLE IF EXISTS `office_supplies`;

CREATE TABLE `office_supplies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requestName` varchar(20) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`),
  CONSTRAINT `office_supplies_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `office_supplies` */

/*Table structure for table `overtime` */

DROP TABLE IF EXISTS `overtime`;

CREATE TABLE `overtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requestName` varchar(20) DEFAULT NULL,
  `overtimeText` varchar(250) DEFAULT NULL,
  `overtimeMoney` float DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `overtime` */

/*Table structure for table `request_seal` */

DROP TABLE IF EXISTS `request_seal`;

CREATE TABLE `request_seal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `project_name` varchar(225) DEFAULT NULL,
  `seal_id` int(11) DEFAULT NULL,
  `pageNumber` int(11) DEFAULT NULL,
  `copiesNumber` int(11) DEFAULT NULL,
  `TEXT` varchar(225) DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `request_date` date DEFAULT NULL,
  `agent` varchar(20) DEFAULT NULL,
  `over_date` date DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `why` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `seal_id` (`seal_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `request_seal_ibfk_1` FOREIGN KEY (`seal_id`) REFERENCES `seal` (`id`),
  CONSTRAINT `request_seal_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `request_seal` */

insert  into `request_seal`(`id`,`number`,`user_id`,`project_name`,`seal_id`,`pageNumber`,`copiesNumber`,`TEXT`,`approver`,`request_date`,`agent`,`over_date`,`state`,`why`) values (1,1,14,'123',2,123,123,'123','赵六','2017-06-02',NULL,NULL,'待审批','是'),(2,2,14,'222',2,22,22,'22','赵六','2017-06-02',NULL,NULL,'待审批','否'),(3,3,14,'333',1,333,333,'333','boss','2017-06-02',NULL,NULL,'待审批','是'),(4,4,14,'444',4,444,444,'444','赵六','2017-06-02',NULL,NULL,'待审批','是'),(5,5,14,'555',1,555,555,'5555','赵六','2017-06-02',NULL,NULL,'待审批','否'),(6,6,14,'6',3,6,6,'6','赵六','2017-06-05',NULL,NULL,'待审批','是'),(7,7,14,'6',1,6,6,'6','赵六','2017-06-05',NULL,NULL,'待审批','是'),(8,8,14,'8',1,8,8,'8','赵六','2017-06-05',NULL,NULL,'待审批',NULL),(9,8,14,'8',1,8,8,'8','赵六','2017-06-05',NULL,NULL,'待审批','是'),(10,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(11,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(12,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(13,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(14,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(15,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(16,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(17,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(18,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(19,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(20,1,14,'1',1,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(21,1,14,'1',2,1,1,'1','boss','2017-06-05',NULL,NULL,'待审批','是'),(22,110,14,'半岛无核化',4,10,10,'啦啦啦','boss','2017-06-05',NULL,NULL,'待审批','是'),(23,110,14,'半岛无核化',1,10,10,'啦啦啦','boss','2017-06-05',NULL,NULL,'待审批','是'),(24,6,14,'6',4,6,6,'6','boss','2017-06-05',NULL,NULL,'待审批','是'),(25,11,14,'111',2,11,11,'111','boss','2017-06-10',NULL,NULL,'待审批','是'),(26,1,14,'1',3,1,1,'1','boss','2017-06-21','李萱','2017-06-21','已审批','否'),(27,3,15,'3',1,3,3,'3','boss','2017-06-22',NULL,NULL,'待审批','否');

/*Table structure for table `rest` */

DROP TABLE IF EXISTS `rest`;

CREATE TABLE `rest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `rest_text` varchar(250) DEFAULT NULL,
  `rest_date` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `advice` varchar(200) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `rest_type_id` int(11) DEFAULT NULL,
  `currents_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `rest_type_id` (`rest_type_id`),
  CONSTRAINT `rest_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `rest_ibfk_2` FOREIGN KEY (`rest_type_id`) REFERENCES `rest_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `rest` */

insert  into `rest`(`id`,`user_id`,`rest_text`,`rest_date`,`date`,`approver`,`advice`,`state`,`rest_type_id`,`currents_date`) values (18,2,'撩妹子，望领导批准','五天','2017-04-28 10:00:57',NULL,NULL,'待审批',5,'2017-04-29'),(20,2,'1','1','2017-05-23 10:48:57',NULL,NULL,'待审批',1,'2017-05-03'),(21,2,'111','1','2017-06-10 02:59:57',NULL,NULL,'待审批',1,'2017-06-07');

/*Table structure for table `rest_type` */

DROP TABLE IF EXISTS `rest_type`;

CREATE TABLE `rest_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `rest_type` */

insert  into `rest_type`(`id`,`name`) values (1,'病假'),(2,'婚嫁'),(3,'丧假'),(4,'年假'),(5,'事假');

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`id`,`NAME`) values (1,'管理员'),(2,'部门经理'),(3,'主管'),(4,'员工'),(7,'总经理'),(8,'副总'),(9,'总经理助理'),(16,'444'),(17,'质检');

/*Table structure for table `seal` */

DROP TABLE IF EXISTS `seal`;

CREATE TABLE `seal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `seal` */

insert  into `seal`(`id`,`type_name`) values (1,'公章'),(2,'合同章'),(3,'财务章'),(4,'法人章');

/*Table structure for table `security_question` */

DROP TABLE IF EXISTS `security_question`;

CREATE TABLE `security_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `security_question` */

insert  into `security_question`(`id`,`name`) values (1,'你的生日'),(2,'你的大学老师'),(3,'你的职业'),(4,'你爱人的名字');

/*Table structure for table `tasks` */

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `task_theme` varchar(50) DEFAULT NULL,
  `task_text` text,
  `task_address` varchar(80) DEFAULT NULL,
  `entrusted_unit` varchar(80) DEFAULT NULL,
  `CLIENT` varchar(50) DEFAULT NULL,
  `client_phone` varchar(50) DEFAULT NULL,
  `task_date` date DEFAULT NULL,
  `recipient` varchar(50) DEFAULT NULL,
  `implement` varchar(50) DEFAULT NULL,
  `implement_date` date DEFAULT NULL,
  `Speed` int(11) DEFAULT NULL,
  `task_phase` varchar(50) DEFAULT NULL,
  `inspection` varchar(20) DEFAULT NULL,
  `inspection_user` varchar(50) DEFAULT NULL,
  `success_date` date DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `over_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `tasks` */

insert  into `tasks`(`id`,`user_name`,`task_theme`,`task_text`,`task_address`,`entrusted_unit`,`CLIENT`,`client_phone`,`task_date`,`recipient`,`implement`,`implement_date`,`Speed`,`task_phase`,`inspection`,`inspection_user`,`success_date`,`state`,`over_date`) values (12,'赵六','666','666','666','666','666','15003100335','2017-07-05','王五','张三','2017-07-05',100,'质量检测','合格','admin','2017-07-28','提前完成','2017-07-31'),(13,'赵六','888','888','88','888','888','15003100335','2017-07-05','王五','张三','2017-07-05',100,'质量检测','合格','admin','2017-07-24','提前完成','2017-07-31'),(14,'赵六','1','1','1','1','1','15003100335','2017-07-05','王五','张三','2017-07-05',100,'质量检测','合格','admin','2017-07-27','提前完成','2017-07-31'),(15,'赵六','12345','12345','12345','1234','12345','15003100335','2017-07-05','王五','张三','2017-07-05',100,'质量检测','合格','zzz','2017-07-13','提前完成','2017-08-17');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `NAME` varchar(20) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `positiveDate` date DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `idCard` int(11) DEFAULT NULL,
  `NATIONAL` varchar(30) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `marital` varchar(5) DEFAULT NULL,
  `face` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `graduated_school` varchar(20) DEFAULT NULL,
  `education` varchar(5) DEFAULT NULL,
  `professional` varchar(20) DEFAULT NULL,
  `POSITION` varchar(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `induction_date` date DEFAULT NULL,
  `image_name` varchar(80) DEFAULT NULL,
  `security_question_id` int(11) DEFAULT NULL,
  `security_answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`),
  KEY `role_id` (`role_id`),
  KEY `security_question_id` (`security_question_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `users_ibfk_3` FOREIGN KEY (`security_question_id`) REFERENCES `security_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`NAME`,`id`,`PASSWORD`,`sex`,`birthday`,`positiveDate`,`role_id`,`departmentId`,`phone`,`idCard`,`NATIONAL`,`height`,`marital`,`face`,`address`,`graduated_school`,`education`,`professional`,`POSITION`,`parent_id`,`state`,`induction_date`,`image_name`,`security_question_id`,`security_answer`) values ('admin',2,'admin','男','2017-06-02','2017-06-01',1,8,'555',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'2017-06-07','2017-05-24_145120.png',NULL,NULL),('张三',14,'111','男','2017-05-02','2016-06-08',4,8,'11',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,15,'open','2017-06-21','button_submit.gif',NULL,NULL),('李四',15,'111','男','2017-05-02',NULL,3,8,'111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,16,'closed',NULL,NULL,NULL,NULL),('王五',16,'111','男','2017-05-02',NULL,2,8,'11',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,17,'closed',NULL,NULL,NULL,NULL),('赵六',17,'111','男','2017-05-02',NULL,8,8,'11',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,18,'closed',NULL,NULL,NULL,NULL),('boss',18,'boss','男','2017-05-02',NULL,7,9,'111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'closed',NULL,NULL,NULL,NULL),('李萱',19,'111','女','2017-04-01',NULL,2,13,'343',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,21,'closed',NULL,NULL,NULL,NULL),('bbb',31,'111','男','2017-06-10',NULL,3,8,'111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,30,NULL,NULL,NULL,NULL,NULL),('呵呵哒',32,'111','男','2017-06-02',NULL,NULL,8,'111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,'1'),('123',33,'111','女','2017-07-05',NULL,NULL,8,'15003100335',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'111'),('666',34,'666','男','2017-07-19',NULL,NULL,8,'666',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,'666'),('111',35,'111','男','2017-07-05',NULL,NULL,8,'111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'111'),('zzz',36,'111','男','2017-07-05',NULL,17,8,'15003100335',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,16,'closed',NULL,NULL,1,'111');

/*Table structure for table `zi_zhi_seal` */

DROP TABLE IF EXISTS `zi_zhi_seal`;

CREATE TABLE `zi_zhi_seal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `projectName` varchar(225) DEFAULT NULL,
  `pageNumber` int(11) DEFAULT NULL,
  `copiesNumber` int(11) DEFAULT NULL,
  `TEXT` varchar(225) DEFAULT NULL,
  `why` varchar(225) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `requestDate` date DEFAULT NULL,
  `approver` varchar(20) DEFAULT NULL,
  `agent` varchar(20) DEFAULT NULL,
  `overDate` date DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `zi_zhi_seal_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `zi_zhi_seal` */

insert  into `zi_zhi_seal`(`id`,`number`,`projectName`,`pageNumber`,`copiesNumber`,`TEXT`,`why`,`user_id`,`requestDate`,`approver`,`agent`,`overDate`,`state`) values (1,1,'111',111,111,'111','111',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(2,2,'222',222,2222,'222','222',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(3,3,'333',3,333,'333','333',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(4,4,'444',444,444,'444','444',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(5,5,'555',555,555,'555','555',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(6,6,'666',666,666,'666','666',14,'2017-06-02','boss',NULL,NULL,'待审批'),(7,7,'777',777,777,'777','777',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(8,8,'888',888,888,'888','888',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(9,9,'9',9,9,'9','9',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(10,10,'1',1,1,'1','1',14,'2017-06-02','赵六',NULL,NULL,'待审批'),(11,11,'11',11,11,'11','11',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(12,11,'11',11,11,'11','11',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(13,11,'11',11,11,'11','11',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(14,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(15,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(16,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(17,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(18,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(19,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(20,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(21,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(22,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(23,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(24,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(25,1,'1',1,1,'1','1',14,'2017-06-05','赵六',NULL,NULL,'待审批'),(26,66,'66',66,66,'66','66',14,'2017-06-05','boss',NULL,NULL,'待审批'),(27,110,'北斗定位',10,10,'稀里哗啦','稀里哗啦',14,'2017-06-05','boss',NULL,NULL,'待审批'),(28,110,'北斗定位',10,10,'稀里哗啦','稀里哗啦',14,'2017-06-05','boss',NULL,NULL,'待审批'),(29,110,'北斗定位',10,10,'稀里哗啦','稀里哗啦',14,'2017-06-05','boss',NULL,NULL,'待审批'),(30,6,'6',6,6,'6','6',14,'2017-06-05','boss',NULL,NULL,'待审批'),(31,1,'1',1,1,'1','1',14,'2017-06-20','赵六',NULL,NULL,'待审批'),(32,1,'hh',11,11,'asdf','asdf',14,'2017-06-20','boss',NULL,NULL,'待审批'),(33,1,'1',1,1,'1','1',14,'2017-06-21','boss',NULL,NULL,'已审批'),(34,1,'1',1,1,'1','1',15,'2017-06-22','boss',NULL,NULL,'待审批'),(35,1,'1',1,1,'1','1',15,'2017-06-22','赵六',NULL,NULL,'待审批');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
