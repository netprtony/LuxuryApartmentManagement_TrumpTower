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
                cate.setId(rs.getString("cateapart_id"));
                cate.setName(rs.getString("cateapart_Name"));
                cate.setExp(rs.getString("cateapart_Explication"));
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
            String sql = "select * from CATEGORIZE_APARTMENTS where Serv_Name like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                CategoryApartmentModel cate = new CategoryApartmentModel();
                cate.setId(rs.getString("cateapart_ID"));
                cate.setName(rs.getString("cateapart_Name"));
                cate.setExp(rs.getString("cateapart_Explication"));
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
                    + "(cateapart_Name, cateapart_Price, cateapart_Explication) "
                    + "values "
                    + "( ?, ?)";
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
    public int delete(int id){
        try {
            String sql = "delete CATEGORIZE_APARTMENTS where cateapart_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(CategoryApartmentModel cate){
        try{
            String sql = "update SERVICES set "
                    + "cateapart_Name = ?,"
                    + "cateapart_Explication = ?"
                    + " where cateapart_id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cate.getName());
            pstm.setString(2, cate.getExp());
            pstm.setInt(3, Integer.parseInt(cate.getId()));
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
