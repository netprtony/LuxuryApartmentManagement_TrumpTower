/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import MODEL.ContractModel;
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
public class ContractDAO {
    public List<ContractModel> readAll(){
        List<ContractModel> lst = new ArrayList<>();
        try {
            String  sql = "exec USP_GetAllContract";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                ContractModel contr = new ContractModel();
                contr.setId(rs.getInt("Contr_ID"));
                contr.setDate(rs.getString("Contr_Date"));
                contr.setStatus(rs.getBoolean("Contr_Status"));
                contr.setCateName(rs.getString("CateCon_Name"));
                contr.setNameCus(rs.getString("Cus_Name"));
                contr.setNumberApart(rs.getString("Apart_Number"));
                contr.setServiceInUser(rs.getInt("Dịch vụ đang sử dụng"));
                lst.add(contr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public List<ContractModel> FindByID(String ID){
        List<ContractModel> lst = new ArrayList<>();
//        try {
//            String sql = "select * from CONTRACTS where Contr_ID like %?%";
//            Connection con = DBConnect.openConnection();
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1, ID);
//            ResultSet rs = pstm.executeQuery();
//            lst.clear();
//            while(rs.next()){
//                ContractModel contr = new ContractModel();
//                contr.setId(Integer.parseInt("Contr_ID"));
//                contr.setDate(rs.getString("Contr_Date"));
//                contr.setStatus(rs.getBoolean("Contr_Status"));
//                contr.setIdCate(Integer.parseInt("CateCon_ID"));
//                contr.setIdCus(rs.getString("Cus_ID"));
//                contr.setIdAprt(Integer.parseInt("Apart_ID"));
//                lst.add(contr);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return lst;
    }
    public int add(ContractModel s){
        try {
            String sql=  "insert into CONTRACTS"
                    + "(Contr_Date, Contr_Status, CateCon_ID, Cus_ID, Apart_ID) "
                    + "values "
                    + "(?, ?, ?, ?, ?) "
                    + "exec USP_setApartmentAvailable ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getDate());
            pstm.setBoolean(2, s.isStatus());
            pstm.setInt(3, s.getIdCate());
            pstm.setString(4, s.getIdCus());
            pstm.setInt(5, s.getIdAprt());
            pstm.setInt(6, s.getIdAprt());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(int id, String idApart){
        try {
            String sql = "delete CONTRACTS where Contr_ID = ? "
                    + "update Apartment set apart_avaiable = 0 where apart_id = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setString(2, idApart);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(ContractModel contr){
        try{
            String sql = "USP_ChangeApartmentAvaiable ?, ?" 
                    + "update CONTRACTS set "
                    + "Contr_Date = ?,"
                    + "Contr_Status = ?,"
                    + "CateCon_ID = ?,"
                    + "Cus_ID = ?,"
                    + "Apart_ID = ?"
                    + " where Contr_ID = ? ";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, contr.getIdCus());
            pstm.setString(2, contr.getIdCus());
            pstm.setInt(3, contr.getIdAprt());
            pstm.setString(4, contr.getDate());
            pstm.setBoolean(5, contr.isStatus());
            pstm.setInt(6, contr.getIdCate());
            pstm.setString(7, contr.getIdCus());
            pstm.setInt(8, contr.getIdAprt());
            pstm.setInt(9, contr.getId());
            
            pstm.setString(8, contr.getIdCus());
            pstm.setString(9, contr.getIdCus());
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
