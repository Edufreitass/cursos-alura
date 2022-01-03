package aula13.exercicio2;

/**
 * O código não compila pois "tamanhoEsperado" não é uma constante.
 * Somente podemos verificar case de switch em variáveis finais inicializadas diretamente.
 */
class A {

    // Não compila
    public static void main(String[] args) {
        int tamanhoEsperado = 1;
        int tamanho = args.length;
        switch(tamanho) {
            case tamanhoEsperado:
                System.out.println("1");
                break;
            default:
                System.out.println("cade o argumento?");
        }
    }
}