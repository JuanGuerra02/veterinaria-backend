insert into raf_tipo_identificacion(nmid,dsnombre)
values (1,'TI'),
        (2,'CC');
        (3,'PASAPORTE');

insert into raf_ciudad (nmid, dsnombre)
values (1, 'Monteria'),
        (2, 'Medellin'),
        (3, 'Bogota');

insert into raf_tipo_paciente (nmid,dsnombre)
values (1,'Gato'),
        (2,'Perro'),
        (3, 'Conejo');

insert into raf_dueno (nmid,dsnombre,nmidentificacion,dsdireccion,nmtelefono,nmciudadid,nmtipidenid)
values(1,'Juan Jose',1066794801,'Calle 18 Cr4',3023548788,1,2),
        (2, 'Jose Ortega',1066684121,'Calle 30',3025786414,2,2),
        (3, 'Mario',99090245874,'Cr 4G #15',3025786414,1,1);

insert into raf_paciente (nmid,dsnombre,dsraza,dtfechanacimiento,dtfecharegistro,nmtippaciid,nmduenoid)
values (1,'Garfiel','Kohana','2006-02-05','2023-01-15',1,1),
        (2, 'Scoot','Pitbull','2007-03-10','2023-01-28',2,3),
        (3, 'Bruno','Pastor Aleman','2009-05-18','2023-01-31',2,2);