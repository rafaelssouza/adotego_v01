-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema adotego
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema adotego
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `adotego` DEFAULT CHARACTER SET utf8 ;
USE `adotego` ;

-- -----------------------------------------------------
-- Table `adotego`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adotego`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `telefone_fixo` VARCHAR(45) NULL,
  `telefone_celular` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cpf_cnpj` VARCHAR(45) NOT NULL,
  `id_endereco_pessoa` INT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  UNIQUE INDEX `idPessoa_UNIQUE` (`idPessoa` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adotego`.`Situacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adotego`.`Situacao` (
  `idSituacao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idSituacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adotego`.`Especie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adotego`.`Especie` (
  `idEspecie` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idEspecie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adotego`.`Raca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adotego`.`Raca` (
  `idRaca` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `raca_idEspecie` INT NOT NULL,
  PRIMARY KEY (`idRaca`),
  INDEX `fk_Raca_Especie1_idx` (`raca_idEspecie` ASC),
  CONSTRAINT `fk_Raca_Especie1`
    FOREIGN KEY (`raca_idEspecie`)
    REFERENCES `adotego`.`Especie` (`idEspecie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adotego`.`Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adotego`.`Animal` (
  `idAnimal` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `data_registro_entrada` DATE NOT NULL,
  `descricao` MEDIUMTEXT NULL,
  `porte` VARCHAR(45) NOT NULL,
  `Situacao_idSituacao` INT NOT NULL,
  `idEspecie` INT NOT NULL,
  `idRaca` INT NOT NULL,
  `animal_idRaca` INT NOT NULL,
  PRIMARY KEY (`idAnimal`, `Situacao_idSituacao`),
  UNIQUE INDEX `idAnimal_UNIQUE` (`idAnimal` ASC),
  INDEX `fk_Animal_Situacao1_idx` (`Situacao_idSituacao` ASC),
  INDEX `fk_Animal_Raca1_idx` (`animal_idRaca` ASC),
  CONSTRAINT `fk_Animal_Situacao1`
    FOREIGN KEY (`Situacao_idSituacao`)
    REFERENCES `adotego`.`Situacao` (`idSituacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Animal_Raca1`
    FOREIGN KEY (`animal_idRaca`)
    REFERENCES `adotego`.`Raca` (`idRaca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adotego`.`Adocao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adotego`.`Adocao` (
  `idAdocao` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `adocao_idPessoa` INT NOT NULL,
  `data_adocao` DATE NOT NULL,
  `adocao_idAnimal` INT NOT NULL,
  `valor` VARCHAR(45) NULL,
  PRIMARY KEY (`idAdocao`, `adocao_idAnimal`),
  INDEX `fk_Adocao_Pessoa1_idx` (`adocao_idPessoa` ASC),
  INDEX `fk_Adocao_Animal1_idx` (`adocao_idAnimal` ASC),
  CONSTRAINT `fk_Adocao_Pessoa1`
    FOREIGN KEY (`adocao_idPessoa`)
    REFERENCES `adotego`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Adocao_Animal1`
    FOREIGN KEY (`adocao_idAnimal`)
    REFERENCES `adotego`.`Animal` (`idAnimal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `adotego`.`Especie`
-- -----------------------------------------------------
START TRANSACTION;
USE `adotego`;
INSERT INTO `adotego`.`Especie` (`idEspecie`, `nome`) VALUES (1, 'Cão');
INSERT INTO `adotego`.`Especie` (`idEspecie`, `nome`) VALUES (2, 'Gato');

COMMIT;


-- -----------------------------------------------------
-- Data for table `adotego`.`Raca`
-- -----------------------------------------------------
START TRANSACTION;
USE `adotego`;
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Australian Cattle', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Australian Shepherd', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Bearded Collie', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Bouvier de Flandres', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Briard', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Collie', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Cuvac', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pastor Alemão', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pastor de Beauce', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pastor Belga', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pastor de Shetland', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pastor Belga Laekenois', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pastor de Tatra', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Puli', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Pumi', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Bullmastiff', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Dogue Alemão', 1);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Abissínio', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'American Shorthair', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Angorá', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Azul Russo', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Bengal', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Burmese', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Oriental', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Persa', 2);
INSERT INTO `adotego`.`Raca` (`idRaca`, `nome`, `raca_idEspecie`) VALUES (DEFAULT, 'Ragdoll', 2);

COMMIT;

