package problems.car_rental_system.services.impl;

import problems.car_rental_system.model.product.Bike;
import problems.car_rental_system.model.product.Vehicle;
import problems.car_rental_system.services.VehicleInventoryManagement;

import java.util.List;

public class BikeInventoryManagement implements VehicleInventoryManagement {

    private List<Vehicle> bikeList;

    BikeInventoryManagement(List<Vehicle> bikeList) {
        this.bikeList = bikeList;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return this.bikeList;
    }

    @Override
    public void setVehicles(List<Vehicle> vehicles) {
        this.bikeList = vehicles;
    }
}
