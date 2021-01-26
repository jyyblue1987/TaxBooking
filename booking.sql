/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 10.1.36-MariaDB : Database - transport
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`transport` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `transport`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(250) NOT NULL,
  `password` varchar(512) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `address` varchar(512) NOT NULL,
  `email` varchar(50) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `admins` */

insert  into `admins`(`admin_id`,`admin_name`,`password`,`active`,`address`,`email`,`type`) values 
(1,'admin','123',1,'dasdadasd ','1674745213',1),
(2,'user','123',0,'69 penistreet dhaka 420','1164521',2),
(3,'Rafman','FatD111',1,'datascet','11114444',1),
(4,'ad','12',1,'New Bitch','2621462',1),
(5,'Shukla','1',0,'dadadadad','14648721',2),
(6,'test','test',1,'test','123',1),
(7,'TestUser','123',1,'test123','123',1),
(8,'test123','123',1,'1234','test1234@gmail.com',2),
(9,'test234','123',1,'Beijin1','1234565',2),
(10,'test124','123',1,'test124','test124@gmail.com',2);

/*Table structure for table `booking_history` */

DROP TABLE IF EXISTS `booking_history`;

CREATE TABLE `booking_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `card_number` varchar(30) DEFAULT NULL,
  `card_code` varchar(30) DEFAULT NULL,
  `departure` date DEFAULT NULL,
  `return` date DEFAULT NULL,
  `bus_id` varchar(30) DEFAULT NULL,
  `costs` float DEFAULT '0',
  `fees` float DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `booking_history` */

insert  into `booking_history`(`id`,`name`,`phone`,`email`,`card_number`,`card_code`,`departure`,`return`,`bus_id`,`costs`,`fees`,`created_at`) values 
(1,'123','123','123','123','123','2021-01-04','2020-12-23','123',600,60,'2021-01-25 17:37:57'),
(2,'123','123','123','123','123','2021-01-25','2021-01-25','123',0,0,'2021-01-25 17:41:44'),
(3,'456','456','456','456','456','2021-01-25','2021-01-28','MM-66',200,20,'2021-01-25 20:53:05'),
(4,'test456','456','test@gmail.com','123','123','2021-01-25','2021-01-28','MM-66',200,20,'2021-01-25 21:03:58'),
(5,'Luqman','+1234567','luqman@gmail.com','CVC123','123456','2021-01-26','2021-01-29','MM-66',200,20,'2021-01-26 08:30:10');

/*Table structure for table `buses` */

DROP TABLE IF EXISTS `buses`;

CREATE TABLE `buses` (
  `bus_id` int(10) NOT NULL AUTO_INCREMENT,
  `bus_name` varchar(110) NOT NULL,
  `model` varchar(110) NOT NULL,
  `capacity` int(10) DEFAULT '5',
  `commissioned` date DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`bus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `buses` */

insert  into `buses`(`bus_id`,`bus_name`,`model`,`capacity`,`commissioned`,`active`) values 
(1,'AAAAA','AAAAAA',5,'2016-08-01',0),
(2,'Star-line','MM-66',6,'2016-04-11',1),
(3,'GG-Man1','A-55',5,'2016-08-24',1),
(5,'Shohah','KK2',5,'2016-08-31',1),
(6,'Star-gazer','55-B',5,'2016-08-17',0),
(7,'Fantom','778D',5,'2016-08-03',0),
(8,'Horn Drill','Fanom-33',5,'2016-08-09',0),
(9,'AAAAAA','AAAAAAA',5,NULL,0),
(10,'dsfsd','fsdfds',5,NULL,0),
(11,'dasadasd','dadadadada',5,NULL,0),
(12,'Bus','adadasda',5,NULL,0),
(13,'testyyyygfd','tastyyyfsfsd',5,NULL,0),
(14,'testbus','123',5,NULL,1),
(16,'School Bus','Benz',20,NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
