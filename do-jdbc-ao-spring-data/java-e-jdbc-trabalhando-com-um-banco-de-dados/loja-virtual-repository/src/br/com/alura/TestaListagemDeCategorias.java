package br.com.alura;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> categorias = categoriaDAO.listar();
            categorias.forEach(categoria -> {
                System.out.println(categoria.getNome());
                try {
                    for (Produto produto : new ProdutoDAO(connection).buscar(categoria)) {
                        System.out.println(categoria.getNome() + " - " + produto.getNome());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
