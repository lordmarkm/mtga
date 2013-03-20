-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cards
-- ------------------------------------------------------
-- Server version 5.5.29-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `binderpages`
--

DROP TABLE IF EXISTS `binderpages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binderpages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `binderId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK22BED45A3949E052` (`binderId`),
  CONSTRAINT `FK22BED45A3949E052` FOREIGN KEY (`binderId`) REFERENCES `binders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binderpages`
--

LOCK TABLES `binderpages` WRITE;
/*!40000 ALTER TABLE `binderpages` DISABLE KEYS */;
INSERT INTO `binderpages` VALUES (14,14);
/*!40000 ALTER TABLE `binderpages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `binders`
--

DROP TABLE IF EXISTS `binders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ownerId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF98CA009A21D1EF3` (`ownerId`),
  CONSTRAINT `FKF98CA009A21D1EF3` FOREIGN KEY (`ownerId`) REFERENCES `players` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binders`
--

LOCK TABLES `binders` WRITE;
/*!40000 ALTER TABLE `binders` DISABLE KEYS */;
INSERT INTO `binders` VALUES (14,14);
/*!40000 ALTER TABLE `binders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardcollectionmappings`
--

DROP TABLE IF EXISTS `cardcollectionmappings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardcollectionmappings` (
  `collectionId` bigint(20) NOT NULL,
  `cardId` bigint(20) NOT NULL,
  KEY `FKECC709139284265E` (`cardId`),
  KEY `FKECC70913F3E1556A` (`collectionId`),
  CONSTRAINT `FKECC709139284265E` FOREIGN KEY (`cardId`) REFERENCES `cards` (`id`),
  CONSTRAINT `FKECC70913F3E1556A` FOREIGN KEY (`collectionId`) REFERENCES `cardcollections` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardcollectionmappings`
--

LOCK TABLES `cardcollectionmappings` WRITE;
/*!40000 ALTER TABLE `cardcollectionmappings` DISABLE KEYS */;
INSERT INTO `cardcollectionmappings` VALUES (27,10),(28,11),(28,11);
/*!40000 ALTER TABLE `cardcollectionmappings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardcollections`
--

DROP TABLE IF EXISTS `cardcollections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardcollections` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pageId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFB21208561859026` (`pageId`),
  CONSTRAINT `FKFB21208561859026` FOREIGN KEY (`pageId`) REFERENCES `binderpages` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardcollections`
--

LOCK TABLES `cardcollections` WRITE;
/*!40000 ALTER TABLE `cardcollections` DISABLE KEYS */;
INSERT INTO `cardcollections` VALUES (27,14),(28,14);
/*!40000 ALTER TABLE `cardcollections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cards` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cc_string` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `exp` bigint(20) NOT NULL,
  `expansion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5A0E763D1E2AD99` (`exp`),
  KEY `FK5A0E763D2F1F03B` (`expansion`),
  CONSTRAINT `FK5A0E763D2F1F03B` FOREIGN KEY (`expansion`) REFERENCES `expansions` (`id`),
  CONSTRAINT `FK5A0E763D1E2AD99` FOREIGN KEY (`exp`) REFERENCES `expansions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (10,'2WW','Wrath of God','Destroy all creatures. They can\'t be regenerated.',66,NULL),(11,'W','Savannah Lions',NULL,65,NULL);
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansions`
--

DROP TABLE IF EXISTS `expansions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expansions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exp_abbr` varchar(255) DEFAULT NULL,
  `exp_logo` tinyblob,
  `exp_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansions`
--

LOCK TABLES `expansions` WRITE;
/*!40000 ALTER TABLE `expansions` DISABLE KEYS */;
INSERT INTO `expansions` VALUES (65,'A',NULL,'Alpha'),(66,'10th',NULL,'10th Edition');
/*!40000 ALTER TABLE `expansions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (14);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-19 11:41:35
