/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo Motta
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection connection;

    public Conexao(String serverhost, String database, String porta, String user, String password) {

        try {
            String url = "jdbc:mysql://" + serverhost + ":" + porta + "/" + database;
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            this.connection = null;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar estabelecer a conexão com o banco de dados: " + e.getMessage());
            this.connection = null;
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

}

