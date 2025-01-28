package problems.parking_lot.model;

import problems.parking_lot.enums.ParkingType;
import problems.parking_lot.enums.VehicleType;

public interface ParkingSpot {

    boolean isEmpty();
    void occupy();
    void vacateParkingSpot();
    ParkingType getParkingType();
}
