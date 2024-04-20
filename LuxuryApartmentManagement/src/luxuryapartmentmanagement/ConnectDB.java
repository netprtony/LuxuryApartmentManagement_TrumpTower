/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package luxuryapartmentmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author netprtony
 */
public class ConnectDB {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=LuxuryApartmentManagement";
    private static final String USER = "sa";
    private static final String PASS = "123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = ConnectDB.getConnection();
        // Do something with the connection...
        // Remember to close the connection when you're done.
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
