/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.CD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CDDao {
    public List<CD> ReadAllCD(){
        List <CD> lst = new ArrayList<>();
        try {
            String sql = "Select * from CDDVD";
            Connection con = DBConnect.openConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                CD cd = new CD();
                cd.setId(Integer.parseInt(rs.getString(1)));
                cd.setTilte(rs.getString(2));
                cd.setCate(rs.getString(3));
                cd.setPublic(Integer.parseInt(rs.getString(4)));
                lst.add(cd);                      
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return lst;
    }

}
