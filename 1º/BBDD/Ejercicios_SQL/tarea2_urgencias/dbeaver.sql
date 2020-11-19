CREATE DATABASE `urgencias` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `Cita` (
  `idMedico` int(10) NOT NULL,
  `idPaciente` int(10) NOT NULL,
  `idHospital` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `observaciones` text DEFAULT 'Ninguna',
  PRIMARY KEY (`idMedico`,`idPaciente`,`idHospital`),
  KEY `fk_Cita_Paciente` (`idPaciente`),
  KEY `fk_Cita_idHospital` (`idHospital`),
  CONSTRAINT `fk_Cita_Paciente` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`),
  CONSTRAINT `fk_Cita_idHospital` FOREIGN KEY (`idHospital`) REFERENCES `Hospital` (`idHospital`),
  CONSTRAINT `fk_Cita_idMedico` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`idMedico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde almacenamos las citas que hay en la base de datos, su clave es la union la varias pk de otras tablas';

CREATE TABLE `Hospital` (
  `idHospital` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  PRIMARY KEY (`idHospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde almacenamos los hospitales que hay en la base de datos';

CREATE TABLE `Medico` (
  `idMedico` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `numeroColegiado` int(15) NOT NULL,
  `idUniversidad` int(10) NOT NULL,
  PRIMARY KEY (`idMedico`),
  UNIQUE KEY `u_Medico_numeroColegiado` (`numeroColegiado`),
  KEY `fk_Medico_idUniversidad` (`idUniversidad`),
  CONSTRAINT `fk_Medico_idUniversidad` FOREIGN KEY (`idUniversidad`) REFERENCES `Universidad` (`idUniversidad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde almacenamos los datos de los médicos en la base de datos';

CREATE TABLE `Paciente` (
  `idPaciente` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `observaciones` text DEFAULT 'Ninguna',
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde almacenamos los pacientes que hay en la base de datos';

CREATE TABLE `Universidad` (
  `idUniversidad` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  PRIMARY KEY (`idUniversidad`),
  UNIQUE KEY `u_Universidad_nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se definen las universidades que hay en la base de datos';
