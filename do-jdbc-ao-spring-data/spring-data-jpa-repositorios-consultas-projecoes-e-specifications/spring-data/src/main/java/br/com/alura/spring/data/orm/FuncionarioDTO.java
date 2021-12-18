package br.com.alura.spring.data.orm;

// Class Based Projection
public class FuncionarioDTO {

    private final String nome;
    private final String cpf;

    public FuncionarioDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
