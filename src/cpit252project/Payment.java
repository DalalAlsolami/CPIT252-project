
package cpit252project;

import java.util.ArrayList;
import java.util.Date;


public interface Payment {
    
    
    public void printInvoice(ArrayList<Item> products, ArrayList<Integer> productsQuantity);
    
    public double CalculateSubtotalPrice(ArrayList<Item> products, ArrayList<Integer> productsQuantity);
    
    public double CalculateTax(double price);

    public boolean cardInformation(String cardNumber, String cardCVV, Date cardExpiryDate);
}
