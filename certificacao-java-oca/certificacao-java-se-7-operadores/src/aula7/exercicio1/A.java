package aula7.exercicio1;

/**
 * As opções (a) e (c) não compilam e precisam do casting mesmo com short e char tendo 2 bytes.
 * Na opção (a), pode ocorrer de o short ser negativo e, portanto, não caber no intervalo dos chars.
 * Na opção (c), o char pode ser muito grande e sair fora do alcance dos positivos do short.
 * A opção (b) compila, pois o char que possui 2 bytes pode ser atribuído para um long que possui 8 bytes.
 */
public class A {

    // Qual código a seguir compila?
    public static void main(String[] args) {
        char c = 10;
        long l = c;
    }
}
