-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for piecetogetherdb
DROP DATABASE IF EXISTS `piecetogetherdb`;
CREATE DATABASE IF NOT EXISTS `piecetogetherdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `piecetogetherdb`;

-- Dumping structure for table piecetogetherdb.jobs
DROP TABLE IF EXISTS `jobs`;
CREATE TABLE IF NOT EXISTS `jobs` (
  `eventId` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `eventType` varchar(255) DEFAULT NULL,
  `hourlyPay` double DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `FK4j3ksi85u83jsfo5atopn2n2n` (`user_id`),
  CONSTRAINT `FK4j3ksi85u83jsfo5atopn2n2n` FOREIGN KEY (`user_id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table piecetogetherdb.jobs: ~14 rows (approximately)
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` (`eventId`, `company`, `date`, `eventType`, `hourlyPay`, `notes`, `salary`, `title`, `user_id`) VALUES
	(1, 'TEKsystems, Optum', '2022-07-18', 'Job', 25, 'starting work soon', NULL, 'Start Web Developer Contract', 1),
	(4, 'Guiness', '2019-04-05', 'Job', 25, 'Got drunk a lot', NULL, 'Taster', 2),
	(5, 'Per scholas', '2018-05-06', 'Job', NULL, 'Great Students', 12000, 'Instructor', 2),
	(6, 'Optum', '2017-11-04', 'Job', NULL, '', 90000, 'Web Developer', 2),
	(7, 'Samsung', '2016-06-06', 'Job', 33.45, '', NULL, 'CEO', 2),
	(8, 'Amazon', '2020-06-08', 'Job', 16.5, 'Job to make ends meet during pandemic', NULL, 'Sortation Specalist', 1),
	(9, 'Amazon', '2021-11-09', 'Job', NULL, '', 33000, 'End Sortation Specialist ', 1),
	(10, 'AERC', '2020-11-16', 'Job', 16, '', NULL, 'End Vet Tech at AERC', 1),
	(11, 'AERC', '2017-07-20', 'Job', 16, '', NULL, 'Start Veterinary Technician', 1),
	(12, 'AERC', '2018-10-16', 'Job', 16, '', NULL, 'Surgery Tech', 1),
	(13, 'SMAEC', '2016-12-21', 'Job', 13.2, '', NULL, 'Start Vet Tech', 1),
	(14, 'Globe University', '2016-08-18', 'Job', 11, '', NULL, 'End Receptionist ', 1),
	(15, 'Globe University', '2016-03-16', 'Job', 11, '', NULL, 'Start Receptionist ', 1),
	(16, 'Red River Zoo', '2014-05-12', 'Job', 10, '', NULL, 'End Zoo Keeper', 1);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;

-- Dumping structure for table piecetogetherdb.other
DROP TABLE IF EXISTS `other`;
CREATE TABLE IF NOT EXISTS `other` (
  `eventId` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `eventType` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `FK3cw4ny7gdodbpkck1xl5bigi8` (`user_id`),
  CONSTRAINT `FK3cw4ny7gdodbpkck1xl5bigi8` FOREIGN KEY (`user_id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Dumping data for table piecetogetherdb.other: ~28 rows (approximately)
