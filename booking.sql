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
  `phone` int(15) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `admins` */

insert  into `admins`(`admin_id`,`admin_name`,`password`,`active`,`address`,`phone`,`type`) values 
(1,'admin','123',1,'dasdadasd ',1674745213,1),
(2,'abib','123',0,'69 penistreet dhaka 420',1164521,1),
(3,'Rafman','FatD111',1,'datascet',11114444,1),
(4,'ad','12',1,'New Bitch',2621462,1),
(5,'Shukla','1',0,'dadadadad',14648721,2),
(6,'test','test',1,'test',123,1),
(7,'TestUser','123',1,'test123',123,1);

/*Table structure for table `booking_history` */

DROP TABLE IF EXISTS `booking_history`;

CREATE TABLE `booking_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `card_number` varchar(30) DEFAULT NULL,
  `card_code` varchar(30) DEFAULT NULL,
  `departure` date DEFAULT NULL,
  `return` date DEFAULT NULL,
  `bus_id` varchar(30) DEFAULT NULL,
  `costs` float DEFAULT '0',
  `fees` float DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `booking_history` */

insert  into `booking_history`(`id`,`name`,`phone`,`email`,`address`,`city`,`card_number`,`card_code`,`departure`,`return`,`bus_id`,`costs`,`fees`,`created_at`) values 
(1,'123','123','123','123','123','123','123','2021-01-04','2020-12-23','123',600,60,'2021-01-25 17:37:57'),
(2,'123','123','123','123','123','123','123','2021-01-25','2021-01-25','123',0,0,'2021-01-25 17:41:44');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

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
(15,'test01','123',2,NULL,1);

/*Table structure for table `daily_schedule` */

DROP TABLE IF EXISTS `daily_schedule`;

CREATE TABLE `daily_schedule` (
  `daily_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`daily_schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `daily_schedule` */

insert  into `daily_schedule`(`daily_schedule_id`,`schedule_id`,`date`,`active`) values 
(1,1,'2016-08-29',1),
(2,2,'2016-08-29',1),
(3,3,'2016-08-29',1),
(4,4,'2016-08-29',1),
(5,5,'2016-08-29',1),
(6,6,'2016-08-29',1);

/*Table structure for table `daily_ticket` */

DROP TABLE IF EXISTS `daily_ticket`;

CREATE TABLE `daily_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) NOT NULL,
  `daily_schedule_id` int(11) NOT NULL,
  `booked` tinyint(4) NOT NULL DEFAULT '0',
  `confirmed` int(11) NOT NULL DEFAULT '0',
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

/*Data for the table `daily_ticket` */

insert  into `daily_ticket`(`id`,`ticket_id`,`daily_schedule_id`,`booked`,`confirmed`,`active`) values 
(1,28,21,0,0,1),
(2,31,21,0,0,1),
(3,28,27,0,0,1),
(4,31,27,0,0,1),
(5,32,27,0,0,1),
(6,19,27,0,0,1),
(7,28,26,0,0,1),
(8,31,26,0,0,1),
(9,2,26,0,0,1),
(10,1,26,0,0,1),
(11,21,27,0,0,1),
(12,26,27,0,0,1),
(13,28,22,0,0,1),
(14,32,22,0,0,1),
(15,31,22,0,0,1),
(16,19,22,0,0,1),
(17,32,21,0,0,1),
(18,19,21,0,0,1),
(19,21,22,0,0,1),
(20,26,22,0,0,1),
(21,22,22,0,0,1),
(22,25,22,0,0,1),
(23,24,22,0,0,1),
(24,20,22,0,0,1),
(25,28,28,0,0,1),
(26,31,28,0,0,1),
(27,2,28,0,0,1),
(28,1,28,0,0,1),
(29,32,28,0,0,1),
(30,19,28,0,0,1),
(31,3,28,0,0,1),
(32,4,28,0,0,1),
(33,21,28,0,0,1),
(34,26,28,0,0,1),
(35,31,33,0,0,1),
(36,19,33,0,0,1),
(37,28,33,0,0,1),
(38,32,33,0,0,1),
(39,6,33,0,0,1),
(40,5,33,0,0,1),
(41,31,1,0,0,1),
(42,28,1,0,0,1),
(43,19,1,0,0,1),
(44,32,1,0,0,1),
(45,5,1,0,0,1),
(46,6,1,0,0,1),
(47,26,1,0,0,1),
(48,21,1,0,0,1),
(49,26,2,0,0,1),
(50,24,2,0,0,1),
(51,27,2,0,0,1),
(52,10,2,0,0,1),
(53,1,2,0,0,1),
(54,6,2,0,0,1),
(55,12,2,0,0,1),
(56,16,2,0,0,1),
(57,15,2,0,0,1);

