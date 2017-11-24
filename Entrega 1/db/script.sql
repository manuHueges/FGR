-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for manuweather
CREATE DATABASE IF NOT EXISTS `manuweather` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `manuweather`;

-- Dumping structure for table manuweather.atm
CREATE TABLE IF NOT EXISTS `atm` (
  `id_atm` int(11) NOT NULL AUTO_INCREMENT,
  `humidity` int(11) DEFAULT NULL,
  `pressure` float DEFAULT NULL,
  `visibility` double DEFAULT NULL,
  `rising` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_atm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.atm: ~0 rows (approximately)
/*!40000 ALTER TABLE `atm` DISABLE KEYS */;
/*!40000 ALTER TABLE `atm` ENABLE KEYS */;

-- Dumping structure for table manuweather.country
CREATE TABLE IF NOT EXISTS `country` (
  `id_country` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cod_c_2` char(2) DEFAULT NULL,
  `cod_c_3` char(3) DEFAULT NULL,
  PRIMARY KEY (`id_country`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.country: ~6 rows (approximately)
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`id_country`, `name`, `cod_c_2`, `cod_c_3`) VALUES
	(1, 'ARGENTINA', 'AR', 'ARG'),
	(3, 'TU VIEJA', 'TV', 'VIE'),
	(4, 'TU VIEJA', 'TV', 'VIE'),
	(5, 'TU VIEJA', 'TV', 'VIE'),
	(6, 'TU VIEJA', 'TV', 'VIE'),
	(7, 'TU VIEJA', 'TV', 'VIE');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

-- Dumping structure for table manuweather.day
CREATE TABLE IF NOT EXISTS `day` (
  `id_day` int(11) NOT NULL AUTO_INCREMENT,
  `temperature` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id_day`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.day: ~1 rows (approximately)
/*!40000 ALTER TABLE `day` DISABLE KEYS */;
INSERT INTO `day` (`id_day`, `temperature`, `description`, `date`) VALUES
	(1, 20, 'mortal', NULL);
/*!40000 ALTER TABLE `day` ENABLE KEYS */;

-- Dumping structure for table manuweather.forecast
CREATE TABLE IF NOT EXISTS `forecast` (
  `id_forecast` int(11) NOT NULL AUTO_INCREMENT,
  `id_forecast_day1` int(11) DEFAULT NULL,
  `id_forecast_day2` int(11) DEFAULT NULL,
  `id_forecast_day3` int(11) DEFAULT NULL,
  `id_forecast_day4` int(11) DEFAULT NULL,
  `id_forecast_day5` int(11) DEFAULT NULL,
  `id_forecast_day6` int(11) DEFAULT NULL,
  `id_forecast_day7` int(11) DEFAULT NULL,
  `id_forecast_day8` int(11) DEFAULT NULL,
  `id_forecast_day9` int(11) DEFAULT NULL,
  `id_forecast_day10` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_forecast`),
  KEY `id_forecast_day1_idx` (`id_forecast_day1`),
  KEY `id_forecast_day2_idx` (`id_forecast_day2`),
  KEY `id_forecast_day3_idx` (`id_forecast_day3`),
  KEY `id_forecast_day4_idx` (`id_forecast_day4`),
  KEY `id_forecast_day5_idx` (`id_forecast_day5`),
  KEY `id_forecast_day6_idx` (`id_forecast_day6`),
  KEY `id_forecast_day7_idx` (`id_forecast_day7`),
  KEY `id_forecast_day8_idx` (`id_forecast_day8`),
  KEY `id_forecast_day9_idx` (`id_forecast_day9`),
  KEY `id_forecast_day10_idx` (`id_forecast_day10`),
  CONSTRAINT `id_forecast_day1` FOREIGN KEY (`id_forecast_day1`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day10` FOREIGN KEY (`id_forecast_day10`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day2` FOREIGN KEY (`id_forecast_day2`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day3` FOREIGN KEY (`id_forecast_day3`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day4` FOREIGN KEY (`id_forecast_day4`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day5` FOREIGN KEY (`id_forecast_day5`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day6` FOREIGN KEY (`id_forecast_day6`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day7` FOREIGN KEY (`id_forecast_day7`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day8` FOREIGN KEY (`id_forecast_day8`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast_day9` FOREIGN KEY (`id_forecast_day9`) REFERENCES `forecastcontent` (`id_forecastday`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';

-- Dumping data for table manuweather.forecast: ~0 rows (approximately)
/*!40000 ALTER TABLE `forecast` DISABLE KEYS */;
/*!40000 ALTER TABLE `forecast` ENABLE KEYS */;

-- Dumping structure for table manuweather.forecastcontent
CREATE TABLE IF NOT EXISTS `forecastcontent` (
  `id_forecastday` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `day_name` varchar(45) DEFAULT NULL,
  `max` int(11) DEFAULT NULL,
  `min` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_forecastday`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.forecastcontent: ~0 rows (approximately)
/*!40000 ALTER TABLE `forecastcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `forecastcontent` ENABLE KEYS */;

-- Dumping structure for table manuweather.state
CREATE TABLE IF NOT EXISTS `state` (
  `id_state` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `abr` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `capital` varchar(100) DEFAULT NULL,
  `id_country` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_state`),
  KEY `id_country_idx` (`id_country`),
  CONSTRAINT `id_country` FOREIGN KEY (`id_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.state: ~2 rows (approximately)
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`id_state`, `name`, `abr`, `size`, `capital`, `id_country`) VALUES
	(1, 'CORDOBA', 'COR', 500, 'CORDOBA', 1),
	(2, '', 'ge', 90, '', 6);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;

-- Dumping structure for table manuweather.weather
CREATE TABLE IF NOT EXISTS `weather` (
  `id_state` int(11) NOT NULL,
  `date` date NOT NULL,
  `id_forecast` int(11) DEFAULT NULL,
  `id_day` int(11) DEFAULT NULL,
  `id_wind` int(11) DEFAULT NULL,
  `id_atm` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_state`,`date`),
  KEY `id_atm` (`id_atm`),
  KEY `id_day` (`id_day`),
  KEY `id_forecast` (`id_forecast`),
  KEY `id_wind` (`id_wind`),
  CONSTRAINT `id_atm` FOREIGN KEY (`id_atm`) REFERENCES `atm` (`id_atm`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_day` FOREIGN KEY (`id_day`) REFERENCES `day` (`id_day`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_forecast` FOREIGN KEY (`id_forecast`) REFERENCES `forecast` (`id_forecast`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_wind` FOREIGN KEY (`id_wind`) REFERENCES `wind` (`id_wind`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.weather: ~1 rows (approximately)
/*!40000 ALTER TABLE `weather` DISABLE KEYS */;
INSERT INTO `weather` (`id_state`, `date`, `id_forecast`, `id_day`, `id_wind`, `id_atm`) VALUES
	(1, '2017-11-16', NULL, 1, NULL, NULL);
/*!40000 ALTER TABLE `weather` ENABLE KEYS */;

-- Dumping structure for table manuweather.wind
CREATE TABLE IF NOT EXISTS `wind` (
  `id_wind` int(11) NOT NULL AUTO_INCREMENT,
  `speed` int(11) DEFAULT NULL,
  `direction` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_wind`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table manuweather.wind: ~0 rows (approximately)
/*!40000 ALTER TABLE `wind` DISABLE KEYS */;
/*!40000 ALTER TABLE `wind` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
