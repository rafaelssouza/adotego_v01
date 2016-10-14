-- mysql workbench forward engineering

set @old_unique_checks=@@unique_checks, unique_checks=0;
set @old_foreign_key_checks=@@foreign_key_checks, foreign_key_checks=0;
set @old_sql_mode=@@sql_mode, sql_mode='traditional,allow_invalid_dates';

-- -----------------------------------------------------
-- schema adotego
-- -----------------------------------------------------

-- -----------------------------------------------------
-- schema adotego
-- -----------------------------------------------------
create schema if not exists `adotego` default character set utf8 ;
use `adotego` ;

-- -----------------------------------------------------
-- table `adotego`.`pessoa`
-- -----------------------------------------------------
create table if not exists `adotego`.`pessoa` (
  `idpessoa` int not null auto_increment,
  `nome` varchar(255) not null,
  `telefone_fixo` varchar(45) null,
  `telefone_celular` varchar(45) not null,
  `data_nascimento` date not null,
  `email` varchar(255) not null,
  `cpf_cnpj` varchar(45) not null,
  `rua` varchar(45) not null,
  `cidade` varchar(45) not null,
  `bairro` varchar(45) not null,
  `uf` varchar(45) not null,
  `numero` varchar(45) not null,
  `cep` varchar(45) not null,
  primary key (`idpessoa`),
  unique index `idpessoa_unique` (`idpessoa` asc))
engine = innodb;


-- -----------------------------------------------------
-- table `adotego`.`situacao`
-- -----------------------------------------------------
create table if not exists `adotego`.`situacao` (
  `idsituacao` int not null auto_increment,
  `descricao` varchar(45) null,
  primary key (`idsituacao`))
engine = innodb;


-- -----------------------------------------------------
-- table `adotego`.`especie`
-- -----------------------------------------------------
create table if not exists `adotego`.`especie` (
  `idespecie` int not null auto_increment,
  `nome` varchar(45) null,
  primary key (`idespecie`))
engine = innodb;


-- -----------------------------------------------------
-- table `adotego`.`raca`
-- -----------------------------------------------------
create table if not exists `adotego`.`raca` (
  `idraca` int not null auto_increment,
  `nome` varchar(45) not null,
  `raca_idespecie` int not null,
  primary key (`idraca`),
  index `fk_raca_especie1_idx` (`raca_idespecie` asc),
  constraint `fk_raca_especie1`
    foreign key (`raca_idespecie`)
    references `adotego`.`especie` (`idespecie`)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table `adotego`.`animal`
-- -----------------------------------------------------
create table if not exists `adotego`.`animal` (
  `idanimal` int not null auto_increment,
  `nome` varchar(255) not null,
  `data_registro_entrada` date not null,
  `descricao` mediumtext null,
  `porte` varchar(45) not null,
  `situacao_idsituacao` int not null,
  `animal_idraca` int not null,
  primary key (`idanimal`, `situacao_idsituacao`),
  unique index `idanimal_unique` (`idanimal` asc),
  index `fk_animal_situacao1_idx` (`situacao_idsituacao` asc),
  index `fk_animal_raca1_idx` (`animal_idraca` asc),
  constraint `fk_animal_situacao1`
    foreign key (`situacao_idsituacao`)
    references `adotego`.`situacao` (`idsituacao`)
    on delete no action
    on update no action,
  constraint `fk_animal_raca1`
    foreign key (`animal_idraca`)
    references `adotego`.`raca` (`idraca`)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table `adotego`.`adocao`
-- -----------------------------------------------------
create table if not exists `adotego`.`adocao` (
  `idadocao` int unsigned not null auto_increment,
  `adocao_idpessoa` int not null,
  `data_adocao` date not null,
  `adocao_idanimal` int not null,
  `valor` varchar(45) null,
  primary key (`idadocao`, `adocao_idanimal`),
  index `fk_adocao_pessoa1_idx` (`adocao_idpessoa` asc),
  index `fk_adocao_animal1_idx` (`adocao_idanimal` asc),
  constraint `fk_adocao_pessoa1`
    foreign key (`adocao_idpessoa`)
    references `adotego`.`pessoa` (`idpessoa`)
    on delete no action
    on update no action,
  constraint `fk_adocao_animal1`
    foreign key (`adocao_idanimal`)
    references `adotego`.`animal` (`idanimal`)
    on delete no action
    on update no action)
engine = innodb
default character set = big5;


set sql_mode=@old_sql_mode;
set foreign_key_checks=@old_foreign_key_checks;
set unique_checks=@old_unique_checks;

-- -----------------------------------------------------
-- data for table `adotego`.`especie`
-- -----------------------------------------------------
start transaction;
use `adotego`;
insert into `adotego`.`especie` (`idespecie`, `nome`) values (1, 'cão');
insert into `adotego`.`especie` (`idespecie`, `nome`) values (2, 'gato');

commit;


-- -----------------------------------------------------
-- data for table `adotego`.`raca`
-- -----------------------------------------------------
start transaction;
use `adotego`;
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'australian cattle', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'australian shepherd', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'bearded collie', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'bouvier de flandres', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'briard', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'collie', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'cuvac', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pastor alemão', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pastor de beauce', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pastor belga', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pastor de shetland', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pastor belga laekenois', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pastor de tatra', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'puli', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'pumi', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'bullmastiff', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'dogue alemão', 1);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'abissínio', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'american shorthair', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'angorá', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'azul russo', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'bengal', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'burmese', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'oriental', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'persa', 2);
insert into `adotego`.`raca` (`idraca`, `nome`, `raca_idespecie`) values (default, 'ragdoll', 2);

commit;