/*Table structure for table `keys` */

DROP TABLE IF EXISTS `keys`;

CREATE TABLE `keys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `key` varchar(40) NOT NULL,
  `level` int(2) NOT NULL,
  `ignore_limits` tinyint(1) NOT NULL DEFAULT '0',
  `is_private_key` tinyint(1) NOT NULL DEFAULT '0',
  `ip_addresses` text,
  `date_created` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `keys` */

insert  into `keys`(`id`,`user_id`,`key`,`level`,`ignore_limits`,`is_private_key`,`ip_addresses`,`date_created`) values 
(1,0,'1234',0,0,0,NULL,0);

/*Table structure for table `logs` */

DROP TABLE IF EXISTS `logs`;

CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uri` varchar(255) NOT NULL,
  `method` varchar(6) NOT NULL,
  `params` text,
  `api_key` varchar(40) NOT NULL,
  `ip_address` varchar(45) NOT NULL,
  `time` int(11) NOT NULL,
  `rtime` float DEFAULT NULL,
  `authorized` varchar(1) NOT NULL,
  `response_code` smallint(3) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `logs` */

/*Table structure for table `routes` */

DROP TABLE IF EXISTS `routes`;

CREATE TABLE `routes` (
  `route_id` int(10) NOT NULL AUTO_INCREMENT,
  `destination` varchar(200) NOT NULL,
  `departs` varchar(200) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `routes` */

insert  into `routes`(`route_id`,`destination`,`departs`,`active`) values 
(1,'Dhaka','Chittagong',1),
(2,'Rajshahi','Dhaka',1),
(3,'Jamalpur','Dhaka',1),
(4,'Mongon','Pluto',1),
(5,'dadadada','dadad',0),
(6,'sdfsdf','fsdf',0),
(7,'Syhlet','Dhaka',1),
(8,'jh','jkbjkbjk',0),
(9,'dasdadadasda','dasdsad',0),
(10,'Moimonshing','Mogakhali',0),
(11,'dada','daasda',0),
(12,'dadada','dada',0),
(13,'Faridpur','Dhaka ',1),
(14,'aaaaa','SD',0),
(15,'a','Asd',0),
(16,'zczcz','czx',0);

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `route_id` int(11) NOT NULL,
  `bus_id` int(11) NOT NULL,
  `time` varchar(256) NOT NULL,
  `fare` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `schedule` */

insert  into `schedule`(`schedule_id`,`route_id`,`bus_id`,`time`,`fare`,`active`) values 
(1,1,1,'01:00:00',700,1),
(2,1,5,'02:00:00',500,1),
(3,1,3,'3 Pm',1600,1),
(4,3,1,'11Am',500,1),
(5,7,3,'12Pm',1000,1),
(6,3,2,'4 Am',700,1),
(7,2,3,'123',123,1);

/*Table structure for table `tickets` */

DROP TABLE IF EXISTS `tickets`;

CREATE TABLE `tickets` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `seat_name` varchar(11) NOT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

/*Data for the table `tickets` */

insert  into `tickets`(`ticket_id`,`seat_name`) values 
(1,'A1'),
(2,'A2'),
(3,'B2'),
(4,'B1'),
(5,'C1'),
(6,'C2'),
(7,'D2'),
(8,'D1'),
(9,'E2'),
(10,'E1'),
(11,'F1'),
(12,'F2'),
(13,'G1'),
(14,'G2'),
(15,'H1'),
(16,'H2'),
(17,'F3'),
(18,'H4'),
(19,'B4'),
(20,'E3'),
(21,'C4'),
(22,'D4'),
(23,'F4'),
(24,'E4'),
(25,'D3'),
(26,'C3'),
(27,'G3'),
(28,'A4'),
(29,'H3'),
(30,'G4'),
(31,'A3'),
(32,'B3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
