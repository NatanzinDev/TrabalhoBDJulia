create database lojadecosmeticos;

create table marca(
	idmarca int auto_increment not null primary key,
    nome varchar(150),
    seguemento varchar(100)
);


create table cosmetico(
 id int primary key auto_increment not null,
 nome varchar(150),
 tipo varchar(100),
 valor double, 
 idmarca int,
 foreign key (idmarca) references marca(idmarca)
);



create table usuario(
	idusuario int auto_increment not null primary key,
    nome varchar(150) not null,
    email text not null,
    senha text not null
);

