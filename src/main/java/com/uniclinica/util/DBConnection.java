package com.uniclinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária para conexão JDBC. A implementação será definida com MySQL.
 */
public class DBConnection {

    private DBConnection() {}

    public static Connection getConnection() {
        String host = System.getenv().getOrDefault("DB_HOST", "localhost");
        String dbName = System.getenv().getOrDefault("DB_NAME", "uniclinicavet");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASS");

        String url = String.format("jdbc:mysql://%s/%s", host, dbName);
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao conectar ao banco", e);
        }
    }
}
