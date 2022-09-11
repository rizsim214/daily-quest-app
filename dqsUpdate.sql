-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dailyquestdb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `quest_tbl`
--

DROP TABLE IF EXISTS `quest_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_tbl` (
  `quest_id` int NOT NULL AUTO_INCREMENT,
  `quest_provider_fk_id` int NOT NULL,
  `quest_name` varchar(50) NOT NULL,
  `quest_description` longtext NOT NULL,
  `quest_location` varchar(100) NOT NULL,
  `quest_bounty` float NOT NULL,
  `quest_status` varchar(45) DEFAULT 'active',
  `quest_difficulty` enum('Easy','Medium','Hard') NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `quest_updatedAt` datetime DEFAULT NULL,
  `acceptedAt` datetime DEFAULT NULL,
  `quest_start_date` datetime DEFAULT NULL,
  `quest_timespan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`quest_id`),
  UNIQUE KEY `questID_UNIQUE` (`quest_id`),
  KEY `quest_provider_fk_id` (`quest_provider_fk_id`),
  FULLTEXT KEY `quest_name` (`quest_name`,`quest_description`),
  FULLTEXT KEY `quest_name_2` (`quest_name`),
  FULLTEXT KEY `quest_description` (`quest_description`),
  CONSTRAINT `quest_provider_fk_id` FOREIGN KEY (`quest_provider_fk_id`) REFERENCES `users_tbl` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_tbl`
--

LOCK TABLES `quest_tbl` WRITE;
/*!40000 ALTER TABLE `quest_tbl` DISABLE KEYS */;
INSERT INTO `quest_tbl` VALUES (1,1,'something','something something something','mabolo',250,'deleted','Medium','2022-07-07 19:40:55','2022-07-13 00:00:00',NULL,NULL,NULL),(2,1,'Gardening','I need someone who can help me in gardening my flowers in the backyard','borongan city',100,'deleted','Easy','2022-07-07 19:43:25','2022-07-13 00:00:00',NULL,NULL,NULL),(3,1,'Backyard Cleaning','I need someone to clean my backyard. Its mostly wood and dusts and also lifting some unused boxes','Brgy. Taboc Borongan City Eastern Samar',150,'done','Easy','2022-07-07 19:45:31','2022-07-20 00:00:00','2022-07-18 00:00:00',NULL,NULL),(4,1,'Pool Cleaning','In need of someone who knows how to clean pools. ASAP','Cebu City',150,'active','Medium','2022-07-07 20:46:16','2022-07-20 00:00:00','2022-07-19 00:00:00',NULL,NULL),(5,2,'Cooking Assistance','I need someone to help me cook for a 100 people guest event. someone who can do anything and knows how to chop onions\r\n','Gotham City',250,'done','Hard','2022-07-07 21:37:53','2022-07-20 00:00:00','2022-07-20 00:00:00',NULL,NULL),(6,2,'House Cleaning','I have been planning to deep clean my house but its hard doing it alone. can someone please help me. i can pay good money. ','Borongan City',120,'active','Medium','2022-07-07 21:39:52','2022-07-21 00:00:00','2022-07-21 00:00:00',NULL,NULL),(7,1,'something123','something something something 123123123','mabolo',150,'deleted','Medium','2022-07-11 18:14:47','2022-07-14 00:00:00',NULL,NULL,NULL),(8,2,'Bartender','I need a barista who can handle mixing different variety of drinks depending on the provided booz. i need someone who\'s versatile\r\n','bantayan Island',150,'done','Medium','2022-07-13 21:46:17','2022-07-20 00:00:00','2022-07-18 00:00:00',NULL,NULL),(9,6,'Ceiling Renovation','need someone to help me renovate my ceiling, someone who is always on time ','Mabolo City',100,'active','Medium','2022-07-14 20:30:50',NULL,'2022-07-15 00:00:00',NULL,NULL),(10,6,'Lawn Mowing','i need help to help me mow my lawn with a scissor if thats okay.','Nasipit Talamban',80,'done','Easy','2022-07-14 20:32:48','2022-07-20 00:00:00','2022-07-18 00:00:00',NULL,NULL),(11,1,'Paint Walls','Paint walls for my house..','Borongan City',50,'done','Easy','2022-07-19 20:38:41','2022-07-20 00:00:00','2022-07-20 00:00:00',NULL,NULL),(12,1,'Backyard Grass Cutting','Need someone to cut the grasses in my backyard because its so messy and i want to redesign it','Brgy. Bato Borongan City',80,'done','Medium','2022-07-21 16:28:24','2022-07-21 00:00:00','2022-07-21 00:00:00',NULL,NULL),(13,8,'Baby Sitting Pets','we need someone to baby sit our 3 pet dogs. because im going on a date with my wife','Manila',80,'done','Medium','2022-07-21 17:39:15','2022-08-31 00:00:00','2022-08-31 00:00:00',NULL,NULL),(14,8,'Backyard Cleaning','I need someone to clean my backyard because its already so dirty. it might house some mosquitoes. \r\n','Manila',80,'done','Hard','2022-07-21 17:40:44','2022-07-21 00:00:00','2022-07-21 00:00:00',NULL,NULL),(15,8,'Cooking Assistance','I need someone to help me cook for the upcoming fiesta. ','Manila',150,'active','Hard','2022-07-21 17:43:52',NULL,NULL,NULL,NULL),(16,8,'Grass Cutting','i want someone to cut the grasses on my backyard','Manila',80,'done','Medium','2022-07-21 20:00:50','2022-07-21 00:00:00','2022-07-21 00:00:00',NULL,NULL),(17,1,'Venue Decoration','i need someone to help me decorate our house for the party','Borongan City',500,'active','Easy','2022-09-06 00:00:00',NULL,NULL,'2022-09-07 00:00:00',NULL),(18,1,'Garden Decoration','I need someone to help me decorate my garden. i have the plan i just need some hands','City of Manila',500,'active','Easy','2022-09-07 00:00:00',NULL,NULL,'2022-09-07 00:00:00',NULL),(19,1,'','something something','',500,'active','Medium','2022-09-07 00:00:00',NULL,NULL,'2022-09-07 00:00:00',NULL),(20,1,'someting Cleaning','something something cleaning cleaning','Manila',500,'active','Medium','2022-09-08 00:00:00',NULL,NULL,'2022-09-08 00:00:00',NULL),(21,1,'nothing nothing ','something to nothing, nothing to something','nothinghill city',1000,'active','Hard','2022-09-08 00:00:00',NULL,NULL,'2022-09-08 00:00:00',NULL),(22,1,'somethign sleepy','someone who can keep me awake for the whole class','borongan',350,'deleted','Easy','2022-09-08 00:00:00','2022-09-08 00:00:00',NULL,'2022-09-08 00:00:00','8 hrs'),(23,1,'somethign sleepy','someone who can keep me awake for the whole class','borongan',350,'deleted','Easy','2022-09-08 00:00:00','2022-09-08 00:00:00',NULL,'2022-09-08 00:00:00','8 hrs'),(24,1,'somethign sleepy','someone who can keep me awake for the whole class','borongan',350,'active','Easy','2022-09-08 00:00:00',NULL,NULL,'2022-09-08 00:00:00','8 hrs');
/*!40000 ALTER TABLE `quest_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_transaction_tbl`
--

DROP TABLE IF EXISTS `quest_transaction_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_transaction_tbl` (
  `quest_transaction_id` int NOT NULL AUTO_INCREMENT,
  `quest_transaction_quest_id` int NOT NULL,
  `quest_seeker_id` int NOT NULL,
  `quest_provider_id` int NOT NULL,
  `quest_transaction_status` varchar(50) NOT NULL DEFAULT 'accepted',
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`quest_transaction_id`),
  KEY `quest_fk_id_idx` (`quest_transaction_quest_id`),
  KEY `quest_seeker_id_idx` (`quest_seeker_id`),
  KEY `quest_provider_id_idx` (`quest_provider_id`),
  CONSTRAINT `quest_fk_id` FOREIGN KEY (`quest_transaction_quest_id`) REFERENCES `quest_tbl` (`quest_id`),
  CONSTRAINT `quest_provider_id` FOREIGN KEY (`quest_provider_id`) REFERENCES `users_tbl` (`user_id`),
  CONSTRAINT `quest_seeker_id` FOREIGN KEY (`quest_seeker_id`) REFERENCES `users_tbl` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_transaction_tbl`
--

LOCK TABLES `quest_transaction_tbl` WRITE;
/*!40000 ALTER TABLE `quest_transaction_tbl` DISABLE KEYS */;
INSERT INTO `quest_transaction_tbl` VALUES (106,5,1,2,'cancelled','2022-07-17 17:31:23','2022-07-20 00:00:00'),(107,8,1,2,'cancelled','2022-07-17 17:31:26','2022-07-19 00:00:00'),(108,5,1,2,'cancelled','2022-07-18 22:12:29','2022-07-19 00:00:00'),(109,8,1,2,'done','2022-07-18 22:12:34','2022-07-20 00:00:00'),(110,3,2,1,'done','2022-07-18 22:13:46','2022-07-20 00:00:00'),(111,10,2,6,'done','2022-07-18 22:13:54','2022-07-20 00:00:00'),(112,4,7,1,'cancelled','2022-07-19 20:28:41','2022-07-20 00:00:00'),(113,6,7,2,'cancelled','2022-07-19 20:29:38','2022-07-19 00:00:00'),(114,11,2,1,'done','2022-07-20 13:21:33','2022-07-20 00:00:00'),(115,5,6,2,'done','2022-07-20 17:52:46','2022-07-20 00:00:00'),(116,6,1,2,'cancelled','2022-07-21 11:22:23','2022-07-21 00:00:00'),(117,12,2,1,'done','2022-07-21 16:30:40','2022-07-21 00:00:00'),(118,13,9,8,'cancelled','2022-07-21 17:44:35','2022-07-21 00:00:00'),(119,14,9,8,'cancelled','2022-07-21 17:46:05','2022-07-21 00:00:00'),(120,16,9,8,'done','2022-07-21 20:01:39','2022-07-21 00:00:00'),(121,14,9,8,'done','2022-07-21 20:09:45','2022-07-21 00:00:00'),(122,13,9,8,'cancelled','2022-07-21 20:10:31','2022-07-21 00:00:00'),(123,13,9,8,'cancelled','2022-07-21 20:13:52','2022-07-21 00:00:00'),(124,13,1,8,'done','2022-08-31 18:33:34','2022-08-31 00:00:00');
/*!40000 ALTER TABLE `quest_transaction_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_tbl`
--

DROP TABLE IF EXISTS `users_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_tbl` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_email` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_contact` varchar(45) DEFAULT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT NULL,
  `user_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userUID_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_tbl`
--

LOCK TABLES `users_tbl` WRITE;
/*!40000 ALTER TABLE `users_tbl` DISABLE KEYS */;
INSERT INTO `users_tbl` VALUES (1,'rizsim214@gmail.com','Michael Sim','157c59f24a9016901460750e2baa31bcb5eef1735f1b34ab43e74333d73078da','Cebu City','09123123123','2022-07-07 19:36:49','2022-07-21 00:00:00',NULL),(2,'bruce123@gmail.com','Bruce Wayne','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Gotham City','09132123123','2022-07-07 21:35:47',NULL,NULL),(6,'miketest@gmail.com','mike test','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Nasipit Talamban','09123123123','2022-07-13 21:49:31',NULL,NULL),(7,'michael@gmail.com','michael sim','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','borongan city','09123123123','2022-07-19 20:26:56',NULL,NULL),(8,'provider@gmail.com','Provider','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Cebu','09123123123','2022-07-21 17:37:05',NULL,NULL),(9,'seeker@gmail.com','seeker','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f','Manila','09321321321','2022-07-21 17:37:28','2022-07-21 00:00:00',NULL);
/*!40000 ALTER TABLE `users_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-08 20:55:05
