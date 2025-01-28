package problems.parking_lot.model;

import problems.parking_lot.enums.VehicleType;
import problems.parking_lot.factory.ParkingSpotFactory;
import problems.parking_lot.service.ParkingSlotManager;

public class Entrance {
    private ParkingSlotManager parkingSlotManager;

    private ParkingSpot findSpace(VehicleType vehicleType) {
        return new ParkingSpotFactory().getParkingSpotStrategy(vehicleType);
    }

    private ParkingSpot findParkingManager(VehicleType vehicleType) {
       return null;
    }



    public void bookSlot(VehicleType vehicleType) {
        findSpace(vehicleType).occupy();
    }

    public Ticket getTicket(ParkingSpot parkingSpot , Vehicle vehicle) {
        return new Ticket(1, vehicle, parkingSpot, vehicle.getVehicleNumber());
    }


}
