package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsuarioDaoTest {

    private UsuarioDao dao;

    @Test
    void testeBuscaDeUsuarioPeloUsername() {
        this.dao = new UsuarioDao();
        Usuario usuario = dao.buscarPorUsername("fulano");
        assertNotNull(usuario);
    }
}