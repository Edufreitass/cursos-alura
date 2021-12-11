package br.com.alura;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        adicionarVariavel("SmartTV", "45 polegadas", preparedStatement);
        adicionarVariavel("Radio", "Radio de bateria", preparedStatement);
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);

//        if (nome.equals("Radio")) {
//            throw new RuntimeException("Não foi possível adicionar o produto");
//        }

        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
