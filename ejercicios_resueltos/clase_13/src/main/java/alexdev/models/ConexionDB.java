package alexdev.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static final String urlMysql = "jdbc:mysql://mysql-alexdev.alwaysdata.net/alexdev_qatar2022";
    static final String userMysql = "alexdev";
    static final String passMysql = "045195@Lex";

    static Connection connection;

    public static Connection getConnection() throws SQLException {
        return connection != null ? connection : DriverManager.getConnection(urlMysql, userMysql, passMysql);
    }
}
