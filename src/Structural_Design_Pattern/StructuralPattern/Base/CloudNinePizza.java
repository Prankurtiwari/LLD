package Structural_Design_Pattern.StructuralPattern.Base;

public class CloudNinePizza extends BasePizza{

    int cost ;

    public CloudNinePizza(int cost) {
        this.cost = cost;
    }

    @Override
    public int cost() {
        return cost;
    }
}
