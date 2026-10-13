/* REQUIREMENT: 
Abstract superclass with at least one data member, one
concrete method, and one abstract method.
*/

public abstract class PizzaBase 
{
    private String pizzaType;

    protected void setPizzaType(String pizzaType)
    {
        this.pizzaType = pizzaType;
    }

    public String getPizzaType(){
        return pizzaType;
    }



    public abstract double calculatePrice();
}
