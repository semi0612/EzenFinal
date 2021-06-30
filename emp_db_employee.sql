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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EMP_ID` varchar(45) NOT NULL,
  `EMP_PW` varchar(45) DEFAULT NULL,
  `EMP_NAME` varchar(45) NOT NULL,
  `EMP_EMAIL` varchar(45) NOT NULL,
  `EMP_TEL` varchar(45) DEFAULT NULL,
  `EMP_DEPT` varchar(45) NOT NULL,
  `EMP_POSI` varchar(45) NOT NULL,
  `EMP_LEVEL` tinyint DEFAULT NULL,
  `EMP_JOIN` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `EMP_RESI` datetime DEFAULT NULL,
  `EMP_SAL` varchar(45) DEFAULT NULL,
  `EMP_PIC` varchar(255) DEFAULT NULL,
  `TOTAL_ANNDAY` int DEFAULT NULL,
  `ANNDAY_USED` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`EMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('2013270073','ntkc4xtw','김쿠키','cookie@naver.com','02-2242-2242','IT기획팀','과장',0,'2021-06-28 01:21:25',NULL,'4200','cookie.jpg',19,0),('20201003','wldbf','민지율','jeey0506@naver.com','070-4654-5575','개발1팀','사원',0,'2021-02-25 00:00:00',NULL,'2800',NULL,15,0),('20245642','tgdwdg1u','이제훈','jeey0506@naver.com','070-2827-1123','인사총무팀','대리',1,'2021-06-28 02:14:01',NULL,'3800','149145568045455.jpg',19,0),('2045878','yoydtjux','김연아','jeey0506@naver.com','6472126024','개발2팀','주임',0,'2021-06-27 22:43:49',NULL,'4300','DDP.jpg',15,0),('424222225','tqap2g7i','김군찬','jeey0506@naver.com','070-3334-2223','공정안전팀','대리',0,'2021-06-28 02:47:19',NULL,'3800','v3_0916311.png',18,0),('42454542','yoydtjux','김연아','jeey0506@naver.com','070-3838-2827','구매무역팀','주임',1,'2021-06-28 02:06:02',NULL,'3800','08pt9k5qa857u85k8387.jpg',17,0),('46556646','6sbkrfig','김지윤','jeey0506@naver.com','070-2822-1111','공정안전팀','팀장',0,'2021-06-28 03:16:56',NULL,'4500','v3_0910735.jpg',20,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 12:25:55
