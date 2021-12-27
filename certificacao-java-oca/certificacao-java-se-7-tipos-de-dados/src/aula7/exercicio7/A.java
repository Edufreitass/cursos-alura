package aula7.exercicio7;

/**
 * Não compila por outro motivo: a variável vazio não é estática.
 */
class A {

    String vazio;

    // Não compila por outro motivo.
    public static void main(String[] args) {
        String full = "Bem-vindo " + vazio;
        System.out.println(full);
    }
}
