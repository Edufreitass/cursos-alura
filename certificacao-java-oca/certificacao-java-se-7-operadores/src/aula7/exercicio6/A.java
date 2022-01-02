package aula7.exercicio6;

public class A {

    // Imprima a divisão por 0 de números inteiros e de números com ponto flutuante:
    // Quais os resultados?
    public static void main(String[] args) {
        System.out.println(3 / 0); // ArithmeticException: / by zero
        System.out.println(3 / 0.0); // Infinity
        System.out.println(3.0 / 0); // Infinity
        System.out.println(-3.0 / 0); // -Infinity
    }
}
