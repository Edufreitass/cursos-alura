package aula7.exercicio6;

/**
 * Não compila pois a String não foi inicializada
 */
class A {

    // Não compila por outro motivo.
    public static void main(String[] args) {
        String vazio;
        String full = "Bem-vindo " + vazio;
        System.out.println(full);
    }
}
