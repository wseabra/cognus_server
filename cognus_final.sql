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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pergunta`
--

LOCK TABLES `Pergunta` WRITE;
/*!40000 ALTER TABLE `Pergunta` DISABLE KEYS */;
INSERT INTO `Pergunta` VALUES (10,'Estou em dúvida.','Qual a melhor música da Avril Lavigne?',2),(11,'Não sei o nome dele.','Qual o vocalista do Arctic Monkeys?',2),(17,'Não consigo decidir qual é.','Qual a melhor música do Arctic Monkeys?',2),(18,'Estou fazendo um trabalho da escola e gostaria de ajuda. ','Quem é o presidente do Brasil?',6),(29,'Estou fazendo um tabalho de história.','Quem descobriu o Brasil?',6),(30,'Pretendo montar uma empresa e preciso saber.','Como funciona um CNPJ?',3),(34,'Rio de Janeiro ou Recife?','Qual a cidade mais bonita do Brasil?',6),(35,'Preciso de hotéis em Gramado para passar o tempo.','Indicação de Hoteis em Gramado',3),(36,'Preciso de indicações de mecânicos em São Paulo.','Mecânico em São Paulo',3),(37,'Gostaria de saber quem é o cantor.\n','Quem canta a música X? ',5),(38,'Eu preciso de livros de ação','Indicação de livros de ação',3),(40,'Quero fazer um curso na Uninorte.','Como faço para conseguir uma bolsa de estudos? ',6),(41,'Estou morando sozinho e preciso de ajuda!','Como fazer feijão?',3),(42,'Estou em São Paulo e preciso de um mecânico.','Onde tem mecânico em Bela Vista?',6),(43,'Não lembro qual era o canal.','Qual canal passa o programa da Sônia? ',6);
/*!40000 ALTER TABLE `Pergunta` ENABLE KEYS */;
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
  PRIMARY KEY (`resp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resposta`
--

LOCK TABLES `Resposta` WRITE;
/*!40000 ALTER TABLE `Resposta` DISABLE KEYS */;
INSERT INTO `Resposta` VALUES (1,5,2,1,1,'TESTE'),(12,0,0,9,2,'eita, ta deborando mesmo!\n'),(13,0,0,9,2,'Amanha'),(14,0,0,9,2,'Um dia.'),(15,0,0,8,2,'Ainda não.'),(16,0,0,9,2,'Ainda não temos notícias.'),(17,0,0,11,2,'Alex Turner.'),(18,0,0,11,2,'O baterista é o Matt Helders'),(19,0,0,11,2,'É o alex deus tuner'),(20,0,0,10,2,'Complicated'),(21,0,0,18,2,'Atualmente é o presidente Temer'),(22,0,0,18,2,'Temer mesmo'),(23,0,0,18,2,'bshsjajsjz'),(24,0,0,18,2,'atualmente, é o temer! '),(25,0,0,19,2,'Brasília.'),(26,0,0,19,3,'Brasília mesmo'),(27,0,0,19,6,'Brasília '),(28,0,0,18,3,'Eu acho que é o Temer.'),(29,0,0,22,3,'BD');
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Topico`
--

LOCK TABLES `Topico` WRITE;
/*!40000 ALTER TABLE `Topico` DISABLE KEYS */;
INSERT INTO `Topico` VALUES (3,'Matematica',0),(4,'Musica',0),(5,'Ciencia',0),(6,'Tecnologia',0),(9,'Avril Lavigne',0),(10,'Arctic Monkeys',0),(12,'Brasil',0),(13,'presidente',0),(14,'capital',0),(18,'Cage the Elephants',0),(20,'bolo',0),(21,'maracuja',0),(22,'CNPJ',0),(23,'Gramado',0),(24,'Lady Gaga',0),(25,'Universidade Federal do Amazonas',0),(26,'cidade',0),(27,'Hoteis',0),(28,'Indicacao',0),(30,'X',0),(31,'livros',0),(32,'acao',0),(33,'bolsa',0),(34,'estudos',0),(35,'feijao',0),(36,'Bela Vista',0);
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
INSERT INTO `TopicoPergunta` VALUES (9,10),(10,11),(4,17),(10,17),(12,18),(13,18),(12,29),(22,30),(12,34),(26,34),(23,35),(27,35),(28,35),(4,37),(30,37),(28,38),(31,38),(32,38),(33,40),(34,40),(35,41),(36,42);
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
INSERT INTO `TopicoUser` VALUES (5,3),(6,3),(6,4),(6,5),(6,6),(5,10),(6,10),(7,10),(7,12);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (2,'vic','v@v','123',99),(3,'aa','g@g','123',0),(4,'a','p@p','123',0),(5,'Victória','victoria@gmail.com','0909',0),(6,'Clara','mcmc@icomp.ufam.edu.br','123',0),(7,'Victoria','vpsa@icomp.ufam.edu.br','123',0);
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

-- Dump completed on 2017-07-20 14:03:48
