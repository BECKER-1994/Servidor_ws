package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final static String USUARIO = "";
    private final static String SENHA = "";
    private final static String URL = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conection = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ConnectionFactory.getConnection();
    }
}
