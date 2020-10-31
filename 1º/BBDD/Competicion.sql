CREATE TABLE IF NOT EXISTS estadio(
  idEstadio INT(5) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  capacidad INT(17) NOT NULL,
  direccion VARCHAR(50),
  cp INT(5) NOT NULL,
  provincia VARCHAR(20) NOT NULL,
  telefono INT(9) NOT NULL,
  inauguracion DATE NOT NULL,
  propietario VARCHAR(50) NOT NULL,
  dimensiones INT(10) NOT NULL,
  otrasInstalaciones VARCHAR(50),
  localidad VARCHAR(20) NOT NULL,
  CONSTRAINT pk_estadio_idEstadio PRIMARY KEY (idEstadio),
  CONSTRAINT u_estadio_telefono UNIQUE (telefono),
  CONSTRAINT u_estadio_direccion UNIQUE (direccion)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen los estadios que existen.'
;

CREATE TABLE IF NOT EXISTS provincia(
  idProvincia INT(5) NOT NULL AUTO_INCREMENT,
  provincia VARCHAR(20) NOT NULL,
  CONSTRAINT pk_provincia_idProvincia PRIMARY KEY (idProvincia)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen las provincias que existen. que son referidas en varias tablas'
;

CREATE TABLE IF NOT EXISTS equipo(
  idEquipo INT(5) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  nombreOficial VARCHAR(50) NOT NULL,
  direccion VARCHAR (50) NOT NULL,
  cp INT(5) NOT NULL,
  idProvincia INT(5) NOT NULL,
  pais VARCHAR(20) NOT NULL,
  direccionInternet VARCHAR(20) NOT NULL,
  email VARCHAR(20) NOT NULL,
  penias VARCHAR(20) NOT NULL,
  telefono INT(9) NOT NULL,
  fax INT(9) NOT NULL,
  otrasSecciones VARCHAR(20),
  fechaFundacion DATE NOT NULL,
  historia VARCHAR(20) NOT NULL,
  himno VARCHAR(20) NOT NULL,
  idEstadio INT(5) NOT NULL,
  localidad VARCHAR(20) NOT NULL,
  CONSTRAINT pk_equipo_idEquipo PRIMARY KEY (idEquipo),
  CONSTRAINT fk_equipo_idProvincia FOREIGN KEY (idProvincia) REFERENCES provincia (idProvincia),
  CONSTRAINT fk_equipo_idEstadio FOREIGN KEY (idEstadio) REFERENCES estadio (idEstadio),
  CONSTRAINT u_equipo_telefono UNIQUE (telefono),
  CONSTRAINT u_equipo_email UNIQUE (email),
  CONSTRAINT u_equipo_fax UNIQUE (fax),
  CONSTRAINT u_equipo_nombreOficial UNIQUE (nombreOficial)
)
ENGINE = InnoDB
COMMENT = 'Tabla donde almacenamos los datos de los equipos.'
;

CREATE TABLE IF NOT EXISTS representante( 
  idRepresentante INT(5) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  CONSTRAINT pk_provincia_idRepresentante PRIMARY KEY (idRepresentante)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen los representantes que existen. que son referidas en varias tablas'
;

CREATE TABLE IF NOT EXISTS demarcacion(
  idDemarcacion INT(5) NOT NULL AUTO_INCREMENT,
  demarcacion VARCHAR(20) NOT NULL,
  CONSTRAINT pk_provincia_idDemarcacion PRIMARY KEY (idDemarcacion),
  CONSTRAINT u_demarcacion_demarcacion UNIQUE (demarcacion)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen las demarcaciones que existen. que son referidas en varias tablas'
;

CREATE TABLE IF NOT EXISTS pie(
  idPie INT(5) NOT NULL AUTO_INCREMENT,
  pie VARCHAR(20) NOT NULL,
  CONSTRAINT pk_provincia_idPie PRIMARY KEY (idPie)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen  que existen. que son referidas en varias tablas'
;

CREATE TABLE IF NOT EXISTS pais(
  idPais INT(5) NOT NULL AUTO_INCREMENT,
  pais VARCHAR(20) NOT NULL,
  abreviatura VARCHAR(5) NOT NULL,
  CONSTRAINT pk_provincia_idPie PRIMARY KEY (idPais),
  CONSTRAINT u_pais_pais UNIQUE (pais),
  CONSTRAINT u_pais_abreviatura UNIQUE (abreviatura)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen los paises que existen. que son referidas en varias tablas'
;

CREATE TABLE IF NOT EXISTS situacionNacionalidad(
  idSituacionNacionalidad INT(5) NOT NULL AUTO_INCREMENT,
  situacion VARCHAR(20) NOT NULL,
  CONSTRAINT pk_provincia_idSituacionNacionalidad PRIMARY KEY (idSituacionNacionalidad)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen las situaciones de nacionalidad que existen. que son referidas en varias tablas'
;

CREATE TABLE IF NOT EXISTS jugador(
  idJugador INT(5) NOT NULL AUTO_INCREMENT,
  nombreFutbolistico VARCHAR(10) NOT NULL,
  nombre VARCHAR(10) NOT NULL,
  apellidos VARCHAR(20) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  lugarNacimiento VARCHAR(20) NOT NULL,
  idProvincia INT(5) NOT NULL,
  idPais INT(5) NOT NULL,
  idPie INT(5) NOT NULL,
  idDemarcacion INT(5) NOT NULL,
  idSituacionNacionalidad INT(5) NOT NULL,
  altura INT(10) NOT NULL,
  peso INT(10) NOT NULL,
  idEquipo INT(5) NOT NULL,
  internacional BOOLEAN NOT NULL,
  historial VARCHAR(20) NOT NULL,
  idRepresentante INT(5) NOT NULL,
  paisNacionalidad VARCHAR(15) NOT NULL,
  retirado BOOLEAN NOT NULL,
  CONSTRAINT pk_jugador_idJugador PRIMARY KEY (idJugador),
  CONSTRAINT fk_jugador_idProvincia FOREIGN KEY (idProvincia) REFERENCES provincia (idProvincia),
  CONSTRAINT fk_jugador_idPais FOREIGN KEY (idPais) REFERENCES pais (idPais),
  CONSTRAINT fk_jugador_idPie FOREIGN KEY (idPie) REFERENCES pie (idPie),
  CONSTRAINT fk_jugador_idDemarcacion FOREIGN KEY (idDemarcacion) REFERENCES demarcacion (idDemarcacion),
  CONSTRAINT fk_jugador_idSituacionNacionalidad FOREIGN KEY (idSituacionNacionalidad) REFERENCES situacionNacionalidad (idSituacionNacionalidad),
  CONSTRAINT fk_jugador_idEquipo FOREIGN KEY (idEquipo) REFERENCES equipo (idEquipo),
  CONSTRAINT fk_jugador_idRepresentante FOREIGN KEY (idRepresentante) REFERENCES representante (idRepresentante)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen los jugadores que existen.'
;