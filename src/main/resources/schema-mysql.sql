CREATE TABLE if NOT EXISTS `raf_ciudad` (
	`nmid` int NOT NULL AUTO_INCREMENT,
	`dsnombre` varchar(50) NOT NULL,
	PRIMARY KEY (`nmid`)
);

CREATE TABLE if NOT EXISTS `raf_tipo_identificacion` (
	`nmid` int NOT NULL auto_increment,
	`dsnombre` varchar(50) NOT NULL,
	PRIMARY KEY (`nmid`)
);

CREATE TABLE if NOT EXISTS `raf_tipo_paciente` (
	`nmid` int NOT NULL auto_increment,
    `dsnombre` varchar(50) NOT NULL,
    PRIMARY KEY (`nmid`)
);

CREATE TABLE if NOT EXISTS `raf_dueno` (
	`nmid` int NOT NULL auto_increment,
    `dsnombre` varchar(50) NOT NULL,
    `nmidentificacion` int NOT NULL,
    `dsdireccion` varchar(50) NOT NULL,
    `nmtelefono` int NOT NULL,
    `nmciudadid` int NOT NULL,
    `nmtipidenid` int NOT NULL,
    PRIMARY KEY (`nmid`)
    );

CREATE TABLE if NOT EXISTS `raf_paciente` (
	`nmid` int NOT NULL auto_increment,
    `dsnombre` varchar(50) NOT NULL,
    `dsraza` varchar(50) NOT NULL,
    `dtfechanacimiento` date NOT NULL,
    `dtfecharegistro` date NOT NULL,
    `nmtippaciid` int NOT NULL,
    `nmduenoid` int NOT NULL,
    PRIMARY KEY (`nmid`)
 );

    ALTER TABLE `raf_dueno` ADD CONSTRAINT `FK_nmciudadid` FOREIGN KEY (`nmciudadid`) REFERENCES `raf_ciudad` (`nmid)`,
	ALTER TABLE `raf_dueno` FOREIGN KEY (`nmtipidenid`) REFERENCES `raf_tipo_identificacion` (`nmid`)

    ALTER TABLE `raf_paciente` CONSTRAINT `FK_nmtippaciid` FOREIGN KEY (`nmtippaciid`) REFERENCES `raf_tipo_paciente`(`nmid`),
    ALTER TABLE `raf_paciente` FOREIGN KEY (`nmduenoid`) REFERENCES `raf_dueno`(`nmid`)
