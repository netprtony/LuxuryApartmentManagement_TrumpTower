 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
    
import MODEL.CategoryContractModel;
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
public class CategoryContractDAO {
    public List<CategoryContractModel> readAll(){
        List<CategoryContractModel> lst = new ArrayList<>();
        try {
            String  sql = "select * from CATEGORIZE_CONTRACTS";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                CategoryContractModel cate = new CategoryContractModel();
                cate.setId(rs.getInt("CateCon_ID"));
                cate.setName(rs.getString("CateCon_Name"));
                lst.add(cate);
            }
        } catch (Exception e) {
            Logger.getLogger(CategoryContractModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    public List<CategoryContractModel> FindByName(String name){
        List<CategoryContractModel> lst = new ArrayList<>();
        try {
            String sql = "select * from CATEGORIZE_CONTRACTS where CateCon_Name like %?%";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                CategoryContractModel cate = new CategoryContractModel();
                cate.setId(rs.getInt("CateCon_ID"));
                cate.setName(rs.getString("CateCon_Name"));
                lst.add(cate);
            }
        } catch (Exception e) {
            Logger.getLogger(CategoryContractModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return lst;
    }
    public int add(CategoryContractModel s){
        try {
            String sql=  "insert into CATEGORIZE_CONTRACTS"
                    + "(CateCon_Name) "
                    + "values "
                    + "(?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, s.getName());
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CategoryContractModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int delete(int id){
        try {
            String sql = "delete CATEGORIZE_CONTRACTS where CateCon_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CategoryContractModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    public int update(CategoryContractModel cate){
        try{
            String sql = "update CATEGORIZE_CONTRACTS set "
                    + "CateCon_Name = ?"
                    + " where CateCon_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cate.getName());
            pstm.setInt(2, cate.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            Logger.getLogger(CategoryContractModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
}
