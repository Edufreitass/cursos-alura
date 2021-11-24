package br.com.alura.escola.dominio.aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        this.aluno = new Aluno(
                new CPF("123.456.789-00"),
                "Fulano da Silva",
                new Email("fulano@email.com")
        );
    }

    @Test
    void deveriaPermitirAdicionarUmTelefone() {
        this.aluno.adicionarTelefone("11", "99999999");
        assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    void deveriaPermitirAdicionarDoisTelefone() {
        this.aluno.adicionarTelefone("11", "99999999");
        this.aluno.adicionarTelefone("11", "88888888");
        assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDeveriaPermitirAdicionarTresTelefone() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.aluno.adicionarTelefone("11", "99999999");
            this.aluno.adicionarTelefone("11", "88888888");
            this.aluno.adicionarTelefone("11", "77777777");
        });
    }
}