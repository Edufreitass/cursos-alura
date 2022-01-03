package aula12.exercicio1;

/**
 * O código compila normalmente e imprime 0 caso não seja passado nenhum argumento.
 */
class A {

    // Se invocarmos sem argumentos, imprime 0.
    public static void main(String[] args) {
        if(args.length > 0)
            System.out.println("Um ou mais argumentos");
        else
            System.out.println("0");
    }
}
