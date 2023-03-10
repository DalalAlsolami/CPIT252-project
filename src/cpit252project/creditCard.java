
package cpit252project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class creditCard implements Payment{
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
    //METHODS : to chick if the information of the cridt card is valid or not.
    public boolean cardInformation(String cardNumber, String CVV, Date expiryDate) {
        boolean cardNUmberValid = false, CVVvalid = false, expiryDateValid = false;

        if (cardNumber.length() == 16
                && Character.isDigit(cardNumber.charAt(0))
                && Character.isDigit(cardNumber.charAt(1))
                && Character.isDigit(cardNumber.charAt(2))
                && Character.isDigit(cardNumber.charAt(3))
                && Character.isDigit(cardNumber.charAt(4))
                && Character.isDigit(cardNumber.charAt(5))
                && Character.isDigit(cardNumber.charAt(6))
                && Character.isDigit(cardNumber.charAt(7))
                && Character.isDigit(cardNumber.charAt(8))
                && Character.isDigit(cardNumber.charAt(9))
                && Character.isDigit(cardNumber.charAt(10))
                && Character.isDigit(cardNumber.charAt(11))
                && Character.isDigit(cardNumber.charAt(12))
                && Character.isDigit(cardNumber.charAt(13))
                && Character.isDigit(cardNumber.charAt(14))
                && Character.isDigit(cardNumber.charAt(15))) {
            cardNUmberValid = true;System.out.println("1"+cardNUmberValid);
        }

        if (CVV.length() == 3
                && Character.isDigit(cardNumber.charAt(0))
                && Character.isDigit(cardNumber.charAt(1))
                && Character.isDigit(cardNumber.charAt(2))) {
            CVVvalid = true;System.out.println("2"+CVVvalid);
        }

        Date today = Calendar.getInstance().getTime();
        if (expiryDate.after(today)) {
            expiryDateValid = true;System.out.println("3"+expiryDateValid);
        }

        return (cardNUmberValid && CVVvalid && expiryDateValid);
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
}
