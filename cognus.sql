-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: cognus
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `Pergunta`
--

DROP TABLE IF EXISTS `Pergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pergunta` (
  `perg_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `texto_perg` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`perg_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `Pergunta_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pergunta`
--

LOCK TABLES `Pergunta` WRITE;
/*!40000 ALTER TABLE `Pergunta` DISABLE KEYS */;
INSERT INTO `Pergunta` VALUES (1,'teste','tessste',1),(2,'shjsjsjsj','shsjjsjs',3),(3,'jjsjsjsjsjks','hsjsjsjjs',3),(4,'jsjsksksksk','hsudjsisjjs',3),(5,'jsjskkskms','jzjsoksksis',3),(6,'snksks','shsjksks',3),(7,'djsksk','ueieie',3);
/*!40000 ALTER TABLE `Pergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PerguntaResposta`
--

DROP TABLE IF EXISTS `PerguntaResposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PerguntaResposta` (
  `perg_id` bigint(20) NOT NULL,
  `resp_id` bigint(20) NOT NULL,
  PRIMARY KEY (`perg_id`,`resp_id`),
  KEY `resp_id` (`resp_id`),
  CONSTRAINT `PerguntaResposta_ibfk_1` FOREIGN KEY (`perg_id`) REFERENCES `Pergunta` (`perg_id`),
  CONSTRAINT `PerguntaResposta_ibfk_2` FOREIGN KEY (`resp_id`) REFERENCES `Resposta` (`resp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PerguntaResposta`
--

LOCK TABLES `PerguntaResposta` WRITE;
/*!40000 ALTER TABLE `PerguntaResposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `PerguntaResposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resposta`
--

DROP TABLE IF EXISTS `Resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resposta` (
  `resp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num_votos_positivos` bigint(20) DEFAULT NULL,
  `num_votos_negativos` bigint(20) DEFAULT NULL,
  `perg_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `texto_resp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resp_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `Resposta_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resposta`
--

LOCK TABLES `Resposta` WRITE;
/*!40000 ALTER TABLE `Resposta` DISABLE KEYS */;
INSERT INTO `Resposta` VALUES (1,5,2,1,1,'TESTE');
/*!40000 ALTER TABLE `Resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Seguidores`
--

DROP TABLE IF EXISTS `Seguidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Seguidores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seguindo_user_id` bigint(20) DEFAULT NULL,
  `seguidor_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `seguindo_user_id` (`seguindo_user_id`),
  KEY `seguidor_user_id` (`seguidor_user_id`),
  CONSTRAINT `Seguidores_ibfk_1` FOREIGN KEY (`seguindo_user_id`) REFERENCES `User` (`user_id`),
  CONSTRAINT `Seguidores_ibfk_2` FOREIGN KEY (`seguidor_user_id`) REFERENCES `User` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Seguidores`
--

LOCK TABLES `Seguidores` WRITE;
/*!40000 ALTER TABLE `Seguidores` DISABLE KEYS */;
/*!40000 ALTER TABLE `Seguidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Topico`
--

DROP TABLE IF EXISTS `Topico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Topico` (
  `topico_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao_topico` varchar(255) NOT NULL,
  `num_seguidores` bigint(20) NOT NULL,
  PRIMARY KEY (`topico_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Topico`
--

LOCK TABLES `Topico` WRITE;
/*!40000 ALTER TABLE `Topico` DISABLE KEYS */;
INSERT INTO `Topico` VALUES (3,'Matematica',0),(4,'Musica',0),(5,'Ciencia',0),(6,'Tecnologia',0);
/*!40000 ALTER TABLE `Topico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TopicoPergunta`
--

DROP TABLE IF EXISTS `TopicoPergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TopicoPergunta` (
  `topico_id` bigint(20) NOT NULL,
  `perg_id` bigint(20) NOT NULL,
  PRIMARY KEY (`topico_id`,`perg_id`),
  KEY `perg_id` (`perg_id`),
  CONSTRAINT `TopicoPergunta_ibfk_1` FOREIGN KEY (`topico_id`) REFERENCES `Topico` (`topico_id`),
  CONSTRAINT `TopicoPergunta_ibfk_2` FOREIGN KEY (`perg_id`) REFERENCES `Pergunta` (`perg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TopicoPergunta`
--

LOCK TABLES `TopicoPergunta` WRITE;
/*!40000 ALTER TABLE `TopicoPergunta` DISABLE KEYS */;
/*!40000 ALTER TABLE `TopicoPergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TopicoUser`
--

DROP TABLE IF EXISTS `TopicoUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TopicoUser` (
  `user_id` bigint(20) NOT NULL,
  `topico_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`topico_id`),
  KEY `topico_id` (`topico_id`),
  CONSTRAINT `TopicoUser_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`),
  CONSTRAINT `TopicoUser_ibfk_2` FOREIGN KEY (`topico_id`) REFERENCES `Topico` (`topico_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TopicoUser`
--

LOCK TABLES `TopicoUser` WRITE;
/*!40000 ALTER TABLE `TopicoUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `TopicoUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `user_senha` varchar(30) DEFAULT NULL,
  `user_numseguidores` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'m@m','mario','99',123),(2,'vic','v@v','123',99),(3,'aa','g@g','123',0),(4,'a','p@p','123',0);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-17 13:07:01
