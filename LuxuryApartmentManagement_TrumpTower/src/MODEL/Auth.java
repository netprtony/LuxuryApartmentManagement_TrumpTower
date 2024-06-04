/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

public class Auth {
    public static AccountModel user;
    
    public boolean isLogin() {
        return user != null;
    }

    public boolean isAdmin() {
        return user.isRole() & isLogin();
    }
}
