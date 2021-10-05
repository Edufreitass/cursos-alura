package br.com.alura.banco;

public class PrincipalBanco {

    public static void main(String[] args) {
        GerenciadorDeTransacao transacao = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessaBanco(pool, transacao)).start();
        new Thread(new TarefaAcessaBancoProcedimento(pool, transacao)).start();
    }
}
