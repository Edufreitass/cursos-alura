# Importe outros pacotes Java e deixe-os acessíveis ao seu código

Se duas classes estão no mesmo pacote, elas se "enxergam" entre si, sem a necessidade de colocar o nome do pacote. 
Por exemplo, imagine que as classes `Pessoa` e `Endereco` estejam no mesmo pacote:

```java
package modelo;

class Endereco {
    String rua;
    String numero;
    String bairro;
    //...
}
```

E o outro arquivo:

```java
package modelo;

class Pessoa {
    Endereco endereco; // Pessoa usando o endereço
}
```

Para usar uma classe que está em outro pacote, temos duas opções: podemos referenciá-la usando o que chamamos de 
`Fully Qualified Name`, ou seja, o nome do pacote seguido do nome da classe. O código ficaria assim:

```java
package financeiro;

class Pedido {
    modelo.Pessoa cliente; // Usando a classe Pessoa de outro pacote
}
```

Tentamos compilar mas ele não deixa, porque uma classe, por padrão, só pode ser acessada dentro do próprio pacote, 
e a nossa classe `Pessoa` está no pacote `modelo`. Portanto, definiremos nossa classe `Pessoa` como pública. 
Veremos com mais calma os modificadores de acesso na seção que cobra isso na prova. Por enquanto, basta lembrar que 
classes públicas podem ser acessadas por outros pacotes, já classes padrão não podem.

```java
package modelo;

public class Pessoa {
    Endereco endereco; // Pessoa usando o endereço
}
```
Outra opção é importar a classe `Produto` e referenciá-la apenas pelo nome simples dentro de nosso código. 
Para fazer o _import_ usamos a palavra `import`, seguida do `Fully Qualified Name` da classe. 
A instrução de `import` deve aparecer na classe logo após o `package` (se este existir), e antes da definição da classe. 
É possível importar mais de uma classe por vez:

```java
package modelo;

// Importando a classe Produto do pacote estoque import estoque.Produto;
// Outro import qualquer import java.util.Date;

class Pedido {
    Pessoa cliente; // mesmo pacote
    Produto item; // importado
    Date dataEmissao; //importado
}
```

Também é possível importar todas as classes de um determinado pacote, basta usar um `*` após o nome do pacote:

```java
// Importando todas as classes do pacote estoque
import estoque.*;
```

## Importando classes com mesmo nome

Quando precisamos usar duas classes com o mesmo nome mas de pacotes diferentes, só podemos importar uma delas. 
A outra deve ser referenciada pelo Fully Qualified Name. Tentativas de importar as duas classes irão resultar 
em erros de compilação:

```java
import java.util.Date;
import java.sql.Date; // Erro de compilação pois temos duas classes Date

class Teste {
    Date d1;
    Date d2;
}
```

O correto seria:

```java

import java.util.Date;

class Teste {
    Date d1;            // java.util
    java.sql.Date d2; // java.sql
}
```

Caso tenhamos um import específico e um import genérico, o Java usa o específico:

```java
import java.util.*;
import java.sql.Date;

class Teste{
    Date d1; // java.sql
    Date d2; // java.sql
}
```

Por padrão, todas as classes do pacote `java.lang` são importadas. Um ponto importante é que nenhuma classe de pacote 
que não seja o padrão pode importar uma classe do pacote padrão:

```java
class Gerente {
}
```

```java
package modelo;
classe Banco {
    Gerente gerente; // não compila pois não é possível importar tipos do pacote padrão de jeito *nenhum*
}
```

## Pacotes

Nesta seção, entenderemos mais a fundo como funciona a declaração de pacotes, 
e como isso influencia nos imports das classes.

Como já discutimos anteriormente, pacotes servem para organizar suas classes e interfaces. 
Eles permitem agrupar componentes que tenham alguma relação entre si, além de garantir algum nível de controle de 
acesso a membros. Além de serem uma divisão lógica para as suas classes, os pacotes também definem uma separação 
física entre os arquivos de seu projeto, já que espelham a estrutura de diretórios dos arquivos do projeto.

## Subpacotes e estrutura de diretórios

