/* REQUIREMENT: 
Main class that handles user input, creates/selects objects,
calls methods, accepts payment, and computes change.
*/

import java.util.*;

public class TAKE_ORDER
{
        static Scanner console = new Scanner(System.in);

    public static void main(String args[])
    {

        System.out.println("========================================");
        System.out.println("           PIZZA ORDER SYSTEM");
        System.out.println("========================================");

        int choice = askPizzaType();
        PIZZA PIE = new PIZZA();
        if (choice == 1){
            PIE = new PIZZA();
        } else {
            PIE = new SPECIAL_PIZZA();
        }
        readOrder(PIE);

        PizzaBase pizza = PIE;
        pizza.calculatePrice();

        BILL_ORDER bill = new BILL_ORDER();
        double amountDue = bill.OUT(PIE);

        double amountReceived = askPayment(amountDue);
        double change = amountReceived - amountDue;
        System.out.println("Change                      : PHP "+ String.format("%.2f", change));
        System.out.println("========================================"); 
    }


        public static int askPizzaType(){
            int choice;
            do { 
                System.out.println("Enter Pizza Type: \n1. Regular Pizza \n2. Special Pizza");
                System.out.print("Choice :  ");
                choice = console.nextInt();
                console.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Enter 1 or 2.");
                }
            } while (choice != 1 && choice !=2);
            return choice;
        }

        public static void readOrder(PIZZA PIE){
            String toppings, discount;
            int diameter, howMany;

            do { 
                System.out.print("\nEnter toppings                :  ");
                toppings = console.nextLine();
                if (!PIE.isValidTopping(toppings)){
                    System.out.println("Invalid topping! Choose Pepperoni, Ham and Cheese, or Hawaiian.");
                }
            } while (!PIE.isValidTopping(toppings));
            PIE.setToppings(toppings);

            do { 
                System.out.print("Enter Diameter in inches      :  ");
                diameter = console.nextInt();
                console.nextLine();
                if (diameter <= 0) {
                    System.out.println("Diameter must be positive.");
                }
            } while (diameter <= 0);
            PIE.setDiameter(diameter);

            do {
                System.out.print("Enter How Many?               :  ");
                howMany = console.nextInt();
                console.nextLine();
                if (howMany <= 0){
                    System.out.println("Quantity must be positive.");
                }
            } while (howMany <= 0);
            PIE.setHowMany(howMany);

            do {
                System.out.print("Enter Type of Discount        :  ");
                discount = console.nextLine();
                if (!PIE.isValidDiscount(discount)){
                    System.out.println("Invalid discount. Choose Senior Citizen, VIPCard, or No Discount.");
                }
            } while (!PIE.isValidDiscount(discount));
            PIE.setDiscount(discount);
        }
        public static double askPayment(double amountDue){
            double amountReceived;
            do { 
                System.out.print("\nEnter Amount Received       : ");
                amountReceived = console.nextDouble();
                console.nextLine();
                if (amountReceived <= amountDue){
                    System.out.println("Amount Receivec must be greater than Amount Due.");
                }
        
            } while (amountReceived <= amountDue);
            return amountReceived;
        }
    }