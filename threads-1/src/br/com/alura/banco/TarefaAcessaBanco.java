package br.com.alura.banco;

public class TarefaAcessaBanco implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao transacao;

    public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao transacao) {
        this.pool = pool;
        this.transacao = transacao;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("peguei a chave do pool");
            pool.getConnection();

            synchronized (transacao) {
                System.out.println("comecando gerenciar a tx");
                transacao.begin();
            }
        }
    }
}
