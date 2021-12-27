package aula7.exercicio2;

/**
 * Dá NullPointerException! msg é null e não dá pra chamar isEmpty em null.
 */
class B {
    String msg;

    // Compila, mas dá exceção na hora de rodar.
    void imprime() {
        if (!msg.isEmpty())
            System.out.println(msg);
        else
            System.out.println("vazio");
    }
}
