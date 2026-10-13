/* REQUIREMENT: 
Receives a pizza object, displays billing details, and returns
the amount due.
*/

public class BILL_ORDER {
    public double OUT(PIZZA PIE) {
      double diameterCM = PIE.getDiameter() * 2.54;
      double price = PIE.getPrice();

      System.out.println("\n----------------------------------------");
      System.out.println("            ORDER DETAILS");
      System.out.println("----------------------------------------");
      System.out.println("Pizza Type         : " + PIE.getPizzaType());
      System.out.println("Topping            : " + PIE.getToppings());
      System.out.println("Diameter           : " + String.format("%.2f", diameterCM) + " cm");
      System.out.println("Quantity           : " + PIE.getHowMany());
      System.out.println("Discount           : " + PIE.getDiscount());
      System.out.println("Discount Rate      : " + Math.round(PIE.getDiscountRate() * 100) + "%" );
      System.out.println("Amount Due         : " + String.format("%.2f", price));




      return price;
    }
  }