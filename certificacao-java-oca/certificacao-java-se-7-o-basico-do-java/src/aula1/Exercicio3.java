package aula1;

/**
 * Isso porque o acesso à variável estática pode ser feito através da instância da classe ou diretamente caso seja uma
 * variável estática sendo acessada por um método estático.
 */
public class Exercicio3 {

    static int i = 3;

    // Compila e imprime os números de 10 até 99.
    public static void main(String[] a) {
        for (new Exercicio3().i = 10; new Exercicio3().i < 100;
             new Exercicio3().i++) {
            System.out.println(i);
        }
    }
}
