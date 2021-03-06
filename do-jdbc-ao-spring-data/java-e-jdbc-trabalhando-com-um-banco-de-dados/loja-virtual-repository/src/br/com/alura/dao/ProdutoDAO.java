package br.com.alura.dao;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public record ProdutoDAO(Connection connection) {

    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());

            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                while (rs.next()) {
                    produto.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rs = pstm.getResultSet()) {
                while (rs.next()) {
                    Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria categoria) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Executando a query de buscar produto por categoria");

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, categoria.getId());
            pstm.execute();

            try (ResultSet rs = pstm.getResultSet()) {
                while (rs.next()) {
                    Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}
