package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void setUp() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void tearDown() {
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();

        Assertions.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        paginaDeLogin.preencheFormularioDeLogin("invalido", "12345678");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        Assertions.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assertions.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();

        Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}
