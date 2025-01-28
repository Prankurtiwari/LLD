package problems.parking_lot.service;

import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.Ticket;
import problems.parking_lot.model.Vehicle;

import java.util.List;

public abstract class ParkingSlotManager {
    protected List<ParkingSpot> list = null;

    protected abstract ParkingSpot findParkingSpotManager(Vehicle vehicle);

    protected abstract void addParkingSpots();

    protected abstract void removeParkingSpots();

    protected abstract boolean parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot);

    protected abstract Vehicle removeVehicle(ParkingSpot parkingSpot);

}
