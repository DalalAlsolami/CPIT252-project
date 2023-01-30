
package cpit252project;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;



import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import static cpit252project.Customer.*;

public class PleaseCookies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //take the minu from file
        File menu = new File("menu.txt");
        Scanner readMenu = new Scanner(menu);
        //read the minu
        while (readMenu.hasNext()) {
            String itemName = readMenu.next();
            double itemPrice = readMenu.nextDouble();
            int itemQuantity = readMenu.nextInt();
            Item newItem = new Item(itemName, itemPrice, itemQuantity);
            Item.addNewItem(newItem);
        }

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Administrator admin =  Administrator.getAdmin("Kh_99", "1234", "Khadegah");

        printHead(); //mine to choose if you are 1/admin or 2/customer
        int number = input.nextInt();
        OrderController controller = new OrderController();//invoker
        //choose1 --> Admin
        //---------------------------------------------------------------------------------------
        if (number == 1) {

            System.out.print("Enter username: ");//should be Kh_99
            String name = input.next();
            System.out.print("Enter password: ");//should be 1234
            String Password = input.next();

            //chick if the username and pass correct -->admin
            if (name.equals(admin.getUserName()) && (Password.endsWith(admin.getPassword()))) {
                int adminInput = 0;
                while (adminInput != 4) {
                    printAdminHeader();//show the services to the admin
                    adminInput = input.nextInt();

                    if (adminInput == 1) { // ADD ITEM.
                        System.out.print("Enter item name: ");
                        String itemName = input.next();
                        System.out.print("Enter item price: ");
                        double itemPrice = input.nextDouble();
                        System.out.print("Enter item quantity: ");
                        int itemQuantity = input.nextInt();
                        Item newItem = new Item(itemName, itemPrice, itemQuantity);
                        System.out.println(Item.addNewItem(newItem));
                    } else if (adminInput == 2) { // DELETE ITEM.
                        System.out.print("Enter item name to delete: ");
                        System.out.println(Item.deleteItem(input.next()));
                    } else if (adminInput == 3) { // show ITEMS.
                        Item.printItems();
                    }
                }
            } else {
                System.out.println("Wrong user name or password");
            }

            //choose2 --> Customer
            //---------------------------------------------------------------------------------------
        } else if (number == 2) {
            boolean finish = true;
            int coustomeOption = 0;
            while (coustomeOption != 3) {
                printCustomerOptions();//show the services to the cusromer
                coustomeOption = input.nextInt();

                if (coustomeOption == 1) {//Create account

                    System.out.print("Enter your username: ");
                    String username = input.next();
                    System.out.print("Enter your passowrd: ");
                    String password = input.next();
                    System.out.print("Enter your first name: ");
                    String firstName = input.next();
                    System.out.print("Enter your last name: ");
                    String lastName = input.next();
                    System.out.print("Enter your address: ");
                    String address = input.next();

                    customers.add(new Customer(username, password, firstName, lastName, address));

                } else if (coustomeOption == 2) {//Login

                    System.out.print("Enter username: ");
                    String username = input.next();
                    System.out.print("Enter password: ");
                    String Password = input.next();

                    Customer currentCustomer = searchCustomer(username, Password);

                    if (currentCustomer == null) {
                        System.out.println("you have to regester first!");
                    } else {
                        System.out.println("---------------------------------------------------");
                        System.out.println("welcome " + currentCustomer.getUserName() + ", our cookies is waiting for you enjoy!");
                        System.out.println("---------------------------------------------------");

                        int customerInput = 0;
                        while (customerInput != 6) {
                            printCustomerHeader();
                            customerInput = input.nextInt();

                            if (customerInput == 1) { //ADD ITEMS

                                Item.printItems();
                                if (finish) {
                                    currentCustomer.addOrder();
                                    finish = false;
                                }
                                String more = "yes";

                                do {

                                    System.out.print("Enter item name: ");
                                    String name = input.next();
                                    System.out.print("Enter item quantity: ");
                                    int quantity = input.nextInt();

                                    System.out.println(currentCustomer.getNewOrder().addItemToOrders(name, quantity));
                                    System.out.print("Do you want to add more items(yes or no)? ");
                                    more = input.next();

                                } while (more.equalsIgnoreCase("yes"));
                            } else if (customerInput == 2) { //FINISH ORDER
                                finish = true;

                                printPymentMethods();
                                System.out.print("Please enter payment method: ");
                                int paymentMethod = input.nextInt();
                                if (paymentMethod == 1) { //Cridet card

                                    currentCustomer.getNewOrder().getPaymentMethod("Credit");
                                    boolean valid = true;
                                    do {
                                        System.out.print("Please enter card number: ");
                                        String cardNumber = input.next();
                                        System.out.print("Please enter CVV: ");
                                        String cardCVV = input.next();
                                        System.out.print("Please enter expiry date(MM/yyyy): ");
                                        String ExpiryDate = input.next();
                                        Date cardExpiryDate = new SimpleDateFormat("MM/yyyy").parse(ExpiryDate);

                                         valid = currentCustomer.getNewOrder().getPayment().cardInformation(cardNumber, cardCVV, cardExpiryDate);
                                        if (valid) {
                                            System.out.println("valid card.");
                                        } else {
                                            System.out.println("Sorry, your card information is wrong! Try again");

                                        }

                                    } while (!valid);
                                } else if (paymentMethod == 2) { //Cash
                                    currentCustomer.getNewOrder().getPaymentMethod("Cash");
                                }
                                System.out.print("Can you share your opinion about our cookies?(yes or no)");
                                if (input.next().equalsIgnoreCase("yes")) {
                                    System.out.print("review: ");
                                    String customerReview = input2.nextLine();
                                }
                                controller.setCommand(new OrderCommands(currentCustomer.getNewOrder()));
                                controller.ConfirmbuttonPressed();

                                break;
                            } else if (customerInput == 3) { //SEARCH FOR AN ITEM
                                System.out.print("Enter item name: ");
                                String name = input.next();
                                Item wantedItem = Item.searchItem(name);
                                if (wantedItem == null) {
                                    System.out.println("Sorry, we do not have this product");
                                } else {
                                    System.out.println("We have " + wantedItem.getQuantity() + " " + wantedItem.getItemName() + " in stock. " + wantedItem.getPrice() + " SAR for each piece.");
                                    System.out.print("Do you want to add this item to cart(yes or no)? ");
                                    String wantToAdd = input.next();
                                    if (wantToAdd.equalsIgnoreCase("yes")) {
                                        System.out.print("Enter item quantity: ");
                                        int quantity = input.nextInt();
                                        currentCustomer.getNewOrder().addItemToOrders(wantedItem.getItemName(), quantity);
                                    }
                                }
                            } else if (customerInput == 4) { //SHOW CART
                                System.out.println(currentCustomer.showCart());
                            } else if (customerInput == 5) { 
                                controller.setCommand(new OrderCommands(currentCustomer.getNewOrder()));
                                controller.CanclebuttonPressed();
                            }
                            }
                        break;
                    }
                }
            }
        }
    }

    public static void printHead() {
        System.out.println("---------------------------------------------------");
        System.out.println("                please cookies system               ");
        System.out.println("---------------------------------------------------");
        System.out.println(" 1) Admin.");
        System.out.println(" 2) Customer.");
        System.out.println("---------------------------------------------------");
        System.out.print(">> ");

    }

    public static void printCustomerOptions() {
        System.out.println("---------------------------------------------------");
        System.out.println("                please cookies system               ");
        System.out.println("---------------------------------------------------");
        System.out.println(" 1) Create new acount.");
        System.out.println(" 2) Log in.");
        System.out.println(" 3) Exit.");
        System.out.println("---------------------------------------------------");
        System.out.print(">> ");

    }

    public static void printAdminHeader() {
        System.out.println("---------------------------------------------------");
        System.out.println("                please cookies system               ");
        System.out.println("---------------------------------------------------");
        System.out.println(" 1) Add new item.");
        System.out.println(" 2) Delete item.");
        System.out.println(" 3) show items.");
        System.out.println(" 4) Exit.");
        System.out.println("---------------------------------------------------");
        System.out.print(">> ");

    }

    public static void printCustomerHeader() {
        System.out.println("---------------------------------------------------");
        System.out.println("                please cookies system               ");
        System.out.println("---------------------------------------------------");
        System.out.println(" 1) Add item.");
        System.out.println(" 2) Confirm order.");
        System.out.println(" 3) Search for an item.");
        System.out.println(" 4) Show cart.");
        System.out.println(" 5) Cancle.");
        System.out.println(" 6) Exit.");
        System.out.println("---------------------------------------------------");
        System.out.print(">> ");
    }

    public static void printPymentMethods() {
        System.out.println("---------------------------------------------------");
        System.out.println("                please cookies system               ");
        System.out.println("---------------------------------------------------");
        System.out.println(" 1) Credit Card");
        System.out.println(" 2) Cash");
        System.out.println("---------------------------------------------------");
    }
 }

