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
import cpit252project.Payment;
import java.util.ArrayList;
public class Order {
    ArrayList<Item> products = new ArrayList<>();
    ArrayList<Integer> productsQuantity = new ArrayList<>();
    private Payment payment;

//CONSREUCTOR
    public Order() {

    }

//SETTERS AND GETTERS
    public void setProducts(ArrayList<Item> products) {
        this.products = products;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    public ArrayList<Integer> getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(ArrayList<Integer> productsQuantity) {
        this.productsQuantity = productsQuantity;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

//METHODS: Add the item that customer need and the quantity of item and return the approriate message
    public String addItemToOrders(String itemName, int customerQuantity) {
        Item item = Item.searchItem(itemName);
        if (!(item == null)) {
            if (itemAvailability(item, customerQuantity)) {
                item.setQuantity(item.getQuantity() - customerQuantity);
                products.add(item);
                productsQuantity.add(customerQuantity);
                return "Item added to cart successfully";
            } else {
                return "We have only " + item.getQuantity() + " " + item.getItemName();
            }
        } else {
            return "Sorry, we do not have this product";
        }
    }

//METHODS: chick if the item of the customer is available in minu 
    public boolean itemAvailability(Item item, int userQuantity) {
        if ((item.getQuantity() >= userQuantity)) {
            return true;
        }
        return false;
    }

//METHODS: finish the order to go to payment
    public void finish() {
        this.payment.printInvoice(products, productsQuantity);
    }
}

