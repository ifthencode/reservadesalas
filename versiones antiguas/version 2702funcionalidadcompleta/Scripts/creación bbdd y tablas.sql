-- creacion del schema

create schema if not exists reservasalas;
-- seleccion del schema
use reservasalas;
-- creacion de la tabla usuarios
CREATE TABLE if not exists usuarios (
    idusuario int auto_increment,
    nombre Varchar(30),
    apellidos varchar(150),
    email varchar(150),
    primary key (idusuario)
);
-- creacion de la tabla salas
CREATE TABLE if not exists salas (
    idsala int auto_increment,
    nombre varchar(30),
    descripcion varchar(150),
    primary key (idsala)
);



-- creacion de la tabla fechas
CREATE TABLE if not exists fechas (
    fecha date,
    primary key (fecha)
);

-- creacion de la tabla horas
CREATE TABLE if not exists horas (
    hora time,
    primary key (hora)
);

-- creacion de la tabla reservas
CREATE TABLE if not exists reservas (
    idreserva int auto_increment,
    sala_id int,
    usuario_id int,
    hora time,
    fecha date,
    comentarios varchar(255),
    primary key (idreserva),
    FOREIGN KEY (sala_id) REFERENCES salas(idsala),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(idusuario),
    FOREIGN KEY (hora) REFERENCES horas(hora),
    FOREIGN KEY (fecha) REFERENCES fechas(fecha)
);