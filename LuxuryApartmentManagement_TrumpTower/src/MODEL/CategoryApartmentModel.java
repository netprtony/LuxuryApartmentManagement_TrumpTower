/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class CategoryApartmentModel {
    private int id;
    private String name;
    private String exp;

    public CategoryApartmentModel() {
    }

    public CategoryApartmentModel(int id, String name, String exp) {
        this.id = id;
        this.name = name;
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExp() {
        return exp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    
    
}
