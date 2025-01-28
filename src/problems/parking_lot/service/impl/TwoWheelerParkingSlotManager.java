package problems.parking_lot.service.impl;

import problems.parking_lot.factory.ParkingSpotFactory;
import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.Vehicle;
import problems.parking_lot.service.ParkingSlotManager;
import problems.parking_lot.strategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingSlotManager extends ParkingSlotManager {

    TwoWheelerParkingSlotManager(List<ParkingSpot> list) {
        this.list = list;
    }
    @Override
    protected ParkingSpot findParkingSpotManager(Vehicle vehicle) {
        return new ParkingSpotFactory().getParkingSpotStrategy(vehicle.getVehicleType());
    }

    @Override
    protected void addParkingSpots() {
        System.out.println("Adding parking spot");
    }

    @Override
    protected void removeParkingSpots() {
        System.out.println("Remove parking spot");
    }

    @Override
    protected boolean parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        return false;
    }

    @Override
    protected Vehicle removeVehicle(ParkingSpot parkingSpot) {
        return null;
    }

}
