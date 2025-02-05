package problems.car_rental_system.services;

import problems.car_rental_system.model.product.Vehicle;

import java.util.List;

public interface VehicleInventoryManagement {

    List<Vehicle> getVehicles();

    void setVehicles(List<Vehicle> vehicles);

}
