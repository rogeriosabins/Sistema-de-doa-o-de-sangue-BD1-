CREATE DATABASE BD;
use BD;
DROP TABLE IF EXISTS FAZ;
DROP TABLE IF EXISTS DOADOR;
DROP TABLE IF EXISTS DOACAO;
DROP TABLE IF EXISTS COLETOR;


 create table COLETOR(
 id_coletor  integer primary key,
 nome_coletor varchar(100));
 
 create table DOACAO(
 
  id_doacao integer auto_increment primary key ,
  data_doacao varchar(100) ,
  hora_doacao varchar(100),
  id_coletor integer,
  foreign key (id_coletor) references COLETOR (id_coletor));
  
  create table DOADOR(
  rg integer primary key,
  nome_doador varchar (100),
  tipo_sanguineo varchar(100),
  idade_doador varchar(100),
  telefone_doador varchar(100),
  endereco_doador varchar (100),
  email_doador varchar(100))
;
  
  create table FAZ(
  id_doacao integer,
  rg integer,
  primary key (id_doacao, rg),
  FOREIGN KEY (id_doacao) references DOACAO(id_doacao),
  FOREIGN KEY (rg) references DOADOR(rg));