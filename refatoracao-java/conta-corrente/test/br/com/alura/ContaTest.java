package br.com.alura;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ContaTest {

    @Test
    public void aoSacarUmValorDeUmaContaOSaldoDeveSofrerUmaSubtracaoDesseValor() {
        Conta conta = new Conta(200.0);
        conta.sacar(50.0);

        assertThat(conta.getSaldo(), is(equalTo(150.0)));
    }
}