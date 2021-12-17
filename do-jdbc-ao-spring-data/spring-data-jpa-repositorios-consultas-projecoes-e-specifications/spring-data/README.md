# ANOTAÇÕES DE RELACIONAMENTO

**FetchMode**

- **SELECT** = Os relacionamentos serão retornados por meio de SELECTs isolados, ao invés de JOINs;
- **JOIN** = Exatamente ao contrário do exemplo anterior;
- **SUBSELECT** = Os relacionamentos serão retornados por meio de SUBSELECTs;

**FetchType**

- **EAGER** = (Ganancioso) Busca os relacionamentos sempre, acessando ou não o(s) objeto(s) desse relacionamento;
- **LAZY** = (Preguiçoso) Busca os relacionamentos se, e somente se, o acesso a esse(s) objeto(s) do relacionamento for(em) acessado(s). Lança um LazyInitializationException, caso se tente acessar o relacionamento após o EntityManager já ter sido fechado;

**FetchMode vs FetchType**

- **Não especificar** FetchMode **explicitamente** faz com que o que for definido em FetchType seja obedecido;
- Especificar **explicitamente** o FetchMode como **JOIN** faz com que definições explicitas de FetchType sejam ignoradas e assume FetchType como **EAGER**;
- Especificar **explicitamente** o FetchMode como **SELECT** ou **SUBSELECT** faz com que FetchType seja obedecido;

**JoinTable**

Como se trata de um relacionamento muito-para-muitos, há a necessidade de haver uma tabela extra, só para mapear o cruzamento de relacionamento entre as linhas das tabelas envolvidas.

- **name**: o nome dessa tabela extra;
- **joinColumns**: As chaves primárias das tabelas envolvidas no relacionamento serão usadas como chaves primárias e estrangeiras na tabela extra;
- **JoinColumn**: A chave estrangeira que se refere ao dono do relacionamento (A entidade onde a declaração está sendo feita);
- **inverseJoinColumn**: O mesmo que o exemplo anterior, só que sobre a outra entidade envolvida;

Um exemplo básico de tabela de relacionamento muito-para-muitos:

| id_funcionario | id_unidade |
|----------------|------------|
| 1              | 1          |
| 1              | 2          |
| 2              | 2          |
| 3              | 1          |

No exemplo acima, nota-se que:

- O funcionário 1 está alocado em ambas unidades 1 e 2;
- O funcionário 2 está alocado apenas na unidade 2;
- O funcionário 3 também está alocado na unidade 1;

Perceba que em um relacionamento muito-para-muitos, não há uma outra forma muito elegante de se resolver esse desafio sem essa tabela extra: Senão, ou a tabela unidade precisaria ter tantas colunas quantos funcionários na empresa (id_funcionario1, id_funcionario2, etc) - Inviável e inelegante - ou o mesmo com a tabela de funcionários, que deveria ter o mesmo número de colunas quanto ao número de unidade (id_unidade1, id_unidade2, etc)

Todos os direitos ao [Ítalo Macellone](https://www.linkedin.com/in/macellone/), autor da explicação.