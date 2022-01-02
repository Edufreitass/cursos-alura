package aula7.exercicio18;

/**
 * O código compila e joga uma exception por causa da divisão inteira (são ints) por zero.
 */
public class A {

    // Compila e dá exception.
    public static void main(String[] args) {
        double resultado = 15 / 0;
        System.out.println(resultado);
    }
}
