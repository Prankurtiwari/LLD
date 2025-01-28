package problems.parking_lot.model;

import problems.parking_lot.enums.ParkingType;
import problems.parking_lot.enums.VehicleType;
import problems.parking_lot.factory.ParkingSpotFactory;
import problems.parking_lot.factory.ParkingSpotStrategyFactory;

public class TwoWheelerParkingSpot implements ParkingSpot{

    private boolean isOccupied;
    private int noOfFloor;
    private Vehicle vehicle;

    @Override
    public boolean isEmpty() {
        return !isOccupied;
    }

    @Override
    public void occupy() {
        this.isOccupied =true;
    }

    @Override
    public void vacateParkingSpot() {
        this.isOccupied = false;
    }

    @Override
    public ParkingType getParkingType() {
        return ParkingType.TWO_WHEEL_PARKING;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getNoOfFloor() {
        return noOfFloor;
    }

    public void setNoOfFloor(int noOfFloor) {
        this.noOfFloor = noOfFloor;
    }

    public int getPrice() {
        return new ParkingSpotStrategyFactory().getParkingSpotStrategy(vehicle.getVehicleType()).basePrice();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
