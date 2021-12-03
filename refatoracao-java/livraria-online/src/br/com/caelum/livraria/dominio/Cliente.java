package br.com.caelum.livraria.dominio;

public class Cliente {

	private final String id;
	private final Telefone telefone;
	private String cep;
	
	public Cliente(String id, Telefone telefone, String cep) {
		this.id = id;
		this.telefone = telefone;
		this.cep = cep;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			iguais = id.equals(outra.id);
		}
		return iguais;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getTelefone() {
		return telefone.toString();
	}

	public String getCep() {
		return cep;
	}
}
