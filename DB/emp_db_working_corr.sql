-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: emp_db
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `working_corr`
--

DROP TABLE IF EXISTS `working_corr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `working_corr` (
  `WORK_COR_RID` varchar(10) NOT NULL,
  `COR_WORK_DAY` date NOT NULL,
  `COR_WORK_IN` time NOT NULL,
  `COR_WORK_OUT` time NOT NULL,
  `COR_WORK_RES` text NOT NULL,
  `COR_WORK_REQ` varchar(20) NOT NULL,
  `COR_WORK_STATE` varchar(20) NOT NULL,
  `WORK_RID` varchar(45) NOT NULL,
  `EMP_ID` varchar(45) NOT NULL,
  PRIMARY KEY (`WORK_COR_RID`),
  KEY `WORK_RID` (`WORK_RID`),
  KEY `EMP_ID` (`EMP_ID`),
  CONSTRAINT `working_corr_ibfk_1` FOREIGN KEY (`WORK_RID`) REFERENCES `working_atti` (`WORK_RID`) ON UPDATE CASCADE,
  CONSTRAINT `working_corr_ibfk_2` FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_corr`
--

LOCK TABLES `working_corr` WRITE;
/*!40000 ALTER TABLE `working_corr` DISABLE KEYS */;
/*!40000 ALTER TABLE `working_corr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-03 23:52:47
