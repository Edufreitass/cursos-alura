package aula2;

/**
 * Não compila: erro na linha B e D.
 *
 * Uma vez que o arquivo chama A.java, o único tipo público que pode existir dentro dele deve se chamar A, o que
 * não é verdade: tentamos definir um tipo B público. Além disso, após o extends não podemos colocar uma ,.
 */
class A implements B { //A
}
public interface B { //B
}
class C extends A { //C
}
class D extends A, implements B { //D
}
