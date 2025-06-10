package com.uniclinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária para conexão JDBC. A implementação será definida com MySQL.
 */
public class DBConnection {

    private DBConnection() {}

    private static final String URL = "jdbc:mysql://localhost:3306/uniclinicavet";
    private static final String USER = "root"; // ajuste conforme suas credenciais
    private static final String PASS = "";     // ajuste conforme suas credenciais

    public static Connection getConnection() {
        String url = URL;
        String user = USER;
        String pass = PASS;
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao conectar ao banco", e);
        }
    }
}
