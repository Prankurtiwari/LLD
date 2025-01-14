package SOLID.liskovSubstition.with;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new LinkedList<>();
        vehicles.add(new MotorCycle());
        vehicles.add(new Bicycle());
        vehicles.add(new Car());

        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle.numberOfWheels());
        }

        List<Vehicle> vehicles1 = new LinkedList<>();
        vehicles1.add(new MotorCycle());
        vehicles1.add(new Bicycle());
        vehicles1.add(new Car());

        for(Vehicle vehicle: vehicles1) {
//            System.out.println(vehicle.hasEngine()); // this compile issue is expected and correct coding practice
        }

        List<EngineVehicle> engineVehicles = new LinkedList<>();
        engineVehicles.add(new MotorCycle());
//        engineVehicles.add(new Bicycle()); // this compile issue is expected and correct coding practice
        engineVehicles.add(new Car());

        for(EngineVehicle vehicle: engineVehicles) {
            System.out.println(vehicle.hasEngine());
        }


    }
}
