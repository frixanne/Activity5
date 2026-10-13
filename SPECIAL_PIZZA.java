/* REQUIREMENT: 
Subclass of PIZZA that adds a meaningful characteristic or
behavior and overrides an inherited method.
*/

public class SPECIAL_PIZZA extends PIZZA {
    private double specialCharge = 75.00;

    public SPECIAL_PIZZA(){
        setPizzaType("Special Pizza");
    }

    public double calculatePrice(){
        double subtotal = (getBaseUnitPrice() + specialCharge) * getHowMany();
        return applyDiscount(subtotal);
    }
}
