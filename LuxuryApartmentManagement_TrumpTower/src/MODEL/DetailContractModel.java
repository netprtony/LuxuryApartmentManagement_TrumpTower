/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class DetailContractModel {
    private int ContrID;
    private int SerID;
    private int quantity;

    public DetailContractModel(int ContrID, int SerID, int quantity) {
        this.ContrID = ContrID;
        this.SerID = SerID;
        this.quantity = quantity;
    }
    public DetailContractModel() {
        
    }
    public int getContrID() {
        return ContrID;
    }

    public int getSerID() {
        return SerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setContrID(int ContrID) {
        this.ContrID = ContrID;
    }

    public void setSerID(int SerID) {
        this.SerID = SerID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
