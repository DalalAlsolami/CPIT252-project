package cpit252project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.util.ArrayList;
public class Administrator {
    private static Administrator admin = null;
    private static String userName;
    private static String password;
    private static String name;
    static ArrayList<Item> items;

// Private CONSREUCTOR to apply singleton patttrens
    private Administrator(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
    }
    
    public static Administrator getAdmin(String userName, String password, String name){
        if (admin == null){
            admin = new Administrator( userName,  password,  name);
        }
            return admin;
    }

//SETTERS AND GETTERS
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
 