package Structural_Design_Pattern.DecoratorPattern.Decorator;

import Structural_Design_Pattern.DecoratorPattern.Base.BasePizza;

public class MushroomTopping extends ToppingDecorator{

    int cost ;
    BasePizza basePizza;

    public MushroomTopping(int cost, BasePizza basePizza) {
        this.cost = cost;
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + cost;
    }
}
