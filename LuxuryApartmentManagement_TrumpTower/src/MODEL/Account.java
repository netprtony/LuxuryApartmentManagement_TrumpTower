/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author netprtony
 */
public class Account {
    private String user;
    private String name;
    private String password;
    private String role;

    public Account() {
    }

    public Account(String user, String name, String password, String role) {
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

    public String getRole() {
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

    public void setRole(String role) {
        this.role = role;
    }
    
}
