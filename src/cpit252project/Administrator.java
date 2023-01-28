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
    private String userName;
    private String password;
    private String name;
    static ArrayList<Item> items;

//CONSREUCTOR
    public Administrator(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
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
 