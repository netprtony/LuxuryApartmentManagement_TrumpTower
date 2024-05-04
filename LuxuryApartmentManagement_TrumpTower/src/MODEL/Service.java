/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class Service {
    private String id;
    private String name;
    private Double price;
    private String exp;
    private boolean available;

    public Service() {
    }

    public Service(String id, String name, Double price, String exp, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.exp = exp;
        this.available = available;
    }

    public String getId() {
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

    public void setId(String id) {
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
