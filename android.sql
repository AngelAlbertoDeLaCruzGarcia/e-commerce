/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.3.15-MariaDB : Database - bdandroid
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdandroid` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bdandroid`;

/*Table structure for table `tblproductos` */

DROP TABLE IF EXISTS `tblproductos`;

CREATE TABLE `tblproductos` (
  `intidprod` int(11) NOT NULL AUTO_INCREMENT,
  `vchnombre` varchar(20) DEFAULT NULL,
  `vchimg` varchar(50) DEFAULT NULL,
  `fltprecio` float DEFAULT NULL,
  `intexistencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`intidprod`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tblproductos` */

insert  into `tblproductos`(`intidprod`,`vchnombre`,`vchimg`,`fltprecio`,`intexistencia`) values (1,'a',NULL,100,12),(2,'as',NULL,0,12),(3,'nuevo',NULL,NULL,NULL);

/*Table structure for table `tblusuarios` */

DROP TABLE IF EXISTS `tblusuarios`;

CREATE TABLE `tblusuarios` (
  `vchuser` varchar(20) NOT NULL,
  `vchpassword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tblusuarios` */

insert  into `tblusuarios`(`vchuser`,`vchpassword`) values ('Angel','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
