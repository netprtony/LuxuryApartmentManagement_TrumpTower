/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class Problem {
    private String id;
    private String describe;
    private String note;
    private String status;
    private String dateOccur;
    private String idAprt;

    public Problem() {
    }

    public Problem(String id, String describe, String note, String status, String dateOccur, String idAprt) {
        this.id = id;
        this.describe = describe;
        this.note = note;
        this.status = status;
        this.dateOccur = dateOccur;
        this.idAprt = idAprt;
    }

    public String getId() {
        return id;
    }

    public String getDescribe() {
        return describe;
    }

    public String getNote() {
        return note;
    }

    public String getStatus() {
        return status;
    }

    public String getDateOccur() {
        return dateOccur;
    }

    public String getIdAprt() {
        return idAprt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateOccur(String dateOccur) {
        this.dateOccur = dateOccur;
    }

    public void setIdAprt(String idAprt) {
        this.idAprt = idAprt;
    }
    
}
