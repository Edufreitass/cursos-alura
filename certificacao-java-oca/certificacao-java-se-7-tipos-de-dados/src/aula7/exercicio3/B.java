package aula7.exercicio3;

/**
 * Não compila pois a variável não foi inicializada.
 */
class B {

    // Não compila.
    void imprime() {
        String msg;
        if (!msg.isEmpty())
            System.out.println(msg);
        else
            System.out.println("vazio");
    }
}