# Java e JDBC: Trabalhando com um banco de dados

### Comandos utilizados pela CLI do MYSQL 8.0.18:

```
$ CREATE DATABASE loja_virtual;

$ USE loja_virtual;

$ CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;

$ SELECT * FROM PRODUTO;

$ INSERT INTO PRODUTO (nome, descricao) VALUES ('NOTEBOOK', 'NOTEBOOK SAMSUNG');
```
### Introdução ao JDBC e o padrão Factory

- Para acessar o banco de dados, precisamos de um driver
  - Um driver nada mais é do que uma biblioteca (JAR)
- JDBC significa Java DataBase Conectivity
  - JDBC define uma camada de abstração entre a sua aplicação e o driver do banco de dados
  - Essa camada possui, na sua grande maioria, interfaces que o driver implementa
- Para abrir uma conexão, devemos usar o método getConnection, da classe DriverManager
  - O método getConnection recebe uma string de conexão JDBC, que define a URL, usuário, senha, etc
