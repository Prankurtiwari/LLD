package problems.parking_lot.strategy;

import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.ThreeWheelerParkingSpot;

public class ThreeWheelerParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot() {
        System.out.println("finding parking for 3 wheeler");
        return new ThreeWheelerParkingSpot();
    }

    @Override
    public int basePrice() {
        return 30;
    }
}
