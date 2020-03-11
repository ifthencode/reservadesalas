-- inserción datos tabla usuarios
insert into usuarios (nombre,apellidos, email) values ('Jacobo','Montero', 'jacobo.montero@optimissa.com');
insert into usuarios (nombre,apellidos, email) values ('Ricardo','Castro', 'ricardo.castro@optimissa.com');

-- insercion datos en tabla salas
insert into salas (nombre, descripcion) values ('Amazonas','Con proyector');
insert into salas (nombre, descripcion) values ('Hampa','Video conferencia');

-- insercion datos en tabla horas
insert into horas values ('08:00');
insert into horas values ('09:00');
insert into horas values ('10:00');
insert into horas values ('11:00');
insert into horas values ('12:00');
insert into horas values ('13:00');
insert into horas values ('14:00');
insert into horas values ('16:00');
insert into horas values ('17:00');
insert into horas values ('18:00');

-- insercion datos en tabla fechas

INSERT INTO fechas VALUES(STR_TO_DATE('01/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('02/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('04/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('05/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('06/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('08/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('09/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('10/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('11/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('12/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('13/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('14/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('15/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('16/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('17/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('18/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('19/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('20/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('21/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('22/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('23/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('24/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('25/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('26/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('27/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('28/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('29/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('30/03/2020', '%d/%m/%Y'));
INSERT INTO fechas VALUES(STR_TO_DATE('31/03/2020', '%d/%m/%Y'));
commit;