package problems.parking_lot.strategy;

import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.TwoWheelerParkingSpot;

public class TwoWheelerParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot() {
        System.out.println("finding parking for 2 wheeler");
        return new TwoWheelerParkingSpot();
    }

    @Override
    public int basePrice() {
        return 20;
    }
}