Pacotes são usados pela JVM como uma maneira de encontrar as classes no sistema de arquivos, logo a estrutura de 
diretórios do projeto deve ser a mesma da estrutura de pacotes. Vamos usar como exemplo a classe `Pessoa`:

```java
package projeto.modelo;

public class Pessoa {}
```

O arquivo `Pessoa.java` deve estar localizado dentro do diretório `modelo`, que deve estar dentro do diretório `projeto`, 
conforme a figura a seguir:

```shell
$ tree projeto/modelo/

projeto/modelo/
└── Pessoa.java
```

Dizemos que `modelo` é um subpacote de `projeto`, já que está dentro dele. Podemos ter vários subpacotes, 
como `projeto.utils` e `projeto.conversores`, por exemplo. Usamos o caractere . como separador de pacotes e subpacotes.

## Convenções de nomes para pacotes

Existem algumas convenções para nomes de pacotes. Elas não são obrigatórias, mas geralmente são seguidas para 
facilitar o entendimento e organização do código:

- O nome do pacote deve ser todo em letras minúsculas;
- Um pacote deve começar com o site da empresa, ao contrário;
- Após o site, deve vir o projeto;
- Após o projeto, a estrutura é livre.

## Import usando classes de outros pacotes

Existem diversas maneiras de referenciar uma classe de pacote diferente em nosso código. Vamos analisar essas opções:

## Fully Qualified Name

Podemos referenciar uma classe em nosso código usando o que chamamos de **Fully Qualified Name**, ou **FQN**. 
Ele é composto pelo pacote completo mais o nome da classe, por exemplo:

```java
class Pessoa {
    // FQN da classe Calendar
    java.util.Calendar dataDeNascimento;
}
```

## import

Usar o `FQN` nem sempre deixa o código legível, portanto, em vez de usar o nome completo da classe, 
podemos importá-la e usar apenas o nome simples da classe:

```java
import java.util.Calendar;

class Pessoa {
    Calendar dataDeNascimento;
}
```

É permitido também importar todas as classes de um pacote de uma vez, usando o `*` no lugar do nome da classe:

```java
import java.util.*;

class Pessoa {
    // Calendar e List são do pacote java.util
    Calendar dataDeNascimento;
    List<String> apelidos;
}
```

Caso existam duas classes com o mesmo nome, mas de pacotes diferentes, só podemos importar uma delas. 
A outra deve ser referenciada pelo `FQN`:

```java
import java.util.Date;

class Foo {
    //do java.util
    Date some;
    java.sql.Date other;
}
```

## Multiplos imports com *

Caso importemos dois ou mais pacotes que contenham classes com o mesmo nome, será obrigatório especificar, 
usando o `FQN`, qual das classes queremos utilizar. Ao tentar usar apenas o nome simples da classe, 
teremos um erro de compilação:

```java
import java.util.*;
import java.sql.*;

public class Testes {
    private Date d; // Erro de compilação, de qual pacote é para usar?
}
```

## Import de subpacotes

Em Java, não podemos importar todas as classes de subpacotes usando `*`. 
Veja a seguinte situação, considerando que cada classe foi definida em seu próprio arquivo:

```java
package sistema.prova;

public class Pergunta {}
```

```java
package sistema.banco;

public class PerguntaDao {}
```

```java
package sistema;

public class Exame {}
```

```java
package sistema.teste;

import sistema.*; //só importou a classe Exame

public class Teste {}
```

O único modo de importar todas as classes é explicitamente importando cada subpacote:

```java
package sistema.teste;

import sistema.*;
import sistema.prova.*;
import sistema.banco.*;
public class Teste {}
```

## import static

Desde o Java 5, é possível importar apenas métodos e atributos estáticos de uma classe, usando a palavra-chave `static` 
juntamente com o `import`. Podemos importar um a um ou simplesmente importar todos usando `*`:

```java
package model;

public class Utils {

    // Atributo estático público 
    public static int VALOR = 0;
    // Métodos estáticos públicos
    public static void metodo1() {}
    public static void metodo1(int a) {}

}
```

```java
// Importando todos os membros public static de Utils
import static model.Utils.*;

public class Testes {

    public static void main(String[] args) {
        int x = VALOR;
        metodo1();
        metodo1(x);
    }
}
```