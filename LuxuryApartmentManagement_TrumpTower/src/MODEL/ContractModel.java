/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;



/**
 *
 * @author netprtony
 */
public class ContractModel {
    private int id;
    private String date;
    private boolean status;
    private int idCate;
    private String idCus;
    private String nameCus;
    private int idAprt;
    private String numberApart;
    private int ServiceInUser;
    private String cateName; 

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateName() {
        return cateName;
    }
    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public void setNumberApart(String numberApart) {
        this.numberApart = numberApart;
    }

    public String getNameCus() {
        return nameCus;
    }

    public String getNumberApart() {
        return numberApart;
    }
    

    public void setServiceInUser(int ServiceInUser) {
        this.ServiceInUser = ServiceInUser;
    }

    public int getServiceInUser() {
        return ServiceInUser;
    }
    public ContractModel() {
    }

    public ContractModel(int id, String date, boolean status, int idCate, String idCus, int idAprt) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.idCate = idCate;
        this.idCus = idCus;
        this.idAprt = idAprt;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }

    public int getIdCate() {
        return idCate;
    }

    public String getIdCus() {
        return idCus;
    }

    public int getIdAprt() {
        return idAprt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public void setIdAprt(int idAprt) {
        this.idAprt = idAprt;
    }

    
    
}
