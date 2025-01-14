package SOLID.liskovSubstition.with;

public class Vehicle {

    // in parent class only put general method common for all subclass
    int numberOfWheels() {
        return 2;
    }
}
