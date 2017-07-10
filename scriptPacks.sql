CREATE SCHEMA packs;

use packs;

-- Creacion de las tablas.

CREATE TABLE `bono` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pack` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `llamada` bigint(20) unsigned NOT NULL,
  `datos` bigint(20) unsigned NOT NULL,
  `sms` bigint(20) unsigned NOT NULL,
  `vigencia` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_PACK_LLAMADA_idx` (`llamada`),
  KEY `FK_PACK_SMS_idx` (`sms`),
  KEY `FK_PACK_DATOS_idx` (`datos`),
  CONSTRAINT `FK7xfuewj0uo7m2r1y5r8mm7v8l` FOREIGN KEY (`llamada`) REFERENCES `bono` (`id`),
  CONSTRAINT `FK_PACK_DATOS` FOREIGN KEY (`datos`) REFERENCES `bono` (`id`),
  CONSTRAINT `FK_PACK_LLAMADA` FOREIGN KEY (`llamada`) REFERENCES `bono` (`id`),
  CONSTRAINT `FK_PACK_SMS` FOREIGN KEY (`sms`) REFERENCES `bono` (`id`),
  CONSTRAINT `FKeh1dqyjtoiay2r3dljptfh28b` FOREIGN KEY (`datos`) REFERENCES `bono` (`id`),
  CONSTRAINT `FKmtdqbvoghp3y78873n59u9bmt` FOREIGN KEY (`sms`) REFERENCES `bono` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE `user_pack` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `phone` bigint(10) unsigned NOT NULL,
  `pack` bigint(20) unsigned NOT NULL,
  `estado` varchar(1) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `fecha_vencimiento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgtmupasc5avhmvcwd5555sjpu` (`pack`),
  CONSTRAINT `FK_PACKS` FOREIGN KEY (`pack`) REFERENCES `pack` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Bonos diarios

INSERT INTO `packs`.`bono` (`id`, `codigo`, `cantidad`, `nombre`, `tipo`) VALUES (DEFAULT, '01', '10', 'Datos diario', 'DATOS');
INSERT INTO `packs`.`bono` (`id`, `codigo`, `cantidad`, `nombre`, `tipo`) VALUES (DEFAULT, '01', '20', 'SMS diario', 'SMS');
INSERT INTO `packs`.`bono` (`id`, `codigo`, `cantidad`, `nombre`, `tipo`) VALUES (DEFAULT, '01', '15', 'Llamada diario', 'LLAMADA');

-- Bonos semanales

INSERT INTO `packs`.`bono` (`id`, `codigo`, `cantidad`, `nombre`, `tipo`) VALUES (DEFAULT, '02', '200', 'Datos semanal', 'DATOS');
INSERT INTO `packs`.`bono` (`id`, `codigo`, `cantidad`, `nombre`, `tipo`) VALUES (DEFAULT, '02', '200', 'SMS semanal', 'SMS');
INSERT INTO `packs`.`bono` (`id`, `codigo`, `cantidad`, `nombre`, `tipo`) VALUES (DEFAULT, '02', '105', 'Llamada semanal', 'LLAMADA');

-- Pack diario

INSERT INTO `packs`.`pack` (`id`, `llamada`, `datos`, `sms`, `vigencia`) VALUES (DEFAULT, '3', '1', '2', 'DIARIO');

-- Pack Semanal

INSERT INTO `packs`.`pack` (`id`, `llamada`, `datos`, `sms`, `vigencia`) VALUES (DEFAULT, '6', '4', '5', 'SEMANAL');
