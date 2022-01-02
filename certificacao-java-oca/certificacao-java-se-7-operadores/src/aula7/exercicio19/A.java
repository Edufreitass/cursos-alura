package aula7.exercicio19;

/**
 * O código compila e imprime: Divisão dá: Infinity.
 * A precedência de operadores é primeiro a divisão, por isso compila.
 */
public class A {

    // Compila e imprime Divisão dá: Infinity.
    public static void main(String[] args) {
        String resultado = "Divisao dá: " + 15 / 0.0;
        System.out.println(resultado);
    }
}
