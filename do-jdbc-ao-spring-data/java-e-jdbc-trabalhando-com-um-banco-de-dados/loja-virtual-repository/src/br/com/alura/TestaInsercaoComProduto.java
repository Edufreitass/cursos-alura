package br.com.alura;

import br.com.alura.dao.ProdutoDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaInsercaoComProduto {

    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            // Lista = persistenciaProduto.listar();
        }
    }
}
