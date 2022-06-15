/********* Creation BD *********/
CREATE SCHEMA IF NOT EXISTS `bd_university`;
USE `bd_university`;

/********* Creation Tables *********/
CREATE TABLE `user`(
	`id` int primary key auto_increment,
    `dni` varchar(15) not null,
	`password` varchar(150) not null
);
CREATE TABLE `rol`(
	`id` int primary key auto_increment,
    `name` varchar(20) not null,
    `id_user` int not null,
    constraint `id_rol_user` foreign key (`id_user`) references `bd_university`.`user`(`id`)
);

/********* Insert data *********/
-- Login -> dni: 4444  -  pass: 9999
INSERT INTO `user`(`dni`, `password`) VALUES ('4444','$2a$10$K.03w32BNeuRngLeeIUUaOqldmUVK3/f3pfRQmzNjOXFugrHz7h6O');
-- Login -> dni: 5555  -  pass: 9999
INSERT INTO `user`(`dni`, `password`) VALUES ('5555','$2a$10$kJYd3edqNe.5fyCzPJFjYOzqZdXyL.FQu.hIh6pMN5QSvbspiSzbC');

INSERT INTO `rol`(`name`, `id_user`) VALUES ('ROLE_ADMIN','1');
INSERT INTO `rol`(`name`, `id_user`) VALUES ('ROLE_USER','1');
INSERT INTO `rol`(`name`, `id_user`) VALUES ('USER_USER','2');