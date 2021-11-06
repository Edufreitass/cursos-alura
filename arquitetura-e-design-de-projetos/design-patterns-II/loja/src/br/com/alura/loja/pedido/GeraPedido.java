package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class GeraPedido {

	private final String cliente;
	private final BigDecimal valorOrcamento;
	private final int quantidadeItens;

	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeItens = quantidadeItens;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

}
