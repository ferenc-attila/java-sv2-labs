-- --------------------------------------------------------
-- Hoszt:                        127.0.0.1
-- Szerver verzió:               10.6.5-MariaDB - mariadb.org binary distribution
-- Szerver OS:                   Win64
-- HeidiSQL Verzió:              11.3.0.6371
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Adatbázis struktúra mentése a suli.
CREATE DATABASE IF NOT EXISTS `suli` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `suli`;

-- Struktúra mentése tábla suli. diak
CREATE TABLE IF NOT EXISTS `diak` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nev` varchar(30) DEFAULT NULL,
  `szuldatum` date DEFAULT NULL,
  `naplo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `naplo_id` (`naplo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Az adatok exportálása nem lett kiválasztva.

-- Struktúra mentése tábla suli. jegy
CREATE TABLE IF NOT EXISTS `jegy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ertek` int(11) DEFAULT NULL,
  `leiras` varchar(10) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `diak_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `diak_id` (`diak_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Az adatok exportálása nem lett kiválasztva.

-- Struktúra mentése tábla suli. naplo
CREATE TABLE IF NOT EXISTS `naplo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leiras` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Az adatok exportálása nem lett kiválasztva.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
