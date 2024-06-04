/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import MODEL.ServiceModel;

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
public class ServiceDAO {
    public List<ServiceModel> readAll(){
        List<ServiceModel> lst = new ArrayList<>();
        try {
            String  sql = "select * from SERVICES";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                ServiceModel s = new ServiceModel();
                s.setId(rs.getInt("Serv_ID"));
                s.setName(rs.getString("Serv_Name"));
                s.setPrice(rs.getDouble("Serv_Price"));
                s.setExp(rs.getString("Serv_Explication"));
                s.setAvailable(rs.getBoolean("Serv_Available"));
                lst.add(s);
            }
        } catch (Exception e) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }

    public List<ServiceModel> FindByName(String name){
        List<ServiceModel> lst = new ArrayList<>();
        try {
            String sql = "select * from SERVICES where Serv_Name like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                ServiceModel s = new ServiceModel();
                s.setId(rs.getInt("Serv_ID"));
                s.setName(rs.getString("Serv_Name"));
                s.setPrice(rs.getDouble("Serv_Price"));
                s.setExp(rs.getString("Serv_Explication"));
                s.setAvailable(rs.getBoolean("Serv_Available"));
                lst.add(s);
            }
        } catch (Exception e) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    
    public int add(ServiceModel s){
        try {
            String sql=  "insert into SERVICES"
                    + "(Serv_Name, Serv_Price, Serv_Explication, Serv_Available) "
                    + "values "
                    + "( ?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getName());
            pstm.setDouble(2, s.getPrice());
            pstm.setString(3, s.getExp());
            pstm.setBoolean(4, s.isAvailable());
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int addByNumberApartment(ServiceModel s){
        try {
            String sql=  "insert into SERVICES"
                    + "(Serv_Name, Serv_Price, Serv_Explication, Serv_Available) "
                    + "values "
                    + "( ?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getName());
            pstm.setDouble(2, s.getPrice());
            pstm.setString(3, s.getExp());
            pstm.setBoolean(4, s.isAvailable());
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int delete(int id){
        try {
            String sql = "delete SERVICES where Serv_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int update(ServiceModel s){
        try{
            String sql = "update SERVICES set "
                    + "Serv_Name = ?,"
                    + "Serv_Price=  ?,"
                    + "Serv_Available= ?"
                    + "Serv_Explication = ?"
                    + " where Serv_id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getName());
            pstm.setDouble(2, s.getPrice());
            pstm.setBoolean(3, s.isAvailable());
            pstm.setString(4, s.getExp());
            pstm.setInt(5, s.getId());

            return pstm.executeUpdate();
        } catch (Exception e){
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    
}
