package SOLID.liskovSubstition.without;

public class Car extends Vehicle{
    @Override
    public int numberOfWheels() {
        return 4;
    }
}
