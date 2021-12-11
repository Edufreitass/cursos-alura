package br.com.alura;

import br.com.alura.dao.ProdutoDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.forEach(System.out::println);
        }
    }
}
