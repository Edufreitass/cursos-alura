package br.com.alura.banco;

public class TarefaAcessaBancoProcedimento implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao transacao;

    public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao transacao) {
        this.pool = pool;
        this.transacao = transacao;
    }

    @Override
    public void run() {
        // Podemos usar um bloco synchronized dentro do outro.
        synchronized (pool) {
            System.out.println("peguei a conexao");
            pool.getConnection();

            synchronized (transacao) {
                System.out.println("comecando a tx");
                transacao.begin();
            }
        }
    }

    /**
     * DEADLOCK
     * Podemos evitar o Deadlock obtendo as chaves dos objetos na mesma ordem, em todos os threads.
     */
//    @Override
//    public void run() {
//        synchronized (transacao) {
//            System.out.println("comecando a transacao");
//            transacao.begin();
//
//            synchronized (pool) {
//                System.out.println("peguei a conexao");
//                pool.getConnection();
//            }
//        }
//    }
}
