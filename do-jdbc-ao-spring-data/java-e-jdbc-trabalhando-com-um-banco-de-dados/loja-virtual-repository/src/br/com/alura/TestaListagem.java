package br.com.alura;

import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimeZone=UTC";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

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
