package aula8.exercicio1;

/**
 * Não compila pois o resultado do parenteses é uma String que não possui o operador de divisão.
 */
public class A {

    // Não compila
    public static void main(String[] args) {
        String resultado = ("divisao dá: " + 15) / 0.0;
        System.out.println(resultado);
    }
}
