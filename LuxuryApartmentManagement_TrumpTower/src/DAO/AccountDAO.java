/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<Account> readAll(){
        List<Account> lstAc = new ArrayList<>();
        try {
            String sql = "select * from Accounts";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lstAc.clear();
            while (rs.next()) {                
                Account ac = new Account();
                ac.setUser(rs.getString(1));
                ac.setName(rs.getString(2));
                ac.setPassword(rs.getString(3));
                ac.setRole(rs.getString(4));
                lstAc.add(ac);
            }
        } catch (Exception e) {
        }
        return lstAc;
    }
    public int Add(Account ac){
        try {
            String sql = "insert into accounts values(?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ac.getUser());
            pstm.setString(2, ac.getName());
            pstm.setString(3, ac.getPassword());
            pstm.setString(4, ac.getRole());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int Update(Account ac){
        try{
            String sql = "update accounts set Acc_User = ?, Acc_NameOwner = ?, Acc_Password = ?, Acc_Role = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ac.getUser());
            pstm.setString(2, ac.getName());
            pstm.setString(3, ac.getPassword());
            pstm.setString(4, ac.getRole());
            return pstm.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public int Delete(String id){
        try {
            String sql = "Detele accounts where Acc_User = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public List<Account> find(String id){
        List<Account> lstAc = new ArrayList<>();
        try {
            String sql = "select * from Accounts where Acc_User = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            lstAc.clear();
            while(rs.next()){
                Account ac = new Account();
                ac.setUser(rs.getString(1));
                ac.setName(rs.getString(2));
                ac.setPassword(rs.getString(3));
                ac.setRole(rs.getString(4));
                lstAc.add(ac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstAc;
    }
}
