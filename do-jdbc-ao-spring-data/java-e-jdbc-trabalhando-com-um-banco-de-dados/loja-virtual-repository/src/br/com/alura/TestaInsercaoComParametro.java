package br.com.alura;

import br.com.alura.factory.ConnectionFactory;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperarConexao()) {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)";

            try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                adicionarVariavel("SmartTV", "45 polegadas", stm);
                adicionarVariavel("Radio", "Radio de bateria", stm);

                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                connection.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if (nome.equals("Radio")) {
            throw new RuntimeException("Não foi possível adicionar o produto");
        }

        stm.execute();

        try (ResultSet resultSet = stm.getGeneratedKeys()) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println("O id criado foi: " + id);
            }
        }
    }
}
