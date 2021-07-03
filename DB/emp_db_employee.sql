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
  `EMP_ID` varchar(50) NOT NULL,
  `EMP_PW` varchar(100) DEFAULT NULL,
  `EMP_NAME` varchar(45) NOT NULL,
  `EMP_EMAIL` varchar(45) NOT NULL,
  `EMP_TEL` varchar(45) DEFAULT NULL,
  `EMP_DEPT` int NOT NULL,
  `EMP_POSI` varchar(45) NOT NULL,
  `EMP_LEVEL` varchar(45) NOT NULL DEFAULT 'ROLE_MEMBER',
  `EMP_JOIN` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `EMP_RESI` datetime DEFAULT NULL,
  `EMP_SAL` varchar(45) DEFAULT NULL,
  `EMP_PIC` varchar(255) DEFAULT NULL,
  `TOTAL_ANNDAY` int DEFAULT NULL,
  `ANNDAY_USED` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`EMP_ID`),
  KEY `FK_EMP_ORG_idx` (`EMP_DEPT`),
  CONSTRAINT `FK_EMP_ORG` FOREIGN KEY (`EMP_DEPT`) REFERENCES `organization` (`org_teamcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('012345','$2a$10$ZHkMbROroDvuAQuiQZbf2uWt5KEjqUJjy1zFcXq5oexqaUaza.frO','문소리','jeey0506@naver.com','070-0000-5878',4,'차장','ROLE_ADMIN','2021-07-03 20:10:36',NULL,'3000','문소리.png',20,0),('022210','wldbf','김수현','jeey0506@naver.com','070-4654-5575',12,'주임','ROLE_MEMBER','2021-02-25 00:00:00',NULL,'2800','김수현.jpg',15,0),('030201','ntkc4xtw','김쿠키','cookie@naver.com','070-2242-2242',3,'사원','ROLE_MEMBER','2021-06-28 01:21:25',NULL,'4200','generated_photos_5e6884006d3b380006f0fe03.jpg',19,2),('051181','6sbkrfig','김지윤','wldbs012@naver.com','070-2822-1111',8,'대리','ROLE_MEMBER','2021-06-28 03:16:56',NULL,'4500','v3_0910735.jpg',20,0),('055210','$2a$10$5Zc33bHOO2.wIzLRIm9qt.DG9McFdzr42L.FY6jsgsp8E53y4S7vy','이상엽','jeey0506@naver.com','070-1111-2922',5,'과장','ROLE_MEMBER','2021-07-03 22:02:32',NULL,'4200','이상엽.png',19,0),('063220','yoydtjux','임윤아','lim0000@naver.com','070-3838-2827',1,'과장','ROLE_MEMBER','2021-06-28 02:06:02',NULL,'3800','08pt9k5qa857u85k8387.jpg',17,0),('068210','$2a$10$Crr2bd0pdaY1lgPd8ta9LORgfHddyDJHFD0MSRybaFYMuQmRGXBI.','유재석','jeey0506@naver.com','070-1827-2382',6,'부장','ROLE_ADMIN','2021-07-02 22:23:30',NULL,'5000','108083_67098_5531.jpg',22,0),('072210','$2a$10$y87LBsLWb.U0etGZlalGLu.mR/HQN7Yd1Cc.sirkDtZFoeA4GBFc.','정재영','jeey0506@naver.com','070-3837-2812',5,'팀장','ROLE_MEMBER','2021-07-02 14:36:43',NULL,'4300','정재영.png',19,0),('082182','tqap2g7i','김군찬','goonchan24@naver.com','070-3334-2223',7,'대리','ROLE_MEMBER','2021-06-28 02:47:19',NULL,'3800','v3_0916311.png',18,1),('093170','yoydtjux','김연아','yunakim@naver.com','070-1234-3333',2,'부장','ROLE_MEMBER','2021-06-27 22:43:49',NULL,'4300','08pt9k5qa857u85k8387.jpg',15,0),('102181','tgdwdg1u','이제훈','jaehooon@naver.com','070-2827-1123',4,'대리','ROLE_ADMIN','2021-06-28 02:14:01',NULL,'3800','149145568045455.jpg',19,0),('105210','$2a$10$P65NMZJ/kYITYUpNfaMZPOKsnj3meMBra1OMeHFdvGOVvuPyaND92','김가은','gauen22@gmail.com','070-1283-2283',10,'과장','ROLE_MEMBER','2021-07-02 22:03:41',NULL,'4200','김가은.png',19,0),('113210','$2a$10$MApLjnYQ/Nn1rcnTwFvLQ.ran0LxiQWS2nMq15wi/68CAhTT5EMtO','이현수','hynsu84@naver.com','070-2821-2221',11,'주임','ROLE_MEMBER','2021-07-01 19:16:24',NULL,'4300','generated_photos_5f1807ec1f67b0000679fe00.jpg',19,0),('128210','$2a$10$vy1zhTQevf.bYEfyhVNqHeKS6SykatwGVr9pETieu59nU6V28TUxm','안뜨면고소','jeey0506@naver.com','070-2721-2291',9,'부장','ROLE_MEMBER','2021-07-03 19:19:10',NULL,'5200','generated_photos_5e6884006d3b380006f0fe03.jpg',24,0);
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

-- Dump completed on 2021-07-03 23:52:47
