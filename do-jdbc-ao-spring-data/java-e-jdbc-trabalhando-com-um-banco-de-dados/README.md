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

### Executando comandos SQL no Java

- Para simplificar e encapsular a criação da conexão, devemos usar uma classe ConnectionFactory
  - A classe ConnectionFactory segue o padrão de criação Factory Method
  - O Factory Method encapsula a criação de um objeto
- Para executar um comando SQL, podemos usar a interface java.sql.Statement
  - O método execute envia o comando para o banco de dados
  - Dependendo do comando SQL, podemos recuperar a chave primária ou os registros selecionados

### Evitando SQL Injection

- Ao executar SQL como Statement, temos um risco de segurança, chamado de SQL Injection
  - SQL Injection nada mais é do que passar um novo comando SQL como parâmetro
- Para evitar SQL Injection, devemos usar a interface PreparedStatement
  - Diferentemente do Statement, o PreparedStatement trata (sanitiza) cada parâmetro do comando SQL

### Controle de transação

- O banco de dados oferece um recurso chamado de transação, para juntar várias alterações como unidade de trabalho
  - Se uma alteração falha, nenhuma alteração é aplicada (é feito um rollback da transação)
  - Todas as alterações precisam funcionar para serem aceitas (é feito um commit)
commit e rollback são operações clássicas de transações
- Para garantir o fechamento dos recursos, existe no Java uma cláusula try-with-resources
  - O recurso em questão deve usar a interface Autoclosable

### Escalabilidade com pool de conexões

- É boa prática usar um pool de conexões
- Um pool de conexões administra/controla a quantidade de conexões abertas
  - Normalmente tem um mínimo e máximo de conexões
- Como existe uma interface que representa a conexão (java.sql.Connection), também existe uma interface que representa o pool de conexões (javax.sql.DataSource)
- C3PO é uma implementação Java de um pool de conexão