/*!40000 ALTER TABLE `other` DISABLE KEYS */;
INSERT INTO `other` (`eventId`, `date`, `eventType`, `notes`, `title`, `user_id`) VALUES
	(1, '2022-02-11', 'Other', 'Matching heart tattoos with Dylan for 10 year aniversary', 'Heart Tattoo', 1),
	(2, '2021-07-27', 'Family', '8lbs 8oz 37 weeks and 2 days 3:21AM', 'Surrogate Baby William Born', 1),
	(4, '2019-04-05', 'School', 'tuition guarantee ', 'Start Thinkful bootcamp', 1),
	(8, '2021-09-21', 'School', '', 'Start UofM Coding Bootcamp', 1),
	(9, '2021-12-15', 'School', 'Made great connections and refreshed knowledge on MERN stack', 'Finish UofM Coding Bootcamp', 1),
	(10, '2021-10-12', 'Vacation', 'Visited Laura Dave and Surrogate babies', 'New Jersey visit', 1),
	(11, '2021-04-10', 'Other', '', 'Covid Vaccine', 1),
	(12, '2020-11-23', 'Family', '', 'Embryo Transfer Surrogate Baby #2', 1),
	(13, '2020-03-18', 'Other', 'Distance learning 1st grade, and no daycare', 'Covid closes schools', 1),
	(14, '2020-02-14', 'Other', 'Lots of fun, won a hat', 'Beerdabler', 1),
	(15, '2020-02-26', 'School', 'Time to look for jobs!', 'Finish Thinkful Bootcamp', 1),
	(16, '2019-10-15', 'Vacation', 'Visiting Laura Dave and Surro baby Lizzie', 'Visit New Jersey', 1),
	(17, '2019-09-24', 'Family', '', 'Edwin Starts Kindergarden', 1),
	(18, '2019-08-02', 'Family', '8lb 10oz  37 weeks 5 days  840AM  22hour labor', 'Surrogate Baby Lizzie Born', 1),
	(19, '2018-11-30', 'Family', '', 'Embryo Transfer Surrogate Baby', 1),
	(20, '2017-10-27', 'Family', '8lb 40weeks  1AM  7 hour labor', 'Nya Born', 1),
	(21, '2017-06-06', 'Vacation', '', 'Greece', 1),
	(22, '2017-05-15', 'Other', '20543 Keystone Ave', 'Moved to Lakeville', 1),
	(23, '2017-03-22', 'School', '', 'Passed VTNE', 1),
	(24, '2016-12-20', 'School', '', 'Graduate Globe Vet Tech', 1),
	(25, '2015-03-12', 'School', 'Globe University', 'Begin Vet Tech ', 1),
	(26, '2014-05-14', 'Other', 'Moved back to Moms', 'Move 87 Emerson Ave', 1),
	(27, '2014-07-19', 'Family', '7lb 14oz  38 weeks 1day  3 hour labor  8:30AM', 'Edwin Born', 1),
	(28, '2013-10-14', 'Vacation', '', 'Ireland Honey Moon', 1),
	(29, '2022-06-25', 'School', 'It went amazing', 'Presentation', 1),
	(30, '1986-07-17', 'Family', '', 'Me Born', 1),
	(31, '2022-06-15', 'Family', '', 'Married Beth', 4),
	(32, '2013-02-20', 'Other', 'some address', 'Move to Fargo', 1);
/*!40000 ALTER TABLE `other` ENABLE KEYS */;

-- Dumping structure for table piecetogetherdb.pets
DROP TABLE IF EXISTS `pets`;
CREATE TABLE IF NOT EXISTS `pets` (
  `eventId` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `eventType` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `petType` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `FKj21u8eer9dqoo1pc34bnnluve` (`user_id`),
  CONSTRAINT `FKj21u8eer9dqoo1pc34bnnluve` FOREIGN KEY (`user_id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table piecetogetherdb.pets: ~6 rows (approximately)
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` (`eventId`, `date`, `eventType`, `notes`, `petType`, `title`, `user_id`) VALUES
	(1, '2020-08-20', 'Pet', 'Found little kitten outside', 'Cat', 'Lita', 1),
	(2, '2019-11-19', 'Pet', '', 'Dog', 'Rehomed Willa', 1),
	(3, '2017-03-08', 'Pet', '', 'Gerbils', 'Alaria and Peba', 1),
	(4, '2018-03-13', 'Pet', '', 'Gerbils', 'Peba died', 1),
	(5, '2019-06-11', 'Pet', 'alaria is a gerbil, soft and cuddly', 'Gerbils', 'Alaria died', 1),
	(6, '2013-01-15', 'Pet', '', 'Dog', 'Willa', 1);
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;

-- Dumping structure for table piecetogetherdb.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table piecetogetherdb.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`Id`, `active`, `email`, `firstName`, `lastName`, `password`, `role`) VALUES
	(1, b'1', 'kathy@email.com', 'Kathy', 'Germann', '$2a$10$SbygTejeW6RgMJIgf89Os.QnAcZxk163oPjo/tQWSFYipbiUYIKbS', 'User'),
	(2, b'1', 'kb@email.com', 'K', 'Pop', '$2a$10$CjsOXzAmL65nHTnnzcEvPuMVClf56MsdAWZmKDC5j756OU68Ag99u', 'User'),
	(3, b'1', 'k@email.com', 'k', 'k', '$2a$10$FarVYu6KJdQrzb6WlEH4Nem5iGUoRy7820MThbRZsqRPwzOh69lYy', 'User'),
	(4, b'1', 'Tom@email.com', 'Tom', 'Johnson', '$2a$10$SbygTejeW6RgMJIgf89Os.QnAcZxk163oPjo/tQWSFYipbiUYIKbS', 'User');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
