package aula1.exercicio3;

/**
 * Não compila, do lado direito da atribuição temos um array de boolean
 * e do lado esquerdo uma variável simples do tipo boolean.
 */
class A {

    // Não compila.
    public static void main(String[] args) {
        boolean array = new boolean[300];
        System.out.println(array[3]);
    }
}
