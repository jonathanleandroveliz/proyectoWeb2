INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (1,b'1',"$2a$10$h1de2mw4/UmAmXhDslsYuuohiJM7UhNTMJUePJkV.DQzByTpQsTxq","Jonathan");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(1,"ROLE_3","1");
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (2,b'1',"$2a$10$h1de2mw4/UmAmXhDslsYuuohiJM7UhNTMJUePJkV.DQzByTpQsTxq","Leandro");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(2,"ROLE_1","2");
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (3,b'1',"$2a$10$h1de2mw4/UmAmXhDslsYuuohiJM7UhNTMJUePJkV.DQzByTpQsTxq","Veliz");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(3,"ROLE_2","3");
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("Zanneti","Titular",32,"zanetti.png","Puppi","Argentina",1000);
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("Ronaldiño","Titular",32,"ronaldiño.jpg","diño","Brasil",1000);
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("Redondo","Titular",32,"redondo.jpg","Fernando","Argentina",1000);
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("Cambiasso","Titular",32,"cambiasso.jpg","cuchu","Argentina",1000);
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("Zidane","Titular",32,"zidane.jpg","El mago","Francia",1000);
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("Figo","Titular",32,"figo.png","Luis","Portugal",1000);
insert into jugador (apellido,categoria,edad,imagen,nombre,pais,valuacion) values ("McCalister","Titular",32,"mccalister.jpg","El colo","Argentina",1000);
insert into tecnico (apellido,cantidad_titulos,edad,imagen,nombre,pais)values("Bosques",13,65,"bosques.png","Enrique","España");
insert into club (nombre,apodo,imagen,anio_fundacion,presidente,tecnico_id) values ("RealMadrid","Merengue","madrid.png",1913,"Pipe Calderon",1);


