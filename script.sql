CREATE DATABASE `adotego`

CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone_fixo` varchar(45) NOT NULL,
  `telefone_celular` varchar(45) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL,
  `uf` varchar(45) NOT NULL,
  `cep` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Raca` (
  `idRaca` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `Especie_idEspecie` int(11) NOT NULL,
  PRIMARY KEY (`idRaca`,`Especie_idEspecie`),
  KEY `fk_Raca_Especie1_idx` (`Especie_idEspecie`),
  CONSTRAINT `fk_Raca_Especie1` FOREIGN KEY (`Especie_idEspecie`) REFERENCES `Especie` (`idEspecie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Situacao` (
  `idSituacao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(155) NOT NULL,
  PRIMARY KEY (`idSituacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Especie` (
  `idEspecie` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idEspecie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `Animal` (
  `idAnimal` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `data_entrada` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `porte` varchar(45) NOT NULL,
  `Situacao_idSituacao` int(11) NOT NULL,
  `Raca_idRaca` int(11) NOT NULL,
  `Especie_idEspecie` int(11) NOT NULL,
  PRIMARY KEY (`idAnimal`),
  KEY `fk_Animal_Situacao_idx` (`Situacao_idSituacao`),
  KEY `fk_Animal_Raca1_idx` (`Raca_idRaca`),
  KEY `fk_Animal_Especie1_idx` (`Especie_idEspecie`),
  CONSTRAINT `fk_Animal_Especie1` FOREIGN KEY (`Especie_idEspecie`) REFERENCES `Especie` (`idEspecie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Animal_Raca1` FOREIGN KEY (`Raca_idRaca`) REFERENCES `Raca` (`idRaca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Animal_Situacao` FOREIGN KEY (`Situacao_idSituacao`) REFERENCES `Situacao` (`idSituacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Adocao` (
  `idAdocao` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `valor` double DEFAULT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Animal_idAnimal` int(11) NOT NULL,
  PRIMARY KEY (`idAdocao`,`Usuario_idUsuario`),
  KEY `fk_Adocao_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Adocao_Animal1_idx` (`Animal_idAnimal`),
  CONSTRAINT `fk_Adocao_Animal1` FOREIGN KEY (`Animal_idAnimal`) REFERENCES `Animal` (`idAnimal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Adocao_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
