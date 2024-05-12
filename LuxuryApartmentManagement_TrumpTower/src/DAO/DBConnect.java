/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class DBConnect {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Loading...");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LuxuryApartmentManagement_TrumpTowers;";
        String user = "sa";
        String password = "Bakugan2805";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connected...");
        return con;
    }
}
