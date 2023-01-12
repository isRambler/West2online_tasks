/*
SQLyog Professional v12.09 (64 bit)
MySQL - 8.0.31 : Database - weather
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weather` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `weather`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `no` varchar(100) NOT NULL,
  `id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lat` varchar(20) DEFAULT NULL,
  `lon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `city` */

insert  into `city`(`no`,`id`,`name`,`lat`,`lon`) values ('1','101230101','福州','26.07530','119.30624'),('2','101010100','北京','39.90499','116.40529'),('3','101020100','上海','31.23171','121.47264');

/*Table structure for table `weather_3d` */

DROP TABLE IF EXISTS `weather_3d`;

CREATE TABLE `weather_3d` (
  `no` varchar(30) NOT NULL,
  `date_1` date DEFAULT NULL,
  `tempmax_1` varchar(10) DEFAULT NULL,
  `tempmin_1` varchar(10) DEFAULT NULL,
  `textday_1` varchar(10) DEFAULT NULL,
  `date_2` date DEFAULT NULL,
  `tempmax_2` varchar(10) DEFAULT NULL,
  `tempmin_2` varchar(10) DEFAULT NULL,
  `textday_2` varchar(10) DEFAULT NULL,
  `date_3` date DEFAULT NULL,
  `tempmax_3` varchar(10) DEFAULT NULL,
  `tempmin_3` varchar(10) DEFAULT NULL,
  `textday_3` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `weather_3d` */

insert  into `weather_3d`(`no`,`date_1`,`tempmax_1`,`tempmin_1`,`textday_1`,`date_2`,`tempmax_2`,`tempmin_2`,`textday_2`,`date_3`,`tempmax_3`,`tempmin_3`,`textday_3`) values ('1','2023-01-12','22','16','小雨','2023-01-13','21','17','小雨','2023-01-14','24','14','多云'),('2','2023-01-12','3','0','小雪','2023-01-13','3','-3','雨夹雪','2023-01-14','1','-8','多云'),('3','2023-01-12','18','13','小雨','2023-01-13','16','11','中雨','2023-01-14','12','4','小雨');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
