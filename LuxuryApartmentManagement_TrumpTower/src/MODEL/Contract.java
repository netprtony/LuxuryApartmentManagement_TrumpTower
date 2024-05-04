/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;



/**
 *
 * @author netprtony
 */
public class Contract {
    private String id;
    private String date;
    private boolean status;
    private String idCate;
    private String idCus;
    private String idAprt;

    public Contract() {
    }

    public Contract(String id, String date, boolean status, String idCate, String idCus, String idAprt) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.idCate = idCate;
        this.idCus = idCus;
        this.idAprt = idAprt;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }

    public String getIdCate() {
        return idCate;
    }

    public String getIdCus() {
        return idCus;
    }

    public String getIdAprt() {
        return idAprt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public void setIdAprt(String idAprt) {
        this.idAprt = idAprt;
    }
    
}
