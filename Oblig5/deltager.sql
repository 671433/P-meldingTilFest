DROP SCHEMA IF EXISTS deltager CASCADE;
CREATE SCHEMA deltager;
SET search_path TO deltager;

drop table if exists deltager;

CREATE TABLE deltager (
mobil CHARACTER (8) PRIMARY KEY, 
hash CHARACTER (64) NOT NULL, 
salt CHARACTER (32) NOT NULL, 
fornavn CHARACTER VARYING (40), 
etternavn CHARACTER VARYING (40), 
kjonn CHARACTER VARYING (6) );


INSERT INTO
deltager(mobil,hash,salt,fornavn,etternavn,kjonn)
VALUES 
(45000116,'pass1234','pass1234','Tamer','Deen','mann')