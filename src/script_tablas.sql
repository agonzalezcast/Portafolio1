CREATE DATABASE db_portafolio

CREATE TABLE t_usuarios(
       nombre VARCHAR(50) NOT NULL,
       correo VARCHAR(10) PRIMARY KEY,
       password VARCHAR(25) NOT NULL
);

CREATE TABLE t_tareas(
    id VARCHAR(10) PRIMARY KEY,
    fecha_limite DATETIME NOT NULL,
    descripcion TEXT NOT NULL,
    completada BOOLEAN DEFAULT FALSE,
    correo VARCHAR(40),
    FOREIGN KEY (correo) REFERENCES t_clientes(cedula)
);

