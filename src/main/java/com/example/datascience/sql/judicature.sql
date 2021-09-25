-- Host: localhost    Database: data_science
-- ------------------------------------------------------

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
-- Table structure for table `word`
--

DROP TABLE IF EXISTS `word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `word` (
  `token` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `origin_ext` varchar(255) NOT NULL,
  `text` mediumblob,
  PRIMARY KEY (`token`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word`
--

LOCK TABLES `word` WRITE;
/*!40000 ALTER TABLE `word` DISABLE KEYS */;
INSERT INTO `word` VALUES ('样例', '样例文件', '.docx', '文章');
/*!40000 ALTER TABLE `word` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57


--
-- Table structure for table `paragraph`
--

DROP TABLE IF EXISTS `paragraph`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paragraph` (
    `id` int(11) NOT NULL,
    `word_token` varchar(255) NOT NULL,
    `text` varchar(255) DEFAULT NULL,
    `is_table_row_end` int(1) DEFAULT 0,
    `is_in_table` int(1) DEFAULT 0,
    `table_id` int(11) default -1,
    PRIMARY KEY (`id`, `word_token`),
    FOREIGN KEY (`word_token`) references word(`token`),
    FOREIGN KEY (`table_id`) references table_info(`id`)
)   ENGINE=MyISAM
    AUTO_INCREMENT = 3
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping data for table `paragraph`
--

LOCK TABLES `paragraph` WRITE;
/*!40000 ALTER TABLE `paragraph` DISABLE KEYS */;
INSERT INTO `paragraph` VALUES (1, '样例', '文章', 1, 0, 1),
                               (2, '样例', '文章', 1, 0, 1);
/*!40000 ALTER TABLE `paragraph` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57


--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
     `id` varchar(50) NOT NULL,
     `word_token` varchar(255) NOT NULL,
     `paragraph_id_before` int(11),
     `paragraph_id_after` int(11),
     `text_before` text,
     `text_after` text,
     `filename` varchar(255),
     `suggest_file_ext` varchar(255),
     `width` double,
     `height` double,
     `base64_content` blob,
     PRIMARY KEY (`id`, `word_token`),
     FOREIGN KEY (`word_token`) references word(`token`),
     FOREIGN KEY (`paragraph_id_before`) references paragraph(`id`),
     FOREIGN KEY (`paragraph_id_after`) references paragraph(`id`)
)   ENGINE=MyISAM
    AUTO_INCREMENT = 2
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1, '样例', 1, 2, 'tmp','tmp','样例1', null, 0, 0, null),
                           (2, 'sample', 1, 2, 'tmp','tmp','sample2', null, 0, 0, null);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57

--
-- Table structure for table `table_info`
--

DROP TABLE IF EXISTS `table_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_info` (
    `id` int(11) NOT NULL,
    `word_token` varchar(255) NOT NULL,
    `paragraph_id_before` int(11),
    `paragraph_id_after` int(11),
    `text_before` text,
    `text_after` text,
    `table_content` text,
    PRIMARY KEY (`id`, `word_token`),
    FOREIGN KEY (`word_token`) references word(`token`),
    FOREIGN KEY (`paragraph_id_before`) references paragraph(`id`),
    FOREIGN KEY (`paragraph_id_after`) references paragraph(`id`)
)   ENGINE=MyISAM
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_info`
--

LOCK TABLES `table_info` WRITE;
/*!40000 ALTER TABLE `table_info` DISABLE KEYS */;
INSERT INTO `table_info` VALUES (1, '样例', 1, 2,'样例','yangli','11');
/*!40000 ALTER TABLE `table_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57

--
-- Table structure for table `table_content`
--

DROP TABLE IF EXISTS `table_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_content` (
    `id` int(11) NOT NULL,
    `table_id` int(11) NOT NULL,
    `word_token` varchar(255) NOT NULL,
    `row_num` int(11) NOT NULL,
    `col_num` int(11) NOT NULL,
    `text` text,
    PRIMARY KEY (`id`,`table_id`, `word_token`),
    FOREIGN KEY (`word_token`) references word(`token`),
    FOREIGN KEY (`table_id`) references table_info(`id`)
)   ENGINE=MyISAM
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `example`
--

LOCK TABLES `table_content` WRITE;
/*!40000 ALTER TABLE `table_content` DISABLE KEYS */;
INSERT INTO `table_content` VALUES (1, 1,'样例', 1, 1, '样例');
/*!40000 ALTER TABLE `table_content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57


--
-- Table structure for table `title`
--

DROP TABLE IF EXISTS `title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `title` (
     `id` int(11) NOT NULL,
     `word_token` varchar(255) NOT NULL,
     `text` varchar(225),
     `paragraph_end` int(11) DEFAULT 0,
     PRIMARY KEY (`id`, `word_token`),
     FOREIGN KEY (`word_token`) references word(`token`)
)   ENGINE=MyISAM
    AUTO_INCREMENT=2
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title`
--

LOCK TABLES `title` WRITE;
/*!40000 ALTER TABLE `title` DISABLE KEYS */;
INSERT INTO `title` VALUES (1, '样例', '样例', 0);
/*!40000 ALTER TABLE `title` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57


--
-- Table structure for table `paragraph_format`
--

DROP TABLE IF EXISTS `paragraph_format`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paragraph_format` (
    `id` int(11) NOT NULL,
    `token` varchar(255) NOT NULL,
    `line_spacing` double,
    `indent_from_left` int DEFAULT 0,
    `indent_from_right` int DEFAULT 0,
    `first_line_indent` int DEFAULT 0,
    `lvl` varchar(255) DEFAULT 'no lvl',
    PRIMARY KEY (`id`, `token`)
)   ENGINE=MyISAM
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paragraph_format`
--

LOCK TABLES `paragraph_format` WRITE;
/*!40000 ALTER TABLE `paragraph_format` DISABLE KEYS */;
INSERT INTO `paragraph_format` VALUES (1, '样例', 1, 0, 0, 0, 0);
/*!40000 ALTER TABLE `paragraph_format` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57

--
-- Table structure for table `font_format`
--

DROP TABLE IF EXISTS `font_format`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `font_format` (
    `id` int(11) NOT NULL,
    `paragraph_id` int(11) NOT NULL,
    `token` varchar(255) NOT NULL,
    `text` varchar(255),
    `color` varchar(255) DEFAULT 'BLACK',
    `font_size` double DEFAULT 0,
    `font_name` varchar(255) DEFAULT 'no',
    `is_bold` int(1) DEFAULT 0,
    `is_italic` int(1) DEFAULT 0,
    `font_alignment` int(11) DEFAULT 0,
    PRIMARY KEY (`id`, `paragraph_id`, `token`)
)   ENGINE=MyISAM
    DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `example`
--

LOCK TABLES `font_format` WRITE;
/*!40000 ALTER TABLE `font_format` DISABLE KEYS */;
INSERT INTO `font_format` VALUES (1, 1, '样例', 'exp', '绿', 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `font_format` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-13 13:43:57