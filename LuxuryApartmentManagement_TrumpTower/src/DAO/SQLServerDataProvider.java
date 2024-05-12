/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author netprtony
 */
public class SQLServerDataProvider {
    private Connection connection;
    public  void open(){
        String server = "localhost";
        String databaseName = "LuxuryApartmentManagement_TrumpTowers";
        String user = "sa", pass = "Bakugan2805";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Loading...");
            String connectionURL = "jdbc:sqlserver://" + server
                    + ":1433;databaseName=" + databaseName
                    + ";user = " + user +"; password = " + pass
                    + ";integratesSecurity = true";
            connection = DriverManager.getConnection(connectionURL);
            System.out.println("Connected...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int executeUpdate(String sql){
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
}
