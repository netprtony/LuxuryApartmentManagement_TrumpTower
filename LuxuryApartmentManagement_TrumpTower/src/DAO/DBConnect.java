/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBConnect {
    public static Connection openConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Loading driver...");

            String url = "jdbc:sqlserver://localhost\\netprtony\\LOCALDB#2A23D8A6;databaseName=LuxuryApartmentManagement_TrumpTowers;integratedSecurity=true;";
            Connection con = DriverManager.getConnection(url);
            System.out.println("Connected...");
            return con;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found. Please check the JDBC driver.");
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void main(String[] args) {
        try {
            Connection con = openConnection();
            // Perform database operations
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
