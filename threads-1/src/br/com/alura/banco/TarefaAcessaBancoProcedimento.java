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
        synchronized (pool) {
            System.out.println("peguei a conexao");
            pool.getConnection();

            synchronized (transacao) {
                System.out.println("comecando a tx");
                transacao.begin();
            }
        }
    }

    // DEADLOCK
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
