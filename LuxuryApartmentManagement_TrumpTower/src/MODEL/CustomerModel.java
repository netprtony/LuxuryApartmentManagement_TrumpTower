/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class CustomerModel {
    private String id;
    private String name;
    private String birth;
    private String homeTower;
    private String gender;
    private String phoneNumber;
    private String mail;
    private String note;

    
    public CustomerModel() {
    }

    public CustomerModel(String id, String name, String birth, String homeTower, String gender, String phoneNumber, String mail, String note) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.homeTower = homeTower;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.note = note;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getHomeTower() {
        return homeTower;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public String getNote() {
        return note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setHomeTower(String homeTower) {
        this.homeTower = homeTower;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
