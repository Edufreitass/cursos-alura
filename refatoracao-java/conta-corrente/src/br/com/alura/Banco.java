package br.com.alura;

public class Banco {

    public void depositar(Conta c, double valor) {
        c.sacar(valor);
    }

    public void realizarTransferencia(Conta a, double valor, Conta c) {
        a.sacar(valor);
        c.depositar(valor);
    }
}
