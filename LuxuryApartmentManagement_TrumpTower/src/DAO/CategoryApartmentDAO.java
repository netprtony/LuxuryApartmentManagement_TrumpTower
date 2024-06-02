/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.CategoryApartmentModel;
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
public class CategoryApartmentDAO {
    public List<CategoryApartmentModel> readAll(){
        List<CategoryApartmentModel> lst = new ArrayList<>();
        try {
            String  sql = "select * from CATEGORIZE_APARTMENTS";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                CategoryApartmentModel cate = new CategoryApartmentModel();
                cate.setId(rs.getInt("CateApart_ID"));
                cate.setName(rs.getString("CateApart_Name"));
                cate.setExp(rs.getString("CateApart_Explication"));
                lst.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public List<CategoryApartmentModel> FindByName(String name){
        List<CategoryApartmentModel> lst = new ArrayList<>();
        try {
            String sql = "select * from CATEGORIZE_APARTMENTS where CateApart_Name like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                CategoryApartmentModel cate = new CategoryApartmentModel();
                cate.setId(rs.getInt("CateApart_ID"));
                cate.setName(rs.getString("CateApart_Name"));
                cate.setExp(rs.getString("CateApart_Explication"));
                lst.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public int add(CategoryApartmentModel s){
        try {
            String sql=  "insert into CATEGORIZE_APARTMENTS"
                    + "(CateApart_Name, CateApart_Explication) "
                    + "values "
                    + "(?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getName());
            pstm.setString(2, s.getExp());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(int ID){
        try {
            String sql = "delete CATEGORIZE_APARTMENTS where CateApart_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(CategoryApartmentModel cate){
        try{
            String sql = "update CATEGORIZE_APARTMENTS set "
                    + "CateApart_Name = ?,"
                    + "CateApart_Explication = ?"
                    + " where CateApart_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cate.getName());
            pstm.setString(2, cate.getExp());
            pstm.setInt(3, cate.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
