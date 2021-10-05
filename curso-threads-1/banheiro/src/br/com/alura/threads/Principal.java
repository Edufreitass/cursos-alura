package br.com.alura.threads;

public class Principal {

    /**
     * Possíveis estados de uma thread:
     *
     * NEW Uma thread foi criada, mas ainda não foi iniciada.
     * RUNNABLE A thread está rodando dentro da JVM.
     * BLOCKED A thread foi bloqueada, pois não conseguiu pegar a chave.
     * WAITING A thread está esperando, pois foi chamado this.wait().
     * TIMED_WAITING A thread está esperando, pois foi chamado this.wait(millis).
     * TERMINATED A thread está finalizada.
     */
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Joao");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
        limpeza.setPriority(10);
        // existem daemon threads para executar tarefas ou serviços secundários
        // daemons serão automaticamente desligados quando todas as outras threads terminarem
        limpeza.setDaemon(true);
//        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
//        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

        convidado1.start();
        convidado2.start();
        limpeza.start();
//        convidado3.start();
//        convidado4.start();
    }
}