/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author netprtony
 */
public class AccountDAO {
    public  Account Login(String user, String password){
        Account acc = null;
        try {
            Connection con = DBConnect.openConnection();
            String sql = "exec USP_LoginAccount @username = ? , @password = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, password);
            ResultSet r = pre.executeQuery();
            if(r.next()){
                acc = new Account();
                acc.setUser(r.getString("Acc_User"));
                acc.setName(r.getString("Acc_NameOwner"));
                acc.setPassword(r.getString("Acc_Password"));
                acc.setRole(r.getString("Acc_Role"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
