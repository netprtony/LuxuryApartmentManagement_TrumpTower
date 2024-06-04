/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class AccountModel {
    private String user;
    private String name;
    private String password;
    private Boolean role;

    public AccountModel() {
    }

    public AccountModel(String user, String name, String password, Boolean role) {
        this.user = user;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isRole() {
        return role;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }
    
}
