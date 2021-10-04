package br.com.alura.threads;

public class PrincipalOrdemDeExecucao {

    public static void main(String[] args) {
        new Thread(new TarefaImprimeNumeros()).start();
        new Thread(new TarefaImprimeNumeros()).start();
    }
}
