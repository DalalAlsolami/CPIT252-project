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
import java.util.Locale;

public class Item {

    private String itemName;
    private double price;
    private int quantity;//for today
    static ArrayList<Item> items = new ArrayList<>();

//CONSREUCTOR
    public Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

//SETTERS AND GETTERS
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

//METHODS: add the new item by the admin to minu
    public static String addNewItem(Item newItem) {
        items.add(newItem);
        return "Item added successfully";
    }
//METHODS: delete the item by the admin from minu 

    public static String deleteItem(String itemName) {
        Item searchItem = searchItem(itemName);
        if (searchItem != null) {
            items.remove(searchItem);
            return "Item deleted successfully";
        } else {
            return "this Item is not exist!";
        }
    }

//METHODS: search for an item to delete it from minu 
    public static Item searchItem(String key) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equals(key)) {
                return items.get(i);
            }
        }
        return null;
    }

//METHODS: print the avalible items "minu" to customer
    public static void printItems() {
        System.out.println("---------------------------------------------------");
        System.out.println("                pleas cookies system               ");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < items.size(); i++) {
            String s = String.format(" %15s",items.get(i).getItemName());
            System.out.println( s+"      " + items.get(i).getPrice() + "           " + items.get(i).getQuantity());
        }
        System.out.println("---------------------------------------------------");
    }
    
}

