/* REQUIREMENT: 
Concrete class representing a pizza order; extends
PizzaBase and implements Discountable.
*/

public class PIZZA extends PizzaBase implements Discountable {
    private String toppings, discount;
    private int diameter, howMany;
    private double price;


  public PIZZA() {
    setPizzaType("Regular Pizza");
  }

  public boolean isValidTopping(String toppings){
    return toppings.equalsIgnoreCase("Pepperoni") || toppings.equalsIgnoreCase("Ham and Cheese") || toppings.equalsIgnoreCase("Hawaiian");
  }

  public boolean isValidDiscount(String discount){
    return discount.equalsIgnoreCase("Senior Citizen") || discount.equalsIgnoreCase("VIPCard") || discount.equalsIgnoreCase("No Discount");
  }

  public void setToppings(String toppings){
    if (toppings.equalsIgnoreCase("Pepperoni")){
      this.toppings = "Pepperoni";
    } else if (toppings.equalsIgnoreCase("Ham and Cheese")){
      this.toppings = "Ham and Cheese";
    } else if (toppings.equalsIgnoreCase("Hawaiian")){
      this.toppings = "Hawaiian";
    }
  }  

  public void setDiscount(String discount){
    if (discount.equalsIgnoreCase("Senior Citizen")){
      this.discount = "Senior Citizen";
  } else if (discount.equalsIgnoreCase("VIPCard")){
      this.discount = "VIPCard";
  } else if (discount.equalsIgnoreCase("No Discount")){
      this.discount = "No Discount";
  }
}
  
    public void setDiameter(int diameter) {
      if (diameter > 0){
      this.diameter = diameter;
    }
  }

    public void setHowMany(int howMany) {
      if (howMany > 0){
      this.howMany = howMany;
    }
  }


    public String getToppings() {
      return toppings;
    }
    public String getDiscount(){
      return discount;
    }
    public int getDiameter() {
      return diameter;
    }
    public int getHowMany() {
      return howMany;
    }
    public double getPrice() {
      return price;
    }

    public double getDiscountRate() {
      if (discount.equals("Senior Citizen")){
        return 0.20;
      } else if (discount.equals("VIPCard")){
        return 0.12;
      } else {
         return 0.0; 
    } }

    private double getToppingsPrice() {
      if (toppings.equals("Pepperoni")){
        return 100;
    } else if (toppings.equals("Ham and Cheese")){
        return 150;
    } else { return 200; } 
  }

    protected double getBaseUnitPrice(){
      double diameterCM = diameter * 2.54;
      double sizePrice = diameterCM * 5;
      return getToppingsPrice() + sizePrice;
    }

    protected double applyDiscount(double subtotal){
      price = subtotal - (subtotal * getDiscountRate());
      return price;
    }

   public double calculatePrice(){
    double subtotal = getBaseUnitPrice() * howMany;
    return  applyDiscount(subtotal);
   }
  }
