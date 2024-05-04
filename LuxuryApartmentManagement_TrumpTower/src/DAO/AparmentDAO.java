/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import MODEL.Apartment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author netprtony
 */
public class AparmentDAO {
    public List<Apartment> readAll(){
        List<Apartment> lstAp = new ArrayList<>();
        try {
            String sql = "select * from apartments";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lstAp.clear();
            while (rs.next()) {                
                Apartment ap = new Apartment();
                ap.setId(rs.getString(1));
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
}
