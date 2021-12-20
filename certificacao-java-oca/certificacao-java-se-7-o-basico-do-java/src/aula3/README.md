# Crie aplicações Java executáveis com um método main

Nesta seção, entenderemos as diferenças entre classes normais e classes que podem ser executadas pela linha de comando.

Uma classe executável é uma classe que possui um método inicial para a execução do programa - o método `main`, que será 
chamado pela JVM. Classes sem o método `main` não são classes executáveis e não podem ser usadas como ponto inicial 
da aplicação.

## Método main

O tal método de entrada deve seguir algumas regras para ser executado pela JVM:

- Ser público (`public`);
- Ser estático (`static`);
- Não ter retorno (`void`);
- Ter o nome `main`;
- Receber como parâmetro um `array` ou `varargs` de String (`String[]` ou `String...`).

São então métodos `main` válidos os seguintes exemplos:

```java

//Parâmetro como array
public static void main (String[] args) {}

//Parâmetro como varargs
public static void main (String... args) {}

//A ordem dos modificadores não importa
static public void main(String[] args) {}

//O nome do parâmetro não importa
public static void main (String... argumentos){}

//Também é uma definição válida de array
public static void main (String args[]) {}
```

## Executando uma classe pela linha de comando

Para executar uma classe com main pela linha de comando, devemos compilar o arquivo com o comando javac e executar a 
classe com o comando java:

Usando o arquivo `HelloWorld.java` a seguir:

```java

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World! ");
    }
}
```

Compilamos e executamos no terminal com os seguintes comandos:

```shell

$ javac HelloWorld.java
$
$ java HelloWorld
Hello World!
```

Repare que, para compilar a classe, passamos como parâmetro para o comando `javac` o nome do arquivo, enquanto para 
executar, passamos apenas o nome da classe (`HelloWorld`) para o comando `java`.

## Passando parâmetros pela linha de comando

Ao executarmos uma classe pela linha de comando, podemos passar parâmetros para o método `main`. Esses valores serão 
recebidos no array do método `main`. Por exemplo, vamos passar um nome para a classe `HelloWorld`:

```java

public class HelloWorld{

    public static void main(String[] args) {
        //Lendo o valor da primeira posição do array args
        System.out.println("Hello " + args[0] + "!");
    }
}
```

Para informar o valor do parâmetro, é só informá-lo **APÓS** o nome da classe que está sendo executada:

```shell

java HelloWorld Mario
Hello Mario!
```

Você pode passar quantos parâmetros quiser, basta separá-los por espaço. Cada parâmetro informado será armazenado em uma 
posição do array, na mesma ordem em que foi informado.

## Compilação e execução

Para criar um programa java, é preciso escrever um código-fonte e, através de um compilador, gerar o executável (bytecode).
O compilador do JDK (`Java Development Kit`) é o `javac`. Para a prova de certificação, devemos conhecer o comportamento 
desse compilador.

A execução do bytecode é feita pela **JVM** (`Java Virtual Machine`). O comando java invoca a máquina virtual para 
executar um programa `java`. Ao baixarmos o Java, podemos escolher baixar o JDK, que já vem com o JRE, ou somente o 
**JRE** (`Java Runtime Environment`), que inclui a `Virtual Machine`.

Algumas questões da prova abordam aspectos fundamentais do processo de compilação e de execução. É necessário saber como
os comandos `javac` e o `java` procuram os arquivos.

## javac

Imagine o arquivo `Prova.java` dentro do diretório de meu projeto:

```java

class Prova {
    double tempo;
}
```

```shell

$ javac Prova.java
```

O bytecode da classe `Prova` gerado na compilação é colocado no arquivo `Prova.class` dentro do nosso diretório de trabalho, 
no meu caso, `projeto`. O resultado é:

```shell
[projeto]$ tree
.
├── Prova.class
└── Prova.java
```

Os projetos profissionais utilizam o recurso de pacotes para melhor organizar os fontes e os bytecodes. Vejamos qual é o
comportamento do `javac` com a utilização de pacotes. Colocamos o arquivo `Prova.java` no diretório `certificacao`:

```java

package certificacao;
class Prova {
    double tempo;
}
```

```shell

[certificacao]$ javac certificacao/Prova.java
```

Nesse exemplo, o arquivo `Prova.class` é colocado no diretório `certificacao`.

```shell
[certificacao]$ tree
.
├── Prova.class
└── Prova.java
```

## Escolhendo a versão do Java na hora de compilar

Na hora da compilação, é possível definir em que versão do Java o código-fonte foi escrito. Isso é feito com a 
opção `-source` do comando `javac`. (`javac MinhaClasse.java -source 1.3`).

