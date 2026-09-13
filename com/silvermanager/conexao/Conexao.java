package com.silvermanager.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/necklacejoias";
    private static final String USER = "root"; 
    private static final String PASS = ""; 

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public Connection conectar() {
    try {
        String url = "jdbc:mysql://localhost:3306/necklacejoias";
        String user = "root";
        String password = ""; 
        
        return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        System.out.println("Erro de conexão: " + e.getMessage());
        return null;
    }
}
}