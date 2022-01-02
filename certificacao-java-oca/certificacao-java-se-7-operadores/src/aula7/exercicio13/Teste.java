package aula7.exercicio13;

/**
 * Dessa vez, o valor de i será usado no if e só depois incrementado. Como o resto de ::0:: dividido
 * por qualquer número também é ::0::, o for só executa uma vez. Mas o valor de i ainda será incrementado,
 * imprimindo o valor de ::1::.
 */
public class Teste {

    // imprime 1
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 5; i++) {
            if (i++ % 3 == 0) {
                break;
            }
        }
        System.out.println(i);
    }
}
