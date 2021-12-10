package br.com.alura;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement statement = connection.createStatement();
        statement.execute("""
                SELECT ID, NOME, DESCRICAO FROM PRODUTO
                """);

        ResultSet resultSet = statement.getResultSet();

        while(resultSet.next()) {
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
