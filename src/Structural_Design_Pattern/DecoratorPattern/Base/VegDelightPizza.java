package Structural_Design_Pattern.DecoratorPattern.Base;

public class VegDelightPizza extends BasePizza{

    int cost ;

    public VegDelightPizza(int cost) {
        this.cost = cost;
    }

    @Override
    public int cost() {
        return cost;
    }
}
