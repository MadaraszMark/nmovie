CREATE DATABASE  IF NOT EXISTS `nmovie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci */;
USE `nmovie`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nmovie
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `release_year` int(11) DEFAULT NULL CHECK (`release_year` >= 1888),
  `runtime_min` int(11) DEFAULT NULL CHECK (`runtime_min` > 0),
  `plot` text DEFAULT NULL,
  `poster_url` varchar(2048) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `version` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_movie_title` (`title`),
  KEY `idx_movie_year` (`release_year`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Inception',2010,148,'Dom Cobb profi álomtolvaj, aki a tudatalattiból lopja ki a titkokat.','https://example.com/inception.jpg',0,'2025-08-18 06:54:40','2025-08-18 06:54:40',0),(2,'The Dark Knight',2008,152,'Batman szembeszáll Jokerral, aki káoszt akar hozni Gotham városára.','https://example.com/dark_knight.jpg',0,'2025-08-18 06:54:40','2025-08-18 06:54:40',0),(3,'Interstellar',2014,169,'Űrhajósok expedícióra indulnak egy féreglyukon át, hogy megmentsék az emberiséget.','https://example.com/interstellar.jpg',0,'2025-08-18 06:54:40','2025-08-18 06:54:40',0),(4,'The Matrix',1999,136,'Egy hacker rájön, hogy a valóság, amelyben él, egy mesterséges szimuláció.','https://example.com/matrix.jpg',0,'2025-08-18 06:54:40','2025-08-18 06:54:40',0),(5,'Pulp Fiction',1994,154,'Több egymással összefonódó történet Los Angeles alvilágából.','https://example.com/pulp_fiction.jpg',0,'2025-08-18 06:54:40','2025-08-18 06:54:40',0),(6,'Gladiator',2000,155,'Maximus tábornok árulás áldozata lesz, és gladiátorként küzd, hogy bosszút álljon családjáért.','https://example.com/gladiator.jpg',0,'2025-08-18 08:30:32','2025-08-18 08:30:32',0),(7,'Forrest Gump',1994,142,'Forrest Gump különleges élete az amerikai történelem eseményein keresztül.','https://example.com/forrest_gump.jpg',0,'2025-08-18 09:18:23','2025-08-18 09:18:23',0),(8,'Forrest Gump 2',2111,110,'Forrest Gump újra alakít.','https://example.com/forrest_gump.jpg',1,'2025-08-19 09:10:03','2025-08-25 08:16:44',0),(9,'Hatos',2002,123,'6 testvér újra taálkoznak','https://example.com/six.jpg',0,'2025-08-25 07:47:44','2025-08-25 07:47:44',0),(10,'Teszt',2002,180,'Teszt','https://example.com/teszt.jpg',1,'2025-08-25 11:01:38','2025-08-25 11:02:44',0),(11,'Teszt2',2002,180,'Teszt','https://example.com/teszt.jpg',0,'2025-08-26 11:12:32','2025-08-26 11:12:32',0),(12,'Teszt3',2012,156,'Teszt3','https://example.com/teszt3.jpg',1,'2025-08-27 06:51:01','2025-08-27 06:51:26',0);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-01 12:49:24
