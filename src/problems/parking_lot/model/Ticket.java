package problems.parking_lot.model;

import java.sql.Timestamp;

public class Ticket {
    private int floorNumber;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private long startTime;
    private long endTime;
    private int price;
    private String name;

    public Ticket(int floorNumber, Vehicle vehicle, ParkingSpot parkingSpot, String name) {
        this.floorNumber = floorNumber;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.name = name;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }


    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