## java

Vamos utilizar um exemplo para mostrar o funcionamento do comando `java`, criando o arquivo `Teste.java` no mesmo 
diretório, no mesmo pacote:

```java

package certificacao;
class Teste {
    public static void main(String[] args) {
        Prova p = new Prova();
        p.tempo = 210;
        System.out.println(p.tempo);
    }
}
```

```shell

$ javac certificacao/Teste.java
$ java certificacao.Teste
210.0
```

E o resultado são os arquivos:

```shell
[certificacao]$ tree
.
├── Prova.class
├── Prova.java
├── Teste.class
└── Teste.java
```

Somente o arquivo `Teste.java` foi passado para o compilador. Nesse arquivo, a classe `Teste` utiliza a classe `Prova` 
que se encontra em outro arquivo, `Prova.java`. Dessa forma, o compilador vai compilar automaticamente o 
arquivo `Prova.java` se necessário.

Para executar, é preciso passar o nome completo da classe desejada para a máquina virtual. O sufixo `.class` não 
faz parte do nome da classe, então ele não aparece na invocação da máquina virtual pelo comando `java`.

## Propriedades na linha de comando

A prova ainda cobra conhecimentos sobre como executar um programa java passando parâmetros ou propriedades para a JVM e 
essas propriedades são identificadas pelo `-D` antes delas. Este `-D` não faz parte da chave.

```shell

java -Dchave1=abc -Dchave2=def Foo xpto bar
```

`chave1=abc` e `chave2=def` são parâmetros/propriedades e `xpto` e bar são argumentos recebidos pelo método `main`.

## Classpath

Para compilar ou para executar, é necessário que os comandos `javac` e `java` possam encontrar as classes referenciadas 
pela aplicação java.

A prova de certificação exige o conhecimento do algoritmo de busca das classes. As classes feitas pelo programador são 
encontradas através do classpath (caminho das classes).

O classpath é formado por diretórios, jars e zips que contenham as classes e pacotes da nossa aplicação. Por padrão, 
o classpath está configurado para o diretório corrente (`.`).

## Configurando o classpath

Há duas maneiras de configurar o classpath:

1) Configurando a variável de ambiente `CLASSPATH` no sistema operacional.

Basta seguir as opções do SO em questão e definir a variável. Isso é considerado uma má prática no dia a dia porque 
é um classpath global, que vai valer para qualquer programa java executado na máquina.

2) Com as opções `-cp` ou `-classpath` dos comandos `javac` ou `java`.

É a forma mais usada. Imagine que queremos usar alguma biblioteca junto com nosso programa:

```shell

$ javac -cp /diretorio/biblioteca.jar Prova.java
$ java -cp /diretorio/biblioteca.jar Prova
```

E podemos passar tanto caminhos de outras pastas como de `JARs` ou `zips`. Para passar mais de uma coisa no classpath, 
usamos o separador de parâmetros no SO (no Windows é ponto e vírgula, no Linux/Mac/Solaris/Unix são dois pontos):

```shell

$ javac -cp /diretorio/biblioteca.jar;/outrodir/ scjp/Prova.java
$ java -cp /diretorio/biblioteca.jar;/outrodir/ scjp.Prova
```

## Para saber mais: arquivos JAR

Para facilitar a distribuição de bibliotecas de classes ou de aplicativos, o JDK disponibiliza uma ferramenta para a compactação das classes java.

Um arquivo `JAR` nada mais é que a pasta de nossas classes no formato `ZIP` mas com extensão `.jar`.

Para criar um `jar` incluindo a pasta `scjp` que fizemos antes:

```shell

jar -cf bib.jar scjp
```

Agora podemos executar nossa classe usando esse jar:

```shell

java -cp bib.jar scjp.Prova
```

## Para saber mais: META-INF/Manifest.mf

Ao criar o `jar` usando o comando jar do JDK, ele cria automaticamente a pasta `META-IN`F, que é usada para configurações 
relativas ao nosso `jar`. E dentro dela, cria o arquivo `Manifest.mf`.

Esse arquivo pode ser usado para algumas configurações. Por exemplo, é possível dizer qual classe do nosso `jar` é a 
classe principal (Main-Class) e que deve ser executada.

Basta criar um arquivo chamado `Manifest.mf` com a seguinte instrução indicando a classe com o método `main`:

```shell
Main-Class: scjp.Teste
```

E depois gerar o jar passando esse arquivo:

```shell
jar -cmf bib.jar meumanifest scjp
```

Na hora de rodar um jar com `Main-Class`, basta usar:

```shell
java -jar bib.jar
```