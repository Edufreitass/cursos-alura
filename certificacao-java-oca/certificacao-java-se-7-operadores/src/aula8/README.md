# Use parentêses para sobrescrever a precedência de operadores

Às vezes desejamos alterar a ordem de precedência de uma linha, e nesses instantes usamos os parênteses:

```java
int a = 15 * 4 + 1; // 15 * 4 = 60, depois 60 + 1 = 61
int b = 15 * (4 + 1); // 4 + 1 = 5, depois 15 * 5 = 75
```

Devemos tomar muito cuidado na concatenação de `String` e precedência:

```java
System.out.println(15 + 0 + " é cento e cinquenta"); 
// 15 é cento e cinquenta
System.out.println(15 + (0 + " é cento e cinquenta")); 
// 150 é cento e cinquenta

System.out.println(("guilherme" + " silveira").length()); 
// 18
```