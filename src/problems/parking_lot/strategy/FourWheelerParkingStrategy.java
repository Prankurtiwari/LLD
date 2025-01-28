package problems.parking_lot.strategy;

import problems.parking_lot.model.FourWheelerParkingSpot;
import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.TwoWheelerParkingSpot;

public class FourWheelerParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot() {
        System.out.println("finding parking for 4 wheeler");
        return new FourWheelerParkingSpot();
    }

    @Override
    public int basePrice() {
        return 50;
    }
}
