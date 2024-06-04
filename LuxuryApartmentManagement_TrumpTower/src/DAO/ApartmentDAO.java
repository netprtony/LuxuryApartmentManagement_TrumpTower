    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import MODEL.ApartmentModel;
import MODEL.ContractModel;
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
public class ApartmentDAO {
    public List<ApartmentModel> readAll(){
        List<ApartmentModel> lstAp = new ArrayList<>();
        try {
            String sql = "select Apart_Number, \n" +
                        "Apart_Floor,\n" +
                        "Apart_View,\n" +
                        "Apart_Acreage,\n" +
                        "Apart_Price,\n" +
                        "Apart_Describe,\n" +
                        "Apart_Available,\n" +
                        "cate.CateApart_Name,\n" +
                        "a.Build_ID \n" +
                        "from Apartments a left join CATEGORIZE_APARTMENTS cate \n" +
                        "on a.CateApart_ID = cate.CateApart_ID";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lstAp.clear();
            while (rs.next()) {                
                ApartmentModel ap = new ApartmentModel();
                ap.setNumber(rs.getString(1));
                ap.setFloor(rs.getInt(2));
                ap.setView(rs.getBoolean(3));
                ap.setAcreage(rs.getString(4));
                ap.setPrice(rs.getDouble(5));
                ap.setDescribe(rs.getString(6));
                ap.setAvaialbe(rs.getBoolean(7));
                ap.setNameCate(rs.getString(8));
                ap.setIdBuild(rs.getString(9));
                lstAp.add(ap);
            }
        } catch (Exception e) {
            
        }
        return lstAp;
    }    
    public List<ApartmentModel> getAllApartmentEmpty(){
        List<ApartmentModel> lst = new ArrayList<>();
        try {
            String sql = "exec USP_readApartmentEmpty";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lst.clear();
            while (rs.next()) {                
                ApartmentModel ap = new ApartmentModel();
                ap.setId(rs.getInt("Apart_ID"));
                ap.setNumber(rs.getString("Apart_Number"));
                lst.add(ap);
            }
        } catch (Exception e) {
            
        }
        return lst;
    }
    public List<CustomerModel> getInfoCustomerByApartmentNumber(String idApart){
        List<CustomerModel> lstCus = new ArrayList<>();
        try {
            String sql = "USP_GetInforRenterByNumberApartment ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idApart);
            ResultSet rs = pstm.executeQuery();
            lstCus.clear();
            while(rs.next()){
                CustomerModel c = new CustomerModel();
                c.setName(rs.getString(1));
                c.setId(rs.getString(2));
                c.setGender(rs.getString(3));
                c.setHomeTower(rs.getString(4));
                c.setPhoneNumber(rs.getString(5));
                c.setMail(rs.getString(6));
                lstCus.add(c);
            }
        } catch (Exception e) {
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lstCus;
    }
     public List<ContractModel> getInfoContractByApartmentNumber(String idApart){
        List<ContractModel> lstContr = new ArrayList<>();
        try {
            String sql = "USP_GetInforContractByNumberApartment ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, idApart);
            ResultSet rs = pstm.executeQuery();
            lstContr.clear();
            while(rs.next()){
                ContractModel c = new ContractModel();
                c.setId(rs.getInt(1));
                c.setDate(rs.getString(2));
                lstContr.add(c);
            }
        } catch (Exception e) {
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lstContr;
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
                a.setAvaialbe(rs.getBoolean("available"));
                a.setDescribe(rs.getString("Apart_describe"));
                a.setFloor(rs.getInt("Apart_floor"));
                a.setIdBuild(rs.getString("Build_ID"));
                a.setIdCate(rs.getInt("CateApart_ID"));
                a.setPrice(rs.getDouble("Apart_Price"));
                a.setNumber(rs.getString("Apart_Number"));
                a.setView(rs.getBoolean("View"));
                
                lst.add(a);
            }
        } catch (Exception e) {
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
        public List<ApartmentModel> Filter(ApartmentModel ap, Double priceFrom, Double priceTo){
        List<ApartmentModel> lst = new ArrayList<>();
        try {
            String sql = "exec USP_FilterApartment "
                    + "@idBuild = ?,"
                    + "@idCate = ?,"
                    + "@isAvail = ?,"
                    + "@priceFrom = ?,"
                    + "@priceTo = ?,"
                    + "@floor = ?,"
                    + "@isView = ?,"
                    + "@acreage = ?,"
                    + "@des = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ap.getIdBuild());
            pstm.setInt(2, ap.getIdCate());
            pstm.setBoolean(3, ap.isAvaialbe());
            pstm.setDouble(4, priceFrom);
            pstm.setDouble(5, priceTo);
            pstm.setInt(6, ap.getFloor());
            pstm.setBoolean(7, ap.isView());
            pstm.setString(8, ap.getAcreage());
            pstm.setString(9, ap.getDescribe()  );
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                ApartmentModel a = new ApartmentModel();
                a.setId(rs.getInt("Apart_id"));
                a.setAcreage(rs.getString("Apart_acreage"));
                a.setAvaialbe(rs.getBoolean("available"));
                a.setDescribe(rs.getString("Apart_describe"));
                a.setFloor(rs.getInt("Apart_floor"));
                a.setIdBuild(rs.getString("Build_ID"));
                a.setIdCate(rs.getInt("CateApart_ID"));
                a.setPrice(rs.getDouble("Apart_Price"));
                a.setNumber(rs.getString("Apart_Number"));
                a.setView(rs.getBoolean("View"));
                
                lst.add(a);
            }
        } catch (Exception e) {
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int delete(String name){
        try {
            String sql = "delete APARTMENTS "
                    + "where Apart_Number = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    
    public int update(ApartmentModel a){
        try{
            String sql = "update APARTMENTS set "
                    + "Apart_Floor = ?, "
                    + "Apart_View = ?, "
                    + "Apart_Acreage = ?, "
                    + "Apart_Price = ?, "
                    + "Apart_Describe = ?, "
                    + "Apart_Available = ?, "
                    + "CateApart_ID = ?,"
                    + "Build_ID = ?"
                    + " where Apart_Number = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, a.getFloor());
            pstm.setBoolean(2, a.isView());
            pstm.setString(3, a.getAcreage());
            pstm.setDouble(4, a.getPrice());
            pstm.setString(5, a.getDescribe());
            pstm.setBoolean(6, a.isAvaialbe());
            pstm.setInt(7, a.getIdCate());
            pstm.setString(8, a.getIdBuild());
            pstm.setString(9, a.getNumber());
            return pstm.executeUpdate();
        } catch (Exception e){
            Logger.getLogger(ApartmentModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
}
