/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ProblemModel;
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
public class ProblemsDAO {
    public List<ProblemModel> readAll(){
        List<ProblemModel> lst = new ArrayList<>();
        try {
            String  sql = "exec USP_readAllProblems";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                ProblemModel pro = new ProblemModel();
                pro.setId(rs.getInt("Prob_ID"));
                pro.setDescribe(rs.getString("Prob_Describe"));
                pro.setNote(rs.getString("Prob_Note"));
                pro.setStatus(rs.getString("Prob_Status"));
                pro.setDateOccur(rs.getString("Prob_DateOccur"));
                pro.setNumberApart(rs.getString("Apart_Number"));
                lst.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public List<ProblemModel> FindByDate(String fromDay, String toDay){
        List<ProblemModel> lst = new ArrayList<>();
        try {
            String sql = "select * from PROBLEMS"
                    + " where Prob_DateOccur >= ?"
                    + " and Prob_DateOccur <= ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDay);
            pstm.setString(2, toDay);
            ResultSet rs = pstm.executeQuery();
            lst.clear();
            while(rs.next()){
                ProblemModel pro = new ProblemModel();
                pro.setId(rs.getInt("Prob_ID"));
                pro.setDescribe(rs.getString("Prob_Describe"));
                pro.setNote(rs.getString("Prob_Note"));
                pro.setStatus(rs.getString("Prob_Status"));
                pro.setDateOccur(rs.getString("Prob_DateOccur"));
                pro.setIdAprt(rs.getInt("Apart_ID"));
                lst.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public int add(ProblemModel pro){
        try {
            String sql=  "insert into PROBLEMS"
                    + "(Prob_Describe, Prob_Note, Prob_Status, Prob_DateOccur, Apart_ID) "
                    + "values "
                    + "(?, ?, ?, ?, ?)";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, pro.getDescribe());
            pstm.setString(2, pro.getNote());
            pstm.setString(3, pro.getStatus());
            pstm.setString(4, pro.getDateOccur());
            pstm.setInt(5, pro.getIdAprt());
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(int id){
        try {
            String sql = "delete PROBLEMS where Prob_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(ProblemModel de){
        try{
            String sql = "update PROBLEMS set "
                    + "Prob_Describe = ?,"
                    + "Prob_Note = ?,"
                    + "Prob_Status = ?,"
                    + "Prob_DateOccur = ?,"
                    + "Apart_ID = ?"
                    + " where Prob_ID = ?";
            Connection con = DBConnect.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, de.getDescribe());
            pstm.setString(2, de.getNote());
            pstm.setString(3, de.getStatus());
            pstm.setString(4, de.getDateOccur());
            pstm.setInt(5, de.getIdAprt());
            pstm.setInt(6, de.getId());
            return pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
