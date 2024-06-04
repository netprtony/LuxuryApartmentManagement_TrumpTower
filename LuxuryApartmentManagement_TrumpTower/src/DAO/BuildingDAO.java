/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.BuildingModel;
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
public class BuildingDAO {
    public List<BuildingModel> readAll(){
        List<BuildingModel> lst = new ArrayList<>();
        try {
            String  sql = "Select * from BUILDINGS";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                BuildingModel b = new BuildingModel();
                b.setId(rs.getString(1));
                b.setAddress(rs.getString(2));
                b.setName(rs.getString(3));
                b.setDescribe(rs.getString(4));
                lst.add(b);
            }
        } catch (Exception e) {
            Logger.getLogger(BuildingModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    
    public List<BuildingModel> FindByName(String name){
        List<BuildingModel> lst = new ArrayList<>();
        try {
            String sql = "select * from BUILDINGS "
                    + "where Build_Name  like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                BuildingModel b = new BuildingModel();
                b.setId(rs.getString(1));
                b.setAddress(rs.getString(2));
                b.setName(rs.getString(3));
                b.setDescribe(rs.getString(4));
                lst.add(b);
            }
        } catch (Exception e) {
            Logger.getLogger(BuildingModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    public int add(BuildingModel bui){
        try {
            String sql=  "insert into BUILDINGS "
                    + "(Build_ID, Build_Address, Build_Name, Build_Describe) "
                    + "values"
                    + " (?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, bui.getId());
            pstm.setString(2, bui.getAddress());
            pstm.setString(3, bui.getName());
            pstm.setString(4, bui.getDescribe());
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(BuildingModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int delete(String id){
        try {
            String sql = "delete BUILDINGS "
                    + "where Build_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(BuildingModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int update(BuildingModel bui){
        try{
            String sql = "update buildings set "
                    + "build_address = ?,"
                    + "build_name = ?,"
                    + "build_describe = ?"
                    +  " where build_id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(4, bui.getId());
            pstm.setString(1, bui.getAddress());
            pstm.setString(2, bui.getName());
            pstm.setString(3, bui.getDescribe());
            return pstm.executeUpdate();
        } catch (Exception e){
            Logger.getLogger(BuildingModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
}
