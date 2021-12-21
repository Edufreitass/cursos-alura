package aula1.exercicio4;

/**
 * Não compila pois boolean em Java só pode ser false ou true.
 */
class A {

    // Não compila: atribuição inválida.
    public static void main(String[] args) {
        boolean argumentos;
        if(args.length > 0)
            argumentos = 1;
        else
            argumentos = 0;
        System.out.println(argumentos);
    }
}
