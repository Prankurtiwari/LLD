package problems.car_rental_system.services.impl;

import problems.car_rental_system.model.product.Car;
import problems.car_rental_system.model.product.Vehicle;
import problems.car_rental_system.services.VehicleInventoryManagement;

import java.util.List;

public class CarInventoryManagement implements VehicleInventoryManagement {
    List<Vehicle> carList;

    public CarInventoryManagement(List<Vehicle> carList) {
        this.carList = carList;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return this.carList;
    }

    @Override
    public void setVehicles(List<Vehicle> vehicles) {
        this.carList = vehicles;
    }
}
