
package cpit252project;

import java.util.ArrayList;
import java.util.Date;


public class cash implements Payment{
    //METHODS : to Calculate and return the Subtotal Price
    public double CalculateSubtotalPrice(ArrayList<Item> products, ArrayList<Integer> productsQuantity) {
        int subtotalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            double price = products.get(i).getPrice() * productsQuantity.get(i);
            subtotalPrice += price;
        }
        return subtotalPrice;
    }
    //METHODS : to Calculate the tax 

    public double CalculateTax(double price) {
        return (price * 0.15);
    }

    @Override
    public void printInvoice(ArrayList<Item> products, ArrayList<Integer> productsQuantity) {
        double subtotalPrice = CalculateSubtotalPrice(products, productsQuantity);
        double tax = CalculateTax(subtotalPrice);

        System.out.println("---------------------------------------------------------\n"
                + "                    PLEASE COOKIES                       \n"
                + "---------------------------------------------------------\n"
                + "     Item name               Price         Quantity    ");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("     " + products.get(i).getItemName() + "                   " + products.get(i).getPrice() + "          " + productsQuantity.get(i));
        }
        System.out.println("     " + "Total price                           " + subtotalPrice + "\n"
            + "     " + "Tax                                   " + tax + "\n"
                + "     " + "Total price                           " + (subtotalPrice + tax));
        System.out.println("\n---------------------------------------------------------\n              THANK YOU (:");
    }

    @Override
    public boolean cardInformation(String cardNumber, String cardCVV, Date cardExpiryDate) {
    return false;
    }
}
