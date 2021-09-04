package com.company.confing;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSQL {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "miki212122";

    public Connection connect() throws SQLException{
        try {
        Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getClass().getName() + ":" + e.getMessage());

        }

        return DriverManager.getConnection(url, user, password);
    }
}
