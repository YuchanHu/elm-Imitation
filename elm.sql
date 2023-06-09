/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.28-log : Database - elm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`elm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `elm`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminId` int(4) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `adminName` (`adminName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`adminId`,`adminName`,`password`) values (1,'admin','admin');

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `businessId` int(4) NOT NULL AUTO_INCREMENT COMMENT '商家编号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `businessName` varchar(40) NOT NULL COMMENT '商家名称',
  `businessAddress` varchar(50) DEFAULT NULL COMMENT '商家地址',
  `businessExplain` varchar(40) DEFAULT NULL COMMENT '商家介绍',
  `starPrice` double(5,2) DEFAULT '0.00' COMMENT '起送费',
  `deliveryPrice` double(5,2) DEFAULT '0.00' COMMENT '配送费',
  PRIMARY KEY (`businessId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `business` */

insert  into `business`(`businessId`,`password`,`businessName`,`businessAddress`,`businessExplain`,`starPrice`,`deliveryPrice`) values (1,'123','牛约堡','上海市场','牛肉汉堡',20.00,2.00),(2,'456','泰式麻辣烫','广州市场','麻辣烫',15.00,3.00),(3,'789','海底捞','王府井','火锅',50.00,10.00),(4,'012','心连心','联盟路','家常菜',10.00,15.50);

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `foodId` int(4) NOT NULL AUTO_INCREMENT,
  `foodName` varchar(30) NOT NULL,
  `foodExplain` varchar(30) DEFAULT NULL,
  `foodPrice` double(5,2) NOT NULL,
  `businessId` int(4) NOT NULL,
  PRIMARY KEY (`foodId`),
  KEY `businessId` (`businessId`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`businessId`) REFERENCES `business` (`businessId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`foodId`,`foodName`,`foodExplain`,`foodPrice`,`businessId`) values (1,'牛气汉堡','牛肉汉堡',20.00,1),(2,'鸡肉堡','鸡肉的',15.00,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
