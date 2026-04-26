CREATE DATABASE db_portafolio

CREATE TABLE t_usuarios(
       nombre VARCHAR(50) NOT NULL,
       correo VARCHAR(40) PRIMARY KEY,
       password VARCHAR(25) NOT NULL
);

CREATE TABLE t_tareas(
    id VARCHAR(10) PRIMARY KEY,
    fecha_limite DATETIME NOT NULL,
    descripcion TEXT NOT NULL,
    completada BOOLEAN DEFAULT FALSE,
    correo_usuario VARCHAR(40) NOT NULL,
    FOREIGN KEY (correo_usuario) REFERENCES t_usuarios(correo)
);

