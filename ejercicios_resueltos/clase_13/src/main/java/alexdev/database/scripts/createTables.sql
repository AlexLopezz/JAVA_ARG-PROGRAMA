use alexdev_qatar2022;

CREATE TABLE Paises(
nombre varchar(255) PRIMARY KEY
);

CREATE TABLE Departamentos(
nombre varchar(255) PRIMARY KEY,
presupuesto varchar(255)
);

CREATE TABLE Empleados (
dni VARCHAR(255) PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
apellido VARCHAR(255) NOT NULL,
pais_FK VARCHAR(150) NOT NULL,
departamento_fk varchar(255) NOT NULL,
FOREIGN KEY (pais_FK)
	REFERENCES Paises (nombre),
FOREIGN KEY (departamento_FK)
	REFERENCES Departamentos (nombre)
);