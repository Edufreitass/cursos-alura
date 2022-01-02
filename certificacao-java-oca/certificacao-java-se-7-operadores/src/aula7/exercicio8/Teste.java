package aula7.exercicio8;

/**
 * Não compila pois "1.0" é double e não pode ser colocado em um float
 */
public class Teste {

    // Não compila a linha D pois "1.0" é double e não pode ser colocado em um float
    public static void main(String[] args) {
        byte b = 1; //A
        int i = 1;   //B
        long l = 1;  //C
        float f = 1.0;  //D
    }
}
