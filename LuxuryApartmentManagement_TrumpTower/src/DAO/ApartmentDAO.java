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


/**
 *
 * @author netprtony
 */
public class ApartmentDAO {
    public List<ApartmentModel> readAll(){
        List<ApartmentModel> lstAp = new ArrayList<>();
        try {
            String sql = "select Apart_Number,\n" +
                            "Apart_Floor,\n" +
                            "case when Apart_View = 1 then N'Có' else N'Không' end as 'View',\n" +
                            "Apart_Acreage,\n" +
                            "Apart_Price,\n" +
                            "Apart_Describe,\n" +
                            "case when Apart_Available = 1 then N'Trống' else N'Có người' end as 'Available',\n" +
                            "cate.CateApart_Name,\n" +
                            "Build_ID\n" +
                            "from Apartments a left join CATEGORIZE_APARTMENTS cate\n" +
                            "on a.CateApart_ID = cate.CateApart_ID";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lstAp.clear();
            while (rs.next()) {                
                ApartmentModel ap = new ApartmentModel();
                ap.setId(rs.getInt(1));
                ap.setNumber(rs.getString(2));
                ap.setFloor(rs.getInt(3));
                ap.setView(rs.getString(4));
                ap.setAcreage(rs.getString(5));
                ap.setPrice(rs.getDouble(6));
                ap.setDescribe(rs.getString(7));
                ap.setAvaialbe(rs.getString(8));
                ap.setNameCate(rs.getString(9));
                ap.setIdBuild(rs.getString(10));
                lstAp.add(ap);
            }
        } catch (Exception e) {
        }
        return lstAp;
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
            e.printStackTrace();
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
            e.printStackTrace();
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
                a.setAvaialbe(rs.getString("available"));
                a.setDescribe(rs.getString("Apart_describe"));
                a.setFloor(rs.getInt("Apart_floor"));
                a.setIdBuild(rs.getString("Build_ID"));
                a.setIdCate(rs.getInt("CateApart_ID"));
                a.setPrice(rs.getDouble("Apart_Price"));
                a.setNumber(rs.getString("Apart_Number"));
                a.setView(rs.getString("View"));
                
                lst.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            pstm.setString(3, ap.isAvaialbe());
            pstm.setDouble(4, priceFrom);
            pstm.setDouble(5, priceTo);
            pstm.setInt(6, ap.getFloor());
            pstm.setString(7, ap.isView());
            pstm.setString(8, ap.getAcreage());
            pstm.setString(9, ap.getDescribe()  );
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                ApartmentModel a = new ApartmentModel();
                a.setId(rs.getInt("Apart_id"));
                a.setAcreage(rs.getString("Apart_acreage"));
                a.setAvaialbe(rs.getString("available"));
                a.setDescribe(rs.getString("Apart_describe"));
                a.setFloor(rs.getInt("Apart_floor"));
                a.setIdBuild(rs.getString("Build_ID"));
                a.setIdCate(rs.getInt("CateApart_ID"));
                a.setPrice(rs.getDouble("Apart_Price"));
                a.setNumber(rs.getString("Apart_Number"));
                a.setView(rs.getString("View"));
                
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
            pstm.setBoolean(3,  "Có".equals(a.isView()));
            pstm.setString(4, a.getAcreage());
            pstm.setDouble(5, a.getPrice());
            pstm.setString(6, a.getDescribe());
            pstm.setBoolean(7,  "Có người".equals(a.isAvaialbe()));
            pstm.setInt(8, a.getIdCate());
            pstm.setString(9, a.getIdBuild());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(String name){
        try {
            String sql = "delete APARTMENTS "
                    + "where Apart_name = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(ApartmentModel a){
        try{
            String sql = "update APARTMENTS set "
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
            pstm.setBoolean(3, "Có".equals(a.isView()));
            pstm.setString(4, a.getAcreage());
            pstm.setDouble(5, a.getPrice());
            pstm.setString(6, a.getDescribe());
            pstm.setBoolean(7, "Có người".equals(a.isAvaialbe()));
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
