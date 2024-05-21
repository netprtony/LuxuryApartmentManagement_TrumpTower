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
            String  sql = "select * from CONTRACTS";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                ContractModel contr = new ContractModel();
                contr.setId(Integer.parseInt("Contr_ID"));
                contr.setDate(rs.getString("Contr_Date"));
                contr.setStatus(rs.getBoolean("Contr_Status"));
                contr.setIdCate(Integer.parseInt("CateCon_ID"));
                contr.setIdCus(rs.getString("Cus_ID"));
                contr.setIdAprt(Integer.parseInt("Apart_ID"));
                lst.add(contr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public List<ContractModel> FindByID(String ID){
        List<ContractModel> lst = new ArrayList<>();
        try {
            String sql = "select * from CONTRACTS where Contr_ID like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ID);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                ContractModel contr = new ContractModel();
                contr.setId(Integer.parseInt("Contr_ID"));
                contr.setDate(rs.getString("Contr_Date"));
                contr.setStatus(rs.getBoolean("Contr_Status"));
                contr.setIdCate(Integer.parseInt("CateCon_ID"));
                contr.setIdCus(rs.getString("Cus_ID"));
                contr.setIdAprt(Integer.parseInt("Apart_ID"));
                lst.add(contr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public int add(ContractModel s){
        try {
            String sql=  "insert into CONTRACTS"
                    + "(Contr_Date, Contr_Status, CateCon_ID, Cus_ID, Apart_ID) "
                    + "values "
                    + "(?, ?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getDate());
            pstm.setBoolean(2, s.isStatus());
            pstm.setInt(3, s.getIdCate());
            pstm.setString(4, s.getIdCus());
            pstm.setInt(5, s.getIdAprt());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(int id){
        try {
            String sql = "delete CONTRACTS where Contr_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(ContractModel contr){
        try{
            String sql = "update CONTRACTS set "
                    + "Contr_Date = ?,"
                    + "Contr_Status = ?,"
                    + "CateCon_ID = ?,"
                    + "Cus_ID = ?,"
                    + "Apart_ID = ?"
                    + " where Contr_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, contr.getDate());
            pstm.setBoolean(2, contr.isStatus());
            pstm.setInt(3, contr.getIdCate());
            pstm.setString(4, contr.getIdCus());
            pstm.setInt(5, contr.getIdAprt());
            pstm.setInt(6, contr.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
