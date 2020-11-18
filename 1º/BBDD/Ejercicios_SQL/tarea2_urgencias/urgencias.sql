CREATE DATABASE IF NOT EXISTS urgencias;

USE urgencias;

CREATE TABLE IF NOT EXISTS Universidad(
  idUniversidad INT(10) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  provincia VARCHAR(100) NOT NULL,
  CONSTRAINT pk_Universidad_idUniversidad PRIMARY KEY (idUniversidad),
  CONSTRAINT u_Universidad_nombre UNIQUE (nombre)
)
ENGINE = InnoDB
COMMENT ='Tabla donde se definen las universidades que hay en la base de datos'
;

CREATE TABLE IF NOT EXISTS Medico(
  idMedico INT (10) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  numeroColegiado INT(15) NOT NULL,
  idUniversidad INT(10) NOT NULL,
  CONSTRAINT pk_Medico_idMedico PRIMARY KEY (idMedico),
  CONSTRAINT fk_Medico_idUniversidad FOREIGN KEY (idUniversidad) REFERENCES Universidad (idUniversidad),
  CONSTRAINT u_Medico_numeroColegiado UNIQUE (numeroColegiado)
)
ENGINE = InnoDB
COMMENT ='Tabla donde almacenamos los datos de los médicos en la base de datos'
;

CREATE TABLE IF NOT EXISTS Hospital(
  idHospital INT (10) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  provincia VARCHAR(100) NOT NULL,
  CONSTRAINT pk_Hospital_idHospital PRIMARY KEY (idHospital)
)
ENGINE = InnoDB
COMMENT = 'Tabla donde almacenamos los hospitales que hay en la base de datos'
;

CREATE TABLE IF NOT EXISTS Paciente(
  idPaciente INT(10) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  observaciones TEXT DEFAULT 'Ninguna',
  CONSTRAINT pk_Paciente_idPaciente PRIMARY KEY (idPaciente)
)
ENGINE = InnoDB
COMMENT = 'Tabla donde almacenamos los pacientes que hay en la base de datos'
;

CREATE TABLE IF NOT EXISTS Cita(
  idMedico INT(10) NOT NULL,
  idPaciente INT(10) NOT NULL,
  idHospital INT(10) NOT NULL,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  observaciones TEXT DEFAULT 'Ninguna',
  CONSTRAINT pk_Cita_idMedico_idPaciente_idHospital PRIMARY KEY (idMedico, idPaciente, idHospital),
  CONSTRAINT fk_Cita_idMedico FOREIGN KEY (idMedico) REFERENCES Medico (idMedico),
  CONSTRAINT fk_Cita_Paciente FOREIGN KEY (idPaciente) REFERENCES Paciente (idPaciente),
  CONSTRAINT fk_Cita_idHospital FOREIGN KEY (idHospital) REFERENCES Hospital (idHospital)
)
ENGINE = InnoDB
COMMENT = 'Tabla donde almacenamos las citas que hay en la base de datos, su clave es la union la varias pk de otras tablas'
;

LOAD DATA LOCAL INFILE '/home/ertonix12/Formacion/1º/BBDD/Ejercicios_SQL/tarea2_urgencias/data/universidades.csv'
INTO TABLE urgencias.Universidad
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
;

LOAD DATA LOCAL INFILE '/home/ertonix12/Formacion/1º/BBDD/Ejercicios_SQL/tarea2_urgencias/data/hospitales.csv'
INTO TABLE urgencias.Hospital
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
;