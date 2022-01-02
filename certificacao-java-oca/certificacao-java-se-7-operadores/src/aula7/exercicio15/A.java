package aula7.exercicio15;

/**
 * A segunda linha do método main não compila pois estoura o limite de byte.
 */
public class A {

    // Não compila.
    public static void main(String[] args) {
        byte b1 = 100;
        byte b2 = 131;
        System.out.println(b1);
    }
}
