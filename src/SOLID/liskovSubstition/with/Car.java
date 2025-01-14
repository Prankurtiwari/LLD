package SOLID.liskovSubstition.with;

public class Car extends EngineVehicle {

    @Override
    public int numberOfWheels() {
        return 4;
    }
}
