/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class ApartmentModel {
    private int id;
    private String number;
    private int floor;
    private boolean view;
    private String acreage;
    private Double price;
    private String describe;
    private boolean avaialbe;
    private int idCate;
    private String idBuild;

    public ApartmentModel() {
    }

    public ApartmentModel(int id, String number, int floor, boolean view, String acreage, Double price, String describe, boolean avaialbe, int idCate, String idBuild) {
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.view = view;
        this.acreage = acreage;
        this.price = price;
        this.describe = describe;
        this.avaialbe = avaialbe;
        this.idCate = idCate;
        this.idBuild = idBuild;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isView() {
        return view;
    }

    public String getAcreage() {
        return acreage;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescribe() {
        return describe;
    }

    public boolean isAvaialbe() {
        return avaialbe;
    }

    public int getIdCate() {
        return idCate;
    }

    public String getIdBuild() {
        return idBuild;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setAvaialbe(boolean avaialbe) {
        this.avaialbe = avaialbe;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public void setIdBuild(String idBuild) {
        this.idBuild = idBuild;
    }
    
}
