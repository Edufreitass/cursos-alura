package br.com.alura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimeZone=UTC";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("Fechando conexão!!!");

        connection.close();
    }
}
