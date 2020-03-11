-- creacion del schema

create schema if not exists reservasalas_b;
-- seleccion del schema
use reservasalas_b;
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

CREATE TABLE fechashoras(
idfechahora int auto_increment,
hora time,
fecha date,
disponible boolean,
primary key (idfechahora)
);



-- creacion de la tabla reservas
CREATE TABLE if not exists reservas (
    idreserva int auto_increment,
    sala_id int,
    usuario_id int,
    fechahora_id int,
    comentarios varchar(255),
    primary key (idreserva),
    FOREIGN KEY (sala_id) REFERENCES salas(idsala),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(idusuario),
    FOREIGN KEY (fechahora_id) REFERENCES fechashoras(idfechahora)
    
);


ALTER TABLE fechashoras DROP COLUMN disponible;
ALTER TABLE fechashoras add disponible varchar(255);
ALTER TABLE fechashoras
 add sala_id int,
 ADD foreign key(sala_id)REFERENCES salas(idsala);



RENAME TABLE reservas TO ars_reservas;
RENAME TABLE fechashoras TO ars_reservas_disp;
RENAME TABLE salas TO ars_reservas_sal;
RENAME TABLE usuarios TO ars_reservas_usu;

ALTER TABLE ars_reservas CHANGE idreserva pk_id_usuario  int auto_increment;
ALTER TABLE ars_reservas CHANGE pk_id_usuario pk_id_reserva  int auto_increment;
ALTER TABLE ars_reservas CHANGE sala_id fk_id_sala  int;
ALTER TABLE ars_reservas CHANGE usuario_id fk_id_usuario  int;
ALTER TABLE ars_reservas CHANGE fechahora_id fk_id_disponibilidad  int;
ALTER TABLE ars_reservas CHANGE comentarios var_comentarios  varchar(255);

ALTER TABLE ars_reservas_disp CHANGE idfechahora pk_id_disponibilidad  int auto_increment;
ALTER TABLE ars_reservas_disp CHANGE hora time_hora_disponibilidad  time;
ALTER TABLE ars_reservas_disp CHANGE fecha date_fecha_disponibilidad  date;
ALTER TABLE ars_reservas_disp CHANGE disponible bool_disponible  boolean;
ALTER TABLE ars_reservas_disp CHANGE bool_disponible var_disponible  varchar(255);
ALTER TABLE ars_reservas_disp CHANGE sala_id fk_id_sala  int;

ALTER TABLE ars_reservas_sal CHANGE idsala pk_id_sala  int auto_increment;
ALTER TABLE ars_reservas_sal CHANGE  nombre  var_nombre_sala  varchar(30);
ALTER TABLE ars_reservas_sal CHANGE  descripcion  var_descripcion_sala  varchar(150);

ALTER TABLE ars_reservas_usu CHANGE idusuario pk_id_usuario  int auto_increment;
ALTER TABLE ars_reservas_usu CHANGE  nombre  var_nombre_usuario  varchar(30);
ALTER TABLE ars_reservas_usu CHANGE  apellidos  var_apellidos_usuario  varchar(150);
ALTER TABLE ars_reservas_usu CHANGE  email  var_email_usuario  varchar(150);

INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('08:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('09:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('10:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('11:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('12:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('13:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('14:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('16:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('17:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
INSERT INTO ars_reservas_disp(time_hora_disponibilidad,date_fecha_disponibilidad,var_disponible,fk_id_sala) VALUES('18:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),'disponible',1);
