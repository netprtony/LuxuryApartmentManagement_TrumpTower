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
    private int id;
    private int idService;

    public DetailContractModel() {
    }

    public DetailContractModel(int id, int idService) {
        this.id = id;
        this.idService = idService;
    }

    public int getId() {
        return id;
    }

    public int getIdService() {
        return idService;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
    
}
