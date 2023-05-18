-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: miniwechat
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (1,'15039102695','河南焦作河南理工大学',1),(2,'232786786786','anhuixuencheng',1);
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_collection`
--

DROP TABLE IF EXISTS `t_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_collection` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `isselect` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collection`
--

LOCK TABLES `t_collection` WRITE;
/*!40000 ALTER TABLE `t_collection` DISABLE KEYS */;
INSERT INTO `t_collection` VALUES (3,4,1,0),(5,3,1,0),(6,2,1,0),(7,10,1,0);
/*!40000 ALTER TABLE `t_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_goods`
--

DROP TABLE IF EXISTS `t_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(45) DEFAULT NULL,
  `gimage` varchar(500) DEFAULT NULL,
  `gdesc` varchar(100) DEFAULT NULL,
  `gnum` int(11) DEFAULT NULL,
  `gprice` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `gstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goods`
--

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;
INSERT INTO `t_goods` VALUES (4,'xiaomi9','http://tmp/wxc748b976c3785f3a.o6zAJsxHtJn0RVH24QjuMtXnhzgE.WZanVWDwvTl610fe7fc4041286b65afe3581a4730939.png','九成新的手表，完美无缺，这个价格很公道',1,3200,1,3),(5,'xiaomi888','http://tmp/wxc748b976c3785f3a.o6zAJsxHtJn0RVH24QjuMtXnhzgE.iboCMybgsi2L10fe7fc4041286b65afe3581a4730939.png','九五新，买来几乎没用过，想换新手机了',1,2133,1,3),(6,'xiaomi888','http://tmp/wxc748b976c3785f3a.o6zAJsxHtJn0RVH24QjuMtXnhzgE.iboCMybgsi2L10fe7fc4041286b65afe3581a4730939.png','6成新，换过屏幕，正常使用没有任何的问题',1,2133,1,2),(10,'魅族16th','http://tmp/wxc748b976c3785f3a.o6zAJsxHtJn0RVH24QjuMtXnhzgE.gSWAUDnDn6cT68aefc00970e58c23ab2dee6220896d9.png','魅族旗舰机，九五新，买来不想用了',1,1888,1,1),(11,'魅族16s','http://tmp/wxc748b976c3785f3a.o6zAJsxHtJn0RVH24QjuMtXnhzgE.v1nbG3SLGo1G68aefc00970e58c23ab2dee6220896d9.png','新上市的，新手机，直接卖',1,6779,1,1),(12,'鼠标','http://tmp/wxc748b976c3785f3a.o6zAJsxHtJn0RVH24QjuMtXnhzgE.9u1Yhzi2bXmjb7e2bbbdab8242a2b1f52e06470d053d.PNG','这是一个神奇的鼠标请爱惜她',1,100,1,1);
/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `gstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,21908,'2019-05-10 20:19:53',1,1,3,1),(2,3200,'2019-05-11 09:51:20',1,1,4,1),(3,2133,'2019-05-11 10:20:40',1,1,5,1),(4,2133,'2019-05-14 19:11:48',1,1,6,0),(5,100,'2019-06-16 15:47:57',1,1,12,0);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `uroleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'lanlan','123',1),(2,'hahah','123',0),(3,'tttt','122',0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
