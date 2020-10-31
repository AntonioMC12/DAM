CREATE DATABASE `competicion` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `demarcacion` (
  `idDemarcacion` int(5) NOT NULL AUTO_INCREMENT,
  `demarcacion` varchar(20) NOT NULL,
  PRIMARY KEY (`idDemarcacion`),
  UNIQUE KEY `u_demarcacion_demarcacion` (`demarcacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen las demarcaciones que existen. que son referidas en varias tablas';

CREATE TABLE `equipo` (
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

CREATE TABLE `estadio` (
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

CREATE TABLE `jugador` (
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

CREATE TABLE `pais` (
  `idPais` int(5) NOT NULL AUTO_INCREMENT,
  `pais` varchar(20) NOT NULL,
  `abreviatura` varchar(5) NOT NULL,
  PRIMARY KEY (`idPais`),
  UNIQUE KEY `u_pais_pais` (`pais`),
  UNIQUE KEY `u_pais_abreviatura` (`abreviatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen los paises que existen. que son referidas en varias tablas';

CREATE TABLE `pie` (
  `idPie` int(5) NOT NULL AUTO_INCREMENT,
  `pie` varchar(20) NOT NULL,
  PRIMARY KEY (`idPie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen  que existen. que son referidas en varias tablas';

CREATE TABLE `provincia` (
  `idProvincia` int(5) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(20) NOT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen las provincias que existen. que son referidas en varias tablas';

CREATE TABLE `representante` (
  `idRepresentante` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idRepresentante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen los representantes que existen. que son referidas en varias tablas';

CREATE TABLE `situacionnacionalidad` (
  `idSituacionNacionalidad` int(5) NOT NULL AUTO_INCREMENT,
  `situacion` varchar(20) NOT NULL,
  PRIMARY KEY (`idSituacionNacionalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla donde se definen las situaciones de nacionalidad que existen. que son referidas en varias tablas';
