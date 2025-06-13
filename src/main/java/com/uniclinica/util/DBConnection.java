package com.uniclinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;


public class DBConnection {

    private DBConnection() {}

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static Connection getConnection() {
        String url = dotenv.get("DB_URL", "jdbc:mysql://localhost:3306/uniclinicavet");
        String user = dotenv.get("DB_USER", "root");
        String pass = dotenv.get("DB_PASS", "");
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao conectar ao banco", e);
        }
    }
}
