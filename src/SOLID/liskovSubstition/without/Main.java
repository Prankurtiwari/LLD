package SOLID.liskovSubstition.without;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new LinkedList<>();
        vehicles.add(new MotorCycle());
        vehicles.add(new Bicycle());
        vehicles.add(new Car());

        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle.hasEngine()); // at bicycle, it will throw error
        }

    }
}
