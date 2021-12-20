# Defina a estrutura de uma classe Java

Nesta seção, iremos entender a estrutura de um arquivo java, onde inserir as declarações de pacotes e imports e como 
declarar classes e interfaces.

Para entender a estrutura de uma classe, vamos ver o arquivo `Pessoa.java`:

```java

// Declaração de pacote
package br.com.caelum.certificacao;

// imports
import java.util.Date;

// Declaração da classe
class Pessoa {
    // conteúdo da classe
}
```

## Pacotes

Pacotes servem para separar e organizar as diversas classes que temos em nossos sistemas. Todas as classes pertencem a 
um pacote, sendo que, caso o pacote não seja explicitamente declarado, a classe fará parte do que chamamos de pacote 
padrão, ou default package. Todas as classes no _default package_ se enxergam e podem ser utilizadas entre si. Classes 
no pacote default não podem ser importadas para uso em outros pacotes:

```java

// Uma classe no pacote padrão
class Pessoa {
    //...
}
```

Para definir qual o pacote a que a classe pertence, usamos a palavra-chave `package`, seguida do nome do pacote. Só pode 
existir um único `package` definido por arquivo, e ele deve ser a primeira instrução do arquivo. Após a definição do 
`package`, devemos finalizar a instrução com um `;`. Podem existir comentários antes da definição de um pacote:

```java

// declaração do pacote
package br.com.caelum.certificacao;

class Pessoa {
    //...
}
```

Aproveitando que tocamos no assunto, o `package` deve ser a primeira instrução de código que temos declarada em nosso 
arquivo. Comentários não são considerados parte do código, portanto, podem existir em qualquer lugar do arquivo java 
sem restrições.

Para inserir comentário em nosso código, temos as seguintes formas:

```java

// comentário de linha

/*
   comentário de
   multiplas linhas
 */
class /* comentário no meio da linha */ Pessoa {

    /**
     *  JavaDoc, repare que a primeira linha do comentário tem
     *  2 asteriscos
     */
    public void metodo() {
    }
}
```

## Para saber mais: JavaDoc

## Classe

Uma classe é a forma no Java onde definimos os atributos e comportamentos de um objeto. A declaração de uma classe pode 
ser bem simples, apenas a palavra `class` seguida do nome e de `{}`:

```java

class Pessoa {}
```

Existem outros modificadores que podem ser usados na definição de uma classe, mas veremos essas outras opções mais à 
frente, onde discutiremos esses modificadores com mais detalhes.

Vale lembrar que java é _case sensitive_ e `Class` é o nome de uma classe e não podemos usá-lo para definir uma nova classe.

Dentro de uma classe, podemos ter variáveis, métodos e construtores. Essas estruturas são chamadas de membros da classe.:

```java


class Pessoa {

    String nome;
    String sobrenome;

    Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return this.nome + this.sobrenome;
    }
}
```

## Nomes dos membros

## Variáveis

Usando como exemplo a classe `Pessoa` definida anteriormente, `nome` e `sobrenome` são variáveis. A declaração de variáveis é 
bem simples, sempre o tipo seguido do nome da variável.

Dizemos que essas são variáveis de instância, pois existe uma cópia delas para cada objeto `Pessoa` criado em nosso 
programa. Cada cópia guarda o estado de uma certa instância desses objetos.

Existem ainda variáveis que não guardam valores ou referências para uma determinada instância, mas sim um valor 
compartilhado por todas as instâncias de objetos. Essas são variáveis estáticas, definidas com a palavra-chave `static`. 
Veremos mais sobre esse tipo de membro mais à frente.

## Métodos

A declaração de métodos é um pouquinho diferente pois precisamos do tipo do retorno, seguido do nome do método e seguido
de parênteses, sendo que pode ou não haver parâmetros de entrada desse método. Cada parâmetro é uma declaração de 
variável em si. Essa linha do método, onde está definido o retorno, o nome e os parâmetros é onde temos a assinatura do método. 
Cuidado, pois a assinatura de um método inclui somente o nome do método e os tipos dos parâmetros.

Assim como variáveis, métodos também podem ser `static`, como veremos mais adiante.

## Construtores

Uma classe pode possuir zero ou vários construtores. Nossa classe `Pessoa` possui um construtor que recebe como parâmetros
o nome e o sobrenome da pessoa. A principal diferença entre a declaração de um método e um construtor é que um construtor 
não tem retorno e possui o mesmo nome da classe.

## Métodos com o mesmo nome da classe

Note que um construtor pode ter um `return` vazio:

```java

class X {
    int j = -100;

    X(int i) {
        if (i > 1)
            return;
        j = i;
    }
}
```

Caso o valor seja maior que `1`, o valor de `j` será `-100`, caso contrário, será o mesmo valor de `i`.

## Interfaces

Além de classes, também podemos declarar interfaces em nossos arquivos java. Para definir uma interface usamos a 
palavra reservada `interface`:

```java

interface Autenticavel {

    final int TAMANHO_SENHA = 8;

    void autentica(String login, String senha);
}
```

Em uma interface, devemos apenas definir a assinatura do método, sem a sua implementação. Além da assinatura de métodos, 
também é possível declarar constantes em interfaces. Toda interface por padrão os métodos e variaveis são `public` caso
você deixe isso explicito ou não. A variavel por padrão é `static` e `final`, já o método por padrão é `abstract`.

## Multíplas estruturas em um arquivo

Em java, é possível definir mais de uma classe/interface em um mesmo arquivo java, embora devamos seguir algumas regras:

- Podem ser definidos em qualquer ordem;
- Se existir alguma classe/interface pública, o nome do arquivo deve ser o mesmo dessa classe/interface;
- Só pode existir uma classe/interface pública por arquivo;
- Se não houver nenhuma classe/interface pública, o arquivo pode ter qualquer nome.

Logo, são válidos:

```java

// arquivo1.java
interface Bar {}

class Foo {}
```

```java

// Foo.java
public class Foo {}

interface X {}
```

## Pacotes e imports em arquivos com múltiplas estruturas

As regras de pacotes e imports valem também para arquivos com múltiplas estruturas definidas. Caso exista a definição 
de um pacote, ela vale para todas as classes/interfaces definidas nesse arquivo, e o mesmo vale para _imports_.