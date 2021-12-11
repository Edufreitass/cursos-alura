package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID"); // posicao 1
            System.out.println(id);

            String nome = resultSet.getString("NOME"); // posicao 2
            System.out.println(nome);

            String descricao = resultSet.getString("DESCRICAO"); // posicao 3
            System.out.println(descricao);
        }

        connection.close();
    }
}
