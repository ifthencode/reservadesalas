
use reservasalas;
-- inserción datos tabla usuarios
insert into usuarios (nombre,apellidos, email) values ('Jacobo','Montero', 'jacobo.montero@optimissa.com');
insert into usuarios (nombre,apellidos, email) values ('Ricardo','Castro', 'ricardo.castro@optimissa.com');

-- insercion datos en tabla salas
insert into salas (nombre, descripcion) values ('Amazonas','Con proyector');
insert into salas (nombre, descripcion) values ('Hampa','Video conferencia');



-- insercion datos en tabla disponible
DELETE FROM reservas;
DELETE FROM fechashoras ;

INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('08:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('09:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('10:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('11:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('12:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('13:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('14:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('16:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('17:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);
INSERT INTO fechashoras(hora,fecha,disponible,sala_id) VALUES('18:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible',2);



INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('01/03/2020', '%d/%m/%Y'),'disponible');

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('02/03/2020', '%d/%m/%Y'),'disponible');

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('03/03/2020', '%d/%m/%Y'),'disponible');

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('04/03/2020', '%d/%m/%Y'),'disponible');

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('05/03/2020', '%d/%m/%Y'),'disponible');

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('06/03/2020', '%d/%m/%Y'),'disponible');

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('07/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('08/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('09/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('10/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('11/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('12/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('13/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('14/03/2020', '%d/%m/%Y'),true);

INSERT INTO fechashoras(hora,fecha,disponible) VALUES('08:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('09:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('10:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('11:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('12:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('13:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('14:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('16:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('17:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);
INSERT INTO fechashoras(hora,fecha,disponible) VALUES('18:00',STR_TO_DATE('15/03/2020', '%d/%m/%Y'),true);

commit;