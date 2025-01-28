package problems.parking_lot.strategy;

import problems.parking_lot.model.ParkingSpot;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot();
    int basePrice();
}
