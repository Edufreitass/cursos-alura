package escola;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CpfTest {

    @Test
    void naoDeveriaCriarCpfComNumerosInvalidos() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Cpf(null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Cpf(""));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Cpf("12345678900"));
    }

    @Test
    void deveriaPermitirCriarCpfComNumeroValido() {
        String numero = "123.456.789-00";
        Cpf cpf = new Cpf(numero);
        Assertions.assertEquals(numero, cpf.getNumero());
    }
}