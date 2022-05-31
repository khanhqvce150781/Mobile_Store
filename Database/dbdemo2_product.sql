-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: dbdemo2
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idpro` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `condition_id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`idpro`),
  UNIQUE KEY `UK_383i0awxqlq7pc33hil7afbgo` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (8,'1',1,'Galaxy S22 Ultra 5G được kế thừa form thiết kế từ những dòng Note trước đây của hãng đem đến cho bạn có cảm giác vừa mới lạ vừa hoài niệm. Trọng lượng của máy khoảng 228 g cho cảm giác cầm nắm đầm tay, khi cầm máy trần thì hơi có cảm giác dễ trượt.','samsung','samsung-galaxy-s22-ultra-1-1.jpg',1000,'Samsung Galaxy S22 Ultra 5G',100),(9,'asdaadda',1,'This is a phoen very beautyfull','daad','samsung-galaxy-s22-ultra-1-1.jpg',63,'OPPO Reno7 Z 5G',47),(10,'da',1,'aa asdioid  aohd  aduhas uidh aoid haush adhs adioahd iuh dahd oidh as asdoio ','dada','Samsung-Galaxy-Z-Flip-3-600x600.jpg',12,'saasdsa',12),(11,'dad',1,'Nói về nâng cấp thì camera chính là điểm có nhiều cải tiến nhất trên thế hệ iPhone mới.','dad','samsung-galaxy-a03-xanh-thumb-600x600.jpg',123,'adjadjd ',231),(12,'10',3,'OPPO A55 4G có 2 biến thể màu gồm Starry Black (đen) và Rainbow Blue (xanh). Thiết kế cong 3D cùng kích thước mỏng nhẹ, OPPO A55 4G vừa vặn trong tay người cầm, cho từng thao tác trải nghiệm thoải mái và chắc chắn.','oppo','oppo-a55-4g-1-4.jpg',200,'Điện thoại OPPO A55',23),(17,'asdasd',2,'saddas','212312','iphone-13-pro-max-gold-1-600x600.jpg',1232,'saasdsadad',123),(18,'phone',2,'daad','oppo','oppo-reno7-z-5g-thumb-1-1-600x600.jpg',123,'OPPO Reno8 Z 5G',313),(19,'asdaadda',2,'luon dep tuoi khanh dep trai','oppo','oppo-reno7-z-5g-thumb-1-1-600x600.jpg',12,'OPPO Reno9 Z 5G',3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31 22:30:07
