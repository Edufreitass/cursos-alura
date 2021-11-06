package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class ItemOrcamento {

    private final BigDecimal valor;

    public ItemOrcamento(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
