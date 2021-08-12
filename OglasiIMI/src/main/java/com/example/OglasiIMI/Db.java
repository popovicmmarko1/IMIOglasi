package com.example.OglasiIMI;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class Db {

    Connection conn = null;
    Statement stmt = null;
    String sql = null;


    public Db()
    {
        System.out.println("Connecting...");

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/baza", "root", ""
            );

            System.out.println("Connected.");

            stmt = conn.createStatement();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }


}
