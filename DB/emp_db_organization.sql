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
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `org_teamcode` int NOT NULL AUTO_INCREMENT,
  `org_groupname` varchar(45) NOT NULL,
  `org_teamname` varchar(45) NOT NULL,
  `org_teamtel` varchar(45) NOT NULL,
  `org_content` varchar(45) NOT NULL,
  PRIMARY KEY (`org_teamcode`,`org_teamname`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'IT본부','IT기획팀','070-3350-5840','IT서비스에 대한 기획 및 프로젝트 서브'),(2,'IT본부','개발1팀','070-3350-5841','IT서비스에 대한 JAVA 관련 프로젝트 개발'),(3,'IT본부','개발2팀','070-3350-5842','IT서비스에 대한 C# .Net 관련 프로젝트 개발'),(4,'경영지원본부','인사총무팀','070-3351-5843','직원 인사관리, 급여 등 총괄업무'),(5,'경영지원본부','재경팀','070-3351-5844','전표처리 및 세금계산서 발행 등 세무 및 회계 관련업무'),(6,'경영지원본부','구매무역팀','070-3351-5845','구매 및 무역 관련업무'),(7,'생산본부','공정안전팀','070-3352-5846','생산라인 점검 및 안전성 보장업무'),(8,'생산본부','공정실행팀','070-3352-5847','생산프로세스 점검 및 유지보수 업무'),(9,'생산본부','생산1팀','070-3352-5848','생산라인 설비 및 실제 생산업무'),(10,'생산본부','생산2팀','070-3352-5849','생산라인 설비 및 실제 생산업무'),(11,'영업본부','영업1팀','070-3375-5910','IT서비스 B2B 영업관리 영업1팀'),(12,'영업본부','영업2팀','070-3375-5917','IT서비스 B2B 신규영업 영업2팀');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
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
