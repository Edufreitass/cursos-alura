package br.com.alura;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        String nome = "Mouse";
        String descricao = "Mouse sem fio";
        String sql = "INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
