package br.com.alura.escola.aluno;

import br.com.alura.escola.aluno.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Email("emailinvalido"));
    }

    @Test
    void deveriaPermitirCriarEmailComEnderecoValido() {
        String endereco = "fulano@gmail.com";
        Email email = new Email(endereco);
        Assertions.assertEquals(endereco, email.getEndereco());
    }
}