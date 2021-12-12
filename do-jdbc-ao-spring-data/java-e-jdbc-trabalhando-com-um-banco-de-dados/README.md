# Java e JDBC: Trabalhando com um banco de dados

### Comandos utilizados pela CLI do MYSQL 8.0.18:

```
$ CREATE DATABASE loja_virtual;

$ USE loja_virtual;

$ CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;

$ SELECT * FROM PRODUTO;

$ INSERT INTO PRODUTO (nome, descricao) VALUES ('NOTEBOOK', 'NOTEBOOK SAMSUNG');

$ CREATE TABLE CATEGORIA (ID INT AUTO_INCREMENT, NOME VARCHAR (50) NOT NULL, PRIMARY KEY (ID)) Engine = InnoDB;

$ INSERT INTO CATEGORIA (NOME) VALUES ('ELETRONICOS'), ('ELETRODOMESTICOS'), ('MOVEIS');

$ ALTER TABLE PRODUTO ADD COLUMN CATEGORIA_ID INT;

$ ALTER TABLE PRODUTO ADD FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA (ID);

$ UPDATE PRODUTO SET CATEGORIA_ID = 1 WHERE ID = 1;
```
### Introdução ao JDBC e o padrão Factory

- Para acessar o banco de dados, precisamos de um driver
  - Um _driver_ nada mais é do que uma biblioteca (JAR)
- JDBC significa _Java DataBase Connectivity_
  - JDBC define uma camada de abstração entre a sua aplicação e o _driver_ do banco de dados
  - Essa camada possui, na sua grande maioria, interfaces que o _driver_ implementa
- Para abrir uma conexão, devemos usar o método `getConnection`, da classe `DriverManager`
  - O método `getConnection` recebe uma string de conexão JDBC, que define a URL, usuário, senha, etc

### Executando comandos SQL no Java

- Para simplificar e encapsular a criação da conexão, devemos usar uma classe `ConnectionFactory
  - A classe `ConnectionFactory` segue o padrão de criação _Factory Method_
  - O _Factory Method_ encapsula a criação de um objeto
- Para executar um comando SQL, podemos usar a interface `java.sql.Statement`
  - O método `execute` envia o comando para o banco de dados
  - Dependendo do comando SQL, podemos recuperar a chave primária ou os registros selecionados

### Evitando SQL Injection

- Ao executar SQL como `Statement`, temos um risco de segurança, chamado de **_SQL Injection_**
  - _SQL Injection_ nada mais é do que passar um novo comando SQL como parâmetro
- Para evitar _SQL Injection_, devemos usar a interface `PreparedStatement`
  - Diferentemente do `Statement`, o `PreparedStatement` trata (_sanitiza_) cada parâmetro do comando SQL

### Controle de transação

- O banco de dados oferece um recurso chamado de transação, para juntar várias alterações como unidade de trabalho
  - Se uma alteração falha, nenhuma alteração é aplicada (é feito um _rollback_ da transação)
  - Todas as alterações precisam funcionar para serem aceitas (é feito um `commit`)
- `commit e rollback` são operações clássicas de transações
- Para garantir o fechamento dos recursos, existe no Java uma cláusula _try-with-resources_
  - O recurso em questão deve usar a interface `Autoclosable`

### Escalabilidade com pool de conexões

- É boa prática usar um **_pool de conexões_**
- Um _pool de conexões_ administra/controla a quantidade de conexões abertas
  - Normalmente tem um mínimo e máximo de conexões
- Como existe uma interface que representa a conexão (`java.sql.Connection`), também existe uma interface que representa o pool de conexões (`javax.sql.DataSource`)
- **C3PO** é uma implementação Java de um _pool de conexão_

### Camada de persistência com DAO

- Para cada tabela de domínio, temos uma classe de domínio
  - Por exemplo, a tabela `produtos` tem uma classe `Produto` associada
  - Objetos dessa classe representa um registro na tabela
- Para acessar a tabela, usaremos um padrão chamado **_Data Access Object (DAO)_**
  - Para cada classe de domínio, existe um DAO. Por exemplo, a classe `Produto` possui um `ProdutoDao`
  - Todos os métodos JDBC relacionados com o produto devem estar encapsulados no `ProdutoDao`

### Evitando queries N + 1

- Que quando temos um relacionamento, é preciso ter cuidado para não cair no problema de _queries_ `N + 1`
  - `N + 1` significa executar uma _query_ e mais uma nova _query_ (`N`) para cada relacionamento
  - Queries `N + 1` podem gerar um problema no desempenho
  - Queries `N + 1` podem ser evitadas através de _joins_ no SQL
- A criar a nossa própria camada de persistência

### Aplicação Desktop

- uma aplicação é escrita em camadas
  - camadas clássicas são _view, controller, modelo e persistência_
- o fluxo entre as camadas segue a ordem:
`view <--> controller <--> persistencia`
- nesse curso focamos na camada de persistência
- uma camada não deve deixar "vazar" detalhes da implementação (por exemplo uma exceção como `SQLException`)
em outras formações você aprenderá como criar a **view** ou **front-end** para Android (_mobile_) ou web (_html_)
