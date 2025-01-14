package Structural_Design_Pattern.StructuralPattern.Decorator;

import Structural_Design_Pattern.StructuralPattern.Base.BasePizza;

public class ExtraCheeseTopping extends ToppingDecorator{

    int cost ;
    BasePizza basePizza;

    public ExtraCheeseTopping(int cost, BasePizza basePizza) {
        this.cost = cost;
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + cost;
    }
}
