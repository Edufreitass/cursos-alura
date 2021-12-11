package br.com.alura;

import br.com.alura.modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {

    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {

            String sql = "INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, comoda.getNome());
                pstm.setString(2, comoda.getDescricao());

                pstm.execute();

                try (ResultSet rs = pstm.getGeneratedKeys()) {
                    while (rs.next()) {
                        comoda.setId(rs.getInt(1));
                    }
                }
            }
        }
        System.out.println(comoda);
    }
}
