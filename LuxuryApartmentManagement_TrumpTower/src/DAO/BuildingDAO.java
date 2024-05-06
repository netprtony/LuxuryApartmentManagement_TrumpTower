/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.Building;
import MODEL.BuildingModel;
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
public class BuildingDAO {
    public List<BuildingModel> readAll(){
        List<BuildingModel> lst = new ArrayList<>();
        try {
            String  sql = "exec USP_GetAllBuilding";
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
            e.printStackTrace();
        }
        return lst;
    }
    public List<BuildingModel> FindById(String id){
        List<BuildingModel> lst = new ArrayList<>();
        try {
            String sql = "exec USP_FindByIDBuilding @id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
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
            e.printStackTrace();
        }
        return lst;
    }
    public int add(Building Bui){
        try {
            String sql = ""
        } catch (Exception e) {
        }
    }
}
