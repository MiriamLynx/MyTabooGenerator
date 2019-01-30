package com.example.mabalofernan.mytabugenerator.logic.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

    private static String DRIVER = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql://mytabugenerator.cldjy3jrgsfz.us-west-2.rds.amazonaws.com:5432/postgres";
    private static String USER = "DBAdmin";
    private static String PASS = "gominola";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found in classpath", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(ResultSet rs, Statement st, Connection c) {
        close(rs);
        close(st);
        close(c);
    }

    public static void close(ResultSet rs, Statement st) {
        close(rs);
        close(st);
    }

    protected static void close(ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
            }
        ;
    }

    public static void close(Statement st) {
        if (st != null)
            try {
                st.close();
            } catch (SQLException e) {
            }
        ;
    }

    public static void close(Connection c) {
        if (c != null)
            try {
                c.close();
            } catch (SQLException e) {
            }
        ;
    }

}