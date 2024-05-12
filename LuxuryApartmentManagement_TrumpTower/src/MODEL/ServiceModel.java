/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class ServiceModel {
    private int id;
    private String name;
    private Double price;
    private String exp;
    private boolean available;

    public ServiceModel() {
    }

    public ServiceModel(int id, String name, Double price, String exp, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.exp = exp;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getExp() {
        return exp;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
}
