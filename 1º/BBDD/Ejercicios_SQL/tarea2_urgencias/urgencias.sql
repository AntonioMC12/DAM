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

LOAD DATA LOCAL INFILE '/home/ertonix12/Formacion/1º/BBDD/Ejercicios_SQL/tarea2_urgencias/data/medicos.csv'
INTO TABLE urgencias.Medico
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
;

/*
##############################################

Metí las fechas mal, y tuve que actualizarlas.

  Se tienen que meter los SET 1 a 1, no los coge
todos a la vez.

##############################################

UPDATE urgencias.Medico
SET fechaNacimiento='1999-05-2' WHERE idMedico = 1
SET fechaNacimiento='1987-03-23' WHERE idMedico = 2
SET fechaNacimiento='1965-01-24' WHERE idMedico = 3
SET fechaNacimiento='1978-12-7' WHERE idMedico = 4
SET fechaNacimiento='1992-09-16' WHERE idMedico = 5
;
*/

LOAD DATA LOCAL INFILE '/home/ertonix12/Formacion/1º/BBDD/Ejercicios_SQL/tarea2_urgencias/data/pacientes.csv'
INTO TABLE urgencias.Paciente
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
;

/*
######################################################

  Actualicé 2 pacientes, pues me equivoqué en el 
csv añadiendo una ',' y en un paciente dejé 
"observaciones" en blanco y no cogió el valor default.

######################################################

UPDATE urgencias.Paciente

SET observaciones='Dice que no sabe si es alérgico al Ibuprofeno que es relativo.' WHERE idPaciente = 1
;
UPDATE urgencias.Paciente
SET observaciones=DEFAULT WHERE idPaciente = 5
;
*/

LOAD DATA LOCAL INFILE '/home/ertonix12/Formacion/1º/BBDD/Ejercicios_SQL/tarea2_urgencias/data/citas.csv'
INTO TABLE urgencias.Cita
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
;

/*
##############################################

  Mysql no coge los campos vacíos como "DEFAULT"
si no que me los deja en NULL o Vacíos. Así 
que tuve que actualizarlos 1 a 1.

##############################################

UPDATE urgencias.Cita
SET observaciones=DEFAULT WHERE idHospital = 1
SET observaciones=DEFAULT WHERE idHospital = 2
SET observaciones=DEFAULT WHERE idHospital = 3
SET observaciones=DEFAULT WHERE idHospital = 4
SET observaciones=DEFAULT WHERE idHospital = 5
;
*/