package aula7.exercicio16;

/**
 * O código não compila pois não podemos declarar um char negativo.
 */
public class A {

    // Não compila somente na declaração de c2.
    public static void main(String[] args) {
        char c = 65;
        char c2 = -3;
        System.out.println(c + c2);
    }
}
