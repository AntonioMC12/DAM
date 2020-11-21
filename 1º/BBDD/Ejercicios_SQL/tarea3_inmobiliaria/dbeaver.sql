CREATE DATABASE `inmobiliaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `Comprador` (
  `dniComprador` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`dniComprador`),
  UNIQUE KEY `u_Comprador_telefono` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se almacenan los Compradores que hay en la base de datos';

CREATE TABLE `Empleado` (
  `dniEmpleado` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`dniEmpleado`),
  UNIQUE KEY `u_Empleado_telefono` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se almacenan los empleados que hay en la base de datos';

CREATE TABLE `Llamada` (
  `dniComprador` int(10) NOT NULL AUTO_INCREMENT,
  `fechaLlamada` datetime NOT NULL,
  `observaciones` text DEFAULT 'Ninguna',
  `origenLlamada` varchar(9) NOT NULL,
  PRIMARY KEY (`dniComprador`,`fechaLlamada`),
  CONSTRAINT `fk_Llamada_dniComprador` FOREIGN KEY (`dniComprador`) REFERENCES `Comprador` (`dniComprador`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se almacenan un registro de llamadas de los Compradores, he considerado que "fechaLlamada" es un DATETIME, \nya que al ser pk no puede repetirse y considero que puedes hacer varias llamadas el mismo día, pero no el mismo día y a la misma hora.\nTambién considero que "origenLlamada" almacena un telefono, por eso lo determino como VARCHAR(9)';

CREATE TABLE `Propiedad` (
  `numeroRegistroPropiedad` int(10) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `precio` int(20) NOT NULL,
  `comision` int(20) NOT NULL,
  `superficieParcela` int(40) NOT NULL,
  `superficieConstruida` int(40) NOT NULL,
  `numeroDormitorios` int(10) NOT NULL,
  `numeroBaños` int(10) NOT NULL,
  `jardin` tinyint(1) NOT NULL,
  `piscina` tinyint(1) NOT NULL,
  `garaje` tinyint(1) NOT NULL,
  `nuevaSegundaMano` tinyint(1) NOT NULL,
  PRIMARY KEY (`numeroRegistroPropiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se almacenan las propiedades que hay en la base de datos\nen el valor "nuevaSegundaMano" 0 -> nueva | 1-> Segunda mano';

CREATE TABLE `Vendedor` (
  `dniVendedor` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `telefonoMovil` varchar(9) NOT NULL,
  `fax` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `pais` varchar(100) NOT NULL,
  PRIMARY KEY (`dniVendedor`),
  UNIQUE KEY `u_Vendedor_telefono` (`telefono`),
  UNIQUE KEY `u_Vendedor_telefonoMovil` (`telefonoMovil`),
  UNIQUE KEY `u_Vendedor_fax` (`fax`),
  UNIQUE KEY `u_Vendedor_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se almacenan los vendedores que hay en la base de datos';

CREATE TABLE `Venta` (
  `idVenta` int(10) NOT NULL AUTO_INCREMENT,
  `numeroRegistroPropiedad` int(10) NOT NULL,
  `fechaVenta` date NOT NULL,
  `dniComprador` int(10) NOT NULL,
  `dniVendedor` int(10) NOT NULL,
  `dniEmpleado` int(10) NOT NULL,
  `observaciones` text DEFAULT 'Ninguna',
  PRIMARY KEY (`idVenta`),
  KEY `fk_Venta_numeroRegistroPropiedad` (`numeroRegistroPropiedad`),
  KEY `fk_Venta_dniComprador` (`dniComprador`),
  KEY `fk_Venta_dniVendedor` (`dniVendedor`),
  KEY `fk_Venta_dniEmpleado` (`dniEmpleado`),
  CONSTRAINT `fk_Venta_dniComprador` FOREIGN KEY (`dniComprador`) REFERENCES `Comprador` (`dniComprador`),
  CONSTRAINT `fk_Venta_dniEmpleado` FOREIGN KEY (`dniEmpleado`) REFERENCES `Empleado` (`dniEmpleado`),
  CONSTRAINT `fk_Venta_dniVendedor` FOREIGN KEY (`dniVendedor`) REFERENCES `Vendedor` (`dniVendedor`),
  CONSTRAINT `fk_Venta_numeroRegistroPropiedad` FOREIGN KEY (`numeroRegistroPropiedad`) REFERENCES `Propiedad` (`numeroRegistroPropiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla donde se almacenan las ventas que hay en la base de datos';
