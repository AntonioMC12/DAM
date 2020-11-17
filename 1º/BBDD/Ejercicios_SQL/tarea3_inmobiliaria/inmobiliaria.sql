CREATE DATABASE IF NOT EXISTS inmobiliaria;

USE inmobiliaria;

CREATE TABLE IF NOT EXISTS Comprador(
  dniComprador INT(10) AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100) NOT NULL,
  telefono VARCHAR(9) NOT NULL,
  CONSTRAINT pk_Comprador_dniComprador PRIMARY KEY (dniComprador),
  CONSTRAINT u_Comprador_telefono UNIQUE (telefono)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se almacenan los Compradores que hay en la base de datos'
;

CREATE TABLE IF NOT EXISTS Empleado(
  dniEmpleado INT(10) AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100) NOT NULL,
  telefono VARCHAR(9) NOT NULL,
  CONSTRAINT pk_Empleado_dniEmpleado PRIMARY KEY (dniEmpleado),
  CONSTRAINT u_Empleado_telefono UNIQUE (telefono)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se almacenan los empleados que hay en la base de datos'
;

CREATE TABLE IF NOT EXISTS Llamada(
  dniComprador INT(10) AUTO_INCREMENT,
  fechaLlamada DATETIME,
  observaciones TEXT DEFAULT 'Ninguna',
  origenLlamada VARCHAR(9) NOT NULL,
  CONSTRAINT pk_Llamada_dniComprador PRIMARY KEY (dniComprador),
  CONSTRAINT pk_Llamada_fechaLlamada PRIMARY KEY (fechaLlamada),
  CONSTRAINT fk_Llamada_dniComprador FOREIGN KEY (dniComprador) REFERENCES Comprador (dniComprador)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se almacenan un registro de llamadas de los Compradores, he considerado que "fechaLlamada" es un DATETIME, 
ya que al ser pk no puede repetirse y considero que puedes hacer varias llamadas el mismo día, pero no el mismo día y a la misma hora.
También considero que "origenLlamada" almacena un telefono, por eso lo determino como VARCHAR(9)'
;

CREATE TABLE IF NOT EXISTS Vendedor(
  dniVendedor INT(10) AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100) NOT NULL,
  telefono VARCHAR(9) NOT NULL,
  telefonoMovil VARCHAR(9) NOT NULL,
  fax VARCHAR(9) NOT NULL,
  email VARCHAR(100) NOT NULL,
  direccion VARCHAR(100) NOT NULL,
  ciudad VARCHAR(100) NOT NULL,
  cp VARCHAR(5) NOT NULL,
  pais VARCHAR(100) NOT NULL,
  CONSTRAINT pk_Vendedor_dniVendedor PRIMARY KEY (dniVendedor),
  CONSTRAINT u_Vendedor_telefono UNIQUE (telefono),
  CONSTRAINT u_Vendedor_telefonoMovil UNIQUE (telefonoMovil),
  CONSTRAINT u_Vendedor_fax UNIQUE (fax),
  CONSTRAINT u_Vendedor_email UNIQUE (email)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se almacenan los vendedores que hay en la base de datos'
;

CREATE TABLE IF NOT EXISTS Propiedad(
  numeroRegistroPropiedad INT(10) AUTO_INCREMENT,
  direccion VARCHAR(100) NOT NULL,
  ciudad VARCHAR(100) NOT NULL,
  cp VARCHAR(5) NOT NULL,
  pais VARCHAR(100) NOT NULL,
  precio INT(20) NOT NULL,
  comision INT(20) NOT NULL,
  superficieParcela INT(40) NOT NULL,
  superficieConstruida INT(40) NOT NULL,
  numeroDormitorios INT(10) NOT NULL,
  numeroBaños INT(10) NOT NULL,
  jardin BOOLEAN NOT NULL,
  piscina BOOLEAN NOT NULL,
  garaje BOOLEAN NOT NULL,
  nuevaSegundaMano BOOLEAN NOT NULL,
  CONSTRAINT pk_Propiedad_numeroRegistroPropiedad PRIMARY KEY (numeroRegistroPropiedad)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se almacenan las propiedades que hay en la base de datos
en el valor "nuevaSegundaMano" 0 -> nueva | 1-> Segunda mano'
;

CREATE TABLE IF NOT EXISTS Venta(
  idVenta INT(10) AUTO_INCREMENT,
  numeroRegistroPropiedad INT(10) NOT NULL,
  fechaVenta DATE NOT NULL,
  dniComprador INT(10) NOT NULL,
  dniVendedor INT (10) NOT NULL,
  dniEmpleado INT (10) NOT NULL,
  observaciones TEXT DEFAULT 'Ninguna',
  CONSTRAINT pk_Venta_idVenta PRIMARY KEY (idVenta),
  CONSTRAINT fk_Venta_numeroRegistroPropiedad FOREIGN KEY (numeroRegistroPropiedad) REFERENCES Propiedad (numeroRegistroPropiedad),
  CONSTRAINT fk_Venta_dniComprador FOREIGN KEY (dniComprador) REFERENCES Comprador (dniComprador),
  CONSTRAINT fk_Venta_dniVendedor FOREIGN KEY (dniVendedor) REFERENCES Vendedor (dniVendedor),
  CONSTRAINT fk_Venta_dniEmpleado FOREIGN KEY (dniEmpleado) REFERENCES Empleado (dniEmpleado)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se almacenan las ventas que hay en la base de datos'
;