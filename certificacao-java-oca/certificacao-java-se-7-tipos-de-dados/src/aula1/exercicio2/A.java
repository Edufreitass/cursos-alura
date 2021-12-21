package aula1.exercicio2;

/**
 * O código não compila pois tentamos acessar a variável idade que pode não ter sido inicializada.
 * Não é certeza (somente se cair no if ela será inicializada).
 */
class A {

    // Não compila: erro na linha que tenta acessar a variável idade.
    public static void main(String[] args) {
        int idade;
        if (args.length > 0) {
            idade = Integer.parseInt(args[0]);
        } else {
            System.err.println("Por favor passe sua idade como primeiro parâmetro");
        }
        System.out.println("Sua idade é " + idade);
    }
}
