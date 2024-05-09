/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import MODEL.ApartmentModel;
import MODEL.ServiceModel;
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
public class ApartmentDAO {
    public List<ApartmentModel> readAll(){
        List<ApartmentModel> lstAp = new ArrayList<>();
        try {
            String sql = "USP_GetAllApartment";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lstAp.clear();
            while (rs.next()) {                
                ApartmentModel ap = new ApartmentModel();
                ap.setId(rs.getInt(1));
                ap.setAcreage(rs.getString(2));
                ap.setAvaialbe(rs.getBoolean(3));
                ap.setFloor(rs.getInt(4));
                ap.setIdBuild(rs.getString(5));
                ap.setNumber(rs.getString(6));
                ap.setPrice(rs.getDouble(7));
                ap.setView(rs.getBoolean(8));
                lstAp.add(ap);
            }
        } catch (Exception e) {
        }
        return lstAp;
    }
    
    public List<ApartmentModel> FindByApartmentNumber(String number){
        List<ApartmentModel> lst = new ArrayList<>();
        try {
            String sql = "select * from APARTMENTS"
                    + " where Apart_number = %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, number);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                ApartmentModel a = new ApartmentModel();
                a.setId(rs.getInt("Apart_id"));
                a.setAcreage(rs.getString("Apart_acreage"));
                a.setAvaialbe(rs.getBoolean("Apart_available"));
                a.setDescribe(rs.getString("Apart_describe"));
                a.setFloor(rs.getInt("Apart_floor"));
                a.setIdBuild(rs.getString("Build_ID"));
                a.setIdCate(rs.getInt("CateApart_ID"));
                a.setPrice(rs.getDouble("Apart_Price"));
                a.setNumber(rs.getString("Apart_Number"));
                a.setView(rs.getBoolean("Apart_View"));
                
                lst.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public int add(ApartmentModel a){
        try {
            String sql=  "insert into APARTMENTS "
                    + "(Apart_Number, "
                    + "Apart_Floor, "
                    + "Apart_View,"
                    + "Apart_Acreage,"
                    + "Apart_Price,"
                    + "Apart_Describe,"
                    + "Apart_Available,"
                    + "CateApart_ID,"
                    + "Build_ID)"
                    + " values"
                    + " (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getNumber());
            pstm.setInt(2, a.getFloor());
            pstm.setBoolean(3, a.isView());
            pstm.setString(4, a.getAcreage());
            pstm.setDouble(5, a.getPrice());
            pstm.setString(6, a.getDescribe());
            pstm.setBoolean(7, a.isAvaialbe());
            pstm.setInt(8, a.getIdCate());
            pstm.setString(9, a.getIdBuild());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(String id){
        try {
            String sql = "delete APARTMENTS "
                    + "where Apart_id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(ApartmentModel a){
        try{
            String sql = "update buidlings set "
                    + "Apart_Number = ?, "
                    + "Apart_Floor = ?, "
                    + "Apart_View = ?, "
                    + "Apart_Acreage = ?, "
                    + "Apart_Price = ?, "
                    + "Apart_Describe = ?, "
                    + "Apart_Available = ?, "
                    + "CateApart_ID = ?,"
                    + "Build_ID = ?"
                    + " where Apart_id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
           pstm.setString(1, a.getNumber());
            pstm.setInt(2, a.getFloor());
            pstm.setBoolean(3, a.isView());
            pstm.setString(4, a.getAcreage());
            pstm.setDouble(5, a.getPrice());
            pstm.setString(6, a.getDescribe());
            pstm.setBoolean(7, a.isAvaialbe());
            pstm.setInt(8, a.getIdCate());
            pstm.setString(9, a.getIdBuild());
            pstm.setInt(10, a.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
