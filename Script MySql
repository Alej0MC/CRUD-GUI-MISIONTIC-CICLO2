CREATE SCHEMA VideosPRO;
USE VideosPRO;
CREATE TABLE Contenido(
cont_id INT AUTO_INCREMENT,
nombre_cont VARCHAR(50),
PRIMARY KEY (cont_id)
);
insert into Contenido (nombre_cont) values ("Los Vengadores");
insert into Contenido (nombre_cont) values ("Interestelar");
insert into Contenido (nombre_cont) values ("El viaje de Chihiro");
insert into Contenido (nombre_cont) values ("Parasitos");
insert into Contenido (nombre_cont) values ("Mas alla de los sueños");
insert into Contenido (nombre_cont) values ("The walking dead");
insert into Contenido (nombre_cont) values ("Viaje a las estrellas: la serie original");
insert into Contenido (nombre_cont) values ("Glow");
insert into Contenido (nombre_cont) values ("La casa de papel");
insert into Contenido (nombre_cont) values ("Friends");
insert into Contenido (nombre_cont) values ("Arrow");
insert into Contenido (nombre_cont) values ("The big bang theory");
insert into Contenido (nombre_cont) values ("Vikingos");

CREATE TABLE Director(
dir_id INT,
dir_nombre VARCHAR(20),
dir_apellido VARCHAR(20),
dir_nacionalidad VARCHAR(50),
PRIMARY KEY (dir_id)
);
insert into Director values (101, "Hayo","Miyazaki", "japones");
insert into Director values (102, "Joss", "Whedon", "estadounidense");
insert into Director values (103, "Christopher", "Nolan", "estadounidense");
insert into Director values (104, "Bong", "Joon-ho", "coreano");
insert into Director values (105, "Vincent", "Ward", "neozelandes");

CREATE TABLE Pelicula(
pelicula_id INT,
resumen_peli VARCHAR(300),
año_peli INT,
dir_peli_id INT,
PRIMARY KEY (pelicula_id),
FOREIGN KEY (pelicula_id) REFERENCES Contenido(cont_id),
FOREIGN KEY (dir_peli_id) REFERENCES Director(dir_id)
);
insert into Pelicula values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Los Vengadores"), "Resumen:Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.", 1990, 102);
insert into Pelicula values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Interestelar"), "Resumen: Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.", 2014, 103);
insert into Pelicula values ((SELECT cont_id FROM Contenido WHERE nombre_cont="El viaje de Chihiro"), "Resumen: Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.", 2001, 101);
insert into Pelicula values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Parasitos"), "Resumen: Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano.", 2019, 104);
insert into Pelicula values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Mas alla de los sueños"), "Resumen: Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.", 1998, 105);

CREATE TABLE Serie(
serie_id INT,
episodios INT,
temporadas INT,
PRIMARY KEY (serie_id),
FOREIGN KEY (serie_id) REFERENCES Contenido(cont_id)
);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="The walking dead"), 153, 11);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Viaje a las estrellas: la serie original"), 80, 3);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Glow"), 30, 3);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="La casa de papel"), 31, 4);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Friends"), 236, 10);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Arrow"), 170, 8);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="The big bang theory"), 279, 12);
insert into Serie values ((SELECT cont_id FROM Contenido WHERE nombre_cont="Vikingos"), 79, 6);

CREATE TABLE Usuario(
alias VARCHAR(50),
nombre_user VARCHAR(50),
apellido_user VARCHAR(50),
mail_user VARCHAR(50),
celular_user VARCHAR(50),
contraseña VARCHAR(50),
fecha_nacimiento DATETIME,
PRIMARY KEY (alias)
);
insert into Usuario (alias, nombre_user, apellido_user) values ("lucky", "Pedro","Perez");
insert into Usuario (alias, nombre_user, apellido_user) values ("malopez", "Maria","Lopez");
insert into Usuario (alias, nombre_user, apellido_user) values ("diva", "Ana","Diaz");
insert into Usuario (alias, nombre_user, apellido_user) values ("dreamer", "Luis","Rojas");
insert into Usuario (alias, nombre_user, apellido_user) values ("ninja", "Andres","Cruz");
insert into Usuario (alias, nombre_user, apellido_user) values ("neon", "Nelson","Ruiz");
insert into Usuario (alias, nombre_user, apellido_user) values ("rose", "Claudia","Mendez");
insert into Usuario (alias, nombre_user, apellido_user) values ("green", "Jorge","Rodriguez");

CREATE TABLE Transmision(
trans_id INT AUTO_INCREMENT,
trans_fecha DATETIME,
trans_cont_id INT,
trans_alias VARCHAR(50),
PRIMARY KEY (trans_id),
FOREIGN KEY (trans_cont_id) REFERENCES Contenido(cont_id),
FOREIGN KEY (trans_alias) REFERENCES Usuario(alias)
);
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2017-10-25 20:00:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="Los Vengadores"),"lucky");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2019-03-15 18:30:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="Parasitos"),"lucky");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2019-05-20 20:30:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="La casa de papel"),"lucky");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2018-05-20 20:30:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="Los Vengadores"),"malopez");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-01-20 20:30:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="La casa de papel"),"malopez");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2019-05-20 20:30:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="Interestelar"),"diva");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2018-06-22 21:30:00",(SELECT cont_id FROM Contenido WHERE nombre_cont="El viaje de Chihiro"),"diva");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-03-17 15:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="The walking dead"),"diva");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-03-17 15:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="The walking dead"),"dreamer");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-04-10 18:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Viaje a las estrellas: la serie original"),"dreamer");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-02-17 20:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Glow"),"ninja");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-02-20 16:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="La casa de papel"),"ninja");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-03-27 18:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Arrow"),"ninja");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-03-20 21:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Friends"),"rose");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-01-10 17:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Interestelar"),"green");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-02-15 20:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Parasitos"),"green");
insert into Transmision (trans_fecha, trans_cont_id, trans_alias) values ("2020-03-17 18:30:20",(SELECT cont_id FROM Contenido WHERE nombre_cont="Mas alla de los sueños"),"green");
