package t15.Oglasi.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    Connection conn = null;
    Statement stmt = null;
    String sql = null;

    public DB()
    {
        System.out.println("Connecting...");
        try
        {
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/baza",
                    "root",
                    ""
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Connected.");
    }
}
