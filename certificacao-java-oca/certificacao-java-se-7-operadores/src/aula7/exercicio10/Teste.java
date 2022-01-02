package aula7.exercicio10;

/**
 * Não compila! Toda conta devolve no mínimo um int. O resultado de b1 + b2 é int.
 * Podemos fazer casting ou declarar b3 como int.
 */
public class Teste {

    public static void main(String[] args) {
        byte b1 = 5;
        byte b2 = 3;
        byte b3 = b1 + b2;
    }
}
