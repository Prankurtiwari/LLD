package problems.parking_lot.model;

import problems.parking_lot.enums.ParkingType;
import problems.parking_lot.enums.VehicleType;
import problems.parking_lot.factory.ParkingSpotStrategyFactory;

public class ThreeWheelerParkingSpot implements ParkingSpot{
    private boolean isOccupied;
    private int noOfFloor;
    private Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPrice() {
        return new ParkingSpotStrategyFactory().getParkingSpotStrategy(vehicle.getVehicleType()).basePrice();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void occupy() {

    }

    @Override
    public void vacateParkingSpot() {

    }

    @Override
    public ParkingType getParkingType() {
        return ParkingType.THREE_WHEEL_PARKING;
    }
}
