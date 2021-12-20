package aula3;

/**
 * Ao rodar sem argumentos, nosso array tem tamanho zero, portanto, ao tentar acessar seu primeiro elemento
 * recebemos um ArrayIndexOutOfBoundsException na linha args[0].
 */
public class Exercicio3 {

    // Ao rodar sem argumentos, ocorre uma ArrayIndexOutOfBoundsException na linha args[0].
    public static void main(String[] args) {
        System.out.println(args);
        System.out.println(args.length);
        System.out.println(args[0]);
    }
}
