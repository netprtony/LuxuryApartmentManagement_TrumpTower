/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author netprtony
 */
public class CustomerDAO {
    public List<CustomerModel> readAll(){
        List<CustomerModel> lst = new ArrayList<>();
        try {
            String  sql = "select * from CUSTOMERS";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                CustomerModel cus = new CustomerModel();
                cus.setId(rs.getString("Cus_ID"));
                cus.setName(rs.getString("Cus_Name"));
                cus.setBirth(rs.getString("Cus_BirDate"));
                cus.setHomeTower(rs.getString("Cus_HomeTower"));
                cus.setGender(rs.getString("Cus_Gender"));
                cus.setPhoneNumber(rs.getString("Cus_PhoneNumber"));
                cus.setMail(rs.getString("Cus_Mail"));
                cus.setNote(rs.getString("Cus_Note"));
                lst.add(cus);
            }
        } catch (Exception e) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    public int Sum(){
        try {
            String sql=  "select Count(*) from Customers";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public List<CustomerModel> readAllCustomerHaveNoContract(){
        List<CustomerModel> lst = new ArrayList<>();
        try {
            String  sql = "exec USP_readAllCustomerHaveNoContract";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                CustomerModel cus = new CustomerModel();
                cus.setId(rs.getString("Cus_ID"));
                cus.setName(rs.getString("Cus_Name"));
                lst.add(cus);
            }
        } catch (Exception e) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    public List<CustomerModel> FindByName(String name){
        List<CustomerModel> lst = new ArrayList<>();
        try {
            String sql = "select * from CUSTOMERS where Cus_Name like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                CustomerModel cus = new CustomerModel();
                cus.setId(rs.getString("Cus_ID"));
                cus.setName(rs.getString("Cus_Name"));
                cus.setBirth(rs.getString("Cus_BirDate"));
                cus.setHomeTower(rs.getString("Cus_HomeTower"));
                cus.setGender(rs.getString("Cus_Gender"));
                cus.setPhoneNumber(rs.getString("Cus_PhoneNumber"));
                cus.setMail(rs.getString("Cus_Mail"));
                cus.setNote(rs.getString("Cus_Note"));
                lst.add(cus);
            }
        } catch (Exception e) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    public int add(CustomerModel s){
        try {
            String sql=  "insert into CUSTOMERS"
                    + "(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber, Cus_Mail, Cus_Note) "
                    + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getId());
            pstm.setString(2, s.getName());
            pstm.setString(3, s.getBirth());
            pstm.setString(4, s.getHomeTower());
            pstm.setString(5, s.getGender());
            pstm.setString(6, s.getPhoneNumber());
            pstm.setString(7, s.getMail());
            pstm.setString(8, s.getNote());
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int delete(String id){
        try {
            String sql = "delete CUSTOMERS where Cus_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int update(CustomerModel cus){
        try{
            String sql = "update CUSTOMERS set "
                    + "Cus_Name = ?,"
                    + "Cus_BirDate = ?,"
                    + "Cus_HomeTower = ?,"
                    + "Cus_Gender = ?,"
                    + "Cus_PhoneNumber = ?,"
                    + "Cus_Mail = ?,"
                    + "Cus_Note = ?"
                    + " where Cus_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cus.getName());
            pstm.setString(2, cus.getBirth());
            pstm.setString(3, cus.getHomeTower());
            pstm.setString(4, cus.getGender());
            pstm.setString(5, cus.getPhoneNumber());
            pstm.setString(6, cus.getMail());
            pstm.setString(7, cus.getNote());
            pstm.setString(8, cus.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
}
