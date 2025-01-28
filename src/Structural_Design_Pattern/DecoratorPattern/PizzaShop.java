package Structural_Design_Pattern.DecoratorPattern;

import Structural_Design_Pattern.DecoratorPattern.Base.BasePizza;
import Structural_Design_Pattern.DecoratorPattern.Base.CloudNinePizza;
import Structural_Design_Pattern.DecoratorPattern.Base.VegDelightPizza;
import Structural_Design_Pattern.DecoratorPattern.Decorator.ExtraCheeseTopping;
import Structural_Design_Pattern.DecoratorPattern.Decorator.MushroomTopping;

public class PizzaShop {

    public static void main(String[] args) {
        BasePizza pizzaBought = new ExtraCheeseTopping(50, new MushroomTopping(20, new CloudNinePizza(100)));
        System.out.println("Cost of my pizza which is CloudNine Pizza with extra Cheese and mushroom is = " + pizzaBought.cost());
        BasePizza pizzaBoughtByFriend1 = new ExtraCheeseTopping(50, new ExtraCheeseTopping(50, new MushroomTopping(20, new VegDelightPizza(500))));
        System.out.println("Cost of friend 1 pizza which is Veg Delight Pizza with double extra Cheese and mushroom is = " + pizzaBoughtByFriend1.cost());
        BasePizza pizzaBoughtByFriend2 = new MushroomTopping(20, new CloudNinePizza(100));
        System.out.println("Cost of friend 2 pizza which is CloudNine Pizza mushroom is = " + pizzaBoughtByFriend2.cost());
    }
}
