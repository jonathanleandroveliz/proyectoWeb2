INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (1,b'1',"$2a$10$h1de2mw4/UmAmXhDslsYuuohiJM7UhNTMJUePJkV.DQzByTpQsTxq","Jonathan");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(1,"ROLE_1","1");
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (2,b'1',"$2a$10$h1de2mw4/UmAmXhDslsYuuohiJM7UhNTMJUePJkV.DQzByTpQsTxq","Leandro");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(2,"ROLE_2","2");
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (3,b'1',"$2a$10$h1de2mw4/UmAmXhDslsYuuohiJM7UhNTMJUePJkV.DQzByTpQsTxq","Veliz");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(3,"ROLE_3","3");

insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("Zanneti","Titular",32,"zanetti.png","Puppi","Argentina",1000,"Defensor");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("Ronaldiño","Titular",32,"ronaldiño.jpg","diño","Brasil",1000,"Delantero");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("Redondo","Titular",32,"redondo.jpg","Fernando","Argentina",1000,"Mediocampista");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("Cambiasso","Titular",32,"cambiasso.jpg","cuchu","Argentina",1000,"Mediocampista");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("Zidane","Titular",32,"zidane.jpg","El mago","Francia",1000,"Delantero");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("Figo","Titular",32,"figo.png","Luis","Portugal",1000,"Delantero");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion,posicion) values ("McCalister","Titular",32,"mccalister.jpg","El colo","Argentina",1000,"Defensor");
insert into tecnico (apellido,cantidad_titulos,edad,imagen,nombre,pais)values("Bosques",13,65,"bdb.jpeg","Enrique","España");
insert into club (nombre,apodo,imagen,anio_fundacion,presidente,tecnico_id) values ("RealMadrid","Merengue","md.png",1913,"Pipe Calderon",1);


