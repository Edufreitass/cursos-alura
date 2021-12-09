# Java e JDBC: Trabalhando com um banco de dados

Comandos utilizados pela CLI do MYSQL 8.0.18:

```
$ CREATE DATABASE loja_virtual;

$ USE loja_virtual;

$ CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;

$ SELECT * FROM PRODUTO;

$ INSERT INTO PRODUTO (nome, descricao) VALUES ('NOTEBOOK', 'NOTEBOOK SAMSUNG');
```
