-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.6-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla competicion.demarcacion
CREATE TABLE IF NOT EXISTS `demarcacion` (
  `idDemarcacion` int(5) NOT NULL AUTO_INCREMENT,
  `demarcacion` varchar(20) NOT NULL,
  PRIMARY KEY (`idDemarcacion`),
  UNIQUE KEY `u_demarcacion_demarcacion` (`demarcacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen las demarcaciones que existen. que son referidas en varias tablas';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `idEquipo` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `nombreOficial` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `cp` int(5) NOT NULL,
  `idProvincia` int(5) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `direccionInternet` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `penias` varchar(20) NOT NULL,
  `telefono` int(9) NOT NULL,
  `fax` int(9) NOT NULL,
  `otrasSecciones` varchar(20) DEFAULT NULL,
  `fechaFundacion` date NOT NULL,
  `historia` varchar(20) NOT NULL,
  `himno` varchar(20) NOT NULL,
  `idEstadio` int(5) NOT NULL,
  `localidad` varchar(20) NOT NULL,
  PRIMARY KEY (`idEquipo`),
  UNIQUE KEY `u_equipo_telefono` (`telefono`),
  UNIQUE KEY `u_equipo_email` (`email`),
  UNIQUE KEY `u_equipo_fax` (`fax`),
  UNIQUE KEY `u_equipo_nombreOficial` (`nombreOficial`),
  KEY `fk_equipo_idProvincia` (`idProvincia`),
  KEY `fk_equipo_idEstadio` (`idEstadio`),
  CONSTRAINT `fk_equipo_idEstadio` FOREIGN KEY (`idEstadio`) REFERENCES `estadio` (`idEstadio`),
  CONSTRAINT `fk_equipo_idProvincia` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde almacenamos los datos de los equipos.';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.estadio
CREATE TABLE IF NOT EXISTS `estadio` (
  `idEstadio` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `capacidad` int(17) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `cp` int(5) NOT NULL,
  `provincia` varchar(20) NOT NULL,
  `telefono` int(9) NOT NULL,
  `inauguracion` date NOT NULL,
  `propietario` varchar(50) NOT NULL,
  `dimensiones` int(10) NOT NULL,
  `otrasInstalaciones` varchar(50) DEFAULT NULL,
  `localidad` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstadio`),
  UNIQUE KEY `u_estadio_telefono` (`telefono`),
  UNIQUE KEY `u_estadio_direccion` (`direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen los estadios que existen.';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.jugador
CREATE TABLE IF NOT EXISTS `jugador` (
  `idJugador` int(5) NOT NULL AUTO_INCREMENT,
  `nombreFutbolistico` varchar(10) NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `lugarNacimiento` varchar(20) NOT NULL,
  `idProvincia` int(5) NOT NULL,
  `idPais` int(5) NOT NULL,
  `idPie` int(5) NOT NULL,
  `idDemarcacion` int(5) NOT NULL,
  `idSituacionNacionalidad` int(5) NOT NULL,
  `altura` int(10) NOT NULL,
  `peso` int(10) NOT NULL,
  `idEquipo` int(5) NOT NULL,
  `internacional` tinyint(1) NOT NULL,
  `historial` varchar(20) NOT NULL,
  `idRepresentante` int(5) NOT NULL,
  `paisNacionalidad` varchar(15) NOT NULL,
  `retirado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idJugador`),
  KEY `fk_jugador_idProvincia` (`idProvincia`),
  KEY `fk_jugador_idPais` (`idPais`),
  KEY `fk_jugador_idPie` (`idPie`),
  KEY `fk_jugador_idDemarcacion` (`idDemarcacion`),
  KEY `fk_jugador_idSituacionNacionalidad` (`idSituacionNacionalidad`),
  KEY `fk_jugador_idEquipo` (`idEquipo`),
  KEY `fk_jugador_idRepresentante` (`idRepresentante`),
  CONSTRAINT `fk_jugador_idDemarcacion` FOREIGN KEY (`idDemarcacion`) REFERENCES `demarcacion` (`idDemarcacion`),
  CONSTRAINT `fk_jugador_idEquipo` FOREIGN KEY (`idEquipo`) REFERENCES `equipo` (`idEquipo`),
  CONSTRAINT `fk_jugador_idPais` FOREIGN KEY (`idPais`) REFERENCES `pais` (`idPais`),
  CONSTRAINT `fk_jugador_idPie` FOREIGN KEY (`idPie`) REFERENCES `pie` (`idPie`),
  CONSTRAINT `fk_jugador_idProvincia` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`),
  CONSTRAINT `fk_jugador_idRepresentante` FOREIGN KEY (`idRepresentante`) REFERENCES `representante` (`idRepresentante`),
  CONSTRAINT `fk_jugador_idSituacionNacionalidad` FOREIGN KEY (`idSituacionNacionalidad`) REFERENCES `situacionnacionalidad` (`idSituacionNacionalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen los jugadores que existen.';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.pais
CREATE TABLE IF NOT EXISTS `pais` (
  `idPais` int(5) NOT NULL AUTO_INCREMENT,
  `pais` varchar(20) NOT NULL,
  `abreviatura` varchar(5) NOT NULL,
  PRIMARY KEY (`idPais`),
  UNIQUE KEY `u_pais_pais` (`pais`),
  UNIQUE KEY `u_pais_abreviatura` (`abreviatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen los paises que existen. que son referidas en varias tablas';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.pie
CREATE TABLE IF NOT EXISTS `pie` (
  `idPie` int(5) NOT NULL AUTO_INCREMENT,
  `pie` varchar(20) NOT NULL,
  PRIMARY KEY (`idPie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen  que existen. que son referidas en varias tablas';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.provincia
CREATE TABLE IF NOT EXISTS `provincia` (
  `idProvincia` int(5) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(20) NOT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen las provincias que existen. que son referidas en varias tablas';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.representante
CREATE TABLE IF NOT EXISTS `representante` (
  `idRepresentante` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idRepresentante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen los representantes que existen. que son referidas en varias tablas';

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla competicion.situacionnacionalidad
CREATE TABLE IF NOT EXISTS `situacionnacionalidad` (
  `idSituacionNacionalidad` int(5) NOT NULL AUTO_INCREMENT,
  `situacion` varchar(20) NOT NULL,
  PRIMARY KEY (`idSituacionNacionalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen las situaciones de nacionalidad que existen. que son referidas en varias tablas';

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
