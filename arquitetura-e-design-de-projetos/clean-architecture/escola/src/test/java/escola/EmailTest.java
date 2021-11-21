package escola;

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
}