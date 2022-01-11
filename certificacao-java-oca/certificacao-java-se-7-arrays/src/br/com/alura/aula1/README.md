# Declare, instancie, inicialize e use um array uni-dimensional

As linguagens de programação, normalmente, fornecem algum recurso para o armazenamento de variáveis em memória 
sequencial. No Java, os _arrays_ permitem esse tipo de armazenamento.

Um _array_ é um objeto que armazena sequencialmente “uma porção” de variáveis de um determinado tipo. 
É importante reforçar que os _arrays_ são objetos. Uma referência para um objeto _array_ deve ser armazenada numa 
variável do tipo _array_.

A prova de certificação verifica se o candidato está apto a manipular tanto _arrays_ de tipos primitivos quanto de 
tipos não primitivos.

Os quatro pontos importantes sobre _arrays_ são:

- Declarar
- Inicializar
- Acessar
- Percorrer

## Arrays de tipos primitivos

**Declaração:**

Para declarar um _array_, é utilizado `[]` logo após ao tipo das variáveis que desejamos armazenar ou logo após ao nome 
da variável.

```java
// Declaração de um array para guardar variáveis do tipo int.
int[] idades;

// Declaração de um array para guardar variáveis do tipo double.
double pesos[];

// Declaração de um array para guardar variáveis do tipo long.
long []pesos;

// Declaração de um array para guardar variáveis do tipo long.
long[]tamanhos;

// Perceba as formas de declarar um array.
```

**Inicialização:**

Como um array é um objeto, a inicialização envolve a criação de um objeto. O new, operador que cria objetos, 
é utilizado para construir um array. Se você não executa o new, qual o valor padrão? Para atributos, é null, 
e para variáveis locais, não há valor, como qualquer outra variável de referência:

```java
public class Clientes {

    int[] idades;

    public static void main(String[] args) {
        Clientes c = new Clientes();
        System.out.println(c.idades); // Imprime null
    }
}

public class Produtos {

    public static void main(String[] args) {
        int[] precos;
        System.out.println(precos); // Não compila, não foi inicializada
    }
}
```

E como instancio um _array_?

```java
// Inicialização do array “idades”.
idades = new int[10];

// Inicialização do array “pesos”.
pesos = new double[50];
```

Na inicialização, é definida a capacidade do _array_, ou seja, a quantidade de variáveis que ele terá. 
Quando falarmos em tamanho de um _array_, estaremos nos referindo à sua capacidade.

Cada variável guardada em um `array` é iniciada implicitamente no momento em que o `array` é criado. 
Os valores atribuídos às variáveis são os valores `default`.

```java
// Imprime 0, pois esse é o valor default para int.
System.out.println(idades[0]);
```

E temos alguns casos extremos:

```java
// Compila e roda
int[] numeros = new int[0];

// Compila, mas joga NegativeArraySizeException
numeros = new int[-1];
```

Durante a declaração de uma referência para um array, temos a oportunidade de criá-lo de uma maneira mais fácil 
se já sabemos o que queremos colocar dentro:

```java
int[] numeros;
numeros = new int[]{1, 2, 5, 7, 5};

Carro[] carros = new Carro[]{new Carro(), null, new Carro()};
```

Não passamos o tamanho e fazemos a declaração dos elementos entre chaves e separados por vírgula. 
Os _arrays_ terão tamanho 5 e 3, respectivamente.

E se a declaração e a inicialização estiverem na **mesma linha** podemos simplificar ainda mais:

```java
int[] numeros = {1, 2, 5, 7, 5};
```

Mas temos que tomar um pouco de cuidado com esse modo mais simples de declarar o _array_. 
Só podemos fazer como no exemplo anterior quando **declaramos e inicializamos** o _array_ na mesma linha. 
Se fizermos a declaração e a inicialização em linhas separadas, o código não compila:

```java
int[] numeros = {1, 2, 5, 7, 5}; // Compila
int[] numeros2;
numeros2 = {1, 2, 5, 7, 5} // Não compila
```

Se desejamos inicializar posteriormente, devemos adicionar o operador `new` para poder iniciar o _array_ em outra linha:

```java
int[] numeros2;
numeros2 = new int[]{1, 2, 5, 7,5}; // Compila
```

## Acesso

As posições de um _array_ são indexadas (numeradas) de `0` até a capacidade do _array_ menos um. 
Para acessar uma das variáveis do _array_, é necessário informar a sua posição.

```java
// Coloca o valor 10 na primeira variável do array idades.
int idades[] = new int[10];
idades[0] = 10;

// Coloca o valor 73.14 na última variável do array pesos.
double pesos[] = new double[50];
pesos[49] = 73.14;
```

O que acontece se alguém tentar acessar uma posição que não existe?

```java
// Erro de execução ao tentar acessar um posição que não existe.
// ArrayIndexOutOfBoundsException
pesos[50] = 88.4;
```

Será gerado um erro de execução (não de compilação). A `exception` lançada pelo Java é `ArrayIndexOutOfBoundsException`.

## Percorrendo

Supondo que a capacidade de um _array_ qualquer seja `100`, os índices desse array variam de `0` até `99`, ou seja, 
de `0` até a capacidade menos um.

O tamanho de um _array_ é definido na inicialização e fica guardado no próprio _array_, 
podendo ser recuperado posteriormente.

Para recuperar o tamanho ou a capacidade de um array, é utilizado um atributo chamado `length` presente em todos 
os _arrays_.

```java
for (int i = 0; i < idades.length; i++) {
    idades[i] = i;
}
```

No `for` tradicional, as posições de um _array_ são acessadas através dos índices. 
Dessa forma, é possível, inclusive, modificar os valores que estão armazenados no _array_.

Porém, em determinadas situações, é necessário apenas ler os valores de um _array_ sem precisar modificá-los. 
Nesse caso, pode ser utilizado o `for` introduzido na versão 5 do Java.

```java
for(int idade : idades) {
    System.out.println(idade);
}
```

Não há índices no `for` do Java 5. Ele simplesmente percorre os valores. 
Assim ele não permite modificar o _array_ facilmente.