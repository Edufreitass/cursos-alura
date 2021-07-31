package br.com.alura.loja;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoTest {

    @Test
    public void test() {
        Produto p = new Produto("teste", BigDecimal.TEN);
        Assert.assertEquals("teste", p.getNome());
        Assert.assertEquals(BigDecimal.TEN, p.getPreco());
    }

}
