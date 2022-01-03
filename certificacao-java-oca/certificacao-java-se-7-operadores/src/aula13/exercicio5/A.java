package aula13.exercicio5;

/**
 * O código não compila pois o case não aceita expressões como < x, mas sim um valor definido em tempo de compilação.
 */
class A {

    // Erro de compilação.
    public static void main(String[] args) {
        switch(10) {
            case < 10:
                System.out.println("menor");
            default:
                System.out.println("igual");
            case > 10:
                System.out.println("maior");
        }
    }
}
