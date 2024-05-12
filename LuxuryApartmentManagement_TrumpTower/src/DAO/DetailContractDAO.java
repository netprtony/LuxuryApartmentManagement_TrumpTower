/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.DetailContractModel;
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
public class DetailContractDAO {
    public List<DetailContractModel> readAll(){
        List<DetailContractModel> lst = new ArrayList<>();
        try {
            String  sql = "select * from DETAIL_CONTRACTS";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                DetailContractModel cus = new DetailContractModel();
                cus.setId(rs.getInt("Contr_ID"));
                cus.setIdService(rs.getInt("Serv_ID"));
                
                lst.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public List<DetailContractModel> FindByIdContract(int id){
        List<DetailContractModel> lst = new ArrayList<>();
        try {
            String sql = "select * from DETAIL_CONTRACTS where Contr_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                DetailContractModel cus = new DetailContractModel();
                cus.setId(rs.getInt("Contr_ID"));
                cus.setIdService(rs.getInt("Serv_ID"));

                lst.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public int add(DetailContractModel de){
        try {
            String sql=  "insert into DETAIL_CONTRACTS"
                    + "(Contr_ID, Serv_ID) "
                    + "values "
                    + "(?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, de.getId());
            pstm.setInt(2, de.getIdService());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(int id){
        try {
            String sql = "delete DETAIL_CONTRACTS where Contr_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(DetailContractModel de){
        try{
            String sql = "update DETAIL_CONTRACTS set "
                    + "Serv_ID = ?"
                    + " where Contr_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, de.getIdService());
            pstm.setInt(2, de.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
