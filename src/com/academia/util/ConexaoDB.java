package com.academia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/academia_db";
    private static final String USUARIO = "";
    private static final String SENHA = "";

    public static Connection conectar() {
        Connection conexao = null;
        try {
            // JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC não encontrado. Verifique se o MySQL Connector/J está no classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}