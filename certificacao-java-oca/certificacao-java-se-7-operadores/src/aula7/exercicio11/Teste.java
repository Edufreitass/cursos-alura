package aula7.exercicio11;

/**
 * Não compila, pois toda conta devolve no mínimo um int, e um int não cabe em um byte.
 */
public class Teste {

    // Não compila por um erro na linha 5
    public static void main(String[] args) {
        byte b1 = 127;
        byte b2 = -128;
        byte b3 = b1 + b2;
        System.out.println(b3);
    }
}
