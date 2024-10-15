interface Pizza {
    String getDescription();
    double getCost();
}
class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }
    @Override
    public double getCost() {
        return 5.00;
    }
}
class VegetarianPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Vegetarian Pizza";
    }

    @Override
    public double getCost() {
        return 6.00;
    }
}
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}
class PepperoniTopping extends ToppingDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}
public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();
        pizza = new CheeseTopping(pizza);
        pizza = new MushroomTopping(pizza);

        System.out.println("Order: " + pizza.getDescription());
        System.out.println("Total Cost: $" + pizza.getCost());
    }
}
