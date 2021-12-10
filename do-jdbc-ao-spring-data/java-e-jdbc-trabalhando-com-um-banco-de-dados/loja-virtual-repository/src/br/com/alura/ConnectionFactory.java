package br.com.alura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimeZone=UTC";
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(url, user, password);
    }
}
